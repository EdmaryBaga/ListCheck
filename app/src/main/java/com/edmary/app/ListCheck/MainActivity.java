package com.edmary.app.ListCheck;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String[] clothes = getResources().getStringArray(R.array.list_prod);
        ArrayList<String> listaClothes = new ArrayList<>(Arrays.asList(clothes));
        for( String x: clothes){
            System.out.println(x);
        }
        RecyclerView recyclerView = findViewById(R.id.lista_prod);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        RecyclerView.Adapter mAdapter = new AdapterList(listaClothes);
        recyclerView.setAdapter(mAdapter);

    }




}





