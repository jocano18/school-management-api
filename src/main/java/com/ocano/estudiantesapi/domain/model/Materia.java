package com.ocano.estudiantesapi.domain.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "materias")
@Data
public class Materia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    @NotBlank(message = "El nombre de la asignatura no puede estar en blanco")
    @Size(min = 2, max = 100)
    @Column(nullable = false, unique = true, length = 100)
    private String nombre;


    @NotBlank(message = "El Codigo de la asignatura no puede estar en blanco")
    @Size(min = 2, max = 100)
    @Column(nullable = false, unique = true, length = 100)
    private String codigo;

    @NotNull(message = "Los créditos son obligatorios")
    @Min(value = 1, message = "La materia debe tener al menos 1 crédito")
    @Column(nullable = false)
    private Integer creditos;

    // Relationship
    @OneToMany(mappedBy = "materia", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference(value = "materia-nota")
    private List<Nota> notas = new ArrayList<>();

}