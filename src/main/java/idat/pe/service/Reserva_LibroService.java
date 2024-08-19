package idat.pe.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import idat.pe.model.Reserva_Libro;
import idat.pe.repository.Reserva_LibroRepository;

import java.util.List;

@Service
@Transactional
public class Reserva_LibroService {

    @Autowired
    private Reserva_LibroRepository rep;

    public Reserva_LibroService() {
    }

    public List<Reserva_Libro> buscarTodo() {
        return (List<Reserva_Libro>) rep.findAll();
    }

    public Reserva_Libro crear(Reserva_Libro reservaLibro) {
        return rep.save(reservaLibro);
    }

    public Reserva_Libro actualizar(Reserva_Libro reservaLibroActualizar) {
        Reserva_Libro reservaLibroActual = rep.findById(reservaLibroActualizar.getIdReserva()).get();
        reservaLibroActual.setUsuario(reservaLibroActualizar.getUsuario());
        reservaLibroActual.setLibro(reservaLibroActualizar.getLibro());
        reservaLibroActual.setFechaReserva(reservaLibroActualizar.getFechaReserva());
        return rep.save(reservaLibroActual);
    }

    public Reserva_Libro buscarPorID(Integer id) {
        return rep.findById(id).get();
    }

    public void borrarPorID(Integer id) {
        rep.deleteById(id);
    }
}
