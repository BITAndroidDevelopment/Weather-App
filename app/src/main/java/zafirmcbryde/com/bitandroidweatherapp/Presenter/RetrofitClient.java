package zafirmcbryde.com.bitandroidweatherapp.Presenter;


import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import zafirmcbryde.com.bitandroidweatherapp.Service.WeatherService;

public class RetrofitClient
{
    private static Retrofit sRetrofit = null;
    private static final String BASE_URL = "http://api.openweathermap.org/data/2.5/";

    public static Retrofit getClient(String baseUrl)
    {
        if(sRetrofit == null)
        {
            sRetrofit = new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return sRetrofit;
    }

    public static WeatherService getWeatherService()
    {
        return RetrofitClient.getClient(BASE_URL).create(WeatherService.class);
    }
}
