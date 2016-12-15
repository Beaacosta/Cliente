package es.uc3m.tiw.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import es.uc3m.tiw.daos.UsuarioDao;
import es.uc3m.tiw.dominios.Usuario;



@RestController
// La siguiente anotación es necesaria para permitir 
// que diferente dominios puedan usar este microservicio
@CrossOrigin
public class Controlador {
	
	private Usuario usuario;
	@Autowired
	private UsuarioDao dao;
	
	//Buscar un usuario en la BBDD por id
	@RequestMapping(value = "/buscar_id", method = RequestMethod.POST)
	public Usuario buscarId(@RequestParam(value = "id", required = true) int id){
		usuario = new Usuario();
		usuario = dao.findById(id);
		return usuario;
	}
	
	//Buscar un usuario en la BBDD por email
	@RequestMapping(value = "/buscar_mail", method = RequestMethod.POST)
	public @ResponseBody Usuario buscarMail(@RequestBody Usuario usuario) throws IllegalArgumentException{
		Usuario u = null;
		try{
			u=dao.findByMail(usuario.getMail());
			if(!u.equals(null)){
				return u;			
			}
			else{
				u = null;
				return u;
			}
		}
		catch(Exception e){
			e.printStackTrace();
			return usuario;
		}

	}
		
	//Listar todos los usuarios
	@RequestMapping(value = "/listar_usuarios", method = RequestMethod.POST)
	public @ResponseBody List<Usuario> listarUsuarios(){
		List<Usuario> usuarios = null;
		usuarios = dao.findAll();
		return usuarios;
	}

	//Eliminar un usuario
	@RequestMapping(value = "/eliminar_usuario", method = RequestMethod.POST)
	public void eliminarUsuario(@RequestBody Usuario usuario){
		dao.delete(usuario);
	}
	
	//Añadir un usuario
	@RequestMapping(value = "/anyadir_usuario", method = RequestMethod.POST)
	public void anyadirUsuario(@RequestBody Usuario usuario){
		dao.save(usuario);
	}
	//Modificar un usuario
	@RequestMapping(value = "/modificar_usuario", method = RequestMethod.POST)
	public void modificarUsuario(@RequestBody Usuario usuario){
			 dao.save(usuario);	
	}
}
