# API TESTING

Customer
GET  /api/v1/customer
POST /api/v1/customer

Example:
{"name":"Anu","email":"anu@example.com","phone":"9000000010"}

Account
GET  /api/v1/account
POST /api/v1/account

Example:
{"customerId":1,"accountNumber":"ACC100010","accountType":"SAVINGS","balance":10000,"status":"ACTIVE"}

Transaction
GET  /api/v1/transaction
POST /api/v1/transaction

Example:
{"accountId":1,"type":"DEBIT","amount":1000,"status":"SUCCESS","description":"ATM withdrawal"}

Payment
GET  /api/v1/payment
POST /api/v1/payment

Example:
{"customerId":1,"paymentType":"BILL_PAYMENT","amount":750,"status":"INITIATED","description":"Electricity bill"}

Loan
GET  /api/v1/loan
POST /api/v1/loan

Example:
{"customerId":1,"loanType":"PERSONAL_LOAN","amount":150000,"status":"PENDING"}
