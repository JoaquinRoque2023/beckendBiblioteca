package idat.pe.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import idat.pe.model.Defecto_Libro;

@Repository
public interface Defecto_LibroRepository extends CrudRepository<Defecto_Libro, Integer> {

}
