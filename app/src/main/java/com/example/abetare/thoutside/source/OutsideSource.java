package com.example.abetare.thoutside.source;

import android.app.DownloadManager;
import android.telecom.Call;

import java.io.IOException;

import com.example.abetare.thoutside.Forecast;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

/**
 * Created by Abetare on 9/19/2016.
 */
public abstract class OutsideSource {

    protected final OutsideSourceCallback mCallback;

    public OutsideSource(OutsideSourceCallback callback) {
        mCallback = callback;
    }

   //i merr forecast
    public void getForecast(double latitude, double longitude) {
        String forecastUrl = getForecastUrl(latitude, longitude);

        OkHttpClient client = new OkHttpClient();
        Request request;
        request = new Request.Builder()
                .url(forecastUrl).build();
        com.squareup.okhttp.Call call;
        call = client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {
                mCallback.onFailure(e);
            }

            @Override
            public void onResponse(Response response) throws IOException {
                try {
                    String forecastData = response.body().string();
                    if (response.isSuccessful()) {
                        Forecast forecast = parseForecastDetails(forecastData);
                        mCallback.onSuccess(forecast);
                    } else {
                        mCallback.onFailure(new OutsideSourceException("Request from forecast service was not successful."));
                    }
                } catch (IOException | OutsideSourceException e) {
                    mCallback.onFailure(e);
                }
            }
        });
    }

    //e nderton te dhenat e marra nga forecast
    protected abstract Forecast parseForecastDetails(String forecastData) throws OutsideSourceException;

    //e nderton url bashk me kordinatat latitude edhe longtitude
    protected abstract String getForecastUrl(double latitude, double longitude);
}
