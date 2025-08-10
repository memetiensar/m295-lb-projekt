package com.wiss.m295_backend.repository;

import com.wiss.m295_backend.entity.Favorite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// Kennzeichnung als Repository-Komponente für Spring
@Repository
// Interface, das JpaRepository erweitert, um CRUD-Operationen für die Entity "Favorite" zu ermöglichen
// Long ist der Typ des Primärschlüssels der Entity "Favorite"
public interface FavoriteRepository extends JpaRepository<Favorite, Long> {
}

/** Zusammenfassung:
 * Dieses Interface stellt ein Repository für die Entity Favorite bereit. Durch die Erweiterung von
 * JpaRepository sind Standard-Datenbankoperationen (wie Erstellen, Lesen, Aktualisieren, Löschen)
 * für Favorite-Objekte direkt verfügbar.
 */