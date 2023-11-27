package com.ejerciciojava.microservicio.jpa.entities;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

@Entity
@Table(name = "cliente")
@Data
@Builder
public class ClienteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "tipoDocumento", nullable = false)
    private String tipoDocumento;

    @Column(name = "numeroDocumento", nullable = false)
    private String numeroDocumento;

    @Column(name = "primerNombre")
    private String primerNombre;

    @Column(name = "segundoNombre")
    private String segundoNombre;

    @Column(name = "primerApellido")
    private String primerApellido;

    @Column(name = "segundoApellido")
    private String segundoApellido;

    @Column(name = "telefono")
    private String telefono;

    @Column(name = "direccion")
    private String direccion;

    @Column(name = "ciudadResidencia")
    private String ciudadResidencia;
}
