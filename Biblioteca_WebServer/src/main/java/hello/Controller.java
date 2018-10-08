package hello;

import static spark.Spark.*;

import java.util.*;

import org.json.JSONObject;

import com.google.gson.Gson;

import spark.*;

public class Controller {
	
	private Modelo model;
	
/*Método desenvolvido por Magno*/	
	public Controller(Modelo model){
		this.model = model;
	}
	
/*Listar todos os Livros*/
	public void listarTodosOsLivros(){
		get("/livro/todosOsLivros", (req, res) -> {
		
			List<Livro> livrosEncontrados = model.getLivros();	
			return new Gson().toJson(livrosEncontrados);
		});
	}
	
/*Método desenvolvido por Magno*/	
	public void buscarLivroPorTitulo(){
		get("/livro/:titulo", (req, res) -> {
			
			res.header("Access-Control-Allow-Origin", "*");
		
			String titulo = (req.params(":titulo")).toLowerCase().replace("%20"," ");
			List<Livro> livrosEncontrados = model.buscarLivroPorTitulo(titulo);	
			return new Gson().toJson(livrosEncontrados);
		});
	}
	
/*Método desenvolvido por Magno*/
	public void buscarLivroPorTomo(){
		get("/livro2/:tomo", (req, res) -> {
			Livro livroEncontrado = model.buscarLivroPorTomo(req.params(":tomo"));	
			return new Gson().toJson(livroEncontrado);
		});
	}

/*Método desenvolvido por Magno*/	
	public void cadastrarLivro() {
		post("/livroInserir", new Route() {

			@Override
			public Object handle(final Request request, final Response response) {
				
				response.header("Access-Control-Allow-Origin", "*");
				
				JSONObject json = new JSONObject(request.body());

				String titulo = json.getString("titulo");
				String genero = json.getString("genero");
				String tomo = json.getString("tomo");
				String autor = json.getString("autor");
				String edicao = json.getString("edicao");
				String editora = json.getString("editora");
				String anoDeEdicao = json.getString("anoDeEdicao");
				String volume = json.getString("volume");
				String estante = json.getString("estante");
				//String disponivel = json.getString("disponivel");

				 boolean resultado = model.cadastrarLivro(new Livro(titulo, genero, tomo, autor, edicao, editora, anoDeEdicao, volume,estante));

				return new Gson().toJson(resultado);
			}
			
		});
	}
	
/*Método desenvolvido por Magno*/	
	public void deletarLivro() {
		post("/livroExcluir", new Route() {

			@Override
			public Object handle(final Request request, final Response response) {
				
				response.header("Access-Control-Allow-Origin", "*");
				
				JSONObject json = new JSONObject(request.body());
				
				String tomo = json.getString("tomo");

				model.deletarLivro(tomo);

				return null;
			}
			
		});
	}
	
/*Método desenvolvido por Carlos Eduardo*/
	public void buscarLivroPorAutor(){
		get("/livro3/:autor", (req, res) -> {
		
			String autor = (req.params(":autor")).toLowerCase().replace("%20"," ");
			List<Livro> livrosEncontrados = model.buscarLivroPorAutor(autor);	
			return new Gson().toJson(livrosEncontrados);
		});
	}
	
}
