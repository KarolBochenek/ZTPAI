# ANTIQ

## Opis

Aplikacja do zarządzania książkami. Pozwala na rejestrację, logowanie, dodawanie nowych przedmiotów i edytowanie ich.

## Uruchomienie
Aby uruchomić projekt lokalnie, postępuj zgodnie z poniższymi krokami:
1. Pobierz Dockera ze strony [Docker](https://www.docker.com/) i zainstaluj go.
2. Sklonuj repozytorium.
3. Ustaw połączenie z bazą danych w pliku `config.php`.
4. Uruchom run.cmd/run.sh (w zależności od systemu) lub wstaw w terminalu katalog projektu jako bieżący i uruchom kontener Docker za pomocą komendy: docker compose build a następnie docker compose up.
5. Uruchom przeglądarkę i wpisz adres: http://localhost:8080
6. By zakończyć, uruchom shudown.cmd/shudown.sh

## Funkcjonalności i charakterystyka

* Rejestracja i logowanie użytkowników
* Sesja użytkownika
* Wylogowywanie użytkownika
* Hashowanie haseł w oparciu o md5
* Dodawanie nowych przedmiotów do bazy danych
* Responsywny design i tryb mobilny

## Użyte technologie

## Diagram ERD

## Widoki
[login-desktop.pdf](https://github.com/user-attachments/files/18459069/login-desktop.pdf)
[register-desktop.pdf](https://github.com/user-attachments/files/18459059/register-desktop.pdf)
[items-desktop.pdf](https://github.com/user-attachments/files/18459065/items-desktop.pdf)
[add-item-desktop.pdf](https://github.com/user-attachments/files/18459066/add-item-desktop.pdf)

# Mobile
[login-mobile.pdf](https://github.com/user-attachments/files/18459063/login-mobile.pdf)
[register-mobile.pdf](https://github.com/user-attachments/files/18459068/register-mobile.pdf)

## Diagram UML

