
package es.uc3m.tiw.daos;



import org.springframework.data.jpa.repository.JpaRepository;


import es.uc3m.tiw.dominios.Usuario;

public interface UsuarioDao extends JpaRepository<Usuario, Long>{

	//Mejor usar JPA que crudRepository (investigar)

}