package idat.pe.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import idat.pe.model.Devolucion_Libro;

@Repository
public interface Devolucion_LibroRepository extends CrudRepository<Devolucion_Libro, Integer> {

}
