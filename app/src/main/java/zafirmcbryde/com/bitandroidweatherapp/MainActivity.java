package zafirmcbryde.com.bitandroidweatherapp;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import zafirmcbryde.com.bitandroidweatherapp.Model.Main;
import zafirmcbryde.com.bitandroidweatherapp.Presenter.RetrofitClient;
import zafirmcbryde.com.bitandroidweatherapp.Service.WeatherService;

public class MainActivity extends AppCompatActivity
{
    public String TAG = MainActivity.class.getSimpleName();
    public TextView temp, location;
    public WeatherService mWeatherService;
    private final String API_KEY = "81b225a4532ccc354f24b935262a2e54";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        temp = findViewById(R.id.location_temp);
        location = findViewById(R.id.location_name);

        mWeatherService = RetrofitClient.getWeatherService();
        mWeatherService.getWeather("Pittsburgh", API_KEY).enqueue(new Callback<List<Main>>()
        {
            @SuppressLint("SetTextI18n")
            @Override
            public void onResponse(Call<List<Main>> call, Response<List<Main>> response)
            {
                Log.d(TAG, "Response + " + response.code());


                List<Main> main = response.body();
                for (Main m : main)
                    temp.setText(m.getTemp().toString());
            }

            @Override
            public void onFailure(Call<List<Main>> call, Throwable t)
            {
                location.setText("Pittsburgh");
            }
        });
    }
}
