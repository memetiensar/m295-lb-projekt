package com.wiss.m295_backend.dto; // Package-Deklaration, ordnet diese Klasse in den Projekt-Namespace ein

import jakarta.validation.constraints.*; // Importiert Validierungs-Annotationen (z.B. @NotNull, @Size)

/**
 * Data Transfer Object (DTO) für Favoriten.
 * Dient dazu, Favoriten-Daten zwischen Backend und Frontend zu übertragen.
 */
public class FavoriteDTO {

    // Eindeutige ID des Favoriten
    private Long id;

    // ID des Fahrers, auf den sich der Favorit bezieht
    // Darf nicht null sein, sonst würde der Favorit ins Leere zeigen
    @NotNull(message = "driverId darf nicht null sein")
    private Long driverId;

    // Kommentar zum Favoriten
    // Muss mindestens 3 Zeichen lang sein
    @Size(min = 3, message = "Kommentar muss mindestens 3 Zeichen enthalten")
    private String kommentar;

    // Getter & Setter ----------------------------------------

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
 * Die FavoriteDTO-Klasse dient als Transportobjekt für Favoriten-Einträge. Sie speichert eine eindeutige ID,
 * die ID des zugehörigen Fahrers und einen optionalen Kommentar. Validierungsregeln stellen sicher, dass die
 * driverId nicht null ist und der Kommentar mindestens 3 Zeichen hat. Getter und Setter ermöglichen den Zugriff
 * auf die Felder.
 */