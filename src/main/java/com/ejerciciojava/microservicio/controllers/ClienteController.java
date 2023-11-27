package com.ejerciciojava.microservicio.controllers;

import com.ejerciciojava.microservicio.dtos.responses.ClienteDTO;
import com.ejerciciojava.microservicio.jpa.entities.ClienteEntity;
import com.ejerciciojava.microservicio.services.ValidacionesCliente;
import org.springframework.web.bind.annotation.*;

import static com.ejerciciojava.microservicio.constants.PathsControllers.*;

@RestController
@RequestMapping(PATH_CLIENTES_CONTROLLER)
public class ClienteController {

    private final ValidacionesCliente validacionesCliente;

    public ClienteController(ValidacionesCliente validacionesCliente) {
        this.validacionesCliente = validacionesCliente;
    }

    @PostMapping(PATH_CONSULTAR_CLIENTES_CONTROLLER)
    public ClienteEntity obtenerInformacionCliente(@RequestBody ClienteDTO clienteDTO) {
        return validacionesCliente.validarExisteCliente(clienteDTO.getTipoDocumento(), clienteDTO.getNumeroDocumento());
    }
}