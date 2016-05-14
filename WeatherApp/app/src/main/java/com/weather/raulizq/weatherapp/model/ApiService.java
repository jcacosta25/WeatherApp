package com.weather.raulizq.weatherapp.model;

import com.weather.raulizq.weatherapp.io.Data;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Juan C. Acosta on 5/7/2016.
 * juan.acosta@gmail.com
 */
public interface ApiService {
    //http://api.openweathermap.org/data/2.5/weather?appid=1ad7df190e16fac7c4816134f47f28f0&q=monterrey,mx
    @GET("weather")
    Call<Data> getCurrentWeather(@Query("appid") String appid, @Query("q") String city);

    @GET("forecast")
    Call<Data> getForecast(@Query("appid") String appid, @Query("q") String city,@Query("units") String unit);
}
