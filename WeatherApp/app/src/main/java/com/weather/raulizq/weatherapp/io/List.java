package com.weather.raulizq.weatherapp.io;

import java.util.ArrayList;

/**
 * Created by Juan C. Acosta on 5/14/2016.
 * bbxmstudios
 * juan.acosta@bbxmstudios.com
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
}
