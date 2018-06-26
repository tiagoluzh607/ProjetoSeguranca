package br.com.caelum.vraptor.interceptor;

import java.util.Base64;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import br.com.caelum.vraptor.AroundCall;
import br.com.caelum.vraptor.InterceptionException;
import br.com.caelum.vraptor.Intercepts;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.annotation.ApiSeguro;
import br.com.caelum.vraptor.interceptor.AcceptsWithAnnotations;
import br.com.caelum.vraptor.interceptor.SimpleInterceptorStack;
import br.com.caelum.vraptor.model.Usuario;
import br.com.caelum.vraptor.service.AutenticacaoService;
import br.com.caelum.vraptor.view.Results;



@Intercepts
@AcceptsWithAnnotations(ApiSeguro.class)
public class ApiAutorizadorInterceptor {

	@Inject HttpServletRequest request;
	@Inject Result result;
	
	
	@AroundCall
	public void autenticar(SimpleInterceptorStack stack) {
		
		String authorizationHeader = null;
		boolean tokenEhValido = false;
		
		try {
			authorizationHeader = obtemHeader(authorizationHeader);
			
			//extrai o token do header
			String senhaBase64 = authorizationHeader.substring("Basic".length()).trim();
			// método que verifica se o token é valido ou não 
			
			Usuario usuario = DecodificaBase64(senhaBase64);
			Usuario usuarioAutenticado = new AutenticacaoService().UsuarioEstaAutenticado(usuario);
			
			if(usuarioAutenticado != null) {
				stack.next();
			}else {
				throw new InterceptionException("Usuario ou Senha Invalidos - O Servidor não localizou nenhum usuario e/ou senhas que foi passada");
			}
				
		}catch (Exception e) {
			result.use(Results.http()).sendError(401, e.getMessage());
		}
		
	}
	

	private String obtemHeader(String authorizationHeader) {
		try{
		
			authorizationHeader = request.getHeader("Authorization");
		
			if (authorizationHeader == null || !authorizationHeader.startsWith("Basic ")) {		
				throw new InterceptionException("Authorization header precisa ser provido");
			}
			
			return authorizationHeader;
		}catch (InterceptionException e) {
			throw new InterceptionException("Authorization header precisa ser provido");
		}
		
	}
	
	private Usuario DecodificaBase64(String senhaBase64) {
		
		//Decodificando String 64
		byte[] decodedBytes = Base64.getDecoder().decode(senhaBase64);
		String senhaDecodificada = new String(decodedBytes);
		
		//Separando String em um objeto
		Usuario usuario = new Usuario();
		
		String array[] = new String[2];
		array = senhaDecodificada.split(":");
		
		usuario.setNome(array[0]);
		usuario.setSenha(array[1]);
		
		return usuario;
		
		
	}
	
}

