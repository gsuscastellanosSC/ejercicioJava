package com.ejerciciojava.microservicio.services.implementation;

import com.ejerciciojava.microservicio.exceptions.NotFoundException;
import com.ejerciciojava.microservicio.jpa.entities.ClienteEntity;
import com.ejerciciojava.microservicio.jpa.repositories.ClienteRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ValidacionesClienteServiceTest {

    @InjectMocks
    private ValidacionesClienteService validacionesClienteService;
    @Mock
    private ClienteRepository clienteRepository;

    private String tipoDocumento = "C";
    private String numeroDocumento = "12345";

    @BeforeEach
    void setUp() {
        tipoDocumento = "C";
        numeroDocumento = "12345";
    }

    @Test
    void testValidarExisteClienteClienteEncontrado() {

        when(clienteRepository.findByTipoDocumentoAndNumeroDocumento(anyString(), anyString()))
                .thenReturn(Optional.of( ClienteEntity.builder().build()));

        assertDoesNotThrow(() -> {
            validacionesClienteService.validarExisteCliente(tipoDocumento, numeroDocumento);
        });
    }

    @Test
    void testValidarExisteClienteClienteNoEncontrado() {

        when(clienteRepository.findByTipoDocumentoAndNumeroDocumento(anyString(), anyString()))
                .thenReturn(Optional.empty());

        assertThrows(NotFoundException.class, () ->
                validacionesClienteService.validarExisteCliente(tipoDocumento, numeroDocumento));
    }

    @Test
    void testValidarTipoDocumentoTipoDocumentoNoValido() {
        tipoDocumento = "Z";

        assertThrows(NotFoundException.class, () ->
                validacionesClienteService.validarTipoDocumento(tipoDocumento));
    }

}