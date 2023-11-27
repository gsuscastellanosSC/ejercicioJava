package com.ejerciciojava.microservicio.dtos.responses;

import lombok.Data;

@Data
public class ResultadoFactorialDTO {
    private final int numero;
    private final long factorial;
}
