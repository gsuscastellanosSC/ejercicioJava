package com.ejerciciojava.microservicio.controllers;

import com.ejerciciojava.microservicio.dtos.responses.ResultadoFactorialDTO;
import com.ejerciciojava.microservicio.services.Factorial;
import com.ejerciciojava.microservicio.services.implementation.FactorialService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.ejerciciojava.microservicio.constants.Constants.PATH_NUMBER_PARAMETER;
import static com.ejerciciojava.microservicio.constants.PathsControllers.PATH_API;
import static com.ejerciciojava.microservicio.constants.PathsControllers.PATH_FACTORIAL_CONTROLLER;

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
