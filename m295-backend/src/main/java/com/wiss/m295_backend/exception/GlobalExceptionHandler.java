package com.wiss.m295_backend.exception;

import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

/**
 * Globaler Fehler-Handler für deine REST-API.
 * Diese Klasse fängt verschiedene Exceptions ab und gibt strukturierte Fehlermeldungen zurück.
 */
@ControllerAdvice  // Kennzeichnet die Klasse als globale Fehlerbehandlungskomponente in Spring
public class GlobalExceptionHandler {

    /**
     * Behandlung eigener CustomExceptions.
     * Diese Methode wird aufgerufen, wenn eine CustomException geworfen wird.
     */
    @ExceptionHandler(CustomException.class)
    public ResponseEntity<Map<String, Object>> handleCustomException(CustomException ex) {
        Map<String, Object> body = new HashMap<>();  // Map zum Aufbau der Antwort
        body.put("error", ex.getError());  // Eigene Fehlerbeschreibung aus der CustomException
        body.put("message", ex.getMessage());  // Nachricht aus RuntimeException (normalerweise identisch)
        body.put("status", HttpStatus.BAD_REQUEST.value());  // HTTP-Status 400 Bad Request
        body.put("timestamp", LocalDateTime.now());  // Zeitstempel der Fehlerbehandlung
        return ResponseEntity.badRequest().body(body);  // Antwort mit Status 400 zurückgeben
    }

    /**
     * Behandlung von Validierungsfehlern (z.B. @Valid in DTOs).
     * Diese Methode fängt Fehler ab, wenn Validierungsregeln verletzt wurden.
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, Object>> handleValidationException(MethodArgumentNotValidException ex) {
        Map<String, Object> body = new HashMap<>();
        body.put("error", "VALIDATION_ERROR");  // Typ des Fehlers

        // Fehlerdetails aus den Validierungsfehlern sammeln und in einen String packen
        StringBuilder sb = new StringBuilder();
        ex.getBindingResult().getFieldErrors().forEach(error ->
                sb.append(error.getField())         // Feldname, das fehlerhaft ist
                        .append(" - ")
                        .append(error.getDefaultMessage())  // Validierungsfehlernachricht
                        .append("; ")
        );

        body.put("message", "Validierungsfehler: " + sb.toString());  // Zusammengefasste Fehlermeldung
        body.put("status", HttpStatus.BAD_REQUEST.value());           // HTTP-Status 400
        body.put("timestamp", LocalDateTime.now());                   // Zeitstempel

        return ResponseEntity.badRequest().body(body);
    }

    /**
     * Behandlung von allgemeinen Fehlern (z.B. NullPointerException).
     * Diese Methode fängt alle anderen Exceptions ab, die nicht explizit behandelt wurden.
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, Object>> handleGeneralException(Exception ex) {
        Map<String, Object> body = new HashMap<>();
        body.put("error", "INTERNAL_SERVER_ERROR");  // Fehlerart
        body.put("message", ex.getMessage());        // Fehlermeldung aus Exception
        body.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());  // HTTP-Status 500
        body.put("timestamp", LocalDateTime.now());  // Zeitstempel

        // Antwort mit Status 500 (Interner Serverfehler) zurückgeben
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(body);
    }
}

/** Zusammenfassung:
 * Diese Klasse GlobalExceptionHandler ist eine zentrale Fehlerbehandlung für eine Spring REST-API. Sie fängt unterschiedliche Arten von Exceptions ab:
 *
 * Eigene CustomException-Fehler werden als Bad Request (400) mit spezifischer Fehlernachricht zurückgegeben.
 *
 * Validierungsfehler (z.B. DTO-Validierung) werden gesammelt und ebenfalls mit Status 400 zurückgemeldet.
 *
 * Alle anderen, nicht abgefangenen Fehler werden als interner Serverfehler (500) mit Fehlerdetails an den Client gemeldet.
 * Dadurch werden Fehler systematisch und einheitlich im API-Responseformat behandelt.
 */