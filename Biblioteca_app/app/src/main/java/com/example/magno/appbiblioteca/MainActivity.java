package com.example.magno.appbiblioteca;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

//import org.json.JSONArray;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.List;

//import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Modelo modelo = new Modelo();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
    }


    public void onClickBuscarPorTitulo(View view) {

        EditText tituloDoLivroProcurado = findViewById(R.id.tituloDoLivroProcurado);
        TextView resultadoDaBusca = findViewById(R.id.resultadoDaBusca);

        String tituloDoLivro = String.valueOf(tituloDoLivroProcurado.getText());

        JSONArray titulosEncontrados = modelo.buscarLivroPorTitulo(tituloDoLivro);
        resultadoDaBusca.setText(titulosEncontrados.toString());

        tituloDoLivroProcurado.setText("");
    }

    public void onClickBuscarPorTomo(View view) {

        EditText tomoDoLivroProcurado = findViewById(R.id.tomoDoLivroProcurado);
        TextView resultadoDaBusca = findViewById(R.id.resultadoDaBusca);

       String tomoDoLivro = String.valueOf(tomoDoLivroProcurado.getText());

        JSONObject titulosEncontrados = modelo.buscarLivroPorTomo(tomoDoLivro);
        resultadoDaBusca.setText(titulosEncontrados.toString());

        tomoDoLivroProcurado.setText("");
    }
}
