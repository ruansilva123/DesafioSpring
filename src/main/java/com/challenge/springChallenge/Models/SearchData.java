package com.challenge.springChallenge.Models;

import java.util.List;

public class SearchData {

    private int longitude;
    private int latitude;
    private String day;
    private String hour;
    private String[] times;
    private double[] hours;

    public int getLongitude() {
        return longitude;
    }

    public void setLongitude(int longitude) {
        this.longitude = longitude;
    }

    public int getLatitude() {
        return latitude;
    }

    public void setLatitude(int latitude) {
        this.latitude = latitude;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public String[] getTimes() {
        return times;
    }

    public void setTimes(String[] times) {
        this.times = times;
    }

    public double[] getHours() {
        return hours;
    }

    public void setHours(double[] hours) {
        this.hours = hours;
    }

    public SearchData(int longitude, int latitude, String day, String hour, String[] times, double[] hours) {
        this.longitude = longitude;
        this.latitude = latitude;
        this.day = day;
        this.hour = hour;
        this.times = times;
        this.hours = hours;
    }
}
