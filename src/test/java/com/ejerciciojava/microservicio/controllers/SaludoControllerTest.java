package com.ejerciciojava.microservicio.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(SaludoController.class)
class SaludoControllerTest {


    @Autowired
    private MockMvc mockMvc;

    @Test
    void saludo_ShouldReturnSaludoDTO() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get("/api/hola")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.mensaje").value("¡Hola! Bienvenido desde ALMIRCAR"));
    }

}