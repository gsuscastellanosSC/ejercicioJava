package com.ejerciciojava.microservicio.dtos.responses;

import lombok.Data;

@Data
public class ClienteDTO {
    private String tipoDocumento;
    private String numeroDocumento;
}
