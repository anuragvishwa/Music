package com.hfad.music;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


/**
 * Created by energywin4 on 21/9/2017.
 */

public class CardContentFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        RecyclerView recyclerView = (RecyclerView)inflater.inflate(
                R.layout.recycler_view,container,false);
        ContentAdapter adapter = new ContentAdapter();
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);
        //Set padding for tiles:
        int tilePadding = getResources().getDimensionPixelSize(R.dimen.md_keylines);
        recyclerView.setPadding(tilePadding,tilePadding,tilePadding,tilePadding);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(),2));
        return recyclerView;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public ImageView picture;
        public TextView name;
        public ViewHolder(LayoutInflater inflater,ViewGroup parent){
            super(inflater.inflate(R.layout.item_card,parent,false));
            name = (TextView) itemView.findViewById(R.id.tile_title);

        }
    }

    public static class ContentAdapter extends RecyclerView.Adapter<ViewHolder>
    {
        private static final int LENGTH = 18;

        public ContentAdapter(){

        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent,int viewType)
        {
            return new ViewHolder(LayoutInflater.from(parent.getContext()),parent);

        }

        @Override
        public void onBindViewHolder(ViewHolder holder,int position){
            //no-op
        }

        @Override
        public int getItemCount()
        {
            return LENGTH;
        }


    }


}
