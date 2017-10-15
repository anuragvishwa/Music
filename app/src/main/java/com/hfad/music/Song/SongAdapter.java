package com.hfad.music.Song;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.hfad.music.R;

import java.util.List;

/**
 * Created by anurag on 12/10/17.
 */

public class SongAdapter extends RecyclerView.Adapter<SongAdapter.ViewHolder> {

   /* public SongAdapter(List<SongList> songLists, Context context) {
        this.songLists = songLists;
        this.context = context;
    }*/

   private final SongContract.Presenter presenter;


   public SongAdapter(SongContract.Presenter songPresenter){
       this.presenter = songPresenter;
   }

/*    private List<SongList> songLists;
    private Context context;*/


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_song,parent,false);

        return new ViewHolder(v);
    }

  /*  @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        SongList songList = songLists.get(position);
        holder.songName.setText(songList.getTitle());
        holder.artistName.setText(songList.getArtist());
    }*/

    @Override
    public void onBindViewHolder(ViewHolder holder,int position){
        presenter.onBindRepositoryRowViewAtPosition(holder,position);
    }

   /* @Override
    public int getItemCount() {
        return songLists.size();
    }*/

   @Override
   public int getItemCount(){
       return presenter.getSongsCount();
   }

    public class ViewHolder extends RecyclerView.ViewHolder implements SongViewHolder{

        public TextView songName;
        public TextView artistName;
        public ImageButton img;

        public ViewHolder(View itemView) {
            super(itemView);

            songName = (TextView)itemView.findViewById(R.id.songName);
            artistName = (TextView)itemView.findViewById(R.id.albumName);

        }

        @Override
        public void setSongName(String title){
            songName.setText(title);
        }

        @Override
        public void setArtistName(String name){
            artistName.setText(name);
        }
    }
}
