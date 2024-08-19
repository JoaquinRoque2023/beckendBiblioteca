package idat.pe.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import idat.pe.model.Devolucion_Libro;
import idat.pe.repository.Devolucion_LibroRepository;

import java.util.List;

@Service
@Transactional
public class Devolucion_LibroService {

    @Autowired
    private Devolucion_LibroRepository rep;

    public Devolucion_LibroService() {
    }

    public List<Devolucion_Libro> buscarTodo() {
        return (List<Devolucion_Libro>) rep.findAll();
    }

    public Devolucion_Libro crear(Devolucion_Libro devolucionLibro) {
        return rep.save(devolucionLibro);
    }

    public Devolucion_Libro actualizar(Devolucion_Libro devolucionLibroActualizar) {
        Devolucion_Libro devolucionLibroActual = rep.findById(devolucionLibroActualizar.getIdDevolucion()).get();
        devolucionLibroActual.setPrestamo(devolucionLibroActualizar.getPrestamo());
        devolucionLibroActual.setFechaDevolucion(devolucionLibroActualizar.getFechaDevolucion());
        devolucionLibroActual.setEstadoLibro(devolucionLibroActualizar.getEstadoLibro());
        return rep.save(devolucionLibroActual);
    }

    public Devolucion_Libro buscarPorID(Integer id) {
        return rep.findById(id).get();
    }

    public void borrarPorID(Integer id) {
        rep.deleteById(id);
    }
}
