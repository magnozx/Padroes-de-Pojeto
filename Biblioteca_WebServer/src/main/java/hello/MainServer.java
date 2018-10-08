package hello;

import static spark.Spark.*;


public class MainServer {
	
	private static Modelo model;
	
    public static void main(String[] args) {

    	model = Modelo.getInstance();
    	
		// Get port config of heroku on environment variable
        ProcessBuilder process = new ProcessBuilder();
        Integer port;
        if (process.environment().get("PORT") != null) {
            port = Integer.parseInt(process.environment().get("PORT"));
        } else {
            port = 1235;
        }
        //ipAddress("172.16.2.130");
        port(port);

		//Servir conteudo html, css e javascript
		staticFileLocation("/static");


		Controller controller = new Controller(model);
		
		controller.buscarLivroPorTitulo();
		controller.buscarLivroPorTomo();
		controller.cadastrarLivro();
		controller.deletarLivro();
		controller.buscarLivroPorAutor();
		controller.listarTodosOsLivros();
		
    }
    

}
