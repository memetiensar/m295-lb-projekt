package com.wiss.m295_backend.controllertests;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wiss.m295_backend.controller.FavoriteController;
import com.wiss.m295_backend.dto.FavoriteDTO;
import com.wiss.m295_backend.service.FavoriteService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.beans.factory.annotation.Autowired;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.List;

// Beschränkt den Test auf den Web-Layer des FavoriteController
@WebMvcTest(FavoriteController.class)
public class FavoriteControllerTest {

    // MockMvc zum Simulieren von HTTP-Anfragen an den Controller
    @Autowired
    private MockMvc mockMvc;

    // Mock des FavoriteService, um Service-Aufrufe zu simulieren
    @MockBean
    private FavoriteService favoriteService;

    // ObjectMapper für JSON-Verarbeitung (z.B. Serialisierung von DTOs)
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void testGetAllFavorites() throws Exception {
        // Erstellen eines Beispiel-FavoriteDTO mit Testdaten
        FavoriteDTO dto = new FavoriteDTO();
        dto.setDriverId(1L);
        dto.setKommentar("Top-Fahrer");

        // Definiere das Verhalten des Mocks: Rückgabe einer Liste mit dem DTO bei getAllFavorites()
        Mockito.when(favoriteService.getAllFavorites()).thenReturn(List.of(dto));

        // Simuliere eine GET-Anfrage an "/favorites" und prüfe:
        // - HTTP-Status 200 OK
        // - Das erste Element im JSON-Antwortarray hat den Kommentar "Top-Fahrer"
        mockMvc.perform(get("/favorites"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].kommentar").value("Top-Fahrer"));
    }

    @Test
    void testUpdateFavorite_shouldReturnUpdatedFavorite() throws Exception {
        // Erstellen eines FavoriteDTO mit aktualisierten Daten
        FavoriteDTO dto = new FavoriteDTO();
        dto.setId(1L);
        dto.setDriverId(1L);
        dto.setKommentar("Aktualisierter Kommentar");

        // Mock-Verhalten: Beim Aufruf von updateFavorite mit ID 1 und beliebigem DTO wird das aktualisierte DTO zurückgegeben
        Mockito.when(favoriteService.updateFavorite(Mockito.eq(1L), Mockito.any()))
                .thenReturn(dto);

        // Simuliere eine PUT-Anfrage an "/favorites/1" mit dem DTO als JSON im Body
        // Prüfe anschließend:
        // - HTTP-Status 200 OK
        // - Der Kommentar im JSON entspricht "Aktualisierter Kommentar"
        mockMvc.perform(put("/favorites/1")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(dto)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.kommentar").value("Aktualisierter Kommentar"));
    }

}

/** Zusammenfassung:
 * Der Test überprüft den FavoriteController in Isolation vom Service-Layer mittels Mocking.
 *
 * Der erste Test (testGetAllFavorites) simuliert eine GET-Anfrage an /favorites und verifiziert, dass die Antwort eine Liste mit einem Favoriten zurückgibt, dessen Kommentar "Top-Fahrer" lautet.
 *
 * Der zweite Test (testUpdateFavorite_shouldReturnUpdatedFavorite) simuliert eine PUT-Anfrage zum Aktualisieren eines Favoriten mit ID 1. Dabei wird geprüft, ob die Antwort den aktualisierten Kommentar korrekt zurückgibt.
 * Diese Tests stellen sicher, dass der Controller korrekt HTTP-Anfragen entgegennimmt, mit dem Service interagiert und passende JSON-Antworten liefert.
 */