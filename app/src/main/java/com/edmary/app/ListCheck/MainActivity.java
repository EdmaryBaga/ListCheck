package com.edmary.app.ListCheck;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String clothes[] = getResources().getStringArray(R.array.list_prod);
        for( String x: clothes){
            System.out.println(x);
        }
        recyclerView = (RecyclerView) findViewById(R.id.lista_prod);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        mAdapter = new AdapterList(clothes);
        recyclerView.setAdapter(mAdapter);

    }




}





