package br.com.caelum.vraptor.dao;

import java.util.ArrayList;
import java.util.Iterator;

import br.com.caelum.vraptor.model.Usuario;

public class UsuarioDAO {

	
	private ArrayList<Usuario>  usuarios;

	public UsuarioDAO() {
		
		usuarios = new ArrayList();
		
		Usuario pacato = new Usuario(1, "pacato", "pacato", "colaborador");
		Usuario adam = new Usuario(2, "adam", "adam", "administrador");
		
		usuarios.add(pacato);
		usuarios.add(adam);
		
	}
	
	
	public ArrayList<Usuario> SelectAll(){
				
		return usuarios;
		
	}
	
	public Usuario PesquisaUsuarioPorNomeESenha(Usuario pesquisaUsuario) {
		
		for (Usuario usuario : usuarios) {
			
			if(pesquisaUsuario.getNome().equals(usuario.getNome()) && pesquisaUsuario.getSenha().equals(usuario.getSenha())) {
				return usuario;
			}
		}
		
		return null;
		
	}
	
	
}
