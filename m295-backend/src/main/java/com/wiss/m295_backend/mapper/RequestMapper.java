package com.wiss.m295_backend.mapper;

import com.wiss.m295_backend.dto.RequestDTO;
import com.wiss.m295_backend.entity.Request;
import org.springframework.stereotype.Component;

@Component
public class RequestMapper {

    // Methode zur Umwandlung eines Request-Entities in ein RequestDTO
    public RequestDTO toDTO(Request request) {
        RequestDTO dto = new RequestDTO();
        dto.setId(request.getId());                 // ID setzen
        dto.setName(request.getName());             // Name setzen
        dto.setBeschreibung(request.getBeschreibung()); // Beschreibung setzen
        dto.setErstelltAm(request.getErstelltAm()); // Erstellungsdatum setzen
        return dto;                                 // DTO zurückgeben
    }

    // Methode zur Umwandlung eines RequestDTO in ein Request-Entity
    public Request toEntity(RequestDTO dto) {
        Request request = new Request();
        request.setId(dto.getId());                 // ID setzen
        request.setName(dto.getName());             // Name setzen
        request.setBeschreibung(dto.getBeschreibung()); // Beschreibung setzen
        request.setErstelltAm(dto.getErstelltAm()); // Erstellungsdatum setzen
        return request;                             // Entity zurückgeben
    }
}

/** Zusammenfassung:
 * Die RequestMapper-Klasse ist eine Spring-Komponente, die die Konvertierung zwischen der Entity Request
 * und dem DTO RequestDTO übernimmt. So können Daten aus der Datenbank-Entität einfach in ein DTO
 * überführt werden, um sie etwa in der API zu übertragen, und umgekehrt.
 */