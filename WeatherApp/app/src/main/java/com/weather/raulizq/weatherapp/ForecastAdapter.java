package com.weather.raulizq.weatherapp;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by Juan C. Acosta on 5/15/2016.
 * bbxmstudios
 * juan.acosta@bbxmstudios.com
 */
public class ForecastAdapter extends RecyclerView.Adapter<ForecastAdapter.ForecastViewHolder> {
    private List<Forecast> items;
    private Context context;

    public static class ForecastViewHolder extends RecyclerView.ViewHolder {
        // Campos respectivos de un item
        public ImageView imagen;
        public TextView temp;

        public ForecastViewHolder(View v) {
            super(v);
            imagen = (ImageView) v.findViewById(R.id.cond_icon);
            temp = (TextView) v.findViewById(R.id.temperature);
        }
    }

    public ForecastAdapter(List<Forecast> items,Context context) {
        this.items = items;
        this.context = context;
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    @Override
    public ForecastViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.forecast_layout, viewGroup, false);
        return new ForecastViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ForecastViewHolder viewHolder, int i) {
        Glide.with(context).load(items.get(i).getImagen()).into(viewHolder.imagen);
        viewHolder.temp.setText(items.get(i).getTemp());

    }
}
