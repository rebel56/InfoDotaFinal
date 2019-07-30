package com.example.infodotafinal.ViewHolder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.infodotafinal.Interface.ItemClickListener;
import com.example.infodotafinal.R;

public class HeroViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    public TextView title_hero;
    public TextView desc_hero;
    public ImageView image_hero;

    private ItemClickListener itemClickListener;

    public void setItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    public HeroViewHolder(@NonNull View itemView) {
        super(itemView);

        title_hero = (TextView)itemView.findViewById(R.id.title_hero);
        desc_hero = (TextView)itemView.findViewById(R.id.desc_hero);
        image_hero = (ImageView) itemView.findViewById(R.id.image_hero);

        itemView.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {

        itemClickListener.onClick(v,getAdapterPosition(), false);
    }
}
