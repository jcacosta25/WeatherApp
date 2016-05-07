package com.weather.raulizq.weatherapp;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;


import com.weather.raulizq.weatherapp.io.Data;
import com.weather.raulizq.weatherapp.model.ServiceGenerator;

import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInput;
import java.net.HttpURLConnection;
import java.net.URL;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /*if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }*/
        setContentView(R.layout.activity_main);
        final TextView text = (TextView) findViewById(R.id.mylabel);

        //Call<Data> call = ServiceGenerator.getApiService().getData("1ad7df190e16fac7c4816134f47f28f0","London","UK");
        Call<Data> call = ServiceGenerator.getApiService().getData();
        call.enqueue(new Callback<Data>() {
            @Override
            public void onResponse(Response<Data> response) {
                //Log.e("onResponse: ", response.body().getName());
                text.setText(response.body().getName());
            }

            @Override
            public void onFailure(Throwable t) {

            }
        });

        //new NetworkTask(this).execute();
        //System.out.println(texto);
        //TextView label = (TextView)this.findViewById(R.id.mylabel);
        //label.setText(texto);
    }
}

class NetworkTask extends AsyncTask<AppCompatActivity, Integer, String> {

    AppCompatActivity layout;

    public NetworkTask(AppCompatActivity layout){
        this.layout = layout;
    }

    protected String doInBackground(AppCompatActivity... urls) {
        String strFileContents = "";
        StringBuffer buffer = new StringBuffer();
        try{
            URL url = new URL("http://api.openweathermap.org/data/2.5/weather?appid=1ad7df190e16fac7c4816134f47f28f0&q=monterrey,mx");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            InputStream in = new BufferedInputStream(conn.getInputStream());
            /*byte[] contents = new byte[1024];
            //System.out.println("CONTENT:"+in.read(contents));
            int bytesRead=0;
            layout = urls[0];
            while( (bytesRead = in.read(contents)) != -1){
                strFileContents = new String(contents, 0, bytesRead);
            }*/
            InputStream is = conn.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String line = null;
            while ( (line = br.readLine()) != null )
                buffer.append(line + "rn");

            is.close();
            conn.disconnect();
        }catch(Exception e){
            System.out.println(e.toString());
        }
        System.out.println(buffer.toString());
        //return strFileContents;
        return buffer.toString();
    }

    protected void onProgressUpdate(Integer... progress) {
        //setProgressPercent(progress[0]);
    }

    protected void onPostExecute(String result) {
        TextView text = (TextView)layout.findViewById(R.id.mylabel);
        text.setText(result);
        try {
            JSONObject reqJson = new JSONObject(result);
            System.out.println(((JSONObject) reqJson.get("coord")).get("lon"));
        }catch (Exception e){
            System.out.println(e);
        }

    }
}


