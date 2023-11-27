package com.ejercicioJava.microservicio.enums;

import lombok.Getter;

@Getter
public enum ErrorMessages {

    INTERNAL_SERVER_ERROR("Error interno del servidor"),
    NOT_FOUND_ERROR("Página no encontrada (404)"),
    GENERAL_EXCEPTION("Se ha producido una excepción"),
    CLIENT_NOT_FOUND("Cliente no encontrado"),
    INVALID_DOCUMENT_TYPE("Tipo de documento no válido"),
    NEGATIVE_NUMBER("El número debe ser no negativo");

    private final String message;
    ErrorMessages(String message) {
        this.message = message;
    }
}
