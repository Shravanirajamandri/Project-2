locals {
  services = [
    "customer-service",
    "account-service",
    "transaction-service",
    "payment-service",
    "loan-service"
  ]
}

resource "aws_ecr_repository" "services" {
  for_each = toset(local.services)
  name = "${var.project_name}/${each.value}"
  image_tag_mutability = "IMMUTABLE"

  image_scanning_configuration {
    scan_on_push = true
  }
}
