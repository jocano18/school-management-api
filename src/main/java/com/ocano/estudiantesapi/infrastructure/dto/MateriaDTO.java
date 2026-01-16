package com.ocano.estudiantesapi.infrastructure.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record MateriaDTO(
        Long id,
        @NotBlank(message = "El nombre es obligatorio") String nombre,
        @NotBlank(message = "El código es obligatorio") String codigo,
        @NotNull(message = "Los créditos son obligatorios") Integer creditos
) {}