package com.ejerciciojava.microservicio.controllers;

import com.ejerciciojava.microservicio.services.implementation.FactorialService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(FactorialController.class)
class FactorialControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private FactorialService factorialService;

    @Test
    @DisplayName("Test unitario PersonaCDAController agregarCDA")
    void testCalcularFactorial() throws Exception {

        int input = 5;
        long expectedFactorial = 120;

        when(factorialService.calcularFactorial(input)).thenReturn(expectedFactorial);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/factorial/{numero}", input)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.numero").value(input))
                .andExpect(MockMvcResultMatchers.jsonPath("$.factorial").value(expectedFactorial));
    }
}