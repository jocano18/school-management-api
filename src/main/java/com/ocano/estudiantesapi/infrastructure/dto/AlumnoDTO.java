package com.ocano.estudiantesapi.infrastructure.dto;

import java.time.LocalDate;

public record AlumnoDTO(
        Long id,
        String nombre,
        String apellido,
        String email,
        LocalDate fechaNacimiento
) {}