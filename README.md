# Banking DevOps KodeKloud Project

A hands-on banking microservices project for practicing Maven, JUnit, Docker, Jenkins, Trivy, Kubernetes, Helm, Argo CD, Terraform and monitoring.

## Services

| Service | Local URL | Container Port |
|---|---:|---:|
| customer-service | http://localhost:8081 | 8080 |
| account-service | http://localhost:8082 | 8080 |
| transaction-service | http://localhost:8083 | 8080 |
| payment-service | http://localhost:8084 | 8080 |
| loan-service | http://localhost:8085 | 8080 |

PostgreSQL: `localhost:5432`, database `banking`, user `banking_user`, password `banking_pass`.

## 1. Check prerequisites

```bash
java -version
mvn -version
docker --version
git --version
```

This project uses Java 17 in the Maven POMs and Docker runtime images.

## 2. Run unit/context tests WITHOUT PostgreSQL

The tests use an in-memory H2 database through the `test` Spring profile. PostgreSQL is not required for `mvn clean test`.

From the project root:

```bash
mvn clean test
```

Expected result:

```text
BUILD SUCCESS
Tests run: 1, Failures: 0, Errors: 0
```

You can also test one service:

```bash
cd services/account-service
mvn clean test
```

## 3. Build JARs

From the project root:

```bash
mvn clean package
```

JAR files are created under each service's `target/` directory.

## 4. Run the real application with PostgreSQL

Start PostgreSQL first:

```bash
docker compose up -d postgres
```

Then build the services:

```bash
mvn clean package -DskipTests
```

Run a service from its directory, for example:

```bash
cd services/account-service
java -jar target/account-service.jar
```

Health check:

```bash
curl http://localhost:8080/actuator/health
```

## 5. Run the complete Docker Compose application

```bash
docker compose up -d --build
docker compose ps
```

Health checks from the EC2 host:

```bash
curl http://localhost:8081/actuator/health
curl http://localhost:8082/actuator/health
curl http://localhost:8083/actuator/health
curl http://localhost:8084/actuator/health
curl http://localhost:8085/actuator/health
```

Stop the application:

```bash
docker compose down
```

Stop and remove database data too:

```bash
docker compose down -v
```

## Why the tests no longer need PostgreSQL

Each service has:

- H2 as a test-only dependency.
- `@ActiveProfiles("test")` on the Spring Boot context test.
- `src/test/resources/application-test.yml` configured for an in-memory H2 database.

Production/local runtime configuration continues to use PostgreSQL through `DB_URL`, `DB_USERNAME`, and `DB_PASSWORD` environment variables.
