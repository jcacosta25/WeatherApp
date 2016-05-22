package com.weather.raulizq.weatherapp.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.weather.raulizq.weatherapp.MainActivity;
import com.weather.raulizq.weatherapp.R;
import com.weather.raulizq.weatherapp.io.Data;
import com.weather.raulizq.weatherapp.model.ServiceGenerator;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Juan C. Acosta on 5/14/2016.
 * bbxmstudios
 * juan.acosta@bbxmstudios.com
 */
public class CurrentFragment extends Fragment {

    TextView city,pressure,humidity,wind1,wind2;
    ImageView condition;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.tab_fragment, container, false);
        city = (TextView) view.findViewById(R.id.cityText);
        pressure = (TextView) view.findViewById(R.id.press);
        humidity = (TextView) view.findViewById(R.id.hum);
        wind1 = (TextView) view.findViewById(R.id.windDeg);
        wind2 = (TextView) view.findViewById(R.id.windSpeed);
        condition = (ImageView) view.findViewById(R.id.condIcon);
        request("Tijuana","MX");
        return view;
    }

    public void request(String ciudad, String country){
        String p = ciudad+","+country;
        Call<Data> call = ServiceGenerator.getApiService().getCurrentWeather(MainActivity.APPID,p);
        //Call<Data> call = ServiceGenerator.getApiService().getData();
        call.enqueue(new Callback<Data>() {
            @Override
            public void onResponse(Response<Data> response) {
                //Log.e("onResponse: ", String.valueOf(response.body().getName()));
                city.setText(response.body().getName());
                pressure.setText(String.valueOf(response.body().getMain().getPressure()));
                humidity.setText(String.valueOf(response.body().getMain().getHumidity()));
                wind1.setText(String.valueOf(response.body().getWind().getSpeed()));
                wind2.setText(String.valueOf(response.body().getWind().getDeg()));
                Glide.with(getActivity()).load("http://openweathermap.org/img/w/"
                        +response.body().getWeather().get(0).getIcon()+".png")
                        .into(condition);

                //text.setText(response.body().getWeather().get(0).getDescription());
            }

            @Override
            public void onFailure(Throwable t) {

            }
        });
    }

    public void location(double lat, double lon){
        Call<Data> call = ServiceGenerator.getApiService().getCurentLocationWeather(MainActivity.APPID,lat,lon);
    }
}