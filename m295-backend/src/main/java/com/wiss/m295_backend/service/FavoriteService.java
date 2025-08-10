package com.wiss.m295_backend.service;

import com.wiss.m295_backend.dto.FavoriteDTO;
import com.wiss.m295_backend.entity.Favorite;
import com.wiss.m295_backend.mapper.FavoriteMapper;
import com.wiss.m295_backend.repository.FavoriteRepository;
import org.springframework.stereotype.Service;
import com.wiss.m295_backend.exception.CustomException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FavoriteService {

    private final FavoriteRepository favoriteRepository; // Repository für DB-Zugriffe auf Favorite-Entitäten
    private final FavoriteMapper favoriteMapper;         // Mapper zur Umwandlung zwischen Entity und DTO

    // Konstruktor für Dependency Injection von Repository und Mapper
    public FavoriteService(FavoriteRepository favoriteRepository, FavoriteMapper favoriteMapper) {
        this.favoriteRepository = favoriteRepository;
        this.favoriteMapper = favoriteMapper;
    }

    // Liefert eine Liste aller Favoriten als DTOs zurück
    public List<FavoriteDTO> getAllFavorites() {
        return favoriteRepository.findAll()                // Alle Favoriten aus der DB holen
                .stream()                                  // Stream zur Verarbeitung
                .map(favoriteMapper::toDTO)                // Jeden Favoriten in ein DTO umwandeln
                .collect(Collectors.toList());             // Alle DTOs in eine Liste sammeln
    }

    // Erstellt einen neuen Favoriten basierend auf einem DTO
    public FavoriteDTO createFavorite(FavoriteDTO dto) {
        Favorite entity = favoriteMapper.toEntity(dto);    // DTO in eine Entity umwandeln
        Favorite saved = favoriteRepository.save(entity); // Entity in DB speichern
        return favoriteMapper.toDTO(saved);                // Gespeicherte Entity zurück in DTO umwandeln und zurückgeben
    }

    // Löscht einen Favoriten anhand der ID
    public void deleteFavorite(Long id) {
        favoriteRepository.deleteById(id);                  // Favorit mit gegebener ID aus der DB löschen
    }

    // Aktualisiert einen Favoriten anhand der ID mit neuen Daten aus DTO
    public FavoriteDTO updateFavorite(Long id, FavoriteDTO dto) {
        Favorite favorite = favoriteRepository.findById(id)    // Favoriten mit ID aus DB holen
                .orElseThrow(() -> new CustomException("Favorite nicht gefunden")); // Exception werfen, wenn nicht gefunden

        favorite.setKommentar(dto.getKommentar());            // Kommentar des Favoriten aktualisieren
        Favorite saved = favoriteRepository.save(favorite);   // Aktualisierte Entity speichern

        return favoriteMapper.toDTO(saved);                    // Aktualisierte Entity als DTO zurückgeben
    }

}

/** Zusammenfassung:
 * Die FavoriteService-Klasse verwaltet Favoriten-Einträge. Sie bietet Methoden, um alle Favoriten abzurufen,
 * neue Favoriten zu erstellen, Favoriten zu löschen und bestehende Favoriten (insbesondere deren Kommentare)
 * zu aktualisieren. Für das Update wird sichergestellt, dass der Favorit existiert, andernfalls wird eine
 * benutzerdefinierte Ausnahme geworfen. Wie bei DriverService kommen Repository und Mapper für Datenbankzugriffe
 * und Entity-DTO-Konvertierungen zum Einsatz.
 */