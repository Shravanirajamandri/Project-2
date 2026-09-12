Start with:
terraform init
terraform fmt -recursive
terraform validate
terraform plan

Only apply after checking your KodeKloud permissions.

This deliberately starts with VPC + ECR rather than automatically creating EKS/NAT.
NAT Gateway and EKS can create AWS charges in normal accounts.

Clean up:
terraform destroy
