package idat.pe.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import idat.pe.model.Reserva_EspaciosComunes;

@Repository
public interface Reserva_EspaciosComunesRepository extends CrudRepository<Reserva_EspaciosComunes, Integer> {

}
