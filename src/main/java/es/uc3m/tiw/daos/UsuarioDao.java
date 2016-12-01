
package es.uc3m.tiw.daos;

import java.sql.SQLException;
import java.util.Collection;

import org.springframework.data.repository.CrudRepository;

import es.uc3m.tiw.dominios.Usuario;

public interface UsuarioDao extends CrudRepository<Usuario, Long> {

	//Mejor usar JPA que crudRepository (investigar)

}