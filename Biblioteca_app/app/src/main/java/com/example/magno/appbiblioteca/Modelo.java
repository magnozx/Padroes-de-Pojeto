package com.example.magno.appbiblioteca;

import android.os.StrictMode;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;



public class Modelo {

    private Conexao conexao = new Conexao();

    public JSONArray buscarLivroPorTitulo(String tituloDoLivroProcurado) {

        JSONArray livrosEncontrados = new JSONArray();

        try {
            livrosEncontrados = conexao.enviarGetParaBuscarLivrosPorTitulo(tituloDoLivroProcurado);
        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }

        return livrosEncontrados;
    }

    public JSONObject buscarLivroPorTomo(String tomoDoLivroProcurado) {

        JSONObject livrosEncontrados = new JSONObject();

        try {
            livrosEncontrados = conexao.enviarGetParaBuscarLivrosPorTomo(tomoDoLivroProcurado);
        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }

        return livrosEncontrados;
    }
}

