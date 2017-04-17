package br.univel;

import br.univel.Pessoa;


public class Pessoa {
	
	@Anotacao(label = "Nome", max = 50, obrigatorio = true, value = "")
	private String nome;	
	
	@Anotacao(label = "Codigo", max = 10, obrigatorio = false, value = "")
	private int id;	
	
	@Anotacao(label = "Nome", max = 100, obrigatorio = true, value = "")
	private String endereco;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	

}
