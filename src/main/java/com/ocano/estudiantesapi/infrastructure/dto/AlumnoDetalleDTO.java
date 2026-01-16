package com.ocano.estudiantesapi.infrastructure.dto;
import java.time.LocalDate;
import java.util.List;

public record AlumnoDetalleDTO(
        Long id,
        String nombre,
        String apellido,
        String email,
        LocalDate fechaNacimiento,
        List<NotaDTO> notas
) {}