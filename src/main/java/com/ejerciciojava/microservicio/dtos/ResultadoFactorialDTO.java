package com.ejerciciojava.microservicio.dtos;

import lombok.Data;

@Data
public class ResultadoFactorialDTO {
    private final int numero;
    private final long factorial;
}
