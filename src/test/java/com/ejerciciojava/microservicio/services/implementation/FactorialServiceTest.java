package com.ejerciciojava.microservicio.services.implementation;

import com.ejerciciojava.microservicio.exceptions.FactorialExeption;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FactorialServiceTest {
    private final FactorialService factorialService = new FactorialService();

    @Test
    void calcularFactorial_NumeroPositivo_DebeRetornarFactorialCorrecto() {
        int numero = 5;
        long factorialEsperado = 120;
        long factorialCalculado = factorialService.calcularFactorial(numero);

        assertEquals(factorialEsperado, factorialCalculado);
    }

    @Test
    void calcularFactorial_NumeroCero_DebeRetornarUno() {
        int numero = 0;
        long factorialCalculado = factorialService.calcularFactorial(numero);
        assertEquals(1, factorialCalculado);
    }

    @Test
    void calcularFactorial_NumeroUno_DebeRetornarUno() {
        int numero = 1;
        long factorialCalculado = factorialService.calcularFactorial(numero);
        assertEquals(1, factorialCalculado);
    }

    @Test
    void calcularFactorial_NumeroNegativo_DebeLanzarExcepcion() {
        int numero = -5; // Número negativo
        assertThrows(FactorialExeption.class, () ->
                factorialService.calcularFactorial(numero));
    }
}