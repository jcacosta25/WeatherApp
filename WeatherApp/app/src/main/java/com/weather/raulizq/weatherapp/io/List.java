package com.weather.raulizq.weatherapp.io;

import java.util.ArrayList;

/**
 * Created by Juan C. Acosta on 5/14/2016.
 * juank2acosta@gmail.com
 */
public class List {
    private Integer dt;
    private Main main;
    private java.util.List<Weather> weather = new ArrayList<Weather>();
    private Clouds clouds;
    private Wind wind;
    private Rain rain;
    private Sys_ sys;
    private String dtTxt;

    public Integer getDt() {
        return dt;
    }

    public void setDt(Integer dt) {
        this.dt = dt;
    }

    public Main getMain() {
        return main;
    }

    public void setMain(Main main) {
        this.main = main;
    }

    public java.util.List<Weather> getWeather() {
        return weather;
    }

    public void setWeather(java.util.List<Weather> weather) {
        this.weather = weather;
    }

    public Clouds getClouds() {
        return clouds;
    }

    public void setClouds(Clouds clouds) {
        this.clouds = clouds;
    }

    public Wind getWind() {
        return wind;
    }

    public void setWind(Wind wind) {
        this.wind = wind;
    }

    public Rain getRain() {
        return rain;
    }

    public void setRain(Rain rain) {
        this.rain = rain;
    }

    public Sys_ getSys() {
        return sys;
    }

    public void setSys(Sys_ sys) {
        this.sys = sys;
    }

    public String getDtTxt() {
        return dtTxt;
    }

    public void setDtTxt(String dtTxt) {
        this.dtTxt = dtTxt;
    }
}
