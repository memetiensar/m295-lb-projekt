package com.wiss.m295_backend.controllertests;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wiss.m295_backend.controller.DriverController;
import com.wiss.m295_backend.dto.DriverDTO;
import com.wiss.m295_backend.service.DriverService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

// Annotation, die den Test nur auf den Web-Layer (Controller) der DriverController-Klasse begrenzt
@WebMvcTest(DriverController.class)
public class DriverControllerTest {

    // MockMvc wird automatisch injiziert und ermöglicht das Simulieren von HTTP-Anfragen an den Controller
    @Autowired
    private MockMvc mockMvc;

    // Mock-Bean des DriverService, um die Service-Schicht zu simulieren und deren Verhalten zu kontrollieren
    @MockBean
    private DriverService driverService;

    // ObjectMapper wird für JSON-Verarbeitung injiziert (nicht direkt genutzt im Test, aber verfügbar)
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void testGetAllDrivers() throws Exception {
        // Erzeugen eines DriverDTO-Objekts mit Testdaten
        DriverDTO dto = new DriverDTO();
        dto.setVorname("Charles");
        dto.setNachname("Leclerc");
        dto.setTeam("Ferrari");

        // Mock-Verhalten definieren: Wenn driverService.getAllDrivers() aufgerufen wird,
        // soll eine Liste mit dem zuvor erstellten DriverDTO zurückgegeben werden
        Mockito.when(driverService.getAllDrivers()).thenReturn(List.of(dto));

        // Führe eine GET-Anfrage auf den Endpoint "/drivers" aus und überprüfe:
        // - Der HTTP-Status ist 200 OK
        // - Das JSON-Antwortarray hat als erstes Element ein "vorname"-Feld mit dem Wert "Charles"
        mockMvc.perform(get("/drivers"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].vorname").value("Charles"));
    }
}

/** Zusammenfassung:
 * Dieser Test prüft den DriverController in Isolation vom Rest der Anwendung (ohne echten Service oderDatenbankzugriff).
 * Durch Mocking des DriverService wird eine vorgegebene Liste von Fahrern zurückgegeben. Der Test führt dann
 * eine GET-Anfrage an den /drivers-Endpoint durch und verifiziert, dass die Antwort den erwarteten
 * HTTP-Status 200 zurückgibt und dass der erste Fahrer im JSON-Antwortarray den Vornamen "Charles" hat.
 * So wird sichergestellt, dass der Controller korrekt auf Anfragen reagiert und die Service-Schicht
 * ordnungsgemäß nutzt.
 */