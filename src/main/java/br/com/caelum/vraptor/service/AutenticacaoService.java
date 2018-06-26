package br.com.caelum.vraptor.service;

import br.com.caelum.vraptor.dao.UsuarioDAO;
import br.com.caelum.vraptor.model.Usuario;

public class AutenticacaoService {

	
	public Usuario UsuarioEstaAutenticado(Usuario usuario){
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		Usuario usuarioAutenticado = usuarioDAO.PesquisaUsuarioPorNomeESenha(usuario);
		return usuarioAutenticado;
	}
	
}
