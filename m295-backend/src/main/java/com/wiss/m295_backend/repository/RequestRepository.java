package com.wiss.m295_backend.repository;

import com.wiss.m295_backend.entity.Request;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// Markiert diese Schnittstelle als Repository-Komponente für Spring
@Repository
// Interface, das JpaRepository erweitert, um CRUD-Operationen für die Entity "Request" zu ermöglichen
// Long ist der Typ des Primärschlüssels der Entity "Request"
public interface RequestRepository extends JpaRepository<Request, Long> {
}

/** Zusammenfassung:
 * Dieses Interface definiert ein Repository für die Entity Request. Es erweitert JpaRepository, sodass
 * grundlegende Datenbankoperationen wie Speichern, Abrufen, Aktualisieren und Löschen von Request-Objekten
 * ohne zusätzlichen Implementierungsaufwand genutzt werden können.
 */