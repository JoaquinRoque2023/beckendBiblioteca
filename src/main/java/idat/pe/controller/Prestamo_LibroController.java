package idat.pe.controller;

import java.time.LocalDate;
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
import idat.pe.model.Prestamo_Libro;
import idat.pe.service.Prestamo_LibroService;

@RestController
@RequestMapping("/prestamos-libros")
public class Prestamo_LibroController {

    @Autowired
    private Prestamo_LibroService serv;

    @GetMapping
    public ResponseEntity<Object> buscarTodo() {
        List<Prestamo_Libro> listaPrestamosLibros = serv.buscarTodo();
        return new ResponseEntity<>(listaPrestamosLibros, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Prestamo_Libro> buscarPorID(@PathVariable("id") int idPrestamo) {
        Prestamo_Libro prestamoLibro = serv.buscarPorID(idPrestamo);
        if (prestamoLibro == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "¡Préstamo de libro no encontrado!");
        }
        return new ResponseEntity<>(prestamoLibro, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Respuesta> crear(@RequestBody Prestamo_Libro prestamoLibroNuevo) {
    	prestamoLibroNuevo.setFechaPrestamo(LocalDate.now());
        Prestamo_Libro prestamoLibroCreado = serv.crear(prestamoLibroNuevo);
        Respuesta respuesta = new Respuesta("OK",
                "Préstamo de libro creado correctamente: " + prestamoLibroCreado.getIdPrestamo());
        return new ResponseEntity<>(respuesta, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Respuesta> actualizar(@PathVariable("id") int idActualizar,
            @RequestBody Prestamo_Libro prestamoLibroActualizar) {
        Prestamo_Libro prestamoLibro = serv.buscarPorID(idActualizar);
        if (prestamoLibro == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "¡Préstamo de libro no encontrado!");
        }

        prestamoLibroActualizar.setIdPrestamo(idActualizar);
        prestamoLibroActualizar.setFechaPrestamo(prestamoLibro.getFechaPrestamo());
        serv.actualizar(prestamoLibroActualizar);
        Respuesta respuesta = new Respuesta("OK", "Préstamo de libro actualizado correctamente");
        return new ResponseEntity<>(respuesta, HttpStatus.ACCEPTED);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Respuesta> eliminar(@PathVariable("id") int idEliminar) {
        Prestamo_Libro prestamoLibro = serv.buscarPorID(idEliminar);
        if (prestamoLibro == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "¡Préstamo de libro no encontrado!");
        }
        serv.borrarPorID(idEliminar);
        Respuesta respuesta = new Respuesta("OK", "Préstamo de libro eliminado correctamente");
        return new ResponseEntity<>(respuesta, HttpStatus.ACCEPTED);
    }
}

