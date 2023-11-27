package com.ejercicioJava.microservicio.dtos;

import lombok.Data;

@Data
public class ClienteDTO {
    private String tipoDocumento;
    private String numeroDocumento;
}
