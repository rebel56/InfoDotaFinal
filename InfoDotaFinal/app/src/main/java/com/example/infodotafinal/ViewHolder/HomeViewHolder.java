package com.example.infodotafinal.ViewHolder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.infodotafinal.Interface.ItemClickListener;
import com.example.infodotafinal.R;

public class HomeViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    public TextView title;
    public TextView desc;
    public ImageView image;

    private ItemClickListener itemClickListener;

    public HomeViewHolder(@NonNull View itemView) {
        super(itemView);

        title = (TextView)itemView.findViewById(R.id.post_title);
        desc = (TextView)itemView.findViewById(R.id.post_desc);
        image = (ImageView) itemView.findViewById(R.id.post_image);

        itemView.setOnClickListener(this);
    }

    public void setItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    @Override
    public void onClick(View v) {

        itemClickListener.onClick(v,getAdapterPosition(), false);

    }
}
