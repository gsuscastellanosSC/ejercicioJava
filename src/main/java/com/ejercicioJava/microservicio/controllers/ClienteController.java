package com.ejercicioJava.microservicio.controllers;

import com.ejercicioJava.microservicio.dtos.ClienteDTO;
import com.ejercicioJava.microservicio.jpa.entities.ClienteEntity;
import com.ejercicioJava.microservicio.services.ValidacionesCliente;
import org.springframework.web.bind.annotation.*;

import static com.ejercicioJava.microservicio.constants.PathsControllers.PATH_CONTROLLER_CLIENTES;
import static com.ejercicioJava.microservicio.constants.PathsControllers.PATH_MICRO_SERVICE_CLIENTES;

@RestController
@RequestMapping(PATH_CONTROLLER_CLIENTES)
public class ClienteController {

    private final ValidacionesCliente validacionesCliente;

    public ClienteController(ValidacionesCliente validacionesCliente) {
        this.validacionesCliente = validacionesCliente;
    }

    @PostMapping(PATH_MICRO_SERVICE_CLIENTES)
    public ClienteEntity obtenerInformacionCliente(@RequestBody ClienteDTO clienteDTO) {
        return validacionesCliente.validarExisteCliente(clienteDTO.getTipoDocumento(), clienteDTO.getNumeroDocumento());
    }
}