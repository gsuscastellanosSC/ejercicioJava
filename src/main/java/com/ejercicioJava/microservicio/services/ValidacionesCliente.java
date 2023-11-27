package com.ejercicioJava.microservicio.services;

import com.ejercicioJava.microservicio.jpa.entities.ClienteEntity;
public interface ValidacionesCliente {
    ClienteEntity validarExisteCliente(String tipoDocumento, String numeroDocumento);
    void validarTipoDocumento(String tipoDocumento);
}
