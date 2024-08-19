package idat.pe.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import idat.pe.model.Usuario;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Integer> {
	
    Usuario findByEmailAndClave(String email, String clave);

	Usuario findByEmail(String email);
}
