package com.pramu.mymovies;

import android.os.Parcel;
import android.os.Parcelable;

public class MyTV implements Parcelable {
    private String judulTV;
    private String overviewTV;
    private String skorPengunjungTV;
    private String statusFilmTV;
    private String bahasaFilmTV;
    private String durasiFilmTV;
    private String genreTV;
    private String tahunRilisTV;

    public int getPosterTV() {
        return posterTV;
    }

    public void setPosterTV(int posterTV) {
        this.posterTV = posterTV;
    }

    private int posterTV;

    public String getJudulTV() {
        return judulTV;
    }

    public void setJudulTV(String judulTV) {
        this.judulTV = judulTV;
    }

    public String getOverviewTV() {
        return overviewTV;
    }

    public void setOverviewTV(String overviewTV) {
        this.overviewTV = overviewTV;
    }

    public String getSkorPengunjungTV() {
        return skorPengunjungTV;
    }

    public void setSkorPengunjungTV(String skorPengunjungTV) {
        this.skorPengunjungTV = skorPengunjungTV;
    }

    public String getStatusFilmTV() {
        return statusFilmTV;
    }

    public void setStatusFilmTV(String statusFilmTV) {
        this.statusFilmTV = statusFilmTV;
    }

    public String getBahasaFilmTV() {
        return bahasaFilmTV;
    }

    public void setBahasaFilmTV(String bahasaFilmTV) {
        this.bahasaFilmTV = bahasaFilmTV;
    }

    public String getDurasiFilmTV() {
        return durasiFilmTV;
    }

    public void setDurasiFilmTV(String durasiFilmTV) {
        this.durasiFilmTV = durasiFilmTV;
    }

    public String getGenreTV() {
        return genreTV;
    }

    public void setGenreTV(String genreTV) {
        this.genreTV = genreTV;
    }

    public String getTahunRilisTV() {
        return tahunRilisTV;
    }

    public void setTahunRilisTV(String tahunRilisTV) {
        this.tahunRilisTV = tahunRilisTV;
    }


    public MyTV() {
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.judulTV);
        dest.writeString(this.overviewTV);
        dest.writeString(this.skorPengunjungTV);
        dest.writeString(this.statusFilmTV);
        dest.writeString(this.bahasaFilmTV);
        dest.writeString(this.durasiFilmTV);
        dest.writeString(this.genreTV);
        dest.writeString(this.tahunRilisTV);
        dest.writeInt(this.posterTV);
    }

    protected MyTV(Parcel in) {
        this.judulTV = in.readString();
        this.overviewTV = in.readString();
        this.skorPengunjungTV = in.readString();
        this.statusFilmTV = in.readString();
        this.bahasaFilmTV = in.readString();
        this.durasiFilmTV = in.readString();
        this.genreTV = in.readString();
        this.tahunRilisTV = in.readString();
        this.posterTV = in.readInt();
    }

    public static final Creator<MyTV> CREATOR = new Creator<MyTV>() {
        @Override
        public MyTV createFromParcel(Parcel source) {
            return new MyTV(source);
        }

        @Override
        public MyTV[] newArray(int size) {
            return new MyTV[size];
        }
    };
}
