# ==========================================================
# VPC
# ==========================================================

resource "aws_vpc" "main" {
  cidr_block           = "10.0.0.0/16"
  enable_dns_support   = true
  enable_dns_hostnames = true

  tags = {
    Name    = "${var.project_name}-vpc"
    Project = var.project_name
  }
}


# ==========================================================
# Availability Zones
# ==========================================================

data "aws_availability_zones" "available" {
  state = "available"
}


# ==========================================================
# Private Subnets
# ==========================================================

resource "aws_subnet" "private" {
  count = 2

  vpc_id = aws_vpc.main.id

  cidr_block = cidrsubnet(
    aws_vpc.main.cidr_block,
    8,
    count.index + 10
  )

  availability_zone = data.aws_availability_zones.available.names[count.index]

  tags = {
    Name = "${var.project_name}-private-${count.index + 1}"

    "kubernetes.io/role/internal-elb" = "1"
  }
}
