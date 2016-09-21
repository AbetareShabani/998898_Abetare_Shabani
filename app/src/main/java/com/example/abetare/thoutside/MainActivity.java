package com.example.abetare.thoutside;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity {
    private TextView temperaturelabel;
    private SensorManager sensormanager;
    private Sensor temperature;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        temperaturelabel = (TextView) findViewById(R.id.text);
        sensormanager = (SensorManager)getSystemService(SENSOR_SERVICE);
        temperature= sensormanager.getDefaultSensor(Sensor.TYPE_AMBIENT_TEMPERATURE);
        if(temperature == null){
            Log.d("MAIN", "teMP is null");
        }
        if(temperaturelabel == null){
            Log.d("MAIN", "temp lable is null");
        }
        temperaturelabel.setText(""+temperature.getPower());
    }
    protected void onResume() {
        super.onResume();
        sensormanager.registerListener((SensorEventListener) this, temperature, SensorManager.SENSOR_DELAY_FASTEST);
    }

    protected void onPause() {
        super.onPause();
        sensormanager.unregisterListener((SensorEventListener) this);
    }

    public void onAccuracyChanged(Sensor sensor, int accuracy) {}
    public void onSensorChanged(SensorEvent event) {
        if (event.sensor.getType() != Sensor.TYPE_AMBIENT_TEMPERATURE) return;

        temperaturelabel.setText(""+temperature.getPower());
    }
}
