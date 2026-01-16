package com.ocano.estudiantesapi.application.service;
import com.ocano.estudiantesapi.domain.model.Alumno;
import com.ocano.estudiantesapi.domain.model.Materia;

import java.util.List;

public interface MateriaService {

    //Create a new Subject in the database
    Materia save(Materia materia);

    //Get All registered Subjects in the system
    List<Materia> findAll();

    //Find Specific Subject by their id
    Materia findById(Long id);

    //Update a Specific Subject
    Materia update(Long id, Materia materia);

    //Update a Specific Student by their id using PATCH
    Materia updatePatch(Long id, Materia materiaDetails);

    //Delete a Specific Subject by their id
    void delete(Long id);

}
