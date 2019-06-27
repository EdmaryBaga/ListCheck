package com.edmary.app.ListCheck;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import com.edmary.app.ListCheck.models.Product;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class MainActivity extends AppCompatActivity {
    ArrayList<String> listaClothes;
    ArrayList<Product> listProd = new ArrayList<>();
    RecyclerView.Adapter mAdapter;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String bandera = getIntent().getStringExtra("bandera");

        if(bandera==null){
            String[] clothes = getResources().getStringArray(R.array.list_prod);
            listaClothes = new ArrayList<>(Arrays.asList(clothes));
            for (String x: listaClothes){
            listProd.add(new Product(x, false));
            }
        }

        RecyclerView recyclerView = findViewById(R.id.lista_prod);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        mAdapter = new AdapterList(listProd);
        recyclerView.setAdapter(mAdapter);

        Button btn_crearProd = findViewById(R.id.crea_producto);
        btn_crearProd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(MainActivity.this, CrearProducto.class);
                startActivityForResult(in, 0);
            }
        });
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode==0){
            if(resultCode== Activity.RESULT_OK){
                String nom = data.getStringExtra("nombre");
                ArrayList<Product> listAux = new ArrayList<>();
                listAux.addAll(listProd);
                listAux.add(new Product(nom, false));
                listProd.clear();
                listProd.addAll(listAux);
                listProd.sort(new Comparator<Product>() {
                    @Override
                    public int compare(Product o1, Product o2) {
                        return o1.getName().compareTo(o2.getName());
                    }
                });
                mAdapter.notifyDataSetChanged();
            }
        }
    }
}