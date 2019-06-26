package com.edmary.app.ListCheck;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    ArrayList<String> listaClothes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String bandera = getIntent().getStringExtra("bandera");

        if(bandera!=null){
           listaClothes = getIntent().getStringArrayListExtra("listaR");
        }
        else{
            String[] clothes = getResources().getStringArray(R.array.list_prod);
            listaClothes = new ArrayList<>(Arrays.asList(clothes));
           }




        RecyclerView recyclerView = findViewById(R.id.lista_prod);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        RecyclerView.Adapter mAdapter = new AdapterList(listaClothes);
        recyclerView.setAdapter(mAdapter);


        Button btn_crearProd = findViewById(R.id.crea_producto);
        btn_crearProd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //ListProgramsActivity.this, ProgramasListActivty.class
                Intent in = new Intent(MainActivity.this, CrearProducto.class);
                in.putStringArrayListExtra("lista", listaClothes);
                startActivity(in);
            }
        });

    }






}





