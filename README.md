# 🧠 SosialHub API

Et REST API bygget med Spring Boot for håndtering av brukere og poster i et sosialt nettverk.

---

## 🚀 Kom i gang lokalt

### 🔧 Forutsetninger

Før du starter, må du ha følgende installert på maskinen din:

- [Java 17+](https://adoptopenjdk.net/)
- [Maven](https://maven.apache.org/download.cgi)
- [PostgreSQL](https://www.postgresql.org/download/)
- [IntelliJ IDEA](https://www.jetbrains.com/idea/)
- [Git](https://git-scm.com/)

---

### ⬇️ Klone prosjektet

```bash
git clone https://github.com/AdrianEd50/sosialhub_final_delivery.git
cd sosialhub_final_delivery


##kjør prosjektet
./mvnw spring-boot:run

-- Springboot starter vanligshvis på:
http://localhost:8080


### koble til en database
spring.datasource.url=jdbc:postgresql://localhost:5432/sosialhub
spring.datasource.username=postgres
spring.datasource.password=passordet_ditt
spring.jpa.hibernate.ddl-auto=update

▶️ Start applikasjonen

Med IntelliJ:
Åpne prosjektet
Kjør SosialhubProjectApplication.java som en Spring Boot-app

Eller med terminal:
./mvnw spring-boot:run


Api endepunkter:

| Metode | Endpoint                   | Beskrivelse                    |
| ------ | -------------------------- | ------------------------------ |
| GET    | `/api/posts`               | Hent alle poster               |
| GET    | `/api/posts/user/{userId}` | Hent alle poster for en bruker |
| POST   | `/api/posts`               | Opprett en ny post             |
| PUT    | `/api/posts/{postId}`      | Oppdater en post               |
| DELETE | `/api/posts/{postId}`      | Slett en post                  |




🧪 Eksempel på bruk (via Postman)
Opprette en ny post
POST /api/posts

json:
{
  "content": "Dette er en ny post",
  "userId": 1
}


Hente alle poster
GET /api/posts


Prosjektstruktur:
src/
├── controller/     --> REST-kontrollere
├── model/          --> Datamodeller (JPA)
├── repository/     --> Database-tilgang (JPA)
├── service/        --> Forretningslogikk
├── DTO/            --> Dataoverføring (f.eks. PostDTO)
└── resources/
    └── application.properties



🛠 Tips for videre arbeid
Bruk Postman til å teste API-endepunktene.
Legg til brukere i databasen før du prøver å lage poster.

