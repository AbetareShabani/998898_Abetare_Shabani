# 998898_Abetare_Shabani
AndroidApp

INTRODUCTION

TheOutside project is an android application programmed in java language. It is an application which shows you the weather cast during the day and also during the week, Google play Services[10] and also the Forecast weather API[2].
This application consists 4 activities[9][11]. The location is sent to ForecastWeather API [8] [3]through the web based on the coordinates of the users’ phone (latitude and longtitude). All this information is stored in the database every time that a user uses this app like, location of user including here city, state, temperature, humidity and pressure. TheOutside gets the current weather condition from Forecast.io [7].
   
   BACKGROUND

Main Activity of this app is basically an activity which has around 8 textViews 2 linear layout and 2 buttons.In the main activity is showed the current location the temperature,humidity and the pressure but so far TheOutside app does not automatically detect the location so we have to hard code the location through  the latitude and longtitude attributes . But in the other side, it gets the data from Forecast.io [1] after we make a request throughout OkHttpClient[4], the reason of using OkHttpClient is the loading which is made fater and the support of synchorinized blocking calls and async calls.The second actitivity is the daily_forecast which shows the data from forecast, to be more specific it displays the temperature of days during a whole week of that location. Continuing, the third activity displays the hourly weather data, which means weather data of one day during rounded hours. In the daily activity after the request in forecast is done we get a JSON format data so that is saved in a JSON object which is parsed later[2], the same is done for the hourly activity. Before getting the data from the forecast the app checks if the request failed or not through an interface which is kind of an error handling[4]. TheOutside app remains the method onResume and onPause which means it will be running in the background as long as we do not stop the app[5]. It also stores the data through SQLiteDatabase[6] so the user does not have to set the location everytime that uses the app but like I mentioned above this app does not automatically detect location so we have to set location manually in the database beside this in the app. In TheOutside Parcel[5][6]l is used too so the class could be reconstructed from the appropriate class when later reading. However, the app is not finished yet, it need some new features and also the error that are going to be mention below to be finished by the end of the week.

   REQUIRMENT

The reasons why the app can not run is the error NullPointerException which I tried to get the idea where is coming from I tested it and it actually is null but even after instantiated it will be giving the same error as before, the attribute that sends the app to crash is the temperature sensor.


THE FUTURE OF THEOUTSIDE APP

A weather app is an app that we use every single day and knowing how the weather is going to be and change makes our living much easier but beside that this app can become an app which gives you weather alerts for every update in the weather data these alerts can be displayed also in the notification bar so you do not have to go through the entire app again, since the main goals of most of software’s is less click or if the notification would be a disturb for someone than create multiple widget option so you can see your forecast from your homescreen. 
Why not adding some other features like animated radar maps, where beside forecast you would be able to see also the storm, earthquakes. 
 

PERSONAL EXPERIENCE

Based on my experience in android development, developing this app in the beginning seemed pretty hard but coding at the end was not the hardest thing that needs to be mentioned. Implementing the API, Google paly Services and get to know them and how to use them was hard for me eventhough while getting into it, got much easier. Also, for 3 weeks from now I did not have a phone at all so I could not test my application in a physical device so all I did was testing in the virtual devices and sometimes the location that I tried to do it would not work but still I got to learn a lot of things during this working period like handling API, SQLite, Forecast, JSON parsing, asynchronous tasks, reading from a parcel, etc. . 


   REFERENCES:
   
[1] http://www.survivingwithandroid.com/2013/08/android-app-development-weather-app.html - Weather App develop

[2]  http://stackoverflow.com/questions/2591098/how-to-parse-json-in-java - Parse JSON

[3] http://www.survivingwithandroid.com/2013/08/android-app-development-weather-app.html  - Forecast weather app development

[4] http://square.github.io/okhttp/  - OkHttpClient

[5] https://developer.android.com/reference/android/os/Parcel.html - Parcel Android

[6] http://stackoverflow.com/questions/1626667/how-to-use-parcel-in-android - Use of Parcel

[7] http://forecast.io/#/f/60.8000,10.7000 – Forecast web page

[8] https://darksky.net/dev/ - Forecast API 

[9] https://teamtreehouse.com/library/android-studio-features - Tutorial on Developing a weather app

[10] https://developers.google.com/android/guides/setup - Google Play Services

[11] https://developer.android.com/training/basics/activity-lifecycle/index.html - Android Development web page


