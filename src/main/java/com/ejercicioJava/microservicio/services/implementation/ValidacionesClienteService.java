package com.ejercicioJava.microservicio.services.implementation;
import com.ejercicioJava.microservicio.enums.DocumentType;
import com.ejercicioJava.microservicio.jpa.entities.ClienteEntity;
import com.ejercicioJava.microservicio.exceptions.NotFoundException;
import com.ejercicioJava.microservicio.jpa.repositories.ClienteRepository;
import com.ejercicioJava.microservicio.services.ValidacionesCliente;
import org.springframework.stereotype.Service;

import static com.ejercicioJava.microservicio.enums.DocumentType.*;
import static com.ejercicioJava.microservicio.enums.ErrorMessages.CLIENT_NOT_FOUND;
import static com.ejercicioJava.microservicio.enums.ErrorMessages.INVALID_DOCUMENT_TYPE;
import static com.ejercicioJava.microservicio.utils.StringUtils.convertToUpperCase;

@Service
public class ValidacionesClienteService implements ValidacionesCliente {
    private final ClienteRepository clienteRepository;

    public ValidacionesClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    public ClienteEntity validarExisteCliente(String tipoDocumento, String numeroDocumento) {
        validarTipoDocumento(tipoDocumento);
        return clienteRepository.findByTipoDocumentoAndNumeroDocumento(convertToUpperCase(tipoDocumento), numeroDocumento)
                .orElseThrow(() -> new NotFoundException(CLIENT_NOT_FOUND.getMessage()));
    }
    @Override
    public void validarTipoDocumento(String tipoDocumento) {
        if (!DOCUMENTS.contains(convertToUpperCase(tipoDocumento))) {
            throw new NotFoundException(INVALID_DOCUMENT_TYPE.getMessage());
        }
    }
}
