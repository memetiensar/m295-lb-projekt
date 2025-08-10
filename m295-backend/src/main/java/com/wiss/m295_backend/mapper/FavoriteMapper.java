package com.wiss.m295_backend.mapper;

import com.wiss.m295_backend.dto.FavoriteDTO;
import com.wiss.m295_backend.entity.Favorite;
import org.springframework.stereotype.Component;

@Component
public class FavoriteMapper {

    // Methode zum Umwandeln eines Favorite-Entities in ein FavoriteDTO-Objekt
    public FavoriteDTO toDTO(Favorite favorite) {
        FavoriteDTO dto = new FavoriteDTO();
        dto.setId(favorite.getId());               // ID setzen
        dto.setDriverId(favorite.getDriverId());   // Driver-ID setzen
        dto.setKommentar(favorite.getKommentar()); // Kommentar setzen
        return dto;                                // DTO zurückgeben
    }

    // Methode zum Umwandeln eines FavoriteDTO in ein Favorite-Entity
    public Favorite toEntity(FavoriteDTO dto) {
        Favorite favorite = new Favorite();
        favorite.setId(dto.getId());               // ID setzen
        favorite.setDriverId(dto.getDriverId());   // Driver-ID setzen
        favorite.setKommentar(dto.getKommentar()); // Kommentar setzen
        return favorite;                           // Entity zurückgeben
    }
}

/** Zusammenfassung:
 * Die Klasse FavoriteMapper ist eine Spring-Komponente, die für die Konvertierung zwischen der Datenbank-Entity
 * Favorite und dem zugehörigen Data Transfer Object FavoriteDTO zuständig ist. Dadurch wird der Datenaustausch
 * zwischen Backend und Frontend erleichtert, indem die relevanten Daten übertragen oder entgegengenommen werden
 * können.
 */