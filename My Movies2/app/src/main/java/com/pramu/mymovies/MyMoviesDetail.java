package com.pramu.mymovies;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class MyMoviesDetail extends AppCompatActivity {


    public static final String EXTRA_MOVIE = "test_extra_movie";
    String judul;
    private String statusFilm;
    private String skorPengunjung;
    private String genre;
    private String durasiFilm;
    private String bahasaFilm;
    private String overview;
    private int path;
    private TextView tViewjudul;
    private TextView tViewstatusFilm;
    private TextView tViewskorPengunjung;
    private TextView tViewgenre;
    private TextView textViewdurasiFilm;
    private TextView tViewbahasaFilm;
    private TextView tViewOverview;

    private ImageView imagePoster;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_movies_detail);
        tViewjudul = findViewById(R.id.txt_judul);
        tViewstatusFilm = findViewById(R.id.statusFilm);
        tViewskorPengunjung = findViewById(R.id.skorPengunjung);
        tViewgenre = findViewById(R.id.genre);
        textViewdurasiFilm = findViewById(R.id.durasiFilm);
        tViewbahasaFilm = findViewById(R.id.bahasaFilm);
        tViewOverview = findViewById(R.id.overview);
        imagePoster = findViewById(R.id.posterFilm);

        MyMovies movie = getIntent().getParcelableExtra(EXTRA_MOVIE);

        judul = movie.getjudul();
        tViewjudul.setText(judul);

        statusFilm = movie.getstatusFilm();
        tViewstatusFilm.setText(statusFilm);

        skorPengunjung = movie.getskorPengunjung();
        tViewskorPengunjung.setText(skorPengunjung);

        genre = movie.getgenre();
        tViewgenre.setText(genre);

        durasiFilm = movie.getdurasiFilm();
        textViewdurasiFilm.setText(durasiFilm);

        bahasaFilm = movie.getbahasaFilm();
        tViewbahasaFilm.setText(bahasaFilm);

        overview = movie.getOverview();
        tViewOverview.setText(overview);

        path = movie.getposterFilm();
        imagePoster.setImageResource(path);

    }
}
