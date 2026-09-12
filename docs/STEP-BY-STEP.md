# Complete practice order

## 1. Understand
Business:
Customer, Account, Transaction, Payment, Loan.

Request path:
Customer -> React -> WAF -> ALB -> Ingress -> Service -> Pod -> PostgreSQL.

Delivery:
GitHub -> Jenkins -> Maven -> Test -> SonarQube -> Trivy -> Docker -> ECR -> GitOps -> Argo CD -> EKS.

## 2. Check KodeKloud
java -version
mvn -version
git --version
docker --version
kubectl version --client
helm version
aws --version
trivy --version

Install only what your KodeKloud lab supports.

## 3. Run locally
docker compose up --build

Then:
curl http://localhost:8081/api/v1/health
curl http://localhost:8082/api/v1/health
curl http://localhost:8083/api/v1/health
curl http://localhost:8084/api/v1/health
curl http://localhost:8085/api/v1/health

Stop:
docker compose down

Reset DB:
docker compose down -v

## 4. Build Maven
cd services/customer-service
mvn clean test package

Repeat for all services or:
cd ../..
bash scripts/build-all.sh

Expected:
BUILD SUCCESS

## 5. Test APIs
GET http://localhost:8081/api/v1/customer
GET http://localhost:8082/api/v1/account
GET http://localhost:8083/api/v1/transaction
GET http://localhost:8084/api/v1/payment
GET http://localhost:8085/api/v1/loan

Example:
curl -X POST http://localhost:8081/api/v1/customer \
-H "Content-Type: application/json" \
-d '{"name":"Anu","email":"anu@example.com","phone":"9000000010"}'

## 6. Git
git init
git add .
git commit -m "Initial banking devops project"
git branch -M main

Then connect your own GitHub repo:
git remote add origin <YOUR_REPO>
git push -u origin main

Never commit credentials.

## 7. Docker
cd services/customer-service
mvn clean package
docker build -t customer-service:1.0 .
docker images

## 8. Trivy
trivy fs --severity HIGH,CRITICAL .
trivy image --severity HIGH,CRITICAL customer-service:1.0

## 9. Jenkins
Create a Pipeline job and point it to:
jenkins/Jenkinsfile

Required Jenkins agent tools:
JDK 17, Maven, Git, Docker, AWS CLI, Trivy.

First make the Maven/Test/Trivy stages work.
Then configure SonarQube.
Then configure ECR credentials/IAM.
Do not paste AWS secret keys into Jenkinsfile.

## 10. Kubernetes
Use a KodeKloud Kubernetes cluster if provided.

kubectl get nodes

Before deployment, replace:
REPLACE_WITH_ECR
REPLACE_TAG

in the five service manifests.

Then:
bash scripts/k8s-deploy.sh

Check:
kubectl get pods -n banking
kubectl get svc -n banking
kubectl get deployments -n banking

Troubleshoot:
kubectl describe pod -n banking <pod>
kubectl logs -n banking <pod>
kubectl get events -n banking --sort-by=.lastTimestamp

## 11. Helm
helm lint helm/banking
helm template banking helm/banking

After setting imageRegistry:
helm upgrade --install banking helm/banking --namespace banking --create-namespace

## 12. ECR
aws sts get-caller-identity

aws ecr get-login-password --region <REGION> |
docker login --username AWS --password-stdin <ACCOUNT_ID>.dkr.ecr.<REGION>.amazonaws.com

Then tag and push:
docker tag customer-service:1.0 <ECR_REPO>/customer-service:1.0
docker push <ECR_REPO>/customer-service:1.0

Repeat for all five services.

## 13. Terraform
cd terraform
terraform init
terraform fmt -recursive
terraform validate
terraform plan

Only apply if your lab allows it and you understand what is being created.

terraform apply
terraform destroy

## 14. EKS
If KodeKloud already provides EKS, use that cluster.

Typical:
aws eks list-clusters --region <REGION>
aws eks update-kubeconfig --region <REGION> --name <CLUSTER>

kubectl get nodes

If creating EKS yourself, you need VPC, subnets, IAM, EKS, node groups, ECR access, security groups, and usually AWS Load Balancer Controller for ALB ingress.

## 15. Argo CD
Put the Helm chart in a GitOps repository.
Change argocd/application.yaml:
repoURL: your GitOps repository

Apply:
kubectl apply -f argocd/application.yaml

Argo CD watches Git and syncs Kubernetes desired state.

## 16. EOD
Real-time:
UI -> API -> service -> DB -> immediate response.

EOD:
scheduled job -> validate -> transform/reconcile -> report.

Traditional enterprise scheduler example: Control-M.
Kubernetes equivalent: CronJob.

## 17. WAF/ALB
WAF:
"Is this HTTP request malicious?"

ALB:
"Where should this request go?"

Production:
Customer -> UI -> WAF -> ALB -> Ingress -> service -> pod.

## 18. Monitoring
Spring Boot:
GET /actuator/health
GET /actuator/health/readiness
GET /actuator/health/liveness
GET /actuator/prometheus

Prometheus collects metrics.
Grafana visualizes metrics.
CloudWatch monitors AWS resources/logs.
SNS sends notifications.

# Troubleshooting

ImagePullBackOff:
kubectl describe pod -n banking <pod>
Check image name/tag/ECR permissions.

CrashLoopBackOff:
kubectl logs -n banking <pod>
kubectl logs -n banking <pod> --previous
Check DB URL/credentials/startup errors.

Pending:
kubectl describe pod -n banking <pod>
Check resources, PVC, nodes, taints.

Service not routing:
kubectl get svc -n banking
kubectl get endpoints -n banking
kubectl get pods -n banking --show-labels
Check Service selector vs Pod labels.

Terraform CIDR overlap:
Make every subnet CIDR unique and inside the VPC CIDR.

NAT issue:
NAT Gateway belongs in a public subnet and requires an Internet Gateway route. It can cost money.
