package com.ocano.estudiantesapi.application.service;

import com.ocano.estudiantesapi.domain.model.Alumno;
import com.ocano.estudiantesapi.domain.repository.AlumnoRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlumnoServiceImpl implements AlumnoService {

        private final AlumnoRepository alumnoRepository;

        public AlumnoServiceImpl(AlumnoRepository alumnoRepository){
            this.alumnoRepository = alumnoRepository;
        }

        @Override
        @Transactional
        public Alumno save(Alumno alumno){
            return alumnoRepository.save(alumno);
        }

        @Override
        @Transactional(readOnly = true)
        public List<Alumno> findAll(){
            return alumnoRepository.findAll();
        }

        @Override
        @Transactional(readOnly = true)
        public Alumno findById(Long id){
            return alumnoRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Alumno no econtrado con ID" + id));
        }

        @Override
        @Transactional
        public Alumno update(Long id, Alumno alumnoDetails){
            Alumno alumnoExistente = findById(id);

            alumnoExistente.setNombre(alumnoDetails.getNombre());
            alumnoExistente.setApellido(alumnoDetails.getApellido());
            alumnoExistente.setEmail(alumnoDetails.getEmail());
            alumnoExistente.setFechaNacimiento(alumnoDetails.getFechaNacimiento());

            return alumnoRepository.save(alumnoExistente);
        }

        @Override
        @Transactional
        public Alumno updatePatch(Long id, Alumno alumnoDetails){
            Alumno alumnoExistente = findById(id);
            if (alumnoDetails.getNombre() != null){
                alumnoExistente.setNombre(alumnoDetails.getNombre());
            }
            if (alumnoDetails.getApellido() != null){
                alumnoExistente.setNombre(alumnoDetails.getApellido());
            }
            if (alumnoDetails.getEmail() != null){
                alumnoExistente.setNombre(alumnoDetails.getEmail());
            }
            return alumnoRepository.save(alumnoExistente);

        }

        @Override
        @Transactional
        public void delete(Long id){
            Alumno alumno = findById(id);
            alumnoRepository.delete(alumno);
        }

    }



