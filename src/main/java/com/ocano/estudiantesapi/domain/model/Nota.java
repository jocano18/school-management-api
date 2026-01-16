package com.ocano.estudiantesapi.domain.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "notas")
@Data
public class Nota {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id" , nullable = false, updatable = false)
    private Long id;

    @NotNull(message = "La nota no puede estar en blanco")
    @Min(value = 0, message = "La nota minima debe ser 0")
    private Double valor;

    @NotNull(message = "La fecha de registro no puede estar en blanco")
    private LocalDateTime fechaRegistro;

    // Relationship
    @ManyToOne
    @JoinColumn(name = "alumno_id")
    @JsonBackReference
    private Alumno alumno;

    @ManyToOne
    @JoinColumn(name = "materia_id")
    @JsonBackReference(value = "materia-nota")
    private Materia materia;
}