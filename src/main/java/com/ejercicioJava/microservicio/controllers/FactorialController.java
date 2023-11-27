package com.ejercicioJava.microservicio.controllers;

import com.ejercicioJava.microservicio.dtos.responses.ResultadoFactorialDTO;
import com.ejercicioJava.microservicio.services.Factorial;
import com.ejercicioJava.microservicio.services.implementation.FactorialService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.ejercicioJava.microservicio.constants.Constants.PATH_NUMBER_PARAMETER;
import static com.ejercicioJava.microservicio.constants.PathsControllers.PATH_API;
import static com.ejercicioJava.microservicio.constants.PathsControllers.PATH_FACTORIAL_CONTROLLER;

@RestController
@RequestMapping(PATH_API)
public class FactorialController {
    private final Factorial factorialService;

    public FactorialController(FactorialService factorialService) {
        this.factorialService = factorialService;
    }

    @GetMapping(PATH_FACTORIAL_CONTROLLER)
    public ResponseEntity<ResultadoFactorialDTO> calcularFactorial(
            @PathVariable(PATH_NUMBER_PARAMETER) int numero) {
        long factorial = factorialService.calcularFactorial(numero);
        return ResponseEntity.ok(new ResultadoFactorialDTO(numero, factorial));
    }
}
