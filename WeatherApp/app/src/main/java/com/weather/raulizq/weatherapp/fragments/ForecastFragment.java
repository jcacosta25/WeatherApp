package com.weather.raulizq.weatherapp.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.weather.raulizq.weatherapp.Forecast;
import com.weather.raulizq.weatherapp.ForecastAdapter;
import com.weather.raulizq.weatherapp.MainActivity;
import com.weather.raulizq.weatherapp.R;
import com.weather.raulizq.weatherapp.io.Data;
import com.weather.raulizq.weatherapp.model.ServiceGenerator;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Juan C. Acosta on 5/14/2016.
 * juank2acosta@gmail.com
 */
public class ForecastFragment extends Fragment {

    private RecyclerView recycler;
    private List items;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager lManager;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.multiple_fragment, container, false);
        items = new ArrayList();
        recycler = (RecyclerView) view.findViewById(R.id.recycler_vew);
        recycler.setHasFixedSize(true);
        lManager = new LinearLayoutManager(getActivity());
        recycler.setLayoutManager(lManager);

        request();


        return view;
    }
    public void request(){
        Call<Data> call = ServiceGenerator.getApiService().getForecast(MainActivity.APPID,"Monterrey,mx","metric");

        call.enqueue(new Callback<Data>() {
            @Override
            public void onResponse(Response<Data> response) {
                for (int i = 0; i < response.body().getList().size() ; i++) {
                    items.add(new Forecast(response.body().getList().get(i).getWeather().get(0).getIcon(),String.valueOf(response.body().getList().get(i).getMain().getTemp())));
                }
                adapter = new ForecastAdapter(items,getContext());
                recycler.setAdapter(adapter);
                //text.setText(response.body().getWeather().get(0).getDescription());
            }

            @Override
            public void onFailure(Throwable t) {

            }
        });
    }
}
