package com.ejerciciojava.microservicio.services;

import com.ejerciciojava.microservicio.jpa.entities.ClienteEntity;
public interface ValidacionesCliente {
    ClienteEntity validarExisteCliente(String tipoDocumento, String numeroDocumento);
    void validarTipoDocumento(String tipoDocumento);
}
