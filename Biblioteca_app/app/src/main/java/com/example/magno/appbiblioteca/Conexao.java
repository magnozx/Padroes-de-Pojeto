package com.example.magno.appbiblioteca;

import android.os.StrictMode;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

import javax.net.ssl.HttpsURLConnection;

public class Conexao {


    //Função para buscar livros por título
    public JSONArray enviarGetParaBuscarLivrosPorTitulo(String tituloDoLivroProcurado) throws IOException, JSONException {

        String url = "https://applibary.herokuapp.com/livro/"+tituloDoLivroProcurado;

        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        // optional default is GET
        con.setRequestMethod("GET");

        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }

        in.close();

        JSONArray retorno = new JSONArray(response.toString());

        con.disconnect();

        return retorno;
    }

    //Função para buscar livros por tomo
    public JSONObject enviarGetParaBuscarLivrosPorTomo(String tomoDoLivroProcurado) throws IOException, JSONException {

        String url = "https://applibary.herokuapp.com/livro2/"+tomoDoLivroProcurado;

        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        // optional default is GET
        con.setRequestMethod("GET");

        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }

        in.close();

        JSONObject retorno = new JSONObject(response.toString());

        con.disconnect();

        return retorno;
    }


    //Função para Cadastrar um Livro
    public void enviarPostParaCadastrarLivro(Livro livroParaSerCadastrado) throws IOException, JSONException {

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        String url = "https://applibary.herokuapp.com/livroInserir";

        URL obj = new URL(url);
        HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();


        con.setRequestMethod("POST");
        con.setRequestProperty("Content-Type", "application/json");
        con.setRequestProperty("Accept","application/json");
        con.setDoOutput(true);
        con.setDoInput(true);

        con.connect();

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

        OutputStream outputPost = new BufferedOutputStream(con.getOutputStream());
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputPost));
        writer.write(urlParameters.toString());
        writer.flush();
        writer.close();

        con.disconnect();
    }

}
