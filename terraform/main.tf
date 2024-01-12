terraform {
  required_providers {
    scaleway = {
      source = "scaleway/scaleway"
      version = "2.33.0"
    }
  }
  backend "s3" {
    bucket                      = "esgi-iac-bucket-test"
    key                         = "./state/terraform.tfstate"
    region                      = "fr-par"
    endpoint                    = "https://s3.fr-par.scw.cloud"
    skip_credentials_validation = true
    skip_region_validation      = true
  }
}

variable "database_password" {
description = "Le mot de passe de la base de données"
    type        = string
    sensitive   = true
}

module "network" {
  source = "./network"
}

module "k8s" {
    source     = "./k8s"
    network_id = module.network.network_id
    db_pwd     = var.database_password
}