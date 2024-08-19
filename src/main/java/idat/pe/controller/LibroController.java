package idat.pe.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import idat.pe.Respuesta;
import idat.pe.model.Libro;
import idat.pe.service.LibroService;

@RestController
@RequestMapping("/libros")
public class LibroController {
    
    @Autowired
    private LibroService serv;
    
    @GetMapping
    public ResponseEntity<Object> buscarTodo(){
    	System.out.println("ingreso a libros");
        List<Libro> listaLibros = serv.buscarTodo();
        return new ResponseEntity<>(listaLibros, HttpStatus.OK);
    }
    
    @GetMapping(value = "/{id}")
    public ResponseEntity<Libro> buscarPorID(@PathVariable("id") int idLibro) {
        Libro libro = serv.buscarPorID(idLibro);
        if (libro == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "¡Libro no encontrado!");
        }
        return new ResponseEntity<>(libro, HttpStatus.OK);
    }
    
    @PostMapping
    public ResponseEntity<Respuesta> crear(@RequestBody Libro libroNuevo) {
        Libro libroCreado = serv.crear(libroNuevo);
        Respuesta respuesta = new Respuesta("OK",
                "Libro creado correctamente : " + libroCreado.getIdLibro());
        return new ResponseEntity<>(respuesta, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Respuesta> actualizar(@PathVariable("id") int idActualizar,
            @RequestBody Libro libroActualizar) {
        Libro libro = serv.buscarPorID(idActualizar);
        if (libro == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "¡Libro no encontrado!");
        }
        
        libroActualizar.setIdLibro(idActualizar);
        
        serv.actualizar(libroActualizar);
        Respuesta respuesta = new Respuesta("OK", "Libro actualizado correctamente");
        return new ResponseEntity<>(respuesta, HttpStatus.ACCEPTED);
    }
    
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Respuesta> eliminar(@PathVariable("id") int idEliminar) {
        Libro libro = serv.buscarPorID(idEliminar);
        if (libro == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "¡Libro no encontrado!");
        }
        serv.borrarPorID(idEliminar);
        Respuesta respuesta = new Respuesta("OK", "Libro eliminado correctamente");
        return new ResponseEntity<>(respuesta, HttpStatus.ACCEPTED);
    }
}
