package com.ocano.estudiantesapi.infrastructure.controller;

import com.ocano.estudiantesapi.application.service.AlumnoService;
import com.ocano.estudiantesapi.domain.model.Alumno;
import com.ocano.estudiantesapi.infrastructure.dto.AlumnoDTO;
import com.ocano.estudiantesapi.infrastructure.dto.AlumnoDetalleDTO;
import com.ocano.estudiantesapi.infrastructure.dto.NotaDTO;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST Controller to manage Alumno resources.
 * Defines the endpoints for CRUD operations using versioned mapping.
 */
@RestController
@RequestMapping("/api/v1/alumnos")
@Tag(name = "Alumnos", description = "Endpoints para la gestión de alumnos")
public class AlumnoController {

    private final AlumnoService alumnoService;

    public AlumnoController(AlumnoService alumnoService){
        this.alumnoService = alumnoService;
    }


     // CREATE A NEW ALUMNO

    @PostMapping
    public ResponseEntity<Alumno> crear(@RequestBody Alumno alumno){
        Alumno nuevoAlumno = alumnoService.save(alumno);
        
        return new ResponseEntity<>(nuevoAlumno, HttpStatus.CREATED);

    }
      @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<Map<String, String>> handleNotFound(NoSuchElementException ex) {
        Map<String, String> error = new HashMap<>();
        error.put("error", ex.getMessage());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }


     //GET ALL ALUMNOS
    @GetMapping
    public ResponseEntity<List<AlumnoDTO>> listarTodos(){
        List<AlumnoDTO> dtos = alumnoService.findAll().stream()
                .map(a -> new AlumnoDTO(a.getId(), a.getNombre(), a.getApellido(), a.getEmail(), a.getFechaNacimiento()))
                .toList();
        return ResponseEntity.ok(dtos);
    }
     


     //GET ALUMNO BY ID
    @GetMapping("/{id}")
    public ResponseEntity<AlumnoDetalleDTO> obtenerPorId(@PathVariable Long id){
        Alumno a = alumnoService.findById(id);
        List<NotaDTO> notasDto = a.getNotas().stream()
                .map(n -> new NotaDTO(n.getId(), n.getValor(), n.getMateria().getNombre()))
                .toList();

        // Constructor de 5 argumentos: id, nombre, apellido, email, notas
        AlumnoDetalleDTO detalle = new AlumnoDetalleDTO(a.getId(), a.getNombre(), a.getApellido(), a.getEmail(), a.getFechaNacimiento(), notasDto);
        return ResponseEntity.ok(detalle);
    }
      @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<Map<String, String>> handleNotFound(NoSuchElementException ex) {
        Map<String, String> error = new HashMap<>();
        error.put("error", ex.getMessage());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }


    //FULL UPDATE (PUT)
    @PutMapping("/{id}")
    public ResponseEntity<Alumno> actualizarAlumnoTotal(@PathVariable Long id, @RequestBody Alumno alumno){
        return ResponseEntity.ok(alumnoService.update(id, alumno));
    }
     @ExceptionHandler(UsuarioNoEncontradoException.class)
    public ResponseEntity<String> manejarUsuarioNoEncontrado(UsuarioNoEncontradoException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Alumno no encontrado: " + ex.getMessage());
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Alumno> actualizarAlumnoParcial(@PathVariable Long id, @RequestBody Alumno alumnoDetalles){
        return ResponseEntity.ok(alumnoService.updatePatch(id , alumnoDetalles));
    }
     @ExceptionHandler(UsuarioNoEncontradoException.class)
    public ResponseEntity<String> manejarUsuarioNoEncontrado(UsuarioNoEncontradoException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Alumno no encontrado: " + ex.getMessage());
    }


    //DELETE ALUMNO
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        alumnoService.delete(id);
        return ResponseEntity.noContent().build();
    }
     @ExceptionHandler(UsuarioNoEncontradoException.class)
    public ResponseEntity<String> manejarUsuarioNoEncontrado(UsuarioNoEncontradoException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Alumno no encontrado no es posible elimanarlo: " + ex.getMessage());
    }
}