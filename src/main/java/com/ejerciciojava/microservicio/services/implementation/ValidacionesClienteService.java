package com.ejerciciojava.microservicio.services.implementation;
import com.ejerciciojava.microservicio.exceptions.NotFoundException;
import com.ejerciciojava.microservicio.utils.StringUtils;
import com.ejerciciojava.microservicio.jpa.entities.ClienteEntity;
import com.ejerciciojava.microservicio.jpa.repositories.ClienteRepository;
import com.ejerciciojava.microservicio.services.ValidacionesCliente;
import org.springframework.stereotype.Service;

import static com.ejerciciojava.microservicio.enums.DocumentType.*;
import static com.ejerciciojava.microservicio.enums.ErrorMessages.CLIENT_NOT_FOUND;
import static com.ejerciciojava.microservicio.enums.ErrorMessages.INVALID_DOCUMENT_TYPE;

@Service
public class ValidacionesClienteService implements ValidacionesCliente {
    private final ClienteRepository clienteRepository;

    public ValidacionesClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    public ClienteEntity validarExisteCliente(String tipoDocumento, String numeroDocumento) {
        validarTipoDocumento(tipoDocumento);
        return clienteRepository.findByTipoDocumentoAndNumeroDocumento(StringUtils.convertToUpperCase(tipoDocumento), numeroDocumento)
                .orElseThrow(() -> new NotFoundException(CLIENT_NOT_FOUND.getMessage()));
    }
    @Override
    public void validarTipoDocumento(String tipoDocumento) {
        if (!DOCUMENTS.contains(StringUtils.convertToUpperCase(tipoDocumento))) {
            throw new NotFoundException(INVALID_DOCUMENT_TYPE.getMessage());
        }
    }
}
