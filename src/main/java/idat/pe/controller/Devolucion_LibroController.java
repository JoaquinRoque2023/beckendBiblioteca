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
import idat.pe.model.Devolucion_Libro;
import idat.pe.service.Devolucion_LibroService;

@RestController
@RequestMapping("/devoluciones-libros")
public class Devolucion_LibroController {

    @Autowired
    private Devolucion_LibroService serv;

    @GetMapping
    public ResponseEntity<Object> buscarTodo() {
        List<Devolucion_Libro> listaDevolucionesLibros = serv.buscarTodo();
        return new ResponseEntity<>(listaDevolucionesLibros, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Devolucion_Libro> buscarPorID(@PathVariable("id") int idDevolucion) {
        Devolucion_Libro devolucionLibro = serv.buscarPorID(idDevolucion);
        if (devolucionLibro == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "¡Devolución de libro no encontrada!");
        }
        return new ResponseEntity<>(devolucionLibro, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Respuesta> crear(@RequestBody Devolucion_Libro devolucionLibroNuevo) {
    	devolucionLibroNuevo.setFechaDevolucion(LocalDate.now());
        Devolucion_Libro devolucionLibroCreado = serv.crear(devolucionLibroNuevo);
        Respuesta respuesta = new Respuesta("OK",
                "Devolución de libro creada correctamente: " + devolucionLibroCreado.getIdDevolucion());
        return new ResponseEntity<>(respuesta, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Respuesta> actualizar(@PathVariable("id") int idActualizar,
            @RequestBody Devolucion_Libro devolucionLibroActualizar) {
        Devolucion_Libro devolucionLibro = serv.buscarPorID(idActualizar);
        if (devolucionLibro == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "¡Devolución de libro no encontrada!");
        }

        devolucionLibroActualizar.setIdDevolucion(idActualizar);
        devolucionLibroActualizar.setFechaDevolucion(devolucionLibro.getFechaDevolucion());
        serv.actualizar(devolucionLibroActualizar);
        Respuesta respuesta = new Respuesta("OK", "Devolución de libro actualizada correctamente");
        return new ResponseEntity<>(respuesta, HttpStatus.ACCEPTED);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Respuesta> eliminar(@PathVariable("id") int idEliminar) {
        Devolucion_Libro devolucionLibro = serv.buscarPorID(idEliminar);
        if (devolucionLibro == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "¡Devolución de libro no encontrada!");
        }
        serv.borrarPorID(idEliminar);
        Respuesta respuesta = new Respuesta("OK", "Devolución de libro eliminada correctamente");
        return new ResponseEntity<>(respuesta, HttpStatus.ACCEPTED);
    }
}

