package com.wiss.m295_backend.controller;

import com.wiss.m295_backend.dto.DriverDTO;
import com.wiss.m295_backend.service.DriverService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST-Controller zur Verwaltung von Formel-1-Fahrern.
 */
@RestController // Markiert diese Klasse als REST-Controller für Spring Boot
@RequestMapping("/drivers") // Basis-URL für alle Endpunkte in dieser Klasse
@CrossOrigin(origins = "*") // Erlaubt Anfragen von allen Domains (CORS)
public class DriverController {

    // Service-Klasse, die die Geschäftslogik für Fahrer enthält
    private final DriverService driverService;

    // Konstruktor-Injektion des DriverService
    public DriverController(DriverService driverService) {
        this.driverService = driverService;
    }

    /**
     * GET-Endpoint: Gibt alle gespeicherten Fahrer zurück.
     * @return Liste aller Fahrer als ResponseEntity
     */
    @GetMapping
    public ResponseEntity<List<DriverDTO>> getAllDrivers() {
        // Holt alle Fahrer aus dem Service und gibt sie im HTTP-Body zurück
        return ResponseEntity.ok(driverService.getAllDrivers());
    }

    /**
     * POST-Endpoint: Erstellt einen neuen Fahrer.
     * @param driverDTO Daten des zu erstellenden Fahrers (wird validiert)
     * @return erstellter Fahrer als ResponseEntity
     */
    @PostMapping
    public ResponseEntity<DriverDTO> createDriver(@Valid @RequestBody DriverDTO driverDTO) {
        // Übergibt die Fahrerdaten an den Service zur Erstellung
        DriverDTO created = driverService.createDriver(driverDTO);
        return ResponseEntity.ok(created);
    }

    /**
     * DELETE-Endpoint: Löscht einen Fahrer anhand seiner ID.
     * @param id ID des zu löschenden Fahrers
     * @return HTTP 204 No Content, wenn erfolgreich
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDriver(@PathVariable Long id) {
        // Löscht den Fahrer mit der angegebenen ID
        driverService.deleteDriver(id);
        return ResponseEntity.noContent().build();
    }
}

/** Zusammenfassung:
 * Der DriverController ist ein Spring Boot REST-Controller, der die Verwaltung von Formel-1-Fahrern ermöglicht.
 * Er bietet drei Endpunkte:
 *
 * GET /drivers – Gibt alle Fahrer zurück.
 *
 * POST /drivers – Erstellt einen neuen Fahrer.
 *
 * DELETE /drivers/{id} – Löscht einen Fahrer anhand seiner ID.
 * Die Geschäftslogik liegt im DriverService, den der Controller per Konstruktor-Injektion nutzt.
 */