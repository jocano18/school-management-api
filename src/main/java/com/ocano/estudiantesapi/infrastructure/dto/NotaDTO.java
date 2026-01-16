package com.ocano.estudiantesapi.infrastructure.dto;

public record NotaDTO(
        Long id,
        Double valor,
        String nombreMateria
) {}