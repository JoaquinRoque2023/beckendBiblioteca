package idat.pe.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import idat.pe.model.Usuario;
import idat.pe.repository.UsuarioRepository;

import java.util.List;

@Service
@Transactional
public class UsuarioService {

    @Autowired
    private UsuarioRepository rep;

    public UsuarioService() {
    }

    public List<Usuario> buscarTodo() {
        return (List<Usuario>) rep.findAll();
    }

    public Usuario crear(Usuario usuario) {
        return rep.save(usuario);
    }

    public Usuario actualizar(Usuario usuarioActualizar) {
        Usuario usuarioActual = rep.findById(usuarioActualizar.getIdUsuario()).get();
        usuarioActual.setClave(usuarioActualizar.getClave());
        usuarioActual.setNombres(usuarioActualizar.getNombres());
        usuarioActual.setApellidoPaterno(usuarioActualizar.getApellidoPaterno());
        usuarioActual.setApellidoMaterno(usuarioActualizar.getApellidoMaterno());
        usuarioActual.setEmail(usuarioActualizar.getEmail());
        usuarioActual.setCelular(usuarioActualizar.getCelular());
        usuarioActual.setDireccion(usuarioActualizar.getDireccion());
        usuarioActual.setFechaRegistro(usuarioActualizar.getFechaRegistro());
        usuarioActual.setEstado(usuarioActualizar.getEstado());
        return rep.save(usuarioActual);
    }

    public Usuario buscarPorID(Integer id) {
        return rep.findById(id).get();
    }

    public void borrarPorID(Integer id) {
    	Usuario usuario = rep.findById(id).get();
        usuario.setEstado("INACTIVO");
        rep.save(usuario);
    }
    public Usuario buscarPorEmailYClave(String email, String clave) {
        return rep.findByEmailAndClave(email, clave);
    }
    public Usuario cambiarClave(String email, String claveAnterior, String nuevaClave) {
        Usuario usuario = rep.findByEmail(email);
        if (usuario == null) {
            throw new RuntimeException("Usuario no encontrado");
        }
        if (!usuario.getClave().equals(claveAnterior)) {
            throw new RuntimeException("Clave actual no válida");
        }
        usuario.setClave(nuevaClave);
        return rep.save(usuario);
    }

    
}

