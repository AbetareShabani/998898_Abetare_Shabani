package com.example.abetare.thoutside;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by Abetare on 9/19/2016.
 */
public class DailyForecast extends Activity {

    private Day[] mDays;
    @InjectView(android.R.id.list)
    ListView mListView;
    @InjectView(android.R.id.empty)
    TextView mEmptyTextView;
    @InjectView(R.id.locationLabel) TextView mLocationLabel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily_forecast);
        ButterKnife.inject(this);

        Intent intent = getIntent();
        String locationName = intent.getStringExtra(MainActivity.LOCATION_SERVICE);
        mLocationLabel.setText(locationName);
        Parcelable[] parcelables = intent.getParcelableArrayExtra(MainActivity.SENSOR_SERVICE);
        mDays = Arrays.copyOf(parcelables, parcelables.length, Day[].class);

        DayCreate adapter = new DayCreate(this, mDays);
        mListView.setAdapter(adapter);
        mListView.setEmptyView(mEmptyTextView);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String dayOfTheWeek = mDays[position].getDayOfTheWeek();
                String conditions = mDays[position].getSummary();
                String highTemp = mDays[position].getTemperatureMax() + "";
                String message = String.format("On %s the high will be %s and it will be %s",
                        dayOfTheWeek, highTemp, conditions);

                Toast.makeText(DailyForecast.this, message, Toast.LENGTH_LONG).show();
            }
        });

    }
}
