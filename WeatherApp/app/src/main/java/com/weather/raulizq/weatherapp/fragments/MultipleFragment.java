package com.weather.raulizq.weatherapp.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.weather.raulizq.weatherapp.R;

/**
 * Created by Juan C. Acosta on 5/14/2016.
 * bbxmstudios
 * juan.acosta@bbxmstudios.com
 */
public class MultipleFragment extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.multiple_fragment, container, false);
        return view;
    }
}
