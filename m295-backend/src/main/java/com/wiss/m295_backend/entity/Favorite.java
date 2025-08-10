package com.wiss.m295_backend.entity;

import jakarta.persistence.*; // Importiert JPA-Annotationen für das ORM (Object-Relational Mapping)

@Entity // Markiert die Klasse als JPA-Entity, die einer Tabelle in der DB entspricht
public class Favorite {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // Primärschlüssel, der automatisch von der Datenbank generiert wird (Auto-Increment)
    private Long id;

    // Referenz auf den Fahrer (Driver) über dessen ID
    private Long driverId;  // Referenz auf Driver

    // Kommentar zum Favoriten, z.B. persönliche Notiz oder Bewertung
    private String kommentar;

    // Getter & Setter Methoden für den Zugriff auf die Attribute

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getDriverId() {
        return driverId;
    }

    public void setDriverId(Long driverId) {
        this.driverId = driverId;
    }

    public String getKommentar() {
        return kommentar;
    }

    public void setKommentar(String kommentar) {
        this.kommentar = kommentar;
    }
}

/** Zusammenfassung:
 * Die Klasse Favorite repräsentiert eine Entität, die als Favorit markierte Fahrer speichert.
 * Sie enthält eine automatisch generierte ID, eine Referenz driverId auf den jeweiligen Fahrer (Driver-Entity)
 * und einen Kommentar als Notiz oder Beschreibung zum Favoriten. Dadurch können Nutzer z.B. Fahrer mit
 * persönlichen Kommentaren markieren.
 */