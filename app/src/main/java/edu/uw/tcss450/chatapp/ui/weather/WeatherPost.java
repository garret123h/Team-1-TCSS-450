package edu.uw.tcss450.chatapp.ui.weather;


public class WeatherPost {
    private final String mTime;
    private final String mCity;
    private final String mTemperature;
    private final String mCondition;
    private final String mMinTemperature;
    private final String mMaxTemperature;
    private final String mDate;


    WeatherPost(String time, String temperature, String city, String condition, String minTemp, String maxTemp, String date) {
        this.mCity = city;
        this.mTemperature = temperature;
        this.mCondition = condition;
        this.mTime = time;
        this.mMinTemperature = minTemp;
        this.mMaxTemperature = maxTemp;
        this.mDate = date;


    }


    public String getmCity() {
        return mCity;
    }

    public String getmDate() {
        return mDate;
    }

    public String getmTemperature() {
        return mTemperature;
    }


    public String getmCondition() {
        return mCondition;
    }

    public String getmTime() {
        return mTime;
    }

    public String getmMinTemperature() {
        return mMinTemperature;
    }

    public String getmMaxTemperature() {
        return mMaxTemperature;
    }
}
