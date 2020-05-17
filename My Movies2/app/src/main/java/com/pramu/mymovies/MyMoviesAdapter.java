package com.pramu.mymovies;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyMoviesAdapter extends RecyclerView.Adapter<MyMoviesAdapter.MovieViewHolder> {
    private Context context;
    private ArrayList<MyMovies> movies;
    public ArrayList<MyMovies> getMovies(){return movies;}

    public void setMovies(ArrayList<MyMovies> movies) {
        this.movies = movies;
    }

    public MyMoviesAdapter(Context context) {
        this.context = context;
    }


    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_row_mymovies, viewGroup,false);
        return new MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder movieViewHolder, int i) {
        movieViewHolder.txtjudul.setText(getMovies().get(i).getjudul());
        movieViewHolder.txtoverview.setText(getMovies().get(i).getOverview());
        movieViewHolder.imgPosterFilm.setImageResource(getMovies().get(i).getposterFilm());
        movieViewHolder.txtdurasiFilm.setText(getMovies().get(i).getdurasiFilm());
        movieViewHolder.txtwaktuTayang.setText(getMovies().get(i).gettahunRilis());
        movieViewHolder.txtskorPengunjung.setText(getMovies().get(i).getskorPengunjung());
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public int getItemCount() {
        return getMovies().size();
    }

    public class MovieViewHolder extends RecyclerView.ViewHolder {
        private TextView txtjudul, txtoverview, txtdurasiFilm, txtwaktuTayang, txtskorPengunjung;
        private ImageView imgPosterFilm;

        public MovieViewHolder(View view) {
            super(view);
            txtjudul = view.findViewById(R.id.txt_judul);
            txtoverview = view.findViewById(R.id.overview);
            imgPosterFilm = view.findViewById(R.id.posterFilm);
            txtdurasiFilm = view.findViewById(R.id.durasiFilm);
            txtwaktuTayang = view.findViewById(R.id.tanggalRilis);
            txtskorPengunjung = view.findViewById(R.id.skorPengunjung);

        }
    }
}