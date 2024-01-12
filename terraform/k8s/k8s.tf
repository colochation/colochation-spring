terraform {
  required_providers {
    scaleway = {
      source = "scaleway/scaleway"
      version = "2.33.0"
    }
  }
}

variable "network_id" {
  description = "L'ID du réseau VPC privé à utiliser pour le cluster"
  type        = string
}

#  K8S
resource "scaleway_k8s_cluster" "this" {
  name    = "cluster"
  version = "1.24.3"
  cni     = "cilium"
  region  = "fr-par"
  delete_additional_resources = true
  private_network_id = var.network_id
}

resource "local_file" "kubeconfig" {
  content = "${scaleway_k8s_cluster.this.kubeconfig[0].config_file}\n"
  filename = "${path.module}/kubeconfig.yml"
}

resource "scaleway_k8s_pool" "this" {
  cluster_id = scaleway_k8s_cluster.this.id
  name       = "pool"
  node_type  = "DEV1-M"
  size       = 1
  region     = scaleway_k8s_cluster.this.region
}

resource "null_resource" "kubeconfig" {
  depends_on = [scaleway_k8s_pool.this]
  triggers = {
    host                   = scaleway_k8s_cluster.this.kubeconfig[0].host
    token                  = scaleway_k8s_cluster.this.kubeconfig[0].token
    cluster_ca_certificate = scaleway_k8s_cluster.this.kubeconfig[0].cluster_ca_certificate
  }
}

provider "kubernetes" {
  host  = null_resource.kubeconfig.triggers.host
  token = null_resource.kubeconfig.triggers.token
  cluster_ca_certificate = base64decode(
    null_resource.kubeconfig.triggers.cluster_ca_certificate
  )
}

resource "kubernetes_deployment" "colochation" {
  metadata {
    name = "colochation"
    labels = {
      app = "colochation"
    }
  }

  spec {
    replicas = 1

    selector {
      match_labels = {
        app = "colochation"
      }
    }

    template {
      metadata {
        labels = {
          app = "colochation"
        }
      }

      spec {
        container {
          image = "rg.fr-par.scw.cloud/colochation-registry/infra-as-code:latest"
          image_pull_policy = "Always"
          name  = "colochation"
          port {
            container_port = 8080
          }
        }
      }
    }
  }
}

resource "kubernetes_service" "main" {
  metadata {
    name = "loadbalancer"
  }
  spec {
    selector = {
      app = "colochation"
    }
    port {
      port        = 80
      target_port = 8080
    }

    type = "LoadBalancer"
  }
}


# BDD

resource "kubernetes_config_map" "db_init_script" {
  metadata {
    name = "mysql-init-script"
  }

  data = {
    "init.sql" = file("${path.module}/init.sql")
  }
}

resource "kubernetes_deployment" "database" {
  metadata {
    name = "database"
    labels = {
      app = "database"
    }
  }

  spec {
    replicas = 1

    selector {
      match_labels = {
        app = "database"
      }
    }

    template {
      metadata {
        labels = {
          app = "database"
        }
      }

      spec {
        container {
          image = "mysql:8.2.0"
          name  = "mysql"

          env {
            name  = "MYSQL_ROOT_PASSWORD"
            value = "pwd"
          }

          env {
            name = "MYSQL_DATABASE"
            value = "colochation"
          }

          port {
            container_port = 3306
          }

          volume_mount {
            name       = "init-script-volume"
            mount_path = "/docker-entrypoint-initdb.d"
          }
        }

        volume {
          name = "init-script-volume"

          config_map {
            name = kubernetes_config_map.db_init_script.metadata[0].name
          }
        }
      }
    }
  }
}

resource "kubernetes_service" "mysql" {
  metadata {
    name = "mysql"
  }

  spec {
    selector = {
      app = "database"
    }
    
    port {
      port        = 3306
      target_port = 3306
    }

    type = "ClusterIP"
  }
}

resource "kubernetes_horizontal_pod_autoscaler" "main" {
  metadata {
    name = "cpu-autoscaler"
  }

  spec {
    max_replicas = 2

    scale_target_ref {
      kind = "Deployment"
      name = "colochation"
    }

    target_cpu_utilization_percentage = 5 #% CPU
  }
}