package com.ejerciciojava.microservicio.enums;

import lombok.Getter;
import lombok.experimental.Accessors;

import java.util.Set;

@Getter
@Accessors(fluent = false)
public enum DocumentType {

    CEDULA("C"),
    PASAPORTE("P");

    private final String documentName;

    DocumentType(String documentName) {
        this.documentName = documentName;
    }

    public static final Set<String> DOCUMENTS = Set.of(CEDULA.getDocumentName(), PASAPORTE.getDocumentName());
}
