package com.ocano.estudiantesapi.application.service;

import com.ocano.estudiantesapi.domain.model.Alumno;

import java.util.List;

public interface AlumnoService {

    //Register a new Student in the database.
    Alumno save(Alumno alumno);

    // Get All registered Students in the System
    List<Alumno> findAll();

    //Find Specific Student by their id
    Alumno findById(Long id);

    //Update a Specific Student by their id (Total)
    Alumno update(Long id, Alumno alumno);

    //Update a Specific Student by their id using PATCH
    Alumno updatePatch(Long id, Alumno alumnoDetails);
    //Delete a Specific Student by their id
    void delete(Long id);

}
