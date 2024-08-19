package idat.pe.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import idat.pe.model.Prestamo_Libro;

@Repository
public interface Prestamo_LibroRepository extends CrudRepository<Prestamo_Libro, Integer> {

}
