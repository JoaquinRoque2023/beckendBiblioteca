package idat.pe.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import idat.pe.model.Prestamo_Computadora;
import idat.pe.repository.Prestamo_ComputadoraRepository;

import java.util.List;

@Service
@Transactional
public class Prestamo_ComputadoraService {

    @Autowired
    private Prestamo_ComputadoraRepository rep;

    public Prestamo_ComputadoraService() {
    }

    public List<Prestamo_Computadora> buscarTodo() {
        return (List<Prestamo_Computadora>) rep.findAll();
    }

    public Prestamo_Computadora crear(Prestamo_Computadora prestamoComputadora) {
        return rep.save(prestamoComputadora);
    }

    public Prestamo_Computadora actualizar(Prestamo_Computadora prestamoComputadoraActualizar) {
        Prestamo_Computadora prestamoComputadoraActual = rep.findById(prestamoComputadoraActualizar.getIdPrestamoComputadora()).get();
        prestamoComputadoraActual.setUsuario(prestamoComputadoraActualizar.getUsuario());
        prestamoComputadoraActual.setComputadora(prestamoComputadoraActualizar.getComputadora());
        prestamoComputadoraActual.setFechaPrestamo(prestamoComputadoraActualizar.getFechaPrestamo());
        prestamoComputadoraActual.setHoraPrestamo(prestamoComputadoraActualizar.getHoraPrestamo());
        prestamoComputadoraActual.setHoraDevolucion(prestamoComputadoraActualizar.getHoraDevolucion());
        return rep.save(prestamoComputadoraActual);
    }

    public Prestamo_Computadora buscarPorID(Integer id) {
        return rep.findById(id).get();
    }

    public void borrarPorID(Integer id) {
        rep.deleteById(id);
    }
}
