terraform {
  required_providers {
    scaleway = {
      source = "scaleway/scaleway"
      version = "2.33.0"
    }
  }
  required_version = ">= 0.13"
  backend "local" {
    path = "terraform.tfstate"
  }
}

provider "scaleway" {}

module "state" {
  source = "./state"
}

module "registry" {
  source = "./registry"
}

