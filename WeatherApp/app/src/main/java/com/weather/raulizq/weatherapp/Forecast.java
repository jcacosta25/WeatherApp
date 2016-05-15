package com.weather.raulizq.weatherapp;

/**
 * Created by Juan C. Acosta on 5/15/2016.
 * bbxmstudios
 * juan.acosta@bbxmstudios.com
 */
public class Forecast {
    private String imagen;
    private String temp;

    public Forecast(String imagen, String temp) {
        this.imagen = "http://openweathermap.org/img/w/"+imagen+".png";
        this.temp = temp;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }
}
