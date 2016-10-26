
//Start of user code imports
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
//End of user code

public class ApiClient {
    public static final String BASE_URL = "http://www.api2.cart.com.py";
    private static Retrofit retrofit = null;


    public static Retrofit getClient() {
        if (retrofit==null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}

