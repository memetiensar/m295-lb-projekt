package com.wiss.m295_backend.controller;

import com.wiss.m295_backend.dto.RequestDTO;
import com.wiss.m295_backend.service.RequestService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

import java.util.List;

/**
 * REST-Controller für Anfragen.
 */
@RestController // Markiert die Klasse als REST-Controller (Spring wandelt Rückgaben in JSON um)
@RequestMapping("/requests") // Basis-URL für alle Endpunkte dieser Klasse
@CrossOrigin(origins = "*") // Erlaubt Anfragen von beliebigen Domains (CORS)
public class RequestController {

    // Service, der die Geschäftslogik für Anfragen enthält
    private final RequestService requestService;

    // Konstruktor-Injektion des Services
    public RequestController(RequestService requestService) {
        this.requestService = requestService;
    }

    /**
     * GET-Endpoint: Gibt alle Anfragen zurück.
     * @return Liste aller gespeicherten Anfragen
     */
    @GetMapping
    public ResponseEntity<List<RequestDTO>> getAllRequests() {
        // Holt alle Anfragen vom Service und gibt sie mit HTTP 200 zurück
        return ResponseEntity.ok(requestService.getAllRequests());
    }

    /**
     * POST-Endpoint: Erstellt eine neue Anfrage.
     * @param dto Daten der neuen Anfrage (validiert mit @Valid)
     * @return erstellte Anfrage mit HTTP 201 Created
     */
    @PostMapping
    public ResponseEntity<RequestDTO> createRequest(@Valid @RequestBody RequestDTO dto) {
        // Übergibt die Daten an den Service zur Erstellung
        RequestDTO created = requestService.createRequest(dto);
        // Gibt HTTP 201 zurück, um anzuzeigen, dass ein neues Objekt erstellt wurde
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    /**
     * PUT-Endpoint: Aktualisiert eine bestehende Anfrage.
     * @param id ID der zu aktualisierenden Anfrage
     * @param dto Neue Daten für die Anfrage
     * @return aktualisierte Anfrage mit HTTP 200
     */
    @PutMapping("/{id}")
    public ResponseEntity<RequestDTO> updateRequest(@PathVariable Long id, @Valid @RequestBody RequestDTO dto) {
        // Aktualisiert die Anfrage und gibt sie zurück
        return ResponseEntity.ok(requestService.updateRequest(id, dto));
    }

    /**
     * DELETE-Endpoint: Löscht eine Anfrage anhand ihrer ID.
     * @param id ID der zu löschenden Anfrage
     * @return HTTP 204 No Content, wenn erfolgreich
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRequest(@PathVariable Long id) {
        // Löscht die Anfrage im Service
        requestService.deleteRequest(id);
        return ResponseEntity.noContent().build();
    }

}

/**
 * Der RequestController ist ein REST-Controller, der CRUD-Operationen für Anfragen anbietet:
 *
 * GET /requests → Alle Anfragen abrufen (HTTP 200)
 *
 * POST /requests → Neue Anfrage erstellen (HTTP 201)
 *
 * PUT /requests/{id} → Anfrage aktualisieren (HTTP 200)
 *
 * DELETE /requests/{id} → Anfrage löschen (HTTP 204)
 *
 * Die eigentliche Logik liegt im RequestService, der vom Controller per Konstruktor injiziert wird.
 */