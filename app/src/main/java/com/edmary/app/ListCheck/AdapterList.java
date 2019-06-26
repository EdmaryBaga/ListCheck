package com.edmary.app.ListCheck;

import android.annotation.SuppressLint;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

class AdapterList extends RecyclerView.Adapter<AdapterList.MyViewHolder> {


     private static ArrayList<String> mDataClothesL;
    private static ArrayList<String> mCheckedDataClothes = new ArrayList<>();
    int contChecked =0;

     public AdapterList (ArrayList<String> mDataClothes) {
         mDataClothesL = mDataClothes;

    }

    @NonNull
    @Override
    public AdapterList.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_list, viewGroup, false);

        return new MyViewHolder(v);
    }
    @Override
    public void onBindViewHolder(@NonNull AdapterList.MyViewHolder myViewHolder, int i) {
        myViewHolder.bin(mDataClothesL.get(i));
    }

    void setAdapterRemov(int posicion){
        mDataClothesL.remove(posicion);
        notifyDataSetChanged();
    }

    void setAdapterCheck(ArrayList<String> list){
        notifyDataSetChanged();
    }


    @Override
    public int getItemCount() {
        return mDataClothesL.size();
    }

     class MyViewHolder extends RecyclerView.ViewHolder {
        View Viewi;
        @SuppressLint("StaticFieldLeak")
         TextView namePrd;
        ImageView Delete;
        CheckBox checkB;
       private MyViewHolder(View v) {
            super(v);
            Viewi= v;
            namePrd = v.findViewById(R.id.name_product);
            Delete= v.findViewById(R.id.btn_delete);
            checkB = v.findViewById(R.id.checkbox_list_clothes);
            Delete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String item= mDataClothesL.get(getAdapterPosition());
                    Toast.makeText(v.getContext(), "Se elimino "+item, Toast.LENGTH_LONG).show();
                    setAdapterRemov(getAdapterPosition());
                }
            });

            checkB.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    String item= mDataClothesL.get(getAdapterPosition());
                    Toast.makeText(buttonView.getContext(), "Usted selecciono "+item, Toast.LENGTH_LONG).show();
                    mDataClothesL.remove(getAdapterPosition());
                    mDataClothesL.add(item);
                    setAdapterCheck(mDataClothesL);
                    contChecked+=1;
                }
            });
        }

          void bin(String NameProducto){
            namePrd.setText(NameProducto);
        }
    }


}
