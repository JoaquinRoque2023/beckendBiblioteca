package idat.pe.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import idat.pe.model.Computadora;

@Repository
public interface ComputadoraRepository extends CrudRepository<Computadora, Integer> {

}
