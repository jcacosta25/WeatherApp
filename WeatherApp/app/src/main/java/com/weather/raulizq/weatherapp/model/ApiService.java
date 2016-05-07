package com.weather.raulizq.weatherapp.model;

import com.weather.raulizq.weatherapp.io.Data;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Juan C. Acosta on 5/7/2016.
 * juan.acosta@gmail.com
 */
public interface ApiService {
    //http://api.openweathermap.org/data/2.5/weather?appid=1ad7df190e16fac7c4816134f47f28f0&q=monterrey,mx
    //monterrey,mx&appid=5f41d5c4673172e37658a56d6877e712
    //@GET("weather/{appid}&q={city},{country}/")
    //Call<Data> getData(@Path("appid") String appid,@Path("city") String city, @Path("country") String country);
    //api.openweathermap.org/data/2.5/forecast?q=London,us&mode=xml
    @GET("weather")
    Call<Data> getData();
}
