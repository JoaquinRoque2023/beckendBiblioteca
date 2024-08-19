package idat.pe.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import idat.pe.model.Prestamo_Libro;
import idat.pe.repository.Prestamo_LibroRepository;

import java.util.List;

@Service
@Transactional
public class Prestamo_LibroService {

    @Autowired
    private Prestamo_LibroRepository rep;

    public Prestamo_LibroService() {
    }

    public List<Prestamo_Libro> buscarTodo() {
        return (List<Prestamo_Libro>) rep.findAll();
    }

    public Prestamo_Libro crear(Prestamo_Libro prestamoLibro) {
        return rep.save(prestamoLibro);
    }

    public Prestamo_Libro actualizar(Prestamo_Libro prestamoLibroActualizar) {
        Prestamo_Libro prestamoLibroActual = rep.findById(prestamoLibroActualizar.getIdPrestamo()).get();
        prestamoLibroActual.setUsuario(prestamoLibroActualizar.getUsuario());
        prestamoLibroActual.setLibro(prestamoLibroActualizar.getLibro());
        prestamoLibroActual.setFechaPrestamo(prestamoLibroActualizar.getFechaPrestamo());
        prestamoLibroActual.setFechaDevolucion(prestamoLibroActualizar.getFechaDevolucion());
        return rep.save(prestamoLibroActual);
    }

    public Prestamo_Libro buscarPorID(Integer id) {
        return rep.findById(id).get();
    }

    public void borrarPorID(Integer id) {
        rep.deleteById(id);
    }
}