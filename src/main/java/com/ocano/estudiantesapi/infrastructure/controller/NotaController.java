package com.ocano.estudiantesapi.infrastructure.controller;

import com.ocano.estudiantesapi.application.service.NotaService;
import com.ocano.estudiantesapi.domain.model.Nota;
import com.ocano.estudiantesapi.infrastructure.dto.NotaDTO;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Tag(name = "Notas", description = "Endpoints para la gestión de Notas")
@RestController
@RequestMapping("/api/v1/notas")
public class NotaController {

    private final NotaService notaService;

    public NotaController(NotaService notaService){
        this.notaService = notaService;
    }


     //REGISTER A NEW GRADE
    @PostMapping
    public ResponseEntity<Nota> registrarNota(
            @RequestParam Long alumnoId,
            @RequestParam Long materiaId,
            @RequestParam double valor){
        Nota notaNueva = notaService.registrarNota(alumnoId, materiaId, valor);
        return new ResponseEntity<>(notaNueva , HttpStatus.CREATED);
    }
    
     //GET ALL GRADES FOR A SPECIFIC STUDENT
    @GetMapping("/alumno/{id}")
    public ResponseEntity<List<NotaDTO>> listarPorAlumno(@PathVariable Long id){
        List<NotaDTO> notasDto = notaService.findByAlumno(id).stream()
                .map(n -> new NotaDTO(n.getId(), n.getValor(), n.getMateria().getNombre()))
                .toList();
        return ResponseEntity.ok(notasDto);
    }
     @ExceptionHandler(UsuarioNoEncontradoException.class)
    public ResponseEntity<String> manejarAlumnoNoEncontrado(AlumnoNoEncontradoException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Alumno no encontrado: " + ex.getMessage());
    }

}