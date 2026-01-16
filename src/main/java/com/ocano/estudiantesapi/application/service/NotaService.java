package com.ocano.estudiantesapi.application.service;

import com.ocano.estudiantesapi.domain.model.Nota;

import java.util.List;

public interface NotaService {

    /**
     * Links a student and a subject through a grade value.
     * The system will automatically timestamp the registration date.
     */
    Nota registrarNota(Long alumnoId, Long materiaId, Double valor);

    //Returns the academic record (all grades) of a specific student
    List<Nota> findByAlumno(Long alumnoId);

    //Returns the academic record (all grades) of a specific materia
    List<Nota> findByMateria(Long materiaId);


}
