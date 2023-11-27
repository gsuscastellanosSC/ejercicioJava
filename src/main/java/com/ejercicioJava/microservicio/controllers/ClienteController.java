package com.ejercicioJava.microservicio.controllers;

import com.ejercicioJava.microservicio.dtos.responses.ClienteDTO;
import com.ejercicioJava.microservicio.jpa.entities.ClienteEntity;
import com.ejercicioJava.microservicio.services.ValidacionesCliente;
import org.springframework.web.bind.annotation.*;

import static com.ejercicioJava.microservicio.constants.PathsControllers.*;

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