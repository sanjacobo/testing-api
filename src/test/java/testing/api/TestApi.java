package testing.api;

import org.junit.jupiter.api.Test;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import testing.api.model.WeatherResponse;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


public class TestApi {

    @Test
    public void test() throws IOException {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.openweathermap.org/data/2.5/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();


        WeatherApi weatherApi = retrofit.create(WeatherApi.class);

        Map<String, String> params = new HashMap<String, String>();
        params.put("q", "London");
        params.put("APPID", "1ddb5bd18d803d606e16b08bd375fa1f");

        Call<WeatherResponse> weatherCall = weatherApi.getWeather(params);

        Response<WeatherResponse> response = weatherCall.execute();

        assertThat("Call is Successful", response.isSuccessful(), equalTo(true));

        assertThat("Location Name", response.body().getName(), equalTo("London"));

    }

}
