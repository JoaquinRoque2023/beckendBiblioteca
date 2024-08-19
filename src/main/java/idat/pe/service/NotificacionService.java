package idat.pe.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import idat.pe.model.Notificacion;
import idat.pe.repository.NotificacionRepository;

import java.util.List;

@Service
@Transactional
public class NotificacionService {

    @Autowired
    private NotificacionRepository rep;

    public NotificacionService() {
    }

    public List<Notificacion> buscarTodo() {
        return (List<Notificacion>) rep.findAll();
    }

    public Notificacion crear(Notificacion notificacion) {
        return rep.save(notificacion);
    }

    public Notificacion actualizar(Notificacion notificacionActualizar) {
        Notificacion notificacionActual = rep.findById(notificacionActualizar.getIdNotificacion()).get();
        notificacionActual.setUsuario(notificacionActualizar.getUsuario());
        notificacionActual.setTipoNotificacion(notificacionActualizar.getTipoNotificacion());
        notificacionActual.setMensaje(notificacionActualizar.getMensaje());
        notificacionActual.setFechaEnvio(notificacionActualizar.getFechaEnvio());
        return rep.save(notificacionActual);
    }

    public Notificacion buscarPorID(Integer id) {
        return rep.findById(id).get();
    }

    public void borrarPorID(Integer id) {
        rep.deleteById(id);
    }
}