terraform {
  required_providers {
    scaleway = {
      source = "scaleway/scaleway"
      version = "2.33.0"
    }
  }
}

resource "scaleway_vpc_private_network" "this" {
    name = "esgi-iac-network"
}


output "network_id" {
  value = scaleway_vpc_private_network.this.id
  description = "L'ID du réseau VPC privé"
}