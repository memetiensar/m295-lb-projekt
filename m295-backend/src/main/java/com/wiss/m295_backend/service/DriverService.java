package com.wiss.m295_backend.service;

import com.wiss.m295_backend.dto.DriverDTO;
import com.wiss.m295_backend.entity.Driver;
import com.wiss.m295_backend.mapper.DriverMapper;
import com.wiss.m295_backend.repository.DriverRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DriverService {

    private final DriverRepository driverRepository;  // Repository für Datenbankzugriffe auf Driver-Entitäten
    private final DriverMapper driverMapper;          // Mapper zur Umwandlung zwischen Entity und DTO

    // Konstruktor für Dependency Injection von Repository und Mapper
    public DriverService(DriverRepository driverRepository, DriverMapper driverMapper) {
        this.driverRepository = driverRepository;
        this.driverMapper = driverMapper;
    }

    // Liefert eine Liste aller Fahrer als DTOs zurück
    public List<DriverDTO> getAllDrivers() {
        return driverRepository.findAll()             // Alle Fahrer aus der DB holen
                .stream()                             // Stream zur Verarbeitung
                .map(driverMapper::toDTO)             // Jeden Fahrer in ein DTO umwandeln
                .collect(Collectors.toList());        // Alle DTOs in eine Liste sammeln
    }

    // Erstellt einen neuen Fahrer basierend auf einem DTO
    public DriverDTO createDriver(DriverDTO dto) {
        Driver driver = driverMapper.toEntity(dto);   // DTO in eine Entity umwandeln
        Driver saved = driverRepository.save(driver); // Entity in DB speichern
        return driverMapper.toDTO(saved);              // Gespeicherte Entity zurück in DTO umwandeln und zurückgeben
    }

    // Löscht einen Fahrer anhand der ID
    public void deleteDriver(Long id) {
        driverRepository.deleteById(id);               // Fahrer mit gegebener ID aus der DB löschen
    }

}

/** Zusammenfassung:
 * Diese Service-Klasse verwaltet Fahrer-Daten. Sie ermöglicht das Abrufen aller Fahrer als DTO-Liste,
 * das Erstellen eines neuen Fahrers aus einem DTO und das Löschen eines Fahrers anhand seiner ID.
 * Die Klasse verwendet ein Repository für die Datenbankzugriffe und einen Mapper, um zwischen Datenbank-Entities
 * und Datenübertragungsobjekten (DTOs) zu konvertieren.
 */