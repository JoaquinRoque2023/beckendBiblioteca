package idat.pe.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import idat.pe.model.Defecto_Libro;
import idat.pe.repository.Defecto_LibroRepository;

import java.util.List;

@Service
@Transactional
public class Defecto_LibroService {

    @Autowired
    private Defecto_LibroRepository rep;

    public Defecto_LibroService() {
    }

    public List<Defecto_Libro> buscarTodo() {
        return (List<Defecto_Libro>) rep.findAll();
    }

    public Defecto_Libro crear(Defecto_Libro defectoLibro) {
        return rep.save(defectoLibro);
    }

    public Defecto_Libro actualizar(Defecto_Libro defectoLibroActualizar) {
        Defecto_Libro defectoLibroActual = rep.findById(defectoLibroActualizar.getIdDefecto()).get();
        defectoLibroActual.setLibro(defectoLibroActualizar.getLibro());
        defectoLibroActual.setFechaRegistro(defectoLibroActualizar.getFechaRegistro());
        defectoLibroActual.setDescripcion(defectoLibroActualizar.getDescripcion());
        return rep.save(defectoLibroActual);
    }

    public Defecto_Libro buscarPorID(Integer id) {
        return rep.findById(id).get();
    }

    public void borrarPorID(Integer id) {
        rep.deleteById(id);
    }
}
