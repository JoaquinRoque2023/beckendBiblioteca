package idat.pe.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import idat.pe.model.Notificacion;

@Repository
public interface NotificacionRepository extends CrudRepository<Notificacion, Integer> {

}
