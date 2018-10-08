package com.example.magno.appbiblioteca;

import android.os.StrictMode;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class Conexao {

    //Função para buscar livros por título
    public JSONArray enviarGetParaBuscarLivrosPorTitulo(String tituloDoLivroProcurado) throws IOException, JSONException {

        String url = "http://192.168.0.13:1235/livro/"+tituloDoLivroProcurado;

        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        // optional default is GET
        con.setRequestMethod("GET");

        //add request header
        con.setRequestProperty("User-Agent", "Mozilla/5.0");

        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        con.disconnect();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        JSONArray retorno = new JSONArray(response.toString());

        return retorno;
    }

    //Função para buscar livros por tomo
    public JSONObject enviarGetParaBuscarLivrosPorTomo(String tomoDoLivroProcurado) throws IOException, JSONException {

        String url = "http://192.168.0.13:1235/livro2/"+tomoDoLivroProcurado;

        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        // optional default is GET
        con.setRequestMethod("GET");

        //add request header
        con.setRequestProperty("User-Agent", "Mozilla/5.0");

        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        con.disconnect();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        JSONObject retorno = new JSONObject(response.toString());

        return retorno;
    }


    /*//Função para transformar objeto Json em um lista livros
    public List<Livro> listarLivrosEncontrados(JSONArray response) {

        List<Livro> listaDeLivrosEncontrados = new LinkedList<>();

        try {

            for (int i = 0; i < response.length(); i++) {
                JSONObject obj = response.getJSONObject(i);
                listaDeLivrosEncontrados.add(new Livro(obj.getString("titulo"),obj.getString("genero"),obj.getString("tomo"),obj.getString("autor"),obj.getString("edicao"),obj.getString("editora"),obj.getString("anoDeEdicao"),obj.getString("volume"),obj.getString("estante")));
            }

        } catch (JSONException e) {
            // handle exception
        }

        return listaDeLivrosEncontrados;
    }

*/
    //Função para Cadastrar um Livro
    public void enviarPostParaCadastrarLivro(Livro livroParaSerCadastrado) throws Exception {

        String url = "http://192.168.0.13:1235/livroInserir";

        URL obj = new URL(url);
        HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();

        //add request header
        con.setRequestMethod("POST");
        con.setRequestProperty("User-Agent", "Mozilla/5.0");
        con.setRequestProperty("Content-Type", "application/json; charset=UTF-8");

        JSONObject urlParameters = new JSONObject();

        urlParameters.put("titulo",livroParaSerCadastrado.getTitulo());
        urlParameters.put("genero",livroParaSerCadastrado.getGenero());
        urlParameters.put("tomo",livroParaSerCadastrado.getTomo());
        urlParameters.put("autor",livroParaSerCadastrado.getAutor());
        urlParameters.put("edicao",livroParaSerCadastrado.getEdicao());
        urlParameters.put("editora",livroParaSerCadastrado.getEditora());
        urlParameters.put("anoDeEdicao",livroParaSerCadastrado.getAnoDeEdicao());
        urlParameters.put("volume",livroParaSerCadastrado.getVolume());
        urlParameters.put("estante",livroParaSerCadastrado.getEstante());

        // Send post request
        con.setDoOutput(true);
        DataOutputStream wr = new DataOutputStream(con.getOutputStream());
        wr.writeBytes(String.valueOf(urlParameters));
        wr.flush();
        wr.close();
    }

}
