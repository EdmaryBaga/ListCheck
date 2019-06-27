package com.edmary.app.ListCheck;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class CrearProducto extends AppCompatActivity {
    private EditText namProd;
    String nombreNuevo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.crear_producto);
        namProd = findViewById(R.id.nombre_prod_new);
        TextView textoNewElem = findViewById(R.id.titulo_crea);
        textoNewElem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v, "Usted puede crear un nuevo producto desde aqui ", Snackbar.LENGTH_LONG)
                        .show();
            }
        });

        Button crear = findViewById(R.id.crear_producto);

        crear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                nombreNuevo = namProd.getText().toString();
                if(nombreNuevo.isEmpty()){
                    Snackbar.make(v, "Debe agregar un nombre a su nuevo producto", Snackbar.LENGTH_LONG)
                            .show();
                }else {
                    Intent intent = new Intent(CrearProducto.this, MainActivity.class);
                    nombreNuevo = nombreNuevo.toLowerCase();
                    nombreNuevo = nombreNuevo.substring(0, 1).toUpperCase() + nombreNuevo.substring(1);
                    intent.putExtra("bandera", true);
                    intent.putExtra("nombre", nombreNuevo);
                    setResult(Activity.RESULT_OK, intent);
                    finish();
                }

            }
        });

    }
}
