package com.wiss.m295_backend.dto; // Package-Deklaration: ordnet die Klasse in den Namespace des Projekts ein

import jakarta.validation.constraints.*; // Importiert Validierungs-Annotationen wie @NotBlank

/**
 * Data Transfer Object (DTO) für Anfragen (Requests).
 * Dient zum Austausch von Request-Daten zwischen Backend und Frontend.
 */
public class RequestDTO {

    // Eindeutige ID der Anfrage
    private Long id;

    // Name der Anfrage, darf nicht leer oder nur aus Leerzeichen bestehen
    @NotBlank(message = "Name darf nicht leer sein")
    private String name;

    // Beschreibung der Anfrage, darf nicht leer sein
    @NotBlank(message = "Beschreibung darf nicht leer sein")
    private String beschreibung;

    // Erstellungsdatum als String, darf nicht leer sein
    // Optional: könnte mit @Pattern auf ein Datumsformat (z. B. yyyy-MM-dd) validiert werden
    @NotBlank(message = "ErstelltAm darf nicht leer sein")
    private String erstelltAm;

    // Getter & Setter ----------------------------------------

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
 * Die RequestDTO-Klasse ist ein Transportobjekt für Anfragen. Sie enthält eine ID, einen Namen,
 * eine Beschreibung und ein Erstellungsdatum. Mithilfe von @NotBlank wird sichergestellt, dass
 * diese Felder nicht leer sind. Getter und Setter ermöglichen den Zugriff und die Änderung der Werte.
 */