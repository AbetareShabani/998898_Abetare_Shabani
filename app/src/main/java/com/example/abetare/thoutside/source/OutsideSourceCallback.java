package com.example.abetare.thoutside.source;

import com.example.abetare.thoutside.Forecast;

/**
 * Created by Abetare on 9/19/2016.
 */
public interface OutsideSourceCallback {

    void onSuccess(Forecast forecast);

    /**
     *  Called if we weren't able to retrieve the weather forecast for whatever reason.
     */
    void onFailure(Exception e);
}
