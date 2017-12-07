package com.allie.templateapplication.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by acaldwell on 9/20/17.
 */

//model item for your employees - hint: setters & getters
public class Employee implements Parcelable {

    String mName;
    String mRole;
    String mTitle;
    String mTasks;
    String mDate;
    String mPosition;

    public String getDate() {
        return mDate;
    }

    public void setDate(String date) {
        this.mDate = date;
    }

    public String getPosition() {
        return mPosition;
    }

    public void setPosition(String position) {
        this.mPosition = position;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        this.mName = name;
    }

    public String getRole() {
        return mRole;
    }

    public void setRole(String role) {
        this.mRole = role;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        this.mTitle = title;
    }

    public String getTasks() {
        return mTasks;
    }

    public void setTasks(String tasks) {
        this.mTasks = tasks;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.mName);
        dest.writeString(this.mRole);
        dest.writeString(this.mTitle);
        dest.writeString(this.mTasks);
        dest.writeString(this.mDate);
        dest.writeString(this.mPosition);
    }

    public Employee() {
    }

    protected Employee(Parcel in) {
        this.mName = in.readString();
        this.mRole = in.readString();
        this.mTitle = in.readString();
        this.mTasks = in.readString();
        this.mDate = in.readString();
        this.mPosition = in.readString();
    }

    public static final Parcelable.Creator<Employee> CREATOR = new Parcelable.Creator<Employee>() {
        @Override
        public Employee createFromParcel(Parcel source) {
            return new Employee(source);
        }

        @Override
        public Employee[] newArray(int size) {
            return new Employee[size];
        }
    };


}
