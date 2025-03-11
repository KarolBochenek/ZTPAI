# ANTIQ

## Opis

Aplikacja do zarządzania antykwariatem z książkami. Pozwala na rejestrację, logowanie, dodawanie nowych przedmiotów i edytowanie ich.

## Funkcjonalności i charakterystyka

* Autentykacja użytkowników: Rejestracja, logowanie i zabezpieczenie za pomocą tokenu JWT.
* Sesja użytkownika
* Zarządzanie książkami: Dodawanie, aktualizowanie, usuwanie i pobieranie książek.
* Zarządzanie autorami: Dodawanie, aktualizowanie, usuwanie i pobieranie autorów.
* Zarządzanie wydawcami: Dodawanie, aktualizowanie, usuwanie i pobieranie wydawców.
* Zarządzanie kategoriami: Dodawanie, aktualizowanie, usuwanie i pobieranie kategorii.
* Swagger UI: Interaktywna dokumentacja i testowanie wszystkich punktów końcowych API. 

## Użyte technologie
* Backend: Spring Boot
* Database: PostgreSQL
* Security: Spring Security with JWT
* API Documentation: Swagger UI (OpenAPI 3)
* ORM: Hibernate
* Build Tool: Maven
* Java Version: 17
  
## Uruchomienie
Aby uruchomić projekt lokalnie, postępuj zgodnie z poniższymi krokami:
1. Sklonuj repozytorium:

`git clone https://github.com/KarolBochenek/ZTPAI/.git`
`cd antiq`

2. Skonfiguruj PostgreSQL:

* Utwórz nową bazę danych w PostgreSQL (np. antiq_db).
* Zmigruj dane i strukurę za pomocą backup.sql
* Zaktualizuj dane logowania w pliku src/main/resources/application.properties (lub application.yml):
  
`spring.datasource.url=jdbc:postgresql://localhost:5432/antiq_db`

`spring.datasource.username=postgres`

`spring.datasource.password=twoje_haslo`

`spring.jpa.hibernate.ddl-auto=update`

3. Uruchom aplikację:

Zbuduj projekt za pomocą Mavena:

`mvn clean install`

Uruchom aplikację Spring Boot:

`mvn spring-boot:run`

Aplikacja zostanie domyślnie uruchomiona na porcie 8080.

## Diagram ERD
<img width="972" alt="ERD" src="https://github.com/user-attachments/assets/97c58d4a-bd14-4602-a0f7-8d6e33b6215c" />

## Swagger UI
Swagger UI jest zintegrowane z aplikacją, aby umożliwić eksplorację i testowanie punktów końcowych API. Możesz uzyskać dostęp do Swagger UI po lokalnym odpaleniu pod adresem:
`http://localhost:8080/swagger-ui/index.html#/`
<img width="988" alt="Swagger" src="https://github.com/user-attachments/assets/82259b55-af81-4c44-a4f1-9961e93ac0a7" />


## Widoki
<img width="465" alt="Zrzut ekranu 2025-03-11 164821" src="https://github.com/user-attachments/assets/2bc7fb3d-118c-4804-a300-549b2e1e2d2d" />
<img width="465" alt="Zrzut ekranu 2025-03-11 164849" src="https://github.com/user-attachments/assets/246f024e-7752-474c-bfd1-1a01dafa422e" />
<img width="696" alt="Zrzut ekranu 2025-03-11 164908" src="https://github.com/user-attachments/assets/3cab57c8-c91f-4486-be6e-d999c764e994" />
<img width="580" alt="Zrzut ekranu 2025-03-11 164923" src="https://github.com/user-attachments/assets/d6f2a9ab-cfc6-41a4-a693-7c7d78535cdd" />


# Mobile
<img width="176" alt="Zrzut ekranu 2025-03-11 164949" src="https://github.com/user-attachments/assets/23690872-062f-481e-9d81-a3c46b18a18d" />
<img width="176" alt="Zrzut ekranu 2025-03-11 164937" src="https://github.com/user-attachments/assets/79a9db62-eacf-453b-bb81-cf6f2533126f" />


## Diagram UML
![UML](https://github.com/user-attachments/assets/f94fc3d9-0a9b-4bd1-b00c-8ae932ac682c)


