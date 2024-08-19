package idat.pe.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import idat.pe.model.Prestamo_Computadora;

@Repository
public interface Prestamo_ComputadoraRepository extends CrudRepository<Prestamo_Computadora, Integer> {

}
