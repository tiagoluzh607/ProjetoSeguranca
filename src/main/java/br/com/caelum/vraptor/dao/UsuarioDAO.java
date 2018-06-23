package br.com.caelum.vraptor.dao;

import java.util.ArrayList;

import br.com.caelum.vraptor.model.Usuario;

public class UsuarioDAO {

	public ArrayList<Usuario> SelectAll(){
		
		ArrayList<Usuario> usuarios = new ArrayList();
		
		Usuario pacato = new Usuario(1, "Pacato", "pacato");
		Usuario adam = new Usuario(2, "Adam", "adam");
		
		usuarios.add(pacato);
		usuarios.add(adam);
		
		return usuarios;
		
	}
	
	
}
