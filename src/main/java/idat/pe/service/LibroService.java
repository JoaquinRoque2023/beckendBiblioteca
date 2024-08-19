package idat.pe.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import idat.pe.model.Libro;
import idat.pe.repository.LibroRepository;

import java.util.List;

@Service
@Transactional
public class LibroService {

    @Autowired
    private LibroRepository rep;

    public LibroService() {
    }

    public List<Libro> buscarTodo() {
        return (List<Libro>) rep.findAll();
    }

    public Libro crear(Libro libro) {
        return rep.save(libro);
    }

    public Libro actualizar(Libro libroActualizar) {
        Libro libroActual = rep.findById(libroActualizar.getIdLibro()).get();
        //libroActual.setTitulo(libroActualizar.getTitulo());
        //libroActual.setAutor(libroActualizar.getAutor());
        //libroActual.setEditorial(libroActualizar.getEditorial());
        //libroActual.setAñoPublicacion(libroActualizar.getAñoPublicacion());
        //libroActual.setIsbn(libroActualizar.getIsbn());
        //libroActual.setCategoria(libroActualizar.getCategoria());
        //libroActual.setUbicacion(libroActualizar.getUbicacion());
        libroActual.setEstado(libroActualizar.getEstado());
        return rep.save(libroActual);
    }

    public Libro buscarPorID(Integer id) {
        return rep.findById(id).get();
    }

    public void borrarPorID(Integer id) {
    	Libro libro = rep.findById(id).get();
        libro.setEstado("INACTIVO");
        rep.save(libro);
    }
}