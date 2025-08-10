package com.wiss.m295_backend.repository;

import com.wiss.m295_backend.entity.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// Annotation, die diese Schnittstelle als Repository-Komponente in Spring kennzeichnet
@Repository
// Interface, das das JpaRepository erweitert, um CRUD-Operationen für die Entity "Driver" zu ermöglichen
// Long ist der Datentyp des Primärschlüssels der Entity "Driver"
public interface DriverRepository extends JpaRepository<Driver, Long> {
}

/** Zusammenfassung:
 * Dieses Interface definiert ein Repository für die Entity Driver. Es erweitert JpaRepository,
 * wodurch automatisch grundlegende Datenbankoperationen (wie Speichern, Finden, Löschen) für Driver-Objekte
 * zur Verfügung stehen, ohne dass zusätzlicher Code geschrieben werden muss.
 */