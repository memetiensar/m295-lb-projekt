package com.wiss.m295_backend.entity;

import jakarta.persistence.*; // Importiert JPA-Annotationen für die Datenbank-Mapping

// Markiert die Klasse als JPA-Entity, damit sie in einer Datenbanktabelle gespeichert werden kann
@Entity
public class Driver {

    // Primärschlüssel der Tabelle
    @Id
    // Generiert automatisch eine eindeutige ID (Auto-Increment in der DB)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Vorname des Fahrers
    private String vorname;

    // Nachname des Fahrers
    private String nachname;

    // Teamname des Fahrers
    private String team;

    // Startnummer des Fahrers
    private int startnummer;

    // Nationalität des Fahrers
    private String nationalitaet;

    // Geburtsdatum des Fahrers (als String gespeichert, könnte auch LocalDate sein)
    private String geburtsdatum; // optional: LocalDate

    // Getter & Setter Methoden für den Zugriff und die Manipulation der Felder

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public String getNachname() {
        return nachname;
    }

    public void setNachname(String nachname) {
        this.nachname = nachname;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public int getStartnummer() {
        return startnummer;
    }

    public void setStartnummer(int startnummer) {
        this.startnummer = startnummer;
    }

    public String getNationalitaet() {
        return nationalitaet;
    }

    public void setNationalitaet(String nationalitaet) {
        this.nationalitaet = nationalitaet;
    }

    public String getGeburtsdatum() {
        return geburtsdatum;
    }

    public void setGeburtsdatum(String geburtsdatum) {
        this.geburtsdatum = geburtsdatum;
    }
}

/** Zusammenfassung:
 * Die Klasse Driver ist eine JPA-Entity, die einen Rennfahrer in einer Datenbank darstellt.
 * Sie enthält Attribute wie Vorname, Nachname, Team, Startnummer, Nationalität und Geburtsdatum.
 * Die id wird automatisch generiert und dient als Primärschlüssel. Über Getter- und Setter-Methoden können
 * die Werte gelesen und verändert werden.
 */