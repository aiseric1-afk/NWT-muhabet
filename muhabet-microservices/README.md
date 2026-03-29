# NWT Muhabet Microservices

Repo za predmetni projekat: 3 microservisa (user-service, content-service, exercise-service) sa JPA i inicijalnim unosom podataka.

## Struktura
- `user-service` - upravljanje korisnicima, napredak, favorite, modeli: `User`, `AiText`, `Favorite`, `Progress`.
- `content-service` - lekcije, fraze, rečnik, modeli: `Category`, `Lesson`, `Word`, `Phrase`, `Translation`, ....
- `exercise-service` - pitanja/odgovori, modeli: `Question`, `Answer`, `Exercise`, `UserAnswer`.

## Pokretanje lokalno
Za svaki servis u posebnom terminalu:

```bash
cd user-service
mvn clean spring-boot:run

cd ../content-service
mvn clean spring-boot:run

cd ../exercise-service
mvn clean spring-boot:run
```

## Testiranje

```bash
cd user-service && mvn test
cd content-service && mvn test
cd exercise-service && mvn test
```

## GitHub konfiguracija
- `.gitignore` isključuje `target/`, `.idea/`, `.vscode/`, `.env`, etc.
- `main` branch držimo stabilnim.
- nove funkcije u `feature/*` grani; PR u `main`.

## CI
Koristi se GitHub Actions za gradnju i testiranje svakog servisa (`.github/workflows/maven.yml`).
