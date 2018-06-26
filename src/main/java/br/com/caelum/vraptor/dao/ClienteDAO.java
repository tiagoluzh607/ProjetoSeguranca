package br.com.caelum.vraptor.dao;

import java.util.ArrayList;

import br.com.caelum.vraptor.model.Cliente;

public class ClienteDAO {

	
	public ArrayList<Cliente> SelectAll(){
		
		ArrayList<Cliente> clientes = new ArrayList();
		
		Cliente diego = new Cliente(1, "Diego", "https://storage.alboom.ninja/sites/6239/img/sobre/534779_275472719204353_277204939_n.jpg?t=1523300084");
		Cliente alan = new Cliente(2 , "Alan", "https://static1.squarespace.com/static/51435924e4b02285c8b9c92d/t/558c96c3e4b03457461d0f2e/1508845725260/caiobraga-perfil.jpg");
		Cliente denner = new Cliente(3, "Denner", "https://s-media-cache-ak0.pinimg.com/originals/d4/0f/4c/d40f4c7cad95054cf8e380dc9e119a78.jpg");		
		Cliente alice = new Cliente(4, "Alice", "http://www.paulafontes.com.br/wp-content/uploads/2013/07/Ale-5.jpg");
		
		clientes.add(diego);
		clientes.add(alan);
		clientes.add(denner);
		clientes.add(alice);
		
		return clientes;
	}
}
