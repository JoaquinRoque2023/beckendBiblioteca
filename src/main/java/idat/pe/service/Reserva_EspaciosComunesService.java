package idat.pe.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import idat.pe.model.Reserva_EspaciosComunes;
import idat.pe.repository.Reserva_EspaciosComunesRepository;

import java.util.List;

@Service
@Transactional
public class Reserva_EspaciosComunesService {

    @Autowired
    private Reserva_EspaciosComunesRepository rep;

    public Reserva_EspaciosComunesService() {
    }

    public List<Reserva_EspaciosComunes> buscarTodo() {
        return (List<Reserva_EspaciosComunes>) rep.findAll();
    }

    public Reserva_EspaciosComunes crear(Reserva_EspaciosComunes reservaEspaciosComunes) {
        return rep.save(reservaEspaciosComunes);
    }

    public Reserva_EspaciosComunes actualizar(Reserva_EspaciosComunes reservaEspaciosComunesActualizar) {
        Reserva_EspaciosComunes reservaEspaciosComunesActual = rep.findById(reservaEspaciosComunesActualizar.getIdReservaEspacio()).get();
        reservaEspaciosComunesActual.setUsuario(reservaEspaciosComunesActualizar.getUsuario());
        reservaEspaciosComunesActual.setEspacio(reservaEspaciosComunesActualizar.getEspacio());
        reservaEspaciosComunesActual.setFechaReserva(reservaEspaciosComunesActualizar.getFechaReserva());
        reservaEspaciosComunesActual.setHoraInicio(reservaEspaciosComunesActualizar.getHoraInicio());
        reservaEspaciosComunesActual.setHoraFin(reservaEspaciosComunesActualizar.getHoraFin());
        return rep.save(reservaEspaciosComunesActual);
    }

    public Reserva_EspaciosComunes buscarPorID(Integer id) {
        return rep.findById(id).get();
    }

    public void borrarPorID(Integer id) {
        rep.deleteById(id);
    }
}
