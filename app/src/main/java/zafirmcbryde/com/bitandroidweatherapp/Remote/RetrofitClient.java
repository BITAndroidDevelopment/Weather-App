package zafirmcbryde.com.bitandroidweatherapp.Remote;


import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient
{
    private static Retrofit sRetrofit = null;
    private static final String BASE_URL = "http://api.openweathermap.org/";

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
