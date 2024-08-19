package idat.pe.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import idat.pe.model.Multa;
import idat.pe.repository.MultaRepository;

import java.util.List;

@Service
@Transactional
public class MultaService {

    @Autowired
    private MultaRepository rep;

    public MultaService() {
    }

    public List<Multa> buscarTodo() {
        return (List<Multa>) rep.findAll();
    }

    public Multa crear(Multa multa) {
        return rep.save(multa);
    }

    public Multa actualizar(Multa multaActualizar) {
        Multa multaActual = rep.findById(multaActualizar.getIdMulta()).get();
        multaActual.setUsuario(multaActualizar.getUsuario());
        multaActual.setDefecto(multaActualizar.getDefecto());
        multaActual.setMonto(multaActualizar.getMonto());
        multaActual.setFechaMulta(multaActualizar.getFechaMulta());
        multaActual.setDescripcion(multaActualizar.getDescripcion());
        multaActual.setEstado(multaActualizar.getEstado());
        return rep.save(multaActual);
    }

    public Multa buscarPorID(Integer id) {
        return rep.findById(id).get();
    }

    public void borrarPorID(Integer id) {
        rep.deleteById(id);
    }
}
