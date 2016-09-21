package com.example.abetare.thoutside;

import android.os.Parcel;
import android.os.Parcelable;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 * Created by Abetare on 9/19/2016.
 */
public class Hours implements Parcelable {
    private long mTime;
    private String mSummary;
    private double mTemperature;
    private String mIcon;
    private String mTimezone;

    public Hours() {
    }

    public long getTime() {
        return mTime;
    }

    public void setTime(long time) {
        mTime = time;
    }

    public String getTimeAsHour() {
        SimpleDateFormat formatter = new SimpleDateFormat("h a");
        formatter.setTimeZone(TimeZone.getTimeZone(mTimezone));
        Date dateTime = new Date(mTime * 1000);
        return formatter.format(dateTime);

    }

    public String getSummary() {
        return mSummary;
    }
    public void setSummary(String summary) {
        mSummary = summary;
    }
    public int getTemperature() {
        return (int) Math.round(mTemperature);
    }

    public void setTemperature(double temperature) {
        mTemperature = temperature;
    }
    public String getIcon() {
        return mIcon;
    }
    public int getIconId() {
        return Forecast.getIconId(mIcon);
    }
    public void setIcon(String icon) {
        mIcon = icon;
    }
    public String getTimezone() {
        return mTimezone;
    }
    public void setTimezone(String timezone) {
        mTimezone = timezone;
    }

    @Override
    public int describeContents() {
        return 0;
    }
    //e konverton string icon ne int per drawable edhe e rrumbullakson temperaturen
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(mTime);
        dest.writeString(mSummary);
        dest.writeDouble(mTemperature);
        dest.writeString(mIcon);
        dest.writeString(mTimezone);

    }
    //e krijon kohen si vetem ore
    private Hours(Parcel in) {
        mTime = in.readLong();
        mSummary = in.readString();
        mTemperature = in.readDouble();
        mIcon = in.readString();
        mTimezone = in.readString();
    }

    public static final Parcelable.Creator<Hours> CREATOR = new Parcelable.Creator<Hours>() {
        @Override
        public Hours createFromParcel(Parcel source) {
            return new Hours(source);
        }

        @Override
        public Hours[] newArray(int size) {
            return new Hours[size];
        }
    };
}
