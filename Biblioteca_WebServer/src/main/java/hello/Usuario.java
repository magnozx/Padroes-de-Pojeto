package hello;

import java.util.List;
import java.util.LinkedList;

public abstract class Usuario {
	private String nome;
	private Endereco endereco;
	private List<String> telefone = new LinkedList<String>();
	private Login loginDoUsuario;
	
	public Usuario(String nome, Endereco endereco, Login loginDoUsuario){
		this.nome = nome;
		this.endereco = endereco;
		this.loginDoUsuario = loginDoUsuario;
	}
	
/*Método desenvolvido por Magno*/
	public void adicionarTelefone(String telefone) {
		this.telefone.add(telefone);
	}
	
/*Método desenvolvido por Magno*/
	public boolean fazerLoginUsuario(String idFornecido, String senhaFornecida) {
		return this.loginDoUsuario.fazerLogin(idFornecido, senhaFornecida);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public List<String> getTelefone() {
		return telefone;
	}

	public void setTelefone(List<String> telefone) {
		this.telefone = telefone;
	}

	public Login getLoginDoUsuario() {
		return loginDoUsuario;
	}

	public void setLoginDoUsuario(Login loginDoUsuario) {
		this.loginDoUsuario = loginDoUsuario;
	}

}
