package com.wiss.m295_backend.dto; // Package-Deklaration, ordnet diese Klasse in den Namespace ein

import jakarta.validation.constraints.*; // Importiert Annotationen für Validierung (z.B. @NotBlank, @Min)

/**
 * Data Transfer Object (DTO) für einen Fahrer.
 * Dient dazu, Daten zwischen Backend und Frontend zu übertragen,
 * ohne direkt die Entitäten zu verwenden.
 */
public class DriverDTO {

    // Eindeutige ID des Fahrers
    private Long id;

    // Vorname des Fahrers, darf nicht leer sein
    @NotBlank(message = "Vorname darf nicht leer sein")
    private String vorname;

    // Nachname des Fahrers, darf nicht leer sein
    @NotBlank(message = "Nachname darf nicht leer sein")
    private String nachname;

    // Name des Teams, darf nicht leer sein
    @NotBlank(message = "Team darf nicht leer sein")
    private String team;

    // Startnummer des Fahrers, muss mindestens 1 sein
    @Min(value = 1, message = "Startnummer muss mindestens 1 sein")
    private int startnummer;

    // Nationalität des Fahrers, darf nicht leer sein
    @NotBlank(message = "Nationalität darf nicht leer sein")
    private String nationalitaet;

    // Geburtsdatum des Fahrers als String, darf nicht leer sein
    // Optional: könnte mit @Pattern auf ein bestimmtes Format geprüft werden
    @NotBlank(message = "Geburtsdatum darf nicht leer sein")
    private String geburtsdatum;

    // Getter & Setter für alle Felder -----------------------

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
 * Die DriverDTO-Klasse ist ein Data Transfer Object für Fahrerdaten. Sie enthält Felder für ID, Vorname,
 * Nachname, Team, Startnummer, Nationalität und Geburtsdatum. Mithilfe von Validierungsannotationen wird
 * sichergestellt, dass die Eingaben nicht leer sind und bestimmte Werte (z. B. Mindeststartnummer)
 * eingehalten werden. Getter und Setter ermöglichen den Zugriff auf die Felder.
 */