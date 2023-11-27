package com.ejercicioJava.microservicio.jpa.repositories;

import com.ejercicioJava.microservicio.jpa.entities.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClienteRepository extends JpaRepository<ClienteEntity, Long> {
    Optional<ClienteEntity> findByTipoDocumentoAndNumeroDocumento(String tipoDocumento, String numeroDocumento);
}