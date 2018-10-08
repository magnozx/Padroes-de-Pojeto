package hello;

public class Funcionario extends Usuario{
	
	private String registroDoFuncionario;
	private String nomeDoGestor;
	private String funcaoExercida;
	private String dataDeContratacao;
	
	public Funcionario(String nome, Endereco endereco, Login loginDoUsuario, String registroDoFuncionario, String nomeDoGestor, String funcaoExercida, String dataDeContratacao){
		super(nome, endereco,loginDoUsuario);
		this.registroDoFuncionario=registroDoFuncionario;
		this.nomeDoGestor=nomeDoGestor;
		this.funcaoExercida=funcaoExercida;
		this.dataDeContratacao=dataDeContratacao;
	}

	public String getRegistroDoFuncionario() {
		return registroDoFuncionario;
	}

	public void setRegistroDoFuncionario(String registroDoFuncionario) {
		this.registroDoFuncionario = registroDoFuncionario;
	}

	public String getNomeDoGestor() {
		return nomeDoGestor;
	}

	public void setNomeDoGestor(String nomeDoGestor) {
		this.nomeDoGestor = nomeDoGestor;
	}

	public String getFuncaoExercida() {
		return funcaoExercida;
	}

	public void setFuncaoExercida(String funcaoExercida) {
		this.funcaoExercida = funcaoExercida;
	}

	public String getDataDeContratacao() {
		return dataDeContratacao;
	}

	public void setDataDeContratacao(String dataDeContratacao) {
		this.dataDeContratacao = dataDeContratacao;
	}

}
