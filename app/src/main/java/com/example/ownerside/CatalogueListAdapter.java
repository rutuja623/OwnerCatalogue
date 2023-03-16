package com.example.ownerside;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CatalogueListAdapter extends RecyclerView.Adapter<CatalogueListAdapter.MyViewHolder>  {


    private static Context context;
    private List<Integer> images;
    private List<String> titles;
    private List<String> qtn;
    private List<String> price;
    public void setFilteredList(List<String> filteredList){
        this.titles = filteredList;
        notifyDataSetChanged();
    }


    public CatalogueListAdapter(Context context, List<Integer> images , List<String> titles, List<String> qtn , List<String> price) {
        this.context = context;
        this.images = images;
        this.titles = titles;
        this.qtn = qtn;
        this.price = price;

    }

    @NonNull
    @Override
    public CatalogueListAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.card_view,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull CatalogueListAdapter.MyViewHolder holder, int position) {

        holder.mTite.setText(titles.get(position));
        holder.mqtn.setText(qtn.get(position));
        holder.mprice.setText(price.get(position));
        holder.mImageview.setImageResource(images.get(position));

    }

    @Override
    public int getItemCount() {
        return titles.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        ImageView mImageview;
        TextView mTite , mqtn , mprice;
        public MyViewHolder(View itemView){
            super(itemView);

            mImageview = itemView.findViewById(R.id.imageview);
            mTite = itemView.findViewById(R.id.textview);
            mqtn = itemView.findViewById(R.id.textview1);
            mprice = itemView.findViewById(R.id.textview2);

//            itemView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
////
////                    Intent intent = new Intent(context , PlantInfo.class);
////                    intent.putExtra("plantname",pname);
////                    intent.putExtra("catname",cat);
////                    v.getContext().startActivity(intent);
//
//                    Bundle bundle = new Bundle();
//                    bundle.putString("plantname", mTextview.getText().toString());
//                    bundle.putString("catname",cat);
//                    Intent intent = new Intent(context, PlantInfo.class);
//                    intent.putExtras(bundle);
//                    v.getContext().startActivity(intent);
//                }
//            });
        }
    }


}