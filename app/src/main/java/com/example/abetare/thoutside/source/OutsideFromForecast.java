package com.example.abetare.thoutside.source;

import com.example.abetare.thoutside.CurrentCon;
import com.example.abetare.thoutside.Day;
import com.example.abetare.thoutside.Forecast;
import com.example.abetare.thoutside.Hours;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Abetare on 9/19/2016.
 */
public class OutsideFromForecast extends OutsideSource{
  //  public class WeatherFromForecastIO extends WeatherSource {
//    public static final String TAG = WeatherFromForecastIO.class.getSimpleName();

        public OutsideFromForecast(OutsideSourceCallback callback) {
            super(callback);
        }

        @Override
        protected String getForecastUrl(double latitude, double longitude) {
            String ApiKey="8f91ff232b54367189c5798debe4943e";
            return "https://api.forecast.io/forecast/" + ApiKey +
                    "/" + latitude + "," + longitude +
                    "?exclude=minutely&units=auto";
        }

        @Override
        protected Forecast parseForecastDetails(String forecastData) throws OutsideSourceException {
            Forecast forecast = new Forecast();

            try {
                forecast.setCurrent(getCurrentDetails(forecastData));
                forecast.setHourlyForecast(getHourlyForecast(forecastData));
                forecast.setDailyForecast(getDailyForecast(forecastData));
            } catch (JSONException e) {
                throw new OutsideSourceException(e);
            }

            return forecast;
        }
        protected Day[] getDailyForecast(String jsonData) throws JSONException {
            JSONObject forecast = new JSONObject(jsonData);
            String timezone = forecast.getString("timezone");
            JSONObject daily = forecast.getJSONObject("daily");
            JSONArray data = daily.getJSONArray("data");

            Day[] days = new Day[data.length()];
            for (int i = 0; i < data.length(); i++) {
                JSONObject jsonDay = data.getJSONObject(i);
                Day day = new Day();
                day.setSummary(jsonDay.getString("summary"));
                day.setTime(jsonDay.getLong("time"));
                day.setIcon(jsonDay.getString("icon"));
                day.setTemperatureMax(jsonDay.getDouble("temperatureMax"));
                day.setTimezone(timezone);

                days[i] = day;
            }
            return days;
        }

        protected Hours[] getHourlyForecast(String jsonData) throws JSONException {
            JSONObject forecast = new JSONObject(jsonData);
            String timezone = forecast.getString("timezone");
            JSONObject hourly = forecast.getJSONObject("hourly");
            JSONArray data = hourly.getJSONArray("data");

            Hours[] hours = new Hours[data.length()];
            for (int i = 0; i < data.length(); i++) {
                JSONObject jsonHour = data.getJSONObject(i);
                Hours hour = new Hours();
                hour.setSummary(jsonHour.getString("summary"));
                hour.setTime(jsonHour.getLong("time"));
                hour.setIcon(jsonHour.getString("icon"));
                hour.setTemperature(jsonHour.getDouble("temperature"));
                hour.setTimezone(timezone);

                hours[i] = hour;
            }
            return hours;
        }


        protected CurrentCon getCurrentDetails(String jsonData) throws JSONException {
            JSONObject forecast = new JSONObject(jsonData);
            String timezone = forecast.getString("timezone");

            JSONObject currently = forecast.getJSONObject("currently");
            CurrentCon current = new CurrentCon();
            current.setHumidity(currently.getDouble("humidity"));
            current.setTime(currently.getLong("time"));
            current.setIcon(currently.getString("icon"));
            current.setPrecipChance(currently.getDouble("precipProbability"));
            current.setSummary(currently.getString("summary"));
            current.setTemperature(currently.getDouble("temperature"));
            current.setTimeZone(timezone);

            return current;
        }

}
