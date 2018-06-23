package br.com.caelum.vraptor.controller;

import java.util.ArrayList;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.dao.ClienteDAO;
import br.com.caelum.vraptor.model.Cliente;
import br.com.caelum.vraptor.model.Usuario;
import br.com.caelum.vraptor.view.Results;

@Controller
public class ApiClienteController {

	@Inject Result result;
	
	@Get("/api/clientes")
	public void buscaClientes() {
		
		
		ClienteDAO clienteDao = new ClienteDAO();
		ArrayList<Cliente> clientes =  clienteDao.SelectAll();
		
		result.use(Results.json()).withoutRoot().from(clientes).serialize();
		
		//result.use(Results.json()).withoutRoot().from(usuarioExistente).serialize();
		
	}
}
