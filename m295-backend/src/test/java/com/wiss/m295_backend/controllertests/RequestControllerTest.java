package com.wiss.m295_backend.controllertests;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wiss.m295_backend.controller.RequestController;
import com.wiss.m295_backend.dto.RequestDTO;
import com.wiss.m295_backend.service.RequestService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

// Testet nur den Web-Layer (Controller) des RequestControllers
@WebMvcTest(RequestController.class)
public class RequestControllerTest {

    // MockMvc ermöglicht das Simulieren von HTTP-Requests gegen den Controller
    @Autowired
    private MockMvc mockMvc;

    // Mocked Service, um den Service-Layer zu simulieren und dessen Verhalten zu kontrollieren
    @MockBean
    private RequestService requestService;

    // ObjectMapper zum Serialisieren und Deserialisieren von JSON
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void testGetAllRequests() throws Exception {
        // Beispielhafte RequestDTO mit Testdaten
        RequestDTO dto = new RequestDTO();
        dto.setName("Neue Anfrage");
        dto.setBeschreibung("Bitte neuen Fahrer hinzufügen");
        dto.setErstelltAm("2025-08-08");

        // Service-Mock definiert: Gibt eine Liste mit dem DTO zurück, wenn getAllRequests() aufgerufen wird
        when(requestService.getAllRequests()).thenReturn(List.of(dto));

        // Führe GET-Request an "/requests" durch und prüfe:
        // - HTTP Status 200 OK
        // - Im JSON-Array hat das erste Element den Namen "Neue Anfrage"
        mockMvc.perform(get("/requests"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value("Neue Anfrage"));
    }

    @Test
    void testCreateRequest_withInvalidData_shouldReturn400() throws Exception {
        // Leeres RequestDTO mit ungültigen (leeren) Pflichtfeldern
        RequestDTO dto = new RequestDTO();
        dto.setName("");          // Pflichtfeld leer
        dto.setBeschreibung("");  // Pflichtfeld leer
        dto.setErstelltAm("");    // Pflichtfeld leer

        // Simuliere POST-Request an "/requests" mit ungültigem JSON-Body
        // Prüfe, dass der Server mit HTTP 400 Bad Request antwortet (Validierungsfehler)
        mockMvc.perform(post("/requests")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(dto)))
                .andExpect(status().isBadRequest());
    }

}

/** Zusammenfassung:
 * Der Test überprüft den RequestController isoliert vom Service-Layer.
 *
 * Der erste Test (testGetAllRequests) simuliert eine GET-Anfrage, um alle Anfragen abzurufen, und prüft, ob eine erwartete Anfrage mit dem Namen "Neue Anfrage" zurückgegeben wird.
 *
 * Der zweite Test (testCreateRequest_withInvalidData_shouldReturn400) testet die Validierung beim Erstellen einer neuen Anfrage: Wenn Pflichtfelder leer sind, erwartet der Test eine HTTP 400 (Bad Request)-Antwort.
 * So wird sichergestellt, dass der Controller sowohl korrekt Daten liefert als auch Validierungsfehler beim Erstellen neuer Requests handhabt.
 */