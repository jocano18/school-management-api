package com.ocano.estudiantesapi.application.service;

import com.ocano.estudiantesapi.domain.model.Alumno;
import com.ocano.estudiantesapi.domain.model.Materia;
import com.ocano.estudiantesapi.domain.model.Nota;
import com.ocano.estudiantesapi.domain.repository.AlumnoRepository;
import com.ocano.estudiantesapi.domain.repository.MateriaRepository;
import com.ocano.estudiantesapi.domain.repository.NotaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class NotaServiceImpl implements NotaService {

    private final NotaRepository notaRepository;
    private final AlumnoRepository alumnoRepository;
    private final MateriaRepository materiaRepository;

    public NotaServiceImpl(NotaRepository notaRepository,
                           AlumnoRepository alumnoRepository,
                           MateriaRepository materiaRepository){

        this.notaRepository = notaRepository;
        this.alumnoRepository = alumnoRepository;
        this.materiaRepository = materiaRepository;
    }

    @Override
    @Transactional
    public Nota registrarNota(Long alumnoId, Long materiaId, Double valor){
        Alumno alumno = alumnoRepository.findById(alumnoId)
                .orElseThrow(() -> new RuntimeException("No se encontró el alumno con el Id" + alumnoId));

        Materia materia = materiaRepository.findById(materiaId)
                .orElseThrow(() -> new RuntimeException("No se encontró la materia con el Id" + materiaId));

        Nota nuevaNota = new Nota();
        nuevaNota.setAlumno(alumno);
        nuevaNota.setMateria(materia);
        nuevaNota.setValor(valor);


        nuevaNota.setFechaRegistro(LocalDateTime.now());

        return notaRepository.save(nuevaNota);

    }

    @Override
    @Transactional(readOnly = true)
    public List<Nota> findByAlumno(Long alumnoId){
        if(!alumnoRepository.existsById(alumnoId)) {
            throw new RuntimeException("ALumno no econtrado");
        }
        return notaRepository.findByAlumnoId(alumnoId);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Nota> findByMateria(Long materiaId) {
        return notaRepository.findByMateriaId(materiaId);
    }



}
