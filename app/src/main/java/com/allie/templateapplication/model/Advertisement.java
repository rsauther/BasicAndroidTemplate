package com.allie.templateapplication.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.widget.TextView;

/**
 * Created by rsauther on 10/22/17.
 */

public class Advertisement implements Parcelable {


    private int mBackgroundColor;
    private String mAdColorText;

    public int getBackgroundColor() {
        return mBackgroundColor;
    }

    public void setBackgroundColor(int color) {
        mBackgroundColor = color;
    }

    public String getAdColorText() {
        return mAdColorText;
    }

    public void setAdColorText(String adColorText) {
        mAdColorText = adColorText;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

        dest.writeInt(this.mBackgroundColor);
        dest.writeString(this.mAdColorText);

    }

    public Advertisement() {
    }

    protected Advertisement(Parcel in) {

        this.mBackgroundColor = in.readInt();
        this.mAdColorText = in.readString();

    }

    public static final Creator<Advertisement> CREATOR = new Creator<Advertisement>() {
        @Override
        public Advertisement createFromParcel(Parcel source) {
            return new Advertisement(source);
        }

        @Override
        public Advertisement[] newArray(int size) {
            return new Advertisement[size];
        }
    };
}
