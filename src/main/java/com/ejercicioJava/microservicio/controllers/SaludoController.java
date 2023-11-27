package com.ejercicioJava.microservicio.controllers;

import com.ejercicioJava.microservicio.dtos.responses.SaludoDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.ejercicioJava.microservicio.constants.Constants.*;
import static com.ejercicioJava.microservicio.constants.PathsControllers.*;

@RestController
@RequestMapping(PATH_API)
public class SaludoController {

    @GetMapping(PATH_HOLA_SALUDO_CONTROLLER)
    public SaludoDTO saludo() {
        return new SaludoDTO(STRING_GREETING.concat(STRING_TEAM_NAME));
    }
}
