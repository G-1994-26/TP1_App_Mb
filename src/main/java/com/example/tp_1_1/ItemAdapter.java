package com.example.tp_1_1;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemViewHolder> {
    private AppCompatActivity context;
    String[] animaux = AnimalList.getNameArray();



    public ItemAdapter(AppCompatActivity context) {
        this.context=context;
    }


    @NonNull
    @Override
    public ItemAdapter.ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //return null;
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row,parent,false);
        ItemViewHolder ivh = new ItemViewHolder(v);
        return ivh;
    }

    @Override
    public void onBindViewHolder(@NonNull ItemAdapter.ItemViewHolder holder, int position) {
        holder.position=position;
        String nom =animaux[position] ;
        holder.textView.setText(nom);
        Animal animal = AnimalList.getAnimal(nom);
        int id =context.getResources().getIdentifier(animal.getImgFile(),"drawable",context.getPackageName());
        holder.imageView.setImageResource(id);
    }

    @Override
    public int getItemCount() {
        return animaux.length;
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public int position;
        public ImageView imageView;
        public TextView textView;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.imageViewRow);
            textView=itemView.findViewById(R.id.label);
            itemView.setOnClickListener(this);
        }


        @Override
        public void onClick(View v) {
            Intent intent = new Intent(context,SecondeActivity.class);
            intent.putExtra("name",textView.getText());
            context.startActivity(intent);

        }
    }

}
