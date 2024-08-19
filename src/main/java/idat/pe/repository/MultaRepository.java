package idat.pe.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import idat.pe.model.Multa;

@Repository
public interface MultaRepository extends CrudRepository<Multa, Integer> {

}
