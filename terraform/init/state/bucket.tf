terraform {
  required_providers {
    scaleway = {
      source = "scaleway/scaleway"
      version = "2.33.0"
    }
  }
}


# STATE BUCKET

resource "scaleway_object_bucket" "this" {
  name = "esgi-iac-bucket-test"
  force_destroy = true
}

resource "local_file" "bucket_endpoint" {
  content = "${scaleway_object_bucket.this.endpoint}\n"
  filename = "${path.module}/bucket_endpoint"
}

resource "local_file" "bucket_name" {
  content = "${scaleway_object_bucket.this.name}\n"
  filename = "${path.module}/bucket_name"
}

# OUTPUT
output "endpoint" {
  value = scaleway_object_bucket.this.endpoint
}