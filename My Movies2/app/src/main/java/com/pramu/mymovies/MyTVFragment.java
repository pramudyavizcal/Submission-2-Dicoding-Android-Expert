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

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class MyTVFragment extends Fragment implements View.OnClickListener{
    private String[] judul, overview, genre, durasiFilmTV, bahasaFilmTV,
            statusFilmTV, skorPengunjungTV, tahunFilmTV;
    private TypedArray posterTV;
    private MyTVAdapter adapter;
    ArrayList<MyTV> tvs;

    public MyTVFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_my_tv, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.rv_TV);
        recyclerView.setHasFixedSize(true);

        adapter = new MyTVAdapter(getContext());
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        MyCustomClick.addTo(recyclerView).setOnItemClickListener(new MyCustomClick.OnItemClickListener() {

            @Override
            public void onItemClicked(RecyclerView recyclerView, int i, View v) {
                MyTV tv = new MyTV();

                tv.setPosterTV(posterTV.getResourceId(i, -1));
                tv.setJudulTV(judul[i]);
                tv.setOverviewTV(overview[i]);
                tv.setGenreTV(genre[i]);
                tv.setStatusFilmTV(statusFilmTV[i]);
                tv.setDurasiFilmTV(durasiFilmTV[i]);
                tv.setSkorPengunjungTV(skorPengunjungTV[i]);
                tv.setBahasaFilmTV(bahasaFilmTV[i]);
                tv.setTahunRilisTV(tahunFilmTV[i]);


                Intent intent = new Intent(getActivity().getApplication(), MyTVDetail.class);
                intent.putExtra(MyTVDetail.EXTRA_TV, tv);
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

        tvs = new ArrayList<>();

        for (int i = 0; i < judul.length; i++) {
            MyTV tv = new MyTV();
            tv.setPosterTV(posterTV.getResourceId(i, -1));
            tv.setJudulTV(judul[i]);
            tv.setOverviewTV(overview[i]);
            tv.setGenreTV(genre[i]);
            tv.setStatusFilmTV(statusFilmTV[i]);
            tv.setDurasiFilmTV(durasiFilmTV[i]);
            tv.setSkorPengunjungTV(skorPengunjungTV[i]);
            tv.setBahasaFilmTV(bahasaFilmTV[i]);
            tv.setTahunRilisTV(tahunFilmTV[i]);
            tvs.add(tv);
        }
        adapter.setTvs(tvs);
    }

    private void prepare() {
        judul = getResources().getStringArray(R.array.data_title_TV);
        overview = getResources().getStringArray(R.array.data_description_TV);
        posterTV = getResources().obtainTypedArray(R.array.data_posterfilm_TV);
        genre = getResources().getStringArray(R.array.data_genres_TV);
        statusFilmTV = getResources().getStringArray(R.array.data_status_TV);
        skorPengunjungTV = getResources().getStringArray(R.array.data_scoreattendance_TV);
        bahasaFilmTV = getResources().getStringArray(R.array.data_languages_TV);
        durasiFilmTV = getResources().getStringArray(R.array.data_runtime_TV);
        tahunFilmTV = getResources().getStringArray(R.array.data_year_TV);
    }
}
