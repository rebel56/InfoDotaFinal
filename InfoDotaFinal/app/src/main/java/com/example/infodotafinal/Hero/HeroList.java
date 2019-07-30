package com.example.infodotafinal.Hero;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.infodotafinal.Interface.ItemClickListener;
import com.example.infodotafinal.Model.Hero;
import com.example.infodotafinal.R;
import com.example.infodotafinal.ViewHolder.HeroViewHolder;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

public class HeroList extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;

    FirebaseDatabase database;
    DatabaseReference heroList;

    String heroId="";

    FirebaseRecyclerAdapter<Hero, HeroViewHolder> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hero);

        database = FirebaseDatabase.getInstance();
        heroList = database.getReference("HERO");

        recyclerView = (RecyclerView)findViewById(R.id.hero_recycle);
        recyclerView.setHasFixedSize(true);
        layoutManager = new GridLayoutManager(HeroList.this, 2);
        recyclerView.setLayoutManager(layoutManager);

        if (getIntent() != null)
            heroId = getIntent().getStringExtra("HeroId");
        if (!heroId.isEmpty() && heroId != null) {

            loadListHero(heroId);
        }


    }

    private void loadListHero(final String heroId) {
        adapter = new FirebaseRecyclerAdapter<Hero, HeroViewHolder>(Hero.class,
                R.layout.activity_hero1,
                HeroViewHolder.class,
                heroList.orderByChild("HeroId").equalTo(heroId)) {
            @Override
            protected void populateViewHolder(HeroViewHolder heroViewHolder, Hero hero, int i) {

                heroViewHolder.title_hero.setText(hero.getTitle_hero());
                heroViewHolder.desc_hero.setText(hero.getDesc_hero());
                Picasso.with(getBaseContext()).load(hero.getImage_hero())

                        .into(heroViewHolder.image_hero);

                final Hero local = hero;
                heroViewHolder.setItemClickListener(new ItemClickListener() {
                    @Override
                    public void onClick(View view, int position, boolean isLongClick) {
                        Toast.makeText(HeroList.this, ""+local.get, Toast.LENGTH_SHORT).show();
                    }
                });


            }
        };


        recyclerView.setAdapter(adapter);


    }
}
