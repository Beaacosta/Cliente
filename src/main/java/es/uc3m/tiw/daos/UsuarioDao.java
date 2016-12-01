
package es.uc3m.tiw.daos;

import org.springframework.data.repository.CrudRepository;

import es.uc3m.tiw.dominios.Usuario;

public interface UsuarioDao extends CrudRepository<Usuario, Long> {

}