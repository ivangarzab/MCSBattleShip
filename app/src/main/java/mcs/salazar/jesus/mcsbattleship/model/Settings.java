package mcs.salazar.jesus.mcsbattleship.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by berekethaile on 2/10/18.
 */

public class Settings implements MVVMModel, Parcelable{
    private String mMusic;
    private String mColor;
    private String mLanguage;

    public Settings() {
        mMusic = "";
        mColor = "";
        mLanguage = "";
    }

    protected Settings(Parcel in) {
        mMusic = in.readString();
        mColor = in.readString();
        mLanguage = in.readString();
    }

    public static final Creator<Settings> CREATOR = new Creator<Settings>() {
        @Override
        public Settings createFromParcel(Parcel in) {
            return new Settings(in);
        }

        @Override
        public Settings[] newArray(int size) {
            return new Settings[size];
        }
    };


    @Override
    public void toJson() {

    }

    @Override
    public void fromJson() {

    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mMusic);
        dest.writeString(mColor);
        dest.writeString(mLanguage);
    }

    public String getMusic() {
        return mMusic;
    }

    public String getColor() {
        return mColor;
    }

    public String getLanguage() {
        return mLanguage;
    }

    public void setMusic(String music) {
        mMusic = music;
    }

    public void setColor(String color) {
        mColor = color;
    }

    public void setLanguage(String language) {
        mLanguage = language;
    }
}
