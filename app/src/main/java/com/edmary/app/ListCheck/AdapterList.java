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

import com.edmary.app.ListCheck.models.Product;

import java.util.ArrayList;

class AdapterList extends RecyclerView.Adapter<AdapterList.MyViewHolder> {

    private static ArrayList<Product> mDataClothesL;
    private static ArrayList<String> mCheckedDataClothes = new ArrayList<>();
    int contChecked =0;

     public AdapterList (ArrayList<Product> mDataClothes) {
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
    public void onBindViewHolder(@NonNull final AdapterList.MyViewHolder myViewHolder, final int position) {

        myViewHolder.bin(mDataClothesL.get(position).getName(),mDataClothesL.get(position).getChek());

        myViewHolder.mCheckB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mDataClothesL.get(position).getChek()){
                    mDataClothesL.get(position).setChek(false);
                    //myViewHolder.mCheckB.setChecked(false);
                }
                else {
                    mDataClothesL.get(position).setChek(true);
                    //myViewHolder.mCheckB.setChecked(true);
                    Product item= mDataClothesL.get(position);
                    item.setChek(true);
                    mDataClothesL.remove(position);
                    mDataClothesL.add(item);
                    contChecked+=1;
                }
                notifyDataSetChanged();
            }
        });
    }

    private void setAdapterRemov(int posicion){
        mDataClothesL.remove(posicion);
        notifyDataSetChanged();
    }

    private void setAdapterCheck(Product item){
        mDataClothesL.add(item);
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
        CheckBox mCheckB;
       private MyViewHolder(View v) {
            super(v);
            Viewi= v;
            namePrd = v.findViewById(R.id.name_product);
            Delete= v.findViewById(R.id.btn_delete);
            mCheckB = v.findViewById(R.id.checkbox_list_clothes);
            Delete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String item= mDataClothesL.get(getAdapterPosition()).getName();
                    Toast.makeText(v.getContext(), "Se elimino "+item, Toast.LENGTH_LONG).show();
                    setAdapterRemov(getAdapterPosition());
                }
            });

        }

          void bin(String NameProducto, Boolean chek){
            namePrd.setText(NameProducto);
            mCheckB.setChecked(chek);
        }
    }

}
