package testing.api;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;
import testing.api.model.WeatherResponse;

import java.util.Map;

public interface WeatherApi {
    @GET("weather")
    Call<WeatherResponse> getWeather(@QueryMap Map<String, String> options);

    /// more endpoints
}



