package idat.pe.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import idat.pe.model.Libro;

@Repository
public interface LibroRepository extends CrudRepository<Libro, Integer> {

}
