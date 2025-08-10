package com.wiss.m295_backend.entity;

import jakarta.persistence.*; // Importiert JPA-Annotationen für die DB-Abbildung

@Entity // Markiert die Klasse als JPA-Entity, die einer Datenbanktabelle entspricht
public class Request {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // Primärschlüssel, automatisch generiert (Auto-Increment)
    private Long id;

    // Name des Requests (Anfrage, Antrag oder Wunsch)
    private String name;

    // Beschreibung des Requests
    private String beschreibung;

    // Erstellungsdatum des Requests, als String gespeichert
    // Alternativ könnte hier ein LocalDate verwendet werden
    private String erstelltAm;

    // Getter & Setter für die Attribute

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBeschreibung() {
        return beschreibung;
    }

    public void setBeschreibung(String beschreibung) {
        this.beschreibung = beschreibung;
    }

    public String getErstelltAm() {
        return erstelltAm;
    }

    public void setErstelltAm(String erstelltAm) {
        this.erstelltAm = erstelltAm;
    }
}

/** Zusammenfassung:
 * Die Klasse Request stellt eine Datenbankentität dar, die eine Anfrage oder einen Wunsch mit den Eigenschaften
 * Name, Beschreibung und Erstellungsdatum speichert. Die ID wird automatisch generiert. Die Daten können über
 * Getter und Setter gelesen und gesetzt werden.
 */