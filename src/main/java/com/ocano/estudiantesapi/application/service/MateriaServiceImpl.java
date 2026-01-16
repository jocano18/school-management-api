package com.ocano.estudiantesapi.application.service;

import com.ocano.estudiantesapi.domain.model.Materia;
import com.ocano.estudiantesapi.domain.repository.MateriaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MateriaServiceImpl implements MateriaService {

        private final MateriaRepository materiaRepository;

        public MateriaServiceImpl(MateriaRepository materiaRepository){
            this.materiaRepository = materiaRepository;
        }

        @Override
        @Transactional
        public Materia save(Materia materia){
            return materiaRepository.save(materia);
        }

        @Override
        @Transactional(readOnly = true)
        public List<Materia> findAll() {
            return materiaRepository.findAll();
        }

        @Override
        @Transactional(readOnly = true)
        public Materia findById(Long id){
            return materiaRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Materia no encontrada con ID" + id));
        }

        @Override
        @Transactional
        public Materia update(Long id, Materia materiaDetails){
            Materia materiaExistente = findById(id);

            materiaExistente.setNombre(materiaDetails.getNombre());
            materiaExistente.setCodigo(materiaDetails.getCodigo());
            materiaExistente.setCreditos(materiaDetails.getCreditos());

            return materiaRepository.save(materiaExistente);

        }

        @Override
        @Transactional
        public Materia updatePatch(Long id, Materia materiaDetails){
            Materia materiaExistente = findById(id);
            if (materiaDetails.getNombre() != null){
                materiaExistente.setNombre(materiaDetails.getNombre());
            }
            if (materiaDetails.getCodigo() != null){
                materiaExistente.setCodigo(materiaDetails.getCodigo());
            }
            if (materiaDetails.getCreditos() != null){
                materiaExistente.setCreditos(materiaDetails.getCreditos());
            }
            return materiaRepository.save(materiaExistente);

        }

        @Override
        @Transactional

        public void  delete(Long id){
            Materia materia = findById(id);
            materiaRepository.delete(materia);
        }


    }

