package com.pramu.mymovies;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class MyTVDetail extends AppCompatActivity {

    public static final String EXTRA_TV = "test_extra_tv";
    String judul;
    private String statusFilmTV;
    private String skorPengunjungTV;
    private String genreTV;
    private String durasiFilmTV;
    private String bahasaFilmTV;
    private String overviewTV;
    private int path;
    private TextView tViewjudulTV;
    private TextView tViewstatusFilmTV;
    private TextView tViewskorPengunjungTV;
    private TextView tViewgenreTV;
    private TextView textViewdurasiFilmTV;
    private TextView tViewbahasaFilmTV;
    private TextView tViewOverviewTV;

    private ImageView imagePoster;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_tvdetail);
        tViewjudulTV = findViewById(R.id.txt_judul);
        tViewstatusFilmTV = findViewById(R.id.statusFilm);
        tViewskorPengunjungTV = findViewById(R.id.skorPengunjung);
        tViewgenreTV = findViewById(R.id.genre);
        textViewdurasiFilmTV = findViewById(R.id.durasiFilm);
        tViewbahasaFilmTV = findViewById(R.id.bahasaFilm);
        tViewOverviewTV = findViewById(R.id.overview);
        imagePoster = findViewById(R.id.posterTV);

        MyTV tv = getIntent().getParcelableExtra(EXTRA_TV);

        judul = tv.getJudulTV();
        tViewjudulTV.setText(judul);

        statusFilmTV = tv.getStatusFilmTV();
        tViewstatusFilmTV.setText(statusFilmTV);

        skorPengunjungTV = tv.getSkorPengunjungTV();
        tViewskorPengunjungTV.setText(skorPengunjungTV);

        genreTV = tv.getGenreTV();
        tViewgenreTV.setText(genreTV);

        durasiFilmTV = tv.getDurasiFilmTV();
        textViewdurasiFilmTV.setText(durasiFilmTV);

        bahasaFilmTV = tv.getBahasaFilmTV();
        tViewbahasaFilmTV.setText(bahasaFilmTV);

        overviewTV = tv.getOverviewTV();
        tViewOverviewTV.setText(overviewTV);

        path = tv.getPosterTV();
        imagePoster.setImageResource(path);

    }
}
