package com.ejerciciojava.microservicio.controllers;

import com.ejerciciojava.microservicio.jpa.entities.ClienteEntity;
import com.ejerciciojava.microservicio.services.ValidacionesCliente;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ClienteController.class)
class ClienteControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ValidacionesCliente validacionesCliente;

    @Test
    void testobtenerInformacionCliente() throws Exception {
        String tipoDocumento = "C";
        String numeroDocumento = "1234567890";

        ClienteEntity clienteEntity = ClienteEntity.builder().build();
        when(validacionesCliente.validarExisteCliente(tipoDocumento, numeroDocumento)).thenReturn(clienteEntity);

        mockMvc.perform(MockMvcRequestBuilders.post("/clientes/consultar")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\n" +
                                "    \"tipoDocumento\": \"C\",\n" +
                                "    \"numeroDocumento\": 23445322\n" +
                                "}"))
                .andExpect(status().isOk());
    }
}