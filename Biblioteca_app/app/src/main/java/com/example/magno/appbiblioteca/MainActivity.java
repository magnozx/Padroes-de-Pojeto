package com.example.magno.appbiblioteca;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.support.v7.widget.Toolbar;

import org.json.JSONArray;
import org.json.JSONObject;


public class MainActivity extends AppCompatActivity {

    Modelo modelo = new Modelo();
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

    }

    @Override
    public boolean onCreateOptionsMenu (Menu menu){
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return super.onCreateOptionsMenu(menu);
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem) {

        if (menuItem.getItemId() == R.id.busca) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
        if (menuItem.getItemId() == R.id.cadastrar) {
            Intent intent_cadastrar = new Intent(this, CadastrarActivity.class);
            startActivity(intent_cadastrar);
        }
        if (menuItem.getItemId() == R.id.deletar) {
            Intent intent_deletar = new Intent(this, DeletarActivity.class);
            startActivity(intent_deletar);
        }
        return true;
    }


        public void onClickBuscarPorTitulo (View view){

            EditText tituloDoLivroProcurado = findViewById(R.id.tituloDoLivroProcurado);
            TextView resultadoDaBusca = findViewById(R.id.resultadoDaBusca);

            String tituloDoLivro = String.valueOf(tituloDoLivroProcurado.getText());

            JSONArray titulosEncontrados = modelo.buscarLivroPorTitulo(tituloDoLivro);
            resultadoDaBusca.setText(titulosEncontrados.toString());

            tituloDoLivroProcurado.setText("");
        }

        public void onClickBuscarPorTomo (View view){

            EditText tomoDoLivroProcurado = findViewById(R.id.tomoDoLivroProcurado);
            TextView resultadoDaBusca = findViewById(R.id.resultadoDaBusca);

            String tomoDoLivro = String.valueOf(tomoDoLivroProcurado.getText());

            JSONObject titulosEncontrados = modelo.buscarLivroPorTomo(tomoDoLivro);
            resultadoDaBusca.setText(titulosEncontrados.toString());

            tomoDoLivroProcurado.setText("");
        }

}
