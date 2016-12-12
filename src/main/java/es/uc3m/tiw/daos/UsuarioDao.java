
package es.uc3m.tiw.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import es.uc3m.tiw.dominios.Usuario;

public interface UsuarioDao extends JpaRepository<Usuario, Long>{

	List<Usuario> findAll();
	Usuario findById(int id);
	Usuario findByMail(String mail);
}