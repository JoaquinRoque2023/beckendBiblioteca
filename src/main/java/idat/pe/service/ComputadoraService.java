package idat.pe.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import idat.pe.model.Computadora;
import idat.pe.repository.ComputadoraRepository;

import java.util.List;

@Service
@Transactional
public class ComputadoraService {

    @Autowired
    private ComputadoraRepository rep;

    public ComputadoraService() {
    }

    public List<Computadora> buscarTodo() {
        return (List<Computadora>) rep.findAll();
    }

    public Computadora crear(Computadora computadora) {
        return rep.save(computadora);
    }

    public Computadora actualizar(Computadora computadoraActualizar) {
        Computadora computadoraActual = rep.findById(computadoraActualizar.getIdComputadora()).get();
        computadoraActual.setNumeroComputadora(computadoraActualizar.getNumeroComputadora());
        computadoraActual.setUbicacion(computadoraActualizar.getUbicacion());
        return rep.save(computadoraActual);
    }

    public Computadora buscarPorID(Integer id) {
        return rep.findById(id).get();
    }

    public void borrarPorID(Integer id) {
        rep.deleteById(id);
    }
}