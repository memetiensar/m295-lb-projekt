Formel1-API – M295 Abschlussprojekt

Diese README dient gleichzeitig als Projektdokumentation gemäss der Vorgabe vom Modul M295.

Ich habe dieses Projekt im Rahmen des Moduls M295 – Backend mit Spring Boot realisieren erstellt.
Die Formel1-API ist eine Spring Boot Anwendung, die eine REST-API für die Verwaltung von Fahrern, Favoriten und Anfragen bietet. Sie basiert auf den Anforderungen des Moduls M295 und bildet das Backend der gleichnamigen Webanwendung ab.

Übersicht

Diese Anwendung ermöglicht:

Die Anzeige und Verwaltung von Fahrerdaten

Das Erstellen und Verwalten von Favoriten

Das Erfassen, Bearbeiten und Löschen von Fahrer-Anfragen

Projektstruktur

m295-backend
├── src/main/java/com/wiss/m295_backend  → Spring Boot REST-API (Java)
├── docker-compose.yml                   → Datenbank-Setup mit PostgreSQL
└── README.md                            → Projektdokumentation
Das Projekt besteht aus einem Spring Boot Backend, das über eine REST-API Daten verwaltet. Eine mögliche Frontend-Anbindung kann z. B. mit React erfolgen.

Backend-Übersicht (Spring Boot)

Das Backend stellt eine REST-API bereit, um folgende Entitäten zu verwalten:

Driver: Name, Team, Nationalität, Geburtsdatum, Startnummer

Favorite: Vom Nutzer gespeicherte Lieblingsfahrer mit Kommentar

Request: Kontakt- oder Anfrageformular zu bestimmten Fahrern

Technologien
Backend: Java 21, Spring Boot 3, JPA, PostgreSQL, Jakarta Validation

Testing: JUnit, MockMvc, Mockito

Dokumentation: README.md inkl. User Stories, Klassendiagramm, Testplan

Voraussetzungen
JDK 21+

Maven 3.8+

PostgreSQL 14+

Git

Architektur
Das Projekt ist modular nach Best Practices aufgebaut:

scss
Kopieren
Bearbeiten
com.wiss.m295_backend
├── controller
├── dto
├── entity
├── exception (GlobalErrorHandling)
├── mapper
├── repository
└── service
Startanleitung
Backend starten (Spring Boot)

./mvnw spring-boot:run
Port: http://localhost:8080
Datenbank: PostgreSQL (lokal, siehe application.properties)

Datenbank-Konfiguration (application.properties)

spring.datasource.url=jdbc:postgresql://localhost:5432/formel1_db
spring.datasource.username=dein_user
spring.datasource.password=dein_passwort
spring.jpa.hibernate.ddl-auto=update
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
Datenmodell (Klassendiagramm)

Driver
└── id
└── firstName
└── lastName
└── team
└── nationality
└── dateOfBirth
└── number

Favorite
└── id
└── driverId → Referenz auf Driver
└── comment

Request
└── id
└── firstName, lastName, email, phone
└── driverId → Referenz auf Driver
└── comment
API-Endpunkte
🏎️ Fahrer
Methode	Pfad	Beschreibung
GET	/drivers	Alle Fahrer anzeigen
GET	/drivers/{id}	Einzelnen Fahrer anzeigen
POST	/drivers	Neuen Fahrer hinzufügen
PUT	/drivers/{id}	Fahrer bearbeiten
DELETE	/drivers/{id}	Fahrer löschen

Favoriten
Methode	Pfad	Beschreibung
GET	/favorites	Alle Favoriten anzeigen
POST	/favorites	Favorit hinzufügen
PUT	/favorites/{id}	Favorit bearbeiten
DELETE	/favorites/{id}	Favorit löschen

Anfragen
Methode	Pfad	Beschreibung
GET	/requests	Alle Anfragen anzeigen
POST	/requests	Neue Anfrage erstellen
PUT	/requests/{id}	Anfrage bearbeiten
DELETE	/requests/{id}	Anfrage löschen

Validierung
Alle DTOs verwenden Bean Validation (@NotBlank, @Size, @Email usw.).

Fehler werden zentral im GlobalExceptionHandler behandelt:


{
  "status": 400,
  "message": "Validation failed: [fieldName] is required",
  "timestamp": "2025-08-10T10:00:00"
}
Testplan
Testfall	Erwartetes Ergebnis:
Alle Fahrer abrufen (/drivers)	Liste der Fahrer wird korrekt zurückgegeben
Neuen Fahrer hinzufügen (/drivers)	POST speichert Fahrer und gibt ihn zurück
Favorit hinzufügen (/favorites)	POST speichert Favorit
Anfrage ohne Pflichtfelder senden (/requests)	400 Validation Error
Fahrer bearbeiten (/drivers/{id})	Änderungen werden gespeichert
Nicht vorhandenen Fahrer löschen (/drivers/999)	404 Not Found

Unit-Tests
Die Anwendung enthält mindestens 5 Unit-/MockMvc-Tests:


@WebMvcTest(DriverController.class)
void testAddDriver() throws Exception {
  // Testet erfolgreiches Hinzufügen eines Fahrers
}
Tests ausführen

mvn test

Installationsanleitung
PostgreSQL-Datenbank anlegen

Zugangsdaten in application.properties eintragen

Projekt mit IntelliJ importieren oder via CLI starten

Folgenden Befehl ausführen:

mvn spring-boot:run 
Hilfestellungen
Unterrichtsbeispiele

ChatGPT: Hilfe bei Strukturierung, Javadoc, Fehlerbehebung, Dokumentation

Internet: StackOverflow, freeCodeCamp

Lizenz
MIT License – frei nutzbar für Lernzwecke
