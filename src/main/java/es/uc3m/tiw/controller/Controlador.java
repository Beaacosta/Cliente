package es.uc3m.tiw.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import es.uc3m.tiw.daos.UsuarioDao;
import es.uc3m.tiw.dominios.Usuario;



@RestController
// La siguiente anotación es necesaria para permitir 
// que diferente dominios puedan usar este microservicio
@CrossOrigin
public class Controlador {
	
	private Usuario usuario;
	private UsuarioDao dao;
	
	@RequestMapping(value = "/buscar_id", method = RequestMethod.GET)
	public Usuario usuarioGet(@RequestParam(value = "id", required = true) int id){
		usuario = new Usuario();
		//metodo dao.buscar...
		return usuario;
		
	}


}
