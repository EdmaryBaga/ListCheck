package com.edmary.app.ListCheck;

import android.annotation.SuppressLint;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.edmary.app.ListCheck.models.Product;

import java.util.ArrayList;
import java.util.Comparator;

class AdapterList extends RecyclerView.Adapter<AdapterList.MyViewHolder> {

    private static ArrayList<Product> mUDataClothes = new ArrayList<>();
    private static ArrayList<Product> mDataClothesL = new ArrayList<>();
    private static ArrayList<Product> mCDataClothes = new ArrayList<>();

     @RequiresApi(api = Build.VERSION_CODES.N)
     public AdapterList (ArrayList<Product> mDataClothes) {

       /*  mDataClothes.sort(new Comparator<Product>() {
             @Override
             public int compare(Product o1, Product o2) {
                 return o1.getName().compareTo(o2.getName());
             }
         });*/

         for (Product x : mDataClothes){
             if(x.getChek()){
                 mCDataClothes.add(x);
             }
             else{
                 mUDataClothes.add(x);
             }
         }
         mDataClothesL.addAll(ordenaList(mUDataClothes));
         mDataClothesL.addAll(ordenaList(mCDataClothes));
         //mDataClothesL = mDataClothes;
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
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View v) {
                if(mDataClothesL.get(position).getChek()){
                    Product item= mDataClothesL.get(position);
                    mCDataClothes.remove(item);
                    item.setChek(false);
                    mUDataClothes.add(item);
                    mDataClothesL.clear();
                    mDataClothesL.addAll(ordenaList(mUDataClothes));
                    mDataClothesL.addAll(ordenaList(mCDataClothes));
                }
                else {
                    Product item= mDataClothesL.get(position);
                    mUDataClothes.remove(item);
                    item.setChek(true);
                    mCDataClothes.add(item);
                    mDataClothesL.clear();
                    mDataClothesL.addAll(ordenaList(mUDataClothes));
                    mDataClothesL.addAll(ordenaList(mCDataClothes));
                }
                notifyDataSetChanged();
            }
        });
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public static ArrayList<Product>  ordenaList(ArrayList<Product> list){

         list.sort(new Comparator<Product>() {
             @Override
             public int compare(Product o1, Product o2) {
                 return o1.getName().compareTo(o2.getName());
             }
         });

        return list;
    }

    private void setAdapterRemov(int posicion){
        mDataClothesL.remove(posicion);
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
