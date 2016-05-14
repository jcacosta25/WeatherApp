package com.weather.raulizq.weatherapp.model;

import retrofit2.GsonConverterFactory;
import retrofit2.Retrofit;

/**
 * Created by Juan C. Acosta on 5/7/2016.
 * juank2acosta@gmail.com
 */
public class ServiceGenerator {
    //private static final String BASE_URL = "http://demo2762479.mockable.io/";
    private static final String BASE_URL = "http://api.openweathermap.org/data/2.5/";
    private static ApiService API_SERVICE;

        public static ApiService getApiService(){
            if(API_SERVICE == null){
                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl(BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                API_SERVICE = retrofit.create(ApiService.class);
            }
            return API_SERVICE;
        }
}
