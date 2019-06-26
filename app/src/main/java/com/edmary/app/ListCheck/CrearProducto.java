package com.edmary.app.ListCheck;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class CrearProducto extends AppCompatActivity {
    private EditText namProd;
    String nombreNuevo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.crear_producto);
        namProd= findViewById(R.id.nombre_prod_new);
        Button crear = findViewById(R.id.crear_producto);
        final ArrayList <String> lista = getIntent().getStringArrayListExtra("lista");

        crear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CrearProducto.this, MainActivity.class);
                intent.putExtra("bandera", "pasar");
                nombreNuevo= namProd.getText().toString();
                lista.add(nombreNuevo);
                intent.putStringArrayListExtra("listaR", lista);
                startActivity(intent);
            }
        });

    }
}