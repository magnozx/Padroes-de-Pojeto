package hello;

public class Cliente extends Usuario{
	private String codigoDoCliente;
	private String dataDeCadastro;
	
	public Cliente(String nome, Endereco endereco, Login loginDoUsuario, String codigoDoCliente, String dataDeCadastro){
		super(nome, endereco,loginDoUsuario);
		this.codigoDoCliente=codigoDoCliente;
		this.dataDeCadastro=dataDeCadastro;
	}

	public String getCodigoDoCliente() {
		return codigoDoCliente;
	}

	public void setCodigoDoCliente(String codigoDoCliente) {
		this.codigoDoCliente = codigoDoCliente;
	}

	public String getDataDeCadastro() {
		return dataDeCadastro;
	}

	public void setDataDeCadastro(String dataDeCadastro) {
		this.dataDeCadastro = dataDeCadastro;
	}

}
