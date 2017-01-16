
package com.example.carritodecompras.conn;

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

	@GET("products")
	Call<Product> getProduct();

	@GET("provider")
	Call<List<Provider>> getAllProviders();

	@GET("provider")
	Call<Provider> getProvider();

	@POST("cart/confirm")
	Call<Boolean> checkOut( Product products );

	@GET("cart")
	Call<List<ShoppingCart>> getUserCart();
}
