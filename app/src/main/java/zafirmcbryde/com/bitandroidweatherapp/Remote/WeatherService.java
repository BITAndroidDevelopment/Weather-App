package zafirmcbryde.com.bitandroidweatherapp.Remote;


import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import zafirmcbryde.com.bitandroidweatherapp.Model.Main;

public interface WeatherService
{
    @GET("/data/2.5/weather")
    Call<List<Main>> getWeather(@Query("q") String cityName,
                                @Query("APPID") String appId);
}
