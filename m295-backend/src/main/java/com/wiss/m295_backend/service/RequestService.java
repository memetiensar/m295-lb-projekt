package com.wiss.m295_backend.service;

import com.wiss.m295_backend.dto.RequestDTO;
import com.wiss.m295_backend.entity.Request;
import com.wiss.m295_backend.mapper.RequestMapper;
import com.wiss.m295_backend.repository.RequestRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RequestService {

    private final RequestRepository requestRepository;  // Repository für DB-Zugriffe auf Request-Entitäten
    private final RequestMapper requestMapper;          // Mapper zur Umwandlung zwischen Entity und DTO

    // Konstruktor für Dependency Injection von Repository und Mapper
    public RequestService(RequestRepository requestRepository, RequestMapper requestMapper) {
        this.requestRepository = requestRepository;
        this.requestMapper = requestMapper;
    }

    // Liefert eine Liste aller Requests als DTOs zurück
    public List<RequestDTO> getAllRequests() {
        return requestRepository.findAll()                // Alle Requests aus der DB holen
                .stream()                                  // Stream zur Verarbeitung
                .map(requestMapper::toDTO)                  // Jeden Request in ein DTO umwandeln
                .collect(Collectors.toList());             // Alle DTOs in eine Liste sammeln
    }

    // Erstellt einen neuen Request basierend auf einem DTO
    public RequestDTO createRequest(RequestDTO dto) {
        Request entity = requestMapper.toEntity(dto);    // DTO in eine Entity umwandeln
        Request saved = requestRepository.save(entity); // Entity in DB speichern
        return requestMapper.toDTO(saved);                // Gespeicherte Entity zurück in DTO umwandeln und zurückgeben
    }

    // Aktualisiert einen bestehenden Request anhand der ID mit neuen Daten aus DTO
    public RequestDTO updateRequest(Long id, RequestDTO dto) {
        Request entity = requestMapper.toEntity(dto);    // DTO in Entity umwandeln
        entity.setId(id);                                // ID setzen, um das bestehende Objekt zu überschreiben
        Request updated = requestRepository.save(entity); // Entity speichern (update)
        return requestMapper.toDTO(updated);              // Aktualisierte Entity als DTO zurückgeben
    }

    // Löscht einen Request anhand der ID
    public void deleteRequest(Long id) {
        requestRepository.deleteById(id);                  // Request mit gegebener ID aus der DB löschen
    }

}

/** Zusammenfassung:
 * Die RequestService-Klasse verwaltet Anfragen (Requests). Sie bietet Methoden zum Abrufen aller Requests,
 * Erstellen neuer Requests, Aktualisieren bestehender Requests anhand der ID und Löschen von Requests.
 * Dabei wird ein Repository für Datenbankoperationen und ein Mapper für die Umwandlung zwischen Entity und
 * DTO genutzt. Das Update erfolgt, indem das DTO in eine Entity umgewandelt wird und die ID gesetzt wird,
 * bevor es gespeichert wird.
 */