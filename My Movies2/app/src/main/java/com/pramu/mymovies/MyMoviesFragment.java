package com.pramu.mymovies;


import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class MyMoviesFragment extends Fragment implements View.OnClickListener{
    private String[] judul, overview, genre, durasiFilm, bahasaFilm,
            statusFilm, skorPengunjung, tahunFilm;
    private TypedArray posterFilm;
    private MyMoviesAdapter adapter;
    ArrayList<MyMovies> movies;

    public MyMoviesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_my_movies, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.rv_movies);
        recyclerView.setHasFixedSize(true);

        adapter = new MyMoviesAdapter(getContext());
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        MyCustomClick.addTo(recyclerView).setOnItemClickListener(new MyCustomClick.OnItemClickListener() {

            @Override
            public void onItemClicked(RecyclerView recyclerView, int i, View v) {
                MyMovies movie = new MyMovies();

                movie.setposterFilm(posterFilm.getResourceId(i, -1));
                movie.setjudul(judul[i]);
                movie.setOverview(overview[i]);
                movie.setgenre(genre[i]);
                movie.setstatusFilm(statusFilm[i]);
                movie.setdurasiFilm(durasiFilm[i]);
                movie.setskorPengunjung(skorPengunjung[i]);
                movie.setbahasaFilm(bahasaFilm[i]);
                movie.settahunRilis(tahunFilm[i]);


                Intent intent = new Intent(getActivity().getApplication(), MyMoviesDetail.class);
                intent.putExtra(MyMoviesDetail.EXTRA_MOVIE, movie);
                startActivity(intent);
            }
        });
        prepare();
        addItem();
        return view;

    }

    @Override
    public void onClick(View v) {

    }
    private void addItem() {

        movies = new ArrayList<>();

        for (int i = 0; i < judul.length; i++) {
            MyMovies movie = new MyMovies();
            movie.setposterFilm(posterFilm.getResourceId(i, -1));
            movie.setjudul(judul[i]);
            movie.setOverview(overview[i]);
            movie.setgenre(genre[i]);
            movie.setstatusFilm(statusFilm[i]);
            movie.setdurasiFilm(durasiFilm[i]);
            movie.setskorPengunjung(skorPengunjung[i]);
            movie.setbahasaFilm(bahasaFilm[i]);
            movie.settahunRilis(tahunFilm[i]);
            movies.add(movie);
        }
        adapter.setMovies(movies);
    }

    private void prepare() {
        judul = getResources().getStringArray(R.array.data_title);
        overview = getResources().getStringArray(R.array.data_description);
        posterFilm = getResources().obtainTypedArray(R.array.data_posterfilm);
        genre = getResources().getStringArray(R.array.data_genres);
        statusFilm = getResources().getStringArray(R.array.data_status);
        skorPengunjung = getResources().getStringArray(R.array.data_scoreattendance);
        bahasaFilm = getResources().getStringArray(R.array.data_languages);
        durasiFilm = getResources().getStringArray(R.array.data_runtime);
        tahunFilm = getResources().getStringArray(R.array.data_year);
    }
}
