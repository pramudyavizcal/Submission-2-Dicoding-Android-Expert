package com.pramu.mymovies;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.CollationElementIterator;
import java.util.ArrayList;

public class MyTVAdapter extends RecyclerView.Adapter<MyTVAdapter.TVViewHolder> {
    private Context context;
    private ArrayList<MyTV> tvs;
    public ArrayList<MyTV> getTvs(){return tvs;}

    public void setTvs(ArrayList<MyTV> tvs) {
        this.tvs = tvs;
    }

    public MyTVAdapter(Context context) {
        this.context = context;
    }


    @NonNull
    @Override
    public MyTVAdapter.TVViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_row_mytv, viewGroup,false);
        return new TVViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TVViewHolder tvViewHolder, int i) {
        tvViewHolder.txtjudul.setText(getTvs().get(i).getJudulTV());
        tvViewHolder.txtoverview.setText(getTvs().get(i).getOverviewTV());
        tvViewHolder.imgPosterTV.setImageResource(getTvs().get(i).getPosterTV());
        tvViewHolder.txtdurasiFilm.setText(getTvs().get(i).getDurasiFilmTV());
        tvViewHolder.txtwaktuTayang.setText(getTvs().get(i).getTahunRilisTV());
        tvViewHolder.txtskorPengunjung.setText(getTvs().get(i).getSkorPengunjungTV());

    }

    @Override
    public int getItemCount() {
        return getTvs().size();
    }

    public class TVViewHolder extends RecyclerView.ViewHolder {
        private TextView txtjudul;
        private TextView txtoverview;
        private TextView txtdurasiFilm;
        private TextView txtwaktuTayang;
        private TextView txtskorPengunjung;
        private ImageView imgPosterTV;

        public TVViewHolder(@NonNull View itemView) {
            super(itemView);
            txtjudul = itemView.findViewById(R.id.txt_judul);
            txtoverview = itemView.findViewById(R.id.overview);
            imgPosterTV = itemView.findViewById(R.id.posterTV);
            txtdurasiFilm = itemView.findViewById(R.id.durasiFilm);
            txtwaktuTayang = itemView.findViewById(R.id.tanggalRilis);
            txtskorPengunjung = itemView.findViewById(R.id.skorPengunjung);
        }
    }
}
