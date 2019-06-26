package com.edmary.app.ListCheck;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

class AdapterList extends RecyclerView.Adapter<AdapterList.MyViewHolder> {


    private String[] mDataClothes;

    public AdapterList (String[] mDataClothes) {
        this.mDataClothes = mDataClothes;
    }

    static class MyViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public View Viewi;
        static TextView namePrd;
        public MyViewHolder(View v) {
            super(v);
            Viewi= v;
            namePrd = v.findViewById(R.id.name_product);
        }

        public static void bin(String NameProducto){
            //setear cada elemento
            namePrd.setText(NameProducto);
        }


    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_list, viewGroup, false);

        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterList.MyViewHolder myViewHolder, int i) {
        MyViewHolder.bin(mDataClothes[i]);
    }


    @Override
    public int getItemCount() {
        return mDataClothes.length;
    }

}
