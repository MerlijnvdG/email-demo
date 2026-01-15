# email-demo

Demo project om e-mails te versturen vanuit een Spring Boot backend. 

## Project structuur

Deze repository is een Maven **parent** met modules.

- `pom.xml` — parent POM
- `backend/` — Spring Boot backend (Java 17, Maven)
- `frontend/` — frontend (aanwezig in repo; exacte setup hangt af van de inhoud van deze map)

## Tech stack

### Backend
- Java 17
- Spring Boot 4.0.1
- Maven
- Spring Web (`spring-boot-starter-web`)
- Spring Mail (`spring-boot-starter-mail`)

## Vereisten

- Java 17 (JDK)
- Maven (of gebruik de Maven Wrapper in `backend/`)

## Backend lokaal draaien

Vanaf de repository root:

```bash
mvn -pl backend spring-boot:run
```

Of vanuit de `backend` map (met wrapper):

```bash
cd backend
./mvnw spring-boot:run
```

## Backend builden

Vanaf de repository root:

```bash
mvn -pl backend clean package
```

## E-mail configuratie

De backend gebruikt Spring Boot mail. Hiervoor heb je SMTP-instellingen nodig in een `application.properties`.

- `spring.mail.host`
- `spring.mail.port`
- `spring.mail.username`
- `spring.mail.password`
- `spring.mail.properties.mail.smtp.auth`
- `spring.mail.properties.mail.smtp.starttls.enable`
