package br.com.caelum.vraptor.model;

public class Cliente {
	
	int id;
	String nome;
	String foto;
	
	public Cliente(int id, String nome, String foto) {
		super();
		this.id = id;
		this.nome = nome;
		this.foto = foto;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}
	
	
	
}
