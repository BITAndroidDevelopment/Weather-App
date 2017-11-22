package zafirmcbryde.com.bitandroidweatherapp.Service;


import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import zafirmcbryde.com.bitandroidweatherapp.Model.Main;

public interface WeatherService
{
    @GET("weather?")
    Call<List<Main>> getWeather(@Query("q") String cityName,
                                @Query("APPID") String appId);
}
