package br.com.caelum.vraptor.controller;

import java.util.ArrayList;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.annotation.ApiSeguro;
import br.com.caelum.vraptor.dao.UsuarioDAO;
import br.com.caelum.vraptor.model.Usuario;
import br.com.caelum.vraptor.view.Results;

@Controller
public class ApiUsuarioController {

	@Inject Result result;
	
	@ApiSeguro
	@Get("/api/usuarios")
	public void buscaUsuarios() {
		
		UsuarioDAO usuariodao = new UsuarioDAO();
		ArrayList<Usuario> usuarios = usuariodao.SelectAll();
		
		result.use(Results.json()).withoutRoot().from(usuarios).serialize();
		
	}
	
}
