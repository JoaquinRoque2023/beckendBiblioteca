package idat.pe.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import idat.pe.model.Reserva_Computadora;
import idat.pe.repository.Reserva_ComputadoraRepository;

import java.util.List;

@Service
@Transactional
public class Reserva_ComputadoraService {

    @Autowired
    private Reserva_ComputadoraRepository rep;

    public Reserva_ComputadoraService() {
    }

    public List<Reserva_Computadora> buscarTodo() {
        return (List<Reserva_Computadora>) rep.findAll();
    }

    public Reserva_Computadora crear(Reserva_Computadora reservaComputadora) {
        return rep.save(reservaComputadora);
    }

    public Reserva_Computadora actualizar(Reserva_Computadora reservaComputadoraActualizar) {
        Reserva_Computadora reservaComputadoraActual = rep.findById(reservaComputadoraActualizar.getIdReservaComputadora()).get();
        reservaComputadoraActual.setUsuario(reservaComputadoraActualizar.getUsuario());
        reservaComputadoraActual.setComputadora(reservaComputadoraActualizar.getComputadora());
        reservaComputadoraActual.setFechaReserva(reservaComputadoraActualizar.getFechaReserva());
        reservaComputadoraActual.setHoraInicio(reservaComputadoraActualizar.getHoraInicio());
        reservaComputadoraActual.setHoraFin(reservaComputadoraActualizar.getHoraFin());
        return rep.save(reservaComputadoraActual);
    }

    public Reserva_Computadora buscarPorID(Integer id) {
        return rep.findById(id).get();
    }

    public void borrarPorID(Integer id) {
        rep.deleteById(id);
    }
}
