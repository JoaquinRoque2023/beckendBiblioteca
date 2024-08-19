package idat.pe.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import idat.pe.model.Reserva_Computadora;

@Repository
public interface Reserva_ComputadoraRepository extends CrudRepository<Reserva_Computadora, Integer> {

}
