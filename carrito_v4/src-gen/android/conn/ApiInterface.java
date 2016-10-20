
//Start of user code imports
import java.util.List;

import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.PUT;
//End of user code

public interface ApiInterface {
	@POST("login")
	Call<Boolean> login( User user );

	@POST("logout")
	Call<Boolean> logout();

	@GET("products")
	Call<List<Product>> getAllProducts();

	@GET("products/{id}")
	Call<Product> getProduct( Integer id );

	@GET("provider")
	Call<List<Provider>> getAllProviders();

	@GET("provider/{id}")
	Call<Provider> getProvider( Integer id );

	@POST("cart/confirm")
	Call<Boolean> confirmCart( Product products );

	@GET("cart")
	Call<List<ShoppingCart>> getUserCart();
}
