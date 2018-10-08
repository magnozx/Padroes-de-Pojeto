package hello;

public class Login {
	
	private String idDoUsuario;
	private String senhaDoUsuario;
	
	public Login(String idDoUsuario, String senhaDoUsuario) {
		this.idDoUsuario = idDoUsuario;
		this.senhaDoUsuario = senhaDoUsuario;
	}
	
/*Método desenvolvido por Magno*/
	public boolean fazerLogin(String idFornecido, String senhaFornecida) {
		if(this.idDoUsuario.equals(idFornecido) && this.senhaDoUsuario.equals(senhaFornecida)) {
			return true;
		}
		return false;
	}

	public String getIdDoUsuario() {
		return idDoUsuario;
	}

	public void setIdDoUsuario(String idDoUsuario) {
		this.idDoUsuario = idDoUsuario;
	}

	public String getSenhaDoUsuario() {
		return senhaDoUsuario;
	}

	public void setSenhaDoUsuario(String senhaDoUsuario) {
		this.senhaDoUsuario = senhaDoUsuario;
	}

	
}
