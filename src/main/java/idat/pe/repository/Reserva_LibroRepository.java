package idat.pe.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import idat.pe.model.Reserva_Libro;

@Repository
public interface Reserva_LibroRepository extends CrudRepository<Reserva_Libro, Integer> {

}
