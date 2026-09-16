# ==========================================================
# AWS Region
# ==========================================================

variable "aws_region" {
  description = "AWS region"
  type        = string
  default     = "us-east-1"
}


# ==========================================================
# Project
# ==========================================================

variable "project_name" {
  description = "Project name"
  type        = string
  default     = "banking-devops"
}


# ==========================================================
# EKS
# ==========================================================

variable "cluster_name" {
  description = "EKS cluster name"
  type        = string
  default     = "banking-eks"
}

variable "kubernetes_version" {
  description = "Kubernetes version"
  type        = string
  default     = "1.33"
}

variable "node_instance_type" {
  description = "EKS worker node instance type"
  type        = string
  default     = "t3.medium"
}

variable "desired_nodes" {
  description = "Desired number of nodes"
  type        = number
  default     = 2
}

variable "min_nodes" {
  description = "Minimum number of nodes"
  type        = number
  default     = 1
}

variable "max_nodes" {
  description = "Maximum number of nodes"
  type        = number
  default     = 2
}
