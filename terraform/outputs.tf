output "vpc_id" { value = aws_vpc.main.id }
output "ecr_repository_urls" {
  value = { for k,v in aws_ecr_repository.services : k => v.repository_url }
}
