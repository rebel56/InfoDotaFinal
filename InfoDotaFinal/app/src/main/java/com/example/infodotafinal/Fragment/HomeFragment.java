package com.example.infodotafinal.Fragment;


import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.infodotafinal.ViewHolder.HomeViewHolder;
import com.example.infodotafinal.Interface.ItemClickListener;
import com.example.infodotafinal.Hero.HeroList;
import com.example.infodotafinal.Model.Post;
import com.example.infodotafinal.R;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment  {



    private RecyclerView mBlogList;
    private DatabaseReference mDatabase;

    FirebaseRecyclerAdapter<Post, HomeViewHolder> firebaseRecyclerAdapter;


    public static HomeFragment newInstance() {
        return new HomeFragment();
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_home, container, false);



        mDatabase = FirebaseDatabase.getInstance().getReference().child("HOME");
        mDatabase.keepSynced(true);

        mBlogList = (RecyclerView) v.findViewById(R.id.home_recycle);
        mBlogList.setHasFixedSize(true);
        mBlogList.setLayoutManager(new GridLayoutManager(getActivity(), 2));

        loadMenu();


        return v;
    }

    private void loadMenu() {

        firebaseRecyclerAdapter = new FirebaseRecyclerAdapter<Post, HomeViewHolder>
                (Post.class,R.layout.fragment_home1,HomeViewHolder.class,mDatabase) {


            @Override
            protected void populateViewHolder(HomeViewHolder homeViewHolder, Post post, int position) {

                homeViewHolder.title.setText(post.getTitle());
                homeViewHolder.desc.setText(post.getDesc());
                Picasso.with(getContext()).load(post.getImage())

                        .into(homeViewHolder.image);
                final Post clickItem = post;
                homeViewHolder.setItemClickListener(new ItemClickListener() {
                    @Override
                    public void onClick(View view, int position, boolean isLongClick) {
                        Intent heroList = new Intent(getActivity(), HeroList.class);
                        heroList.putExtra("HeroId",firebaseRecyclerAdapter.getRef(position).getKey());
                        startActivity(heroList);


                    }
                });


            }

        };

        mBlogList.setAdapter(firebaseRecyclerAdapter);



    }


}
