package com.wiss.m295_backend.controller;

import com.wiss.m295_backend.dto.FavoriteDTO;
import com.wiss.m295_backend.service.FavoriteService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST-Controller für Favoriten-Verwaltung.
 */
@RestController // Markiert die Klasse als REST-Controller (Spring kümmert sich um JSON-Serialisierung)
@RequestMapping("/favorites") // Basis-URL für alle Endpunkte dieser Klasse
@CrossOrigin(origins = "*") // Erlaubt CORS-Anfragen von allen Domains
public class FavoriteController {

    // Service-Layer für die Geschäftslogik rund um Favoriten
    private final FavoriteService favoriteService;

    // Konstruktor-Injektion des Services
    public FavoriteController(FavoriteService favoriteService) {
        this.favoriteService = favoriteService;
    }

    /**
     * GET-Endpoint: Gibt alle gespeicherten Favoriten zurück.
     * @return Liste von Favoriten
     */
    @GetMapping
    public ResponseEntity<List<FavoriteDTO>> getAllFavorites() {
        // Holt alle Favoriten über den Service
        return ResponseEntity.ok(favoriteService.getAllFavorites());
    }

    /**
     * POST-Endpoint: Erstellt einen neuen Favoriten.
     * @param dto Daten des neuen Favoriten (wird validiert)
     * @return erstellter Favorit
     */
    @PostMapping
    public ResponseEntity<FavoriteDTO> createFavorite(@Valid @RequestBody FavoriteDTO dto) {
        // Erstellt einen neuen Favoriten über den Service
        return ResponseEntity.ok(favoriteService.createFavorite(dto));
    }

    /**
     * PUT-Endpoint: Aktualisiert einen Favoriten anhand seiner ID.
     * @param id ID des zu aktualisierenden Favoriten
     * @param dto Neue Daten für den Favoriten
     * @return aktualisierter Favorit
     */
    @PutMapping("/{id}")
    public ResponseEntity<FavoriteDTO> updateFavorite(
            @PathVariable Long id,
            @Valid @RequestBody FavoriteDTO dto) {
        // Aktualisiert den Favoriten im Service
        return ResponseEntity.ok(favoriteService.updateFavorite(id, dto));
    }

    /**
     * DELETE-Endpoint: Löscht einen Favoriten anhand seiner ID.
     * @param id ID des zu löschenden Favoriten
     * @return HTTP 204 No Content bei Erfolg
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFavorite(@PathVariable Long id) {
        // Löscht den Favoriten über den Service
        favoriteService.deleteFavorite(id);
        return ResponseEntity.noContent().build();
    }

}

/** Zusammenfassung:
 *Der FavoriteController ist ein Spring Boot REST-Controller, der CRUD-Operationen für Favoriten anbietet.
 *
 * GET /favorites – Liste aller Favoriten abrufen.
 *
 * POST /favorites – Neuen Favoriten erstellen.
 *
 * PUT /favorites/{id} – Favoriten aktualisieren.
 *
 * DELETE /favorites/{id} – Favoriten löschen.
 * Alle Geschäftslogiken werden vom FavoriteService bereitgestellt.
 */