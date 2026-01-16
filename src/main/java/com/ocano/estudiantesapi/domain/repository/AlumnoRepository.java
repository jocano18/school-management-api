package com.ocano.estudiantesapi.domain.repository;

import com.ocano.estudiantesapi.domain.model.Alumno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AlumnoRepository extends JpaRepository<Alumno, Long> {

}
