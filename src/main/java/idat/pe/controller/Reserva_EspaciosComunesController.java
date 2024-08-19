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

import idat.pe.model.Reserva_EspaciosComunes;
import idat.pe.service.Reserva_EspaciosComunesService;

@RestController
@RequestMapping("/reservas-espacios-comunes")
public class Reserva_EspaciosComunesController {

    @Autowired
    private Reserva_EspaciosComunesService serv;

    @GetMapping
    public ResponseEntity<List<Reserva_EspaciosComunes>> buscarTodo() {
        List<Reserva_EspaciosComunes> listaReservas = serv.buscarTodo();
        return new ResponseEntity<>(listaReservas, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Reserva_EspaciosComunes> buscarPorID(@PathVariable("id") Integer id) {
        Reserva_EspaciosComunes reserva = serv.buscarPorID(id);
        if (reserva == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "¡Reserva no encontrada!");
        }
        return new ResponseEntity<>(reserva, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Reserva_EspaciosComunes> crear(@RequestBody Reserva_EspaciosComunes nuevaReserva) {
        Reserva_EspaciosComunes reservaCreada = serv.crear(nuevaReserva);
        return new ResponseEntity<>(reservaCreada, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Reserva_EspaciosComunes> actualizar(@PathVariable("id") Integer id,
            @RequestBody Reserva_EspaciosComunes reservaActualizar) {
        Reserva_EspaciosComunes reservaExistente = serv.buscarPorID(id);
        if (reservaExistente == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "¡Reserva no encontrada!");
        }

        reservaActualizar.setIdReservaEspacio(id);
        Reserva_EspaciosComunes reservaActualizada = serv.actualizar(reservaActualizar);
        return new ResponseEntity<>(reservaActualizada, HttpStatus.ACCEPTED);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> eliminar(@PathVariable("id") Integer id) {
        Reserva_EspaciosComunes reserva = serv.buscarPorID(id);
        if (reserva == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "¡Reserva no encontrada!");
        }
        serv.borrarPorID(id);
        return new ResponseEntity<>("Reserva eliminada correctamente", HttpStatus.ACCEPTED);
    }
}
