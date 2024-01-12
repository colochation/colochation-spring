terraform {
  required_providers {
    scaleway = {
      source = "scaleway/scaleway"
      version = "2.33.0"
    }
  }
}


resource "scaleway_registry_namespace" "main" {
  name       = "colochation-registry"
  region     = "fr-par"
  is_public  = false
}


resource "local_file" "endpoint" {
  content = "${scaleway_registry_namespace.main.endpoint}\n"
  filename = "${path.module}/endpoint.txt"
}

output "registry_endpoint" {
  value = scaleway_registry_namespace.main.endpoint
  description = "L'endpoint du registre de conteneurs Scaleway"
}

output "registry_id" {
  value = scaleway_registry_namespace.main.id
  description = "L'ID du registre de conteneurs Scaleway"
}