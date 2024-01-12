terraform {
  required_providers {
    scaleway = {
      source = "scaleway/scaleway"
      version = "2.33.0"
    }
  }
}

resource "kubernetes_secret" "registry_secret" {
  metadata {
    name = "myregistrysecret"
  }

  type = "kubernetes.io/dockerconfigjson"

  data = {
    ".dockerconfigjson" = jsonencode({
      auths = {
        "rg.fr-par.scw.cloud" = {
          username = "nologin"
          password = "f69155b6-f089-4b87-9e79-80ead3ee314c"
          email    = "tomnesmouhamadou@myges.fr"
        }
      }
    })
  }
}