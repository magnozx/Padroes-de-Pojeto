package hello;

public class Livro {
	
	private String titulo;
	private String genero;
	private String tomo;
	private String autor;
	private String edicao;
	private String editora;
	private String anoDeEdicao;
	private String volume;
	private String estante;
	//private String disponivel; TODO Campo para verificação de reserva

	
	public Livro(String titulo, String genero, String tomo, String autor, String edicao, String editora, String anoDeEdicao, String volume, String estante /*String disponivel*/) {
		this.titulo = titulo;
		this. genero = genero;
		this.tomo = tomo;
		this.autor = autor;
		this.edicao = edicao;
		this.editora = editora;
		this.anoDeEdicao = anoDeEdicao;
		this.volume = volume;
		this.estante = estante;
		//this.disponivel = disponivel; TODO Campo para verificação de reserva
		
	}

	
	public String getEstante() {
		return estante;
	}


	public void setEstante(String estante) {
		this.estante = estante;
	}

/* TODO Campo para verificação de reserva
	public String getDisponivel() {
		return disponivel;
	}


	public void setDisponivel(String disponivel) {
		this.disponivel = disponivel;
	}
*/

	public String getTomo() {
		return tomo;
	}


	public void setTomo(String tomo) {
		this.tomo = tomo;
	}


	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getEdicao() {
		return edicao;
	}

	public void setEdicao(String edicao) {
		this.edicao = edicao;
	}
	
	public String getEditora() {
		return editora;
	}


	public void setEditora(String editora) {
		this.editora = editora;
	}

	public String getAnoDeEdicao() {
		return anoDeEdicao;
	}

	public void setAnoDeEdicao(String anoDeEdicao) {
		this.anoDeEdicao = anoDeEdicao;
	}

	public String getVolume() {
		return volume;
	}

	public void setVolume(String volume) {
		this.volume = volume;
	}
	
	
	
}
