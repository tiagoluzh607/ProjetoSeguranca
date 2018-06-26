package br.com.caelum.vraptor.controller;

import java.util.ArrayList;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.dao.ClienteDAO;
import br.com.caelum.vraptor.dao.UsuarioDAO;
import br.com.caelum.vraptor.model.Usuario;
import br.com.caelum.vraptor.service.AutenticacaoService;

@Controller
public class HomeController {

	@Inject Result result;
	
	public void index() {
		
		
	}
	
	@Post
	public void autentica(Usuario usuario) {
			
		Usuario usuarioAutenticado = new AutenticacaoService().UsuarioEstaAutenticado(usuario);
		
		if(usuarioAutenticado != null) {
			result.redirectTo(HomeController.class).posLogin(usuarioAutenticado);
		}else {
			result.redirectTo(HomeController.class).index();
		}
		
	}
	
	
	public void posLogin(Usuario usuario) {
		
		ClienteDAO clienteDAO = new ClienteDAO();
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		
		result.include("clienteList", clienteDAO.SelectAll());
		
		if(usuario.getPermissao().equals("administrador")) {
			result.include("usuarioList", usuarioDAO.SelectAll());
		}
		
		
	}
	
}
