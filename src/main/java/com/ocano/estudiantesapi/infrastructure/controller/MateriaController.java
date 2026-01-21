package com.ocano.estudiantesapi.infrastructure.controller;

import com.ocano.estudiantesapi.application.service.MateriaService;
import com.ocano.estudiantesapi.domain.model.Materia;
import com.ocano.estudiantesapi.infrastructure.dto.MateriaDTO;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/materias")
@Tag(name = "Materias", description = "Endpoints para la gestión de materias")
public class MateriaController {
    private final MateriaService materiaService;

    public MateriaController(MateriaService materiaService){
        this.materiaService = materiaService;
    }


     //CREATE A NEW MATERIA
    @PostMapping
    public ResponseEntity<Materia> create(@RequestBody Materia materia){
        Materia materiaNueva = materiaService.save(materia);
        return new ResponseEntity<>(materiaNueva, HttpStatus.CREATED);
    }


     //GET ALL MATERIAS
    @GetMapping
    public ResponseEntity<List<MateriaDTO>> listarTodo(){
        List<MateriaDTO> dtos = materiaService.findAll().stream()
                .map(m -> new MateriaDTO(m.getId(), m.getNombre(), m.getCodigo(), m.getCreditos()))
                .toList();
        return ResponseEntity.ok(dtos);
    }


     //GET MATERIA BY ID
    @GetMapping("/{id}")
    public ResponseEntity<Materia> obtenerPorId(@PathVariable Long id){
        return ResponseEntity.ok(materiaService.findById(id));
    }
     @ExceptionHandler(MateriaNoEncontradoException.class)
    public ResponseEntity<String> manejarMateriaoNoEncontrado(MateriaNoEncontradoException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Materia no encontrada " + ex.getMessage());
    }


     //FULL UPDATE (PUT)
    @PutMapping("/{id}")
    public ResponseEntity<Materia> actualizarTodo(@PathVariable Long id, @RequestBody Materia materiaDetails) {
        return ResponseEntity.ok(materiaService.update(id, materiaDetails));
    }
    @ExceptionHandler(MateriaNoEncontradoException.class)
    public ResponseEntity<String> manejarMateriaoNoEncontrado(MateriaNoEncontradoException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Materia no encontrado" + ex.getMessage());
    }        .body("Usuario no encontrado: " + ex.getMessage());
    }
    @PatchMapping("/{id}")
    public ResponseEntity<Materia> actualizarParcial(@PathVariable Long id, @RequestBody Materia materiaDetails){
        return ResponseEntity.ok(materiaService.updatePatch(id, materiaDetails));
    }

    @ExceptionHandler(MateriaNoEncontradoException.class)
    public ResponseEntity<String> manejarMateriaoNoEncontrado(MateriaNoEncontradoException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Materia no encontrado" + ex.getMessage());
    }


     //DELETE MATERIA

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        materiaService.delete(id);
        return ResponseEntity.noContent().build();
    }
     @ExceptionHandler(MateriaNoEncontradoException.class)
    public ResponseEntity<String> manejarMateriaoNoEncontrado(MateriaNoEncontradoException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Materia no encontrado:No puedes elimnarlo " + ex.getMessage());
    }
}