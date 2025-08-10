package com.wiss.m295_backend.exception;

// CustomException erbt von RuntimeException und dient zur eigenen Fehlerbehandlung
public class CustomException extends RuntimeException {

    // Eigene Fehlernachricht, die in dieser Exception gespeichert wird
    private final String error;

    // Konstruktor, der eine Fehlernachricht entgegennimmt
    public CustomException(String error) {
        super(error);  // Aufruf des RuntimeException-Konstruktors mit der Fehlernachricht
        this.error = error;  // Speichern der Fehlernachricht im eigenen Feld
    }

    // Getter-Methode, um die gespeicherte Fehlernachricht abzurufen
    public String getError() {
        return error;
    }
}

/** Zusammenfassung:
 * Dieser Code definiert eine benutzerdefinierte Ausnahme (CustomException), die von RuntimeException erbt.
 * Sie ermöglicht es, eine eigene Fehlernachricht zu übergeben und abzurufen, was die Fehlerbehandlung im
 * Programm flexibler macht.
 */