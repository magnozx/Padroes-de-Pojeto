package hello;

import java.util.List;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.query.Query;

import java.util.LinkedList;



public class Modelo {
	
	private static Modelo uniqueInstance;
	
	ObjectContainer livros = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), "bd/livros.db4o");
	ObjectContainer usuarios = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), "bd/usuarios.db4o");

/*Método desenvolvido por Magno*/
	private Modelo(){
	}
	
/*Método desenvolvido por Magno*/
	public static Modelo getInstance(){
		if(uniqueInstance == null){
			uniqueInstance = new Modelo();
		}
		return uniqueInstance;
	}
	
/*Método desenvolvido por Magno*/	
	public List<Livro> getLivros() {
		List<Livro> listaDeLivros = new LinkedList<Livro>();
		Query query = livros.query();
		query.constrain(Livro.class);
	    ObjectSet<Livro> todosOsLivros = query.execute();
	    for(Livro livro:todosOsLivros) listaDeLivros.add(livro);
		return listaDeLivros;
	}

/*Método desenvolvido por Magno*/
	public boolean cadastrarLivro(Livro livro){
		boolean cadastrado = true;
		if(verificarSeTomoJaEstaCadastrado(livro.getTomo())) {
			livros.store(livro);
			livros.commit();
		} else {
			cadastrado = false;
		}
		return cadastrado;
	}

/*Método desenvolvido por Magno*/
	public boolean verificarSeTomoJaEstaCadastrado(String tomo) {
		boolean verificador = true;
		Query query = livros.query();
		query.constrain(Livro.class);
		ObjectSet<Livro> todosOsLivros = query.execute();
		for(Livro livro : todosOsLivros) {
			if(livro.getTomo().equals(tomo)) {
				verificador = false;
			}
		}
		return verificador;
	}
	
	
/*Método desenvolvido por Magno*/
	public void deletarLivro(String tomo){
		Query query = livros.query();
		query.constrain(Livro.class);
		ObjectSet<Livro> todosOsLivros = query.execute();
		
		for(Livro livro:todosOsLivros){
			if(livro.getTomo().equals(tomo)){
				livros.delete(livro);
				livros.commit();
			}
		}
	}
	

/*Método desenvolvido por Magno*/
	public List<Livro> buscarLivroPorTitulo(String titulo){
		List<Livro> livrosEncontrados = new LinkedList<Livro>();
		Query query = livros.query();
		query.constrain(Livro.class);
	    ObjectSet<Livro> todosOsLivros = query.execute();
		for(Livro livro:todosOsLivros){
			if(livro.getTitulo().toLowerCase().contains(titulo)) livrosEncontrados.add(livro);
		}
		return livrosEncontrados;
	}
	

/*Método desenvolvido por Carlos Eduardo*/
	public Livro buscarLivroPorTomo(String tomo){
		Livro livroEncontrado = null;
		Query query = livros.query();
		query.constrain(Livro.class);
	    ObjectSet<Livro> todosOsLivros = query.execute();
		for(Livro livro:todosOsLivros){
			if(livro.getTomo().equals(tomo)) livroEncontrado=livro;
		}
		return livroEncontrado;           
	}

	
/*Método desenvolvido por Carlos Eduardo*/
	public List<Livro> buscarLivroPorAutor(String autor){
		List<Livro> livrosEncontrados = new LinkedList<Livro>();
		Query query = livros.query();
		query.constrain(Livro.class);
	    ObjectSet<Livro> todosOsLivros = query.execute();
		for(Livro livro:todosOsLivros){
			if(livro.getAutor().toLowerCase().contains(autor)) livrosEncontrados.add(livro);	
		}
		return livrosEncontrados;
	}
	
/*Método desenvolvido por Magno*/
	public void cadastrarUsuario (Usuario novoUsuario) {
		if(verificarSeUsuarioJaExiste(novoUsuario.getLoginDoUsuario().getIdDoUsuario())) {
			usuarios.store(novoUsuario);
			usuarios.commit();
		}
	}
	
/*Método desenvolvido por Magno*/
	public boolean verificarSeUsuarioJaExiste(String idDoUsuario) {
		boolean verificador = true;
		for(Usuario usuario : listarTodosOsUsuarios()) {
			if(usuario.getLoginDoUsuario().getIdDoUsuario().equals(idDoUsuario)) {
				verificador = false;
			}
		}
		return verificador;
	}
	
/*Método desenvolvido por Magno*/
	public List<Usuario> listarTodosOsUsuarios() {
		List<Usuario> listaDeTodosOsUsuarios = new LinkedList<Usuario>();
		Query query = usuarios.query();
		query.constrain(Usuario.class);
	    ObjectSet<Usuario> todosOsUsuarios = query.execute();
	    for(Usuario usuario : todosOsUsuarios) listaDeTodosOsUsuarios.add(usuario);
	    return listaDeTodosOsUsuarios;
	} 
	
/*Método desenvolvido por Carlos Eduardo*/
	public List<Usuario> buscarUsuarioPorNome(String nome){
		List<Usuario> usuariosEncontrados = new LinkedList<Usuario>();
		List<Usuario> todosOsUsuarios = new LinkedList<Usuario>();
		todosOsUsuarios = listarTodosOsUsuarios();
		for(Usuario usuario : todosOsUsuarios){
			if(usuario.getNome().contains(nome)) usuariosEncontrados.add(usuario);
		}
		return usuariosEncontrados;           
	}
	
/*Método desenvolvido por Magno*/
	public boolean fazerLoginDoUsuario(Login login){
		for(Usuario usuario : listarTodosOsUsuarios()) {
			return (usuario.fazerLoginUsuario(login.getIdDoUsuario(), login.getSenhaDoUsuario()));
		}
		return false;
	}
	
/*	
//Método desenvolvido por Carlos Eduardo
	public List<Livro> BuscarLivroPorTituloEdicao(String titulo, String edicao){
		List<Livro> livrosEncontrados = new LinkedList<Livro>();
		Query query = livros.query();
		query.constrain(Livro.class);
	    ObjectSet<Livro> todosOsLivros = query.execute();
		for(Livro livro:todosOsLivros){
			if((livro.getTitulo().equals(titulo)) && (livro.getEdicao().equals(edicao))) livrosEncontrados.add(livro);
		}
		return livrosEncontrados;
	
	}
	
//Método desenvolvido por Carlos Eduardo
	public List<Livro> BuscarLivroPorTituloAutorEdicao(String titulo, String autor, String edicao){
		List<Livro> livrosEncontrados = new LinkedList<Livro>();
		Query query = livros.query();
		query.constrain(Livro.class);
	    ObjectSet<Livro> todosOsLivros = query.execute();
		for(Livro livro:todosOsLivros){
			if( (livro.getTitulo().equals(titulo)) && (livro.getEdicao().equals(edicao)) && (livro.getAutor().equals(autor))) livrosEncontrados.add(livro);
		}
		return livrosEncontrados;
	
	}
	
//Método desenvolvido por Carlos Eduardo
	public List<Livro> BuscarLivroPorTituloAutorEditora(String titulo, String autor, String editora){
		List<Livro> livrosEncontrados = new LinkedList<Livro>();
		Query query = livros.query();
		query.constrain(Livro.class);
	    ObjectSet<Livro> todosOsLivros = query.execute();
		for(Livro livro:todosOsLivros){
			if( (livro.getTitulo().equals(titulo)) && (livro.getAutor().equals(autor)) && (livro.getEditora().equals(editora))) livrosEncontrados.add(livro);
		}
		return livrosEncontrados;
	}

//Método desenvolvido por Carlos Eduardo
	public List<Livro> BuscarLivroPorTituloEditora(String titulo, String editora){
		List<Livro> livrosEncontrados = new LinkedList<Livro>();
		Query query = livros.query();
		query.constrain(Livro.class);
	    ObjectSet<Livro> todosOsLivros = query.execute();
		for(Livro livro:todosOsLivros){
			if((livro.getTitulo().equals(titulo)) && (livro.getEditora().equals(editora))) livrosEncontrados.add(livro);
		}
		return livrosEncontrados;
	
	}
*/	

}
