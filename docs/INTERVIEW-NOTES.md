# INTERVIEW NOTES

Five services:
Customer = customer profile
Account = account/balance
Transaction = debit/credit transaction
Payment = payment/bill payment
Loan = loan lifecycle

CI:
checkout -> build -> test -> quality -> security -> image

CD:
image -> registry -> GitOps -> Argo CD -> Kubernetes

Authentication:
Who are you?

Authorization:
What are you allowed to do?

Authentication is a security concern here, not a sixth business service.

WAF:
protects HTTP/HTTPS application traffic.

ALB:
routes/load-balances traffic.

Terraform:
provisions infrastructure.

Ansible:
configuration/automation.

Rolling deployment:
new pods come up while old pods continue serving.
Readiness probes prevent unready pods receiving traffic.

HPA:
automatically adjusts pod count based on metrics.

PDB:
helps maintain minimum availability during voluntary disruptions.

GitOps:
Git contains desired deployment state; Argo CD reconciles the cluster to it.

HONEST INTERVIEW POSITIONING:
"My professional background was ETL and banking data processing. I built this banking-domain project hands-on to apply DevOps practices. I can explain the banking business flow from my domain experience and the CI/CD, Docker, Kubernetes, AWS and GitOps implementation from my hands-on project."
