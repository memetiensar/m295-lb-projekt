package com.wiss.m295_backend.mapper;

import com.wiss.m295_backend.dto.DriverDTO;
import com.wiss.m295_backend.entity.Driver;
import org.springframework.stereotype.Component;

@Component
public class DriverMapper {

    // Methode zum Umwandeln eines Driver-Entities in ein DriverDTO-Objekt
    public DriverDTO toDTO(Driver driver) {
        DriverDTO dto = new DriverDTO();
        dto.setId(driver.getId());                   // ID setzen
        dto.setVorname(driver.getVorname());         // Vorname setzen
        dto.setNachname(driver.getNachname());       // Nachname setzen
        dto.setTeam(driver.getTeam());                // Team setzen
        dto.setStartnummer(driver.getStartnummer()); // Startnummer setzen
        dto.setNationalitaet(driver.getNationalitaet()); // Nationalität setzen
        dto.setGeburtsdatum(driver.getGeburtsdatum());   // Geburtsdatum setzen
        return dto;                                  // DTO zurückgeben
    }

    // Methode zum Umwandeln eines DriverDTO in ein Driver-Entity
    public Driver toEntity(DriverDTO dto) {
        Driver driver = new Driver();
        driver.setId(dto.getId());                   // ID setzen
        driver.setVorname(dto.getVorname());         // Vorname setzen
        driver.setNachname(dto.getNachname());       // Nachname setzen
        driver.setTeam(dto.getTeam());                // Team setzen
        driver.setStartnummer(dto.getStartnummer()); // Startnummer setzen
        driver.setNationalitaet(dto.getNationalitaet()); // Nationalität setzen
        driver.setGeburtsdatum(dto.getGeburtsdatum());   // Geburtsdatum setzen
        return driver;                               // Entity zurückgeben
    }
}

/** Zusammenfassung:
 * Diese Klasse DriverMapper ist ein Spring-Komponenten-Bean, das die Umwandlung zwischen der Entity-Klasse
 * Driver und dem Data Transfer Object DriverDTO übernimmt. So kann man leicht die Daten aus der Datenbank-Entity
 * in ein DTO für die Übertragung in der API oder UI konvertieren und umgekehrt.
 */