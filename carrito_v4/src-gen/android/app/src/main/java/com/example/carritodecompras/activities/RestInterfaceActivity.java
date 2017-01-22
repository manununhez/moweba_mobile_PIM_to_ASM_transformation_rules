
package com.example.carritodecompras.activities;

//Start of user code imports
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.support.v7.app.ActionBar;
import android.view.MenuItem;

import com.example.carritodecompras.R;
import com.example.carritodecompras.conn.ApiClient;
import com.example.carritodecompras.conn.ApiInterface;


import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
//End of user code

public class RestInterfaceActivity extends AppCompatActivity {
    private TextView tvResults;
    private ApiInterface apiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restinterface);

		// Setting the toolbar title
		ActionBar actionBar = getSupportActionBar();
        if(actionBar != null) {
            actionBar.setTitle("RestInterface");
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        tvResults = (TextView) findViewById(R.id.tvResults);
        apiService = ApiClient.getClient().create(ApiInterface.class);

		Button btnLogin = (Button) findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login();
            }
        });

		Button btnLogout = (Button) findViewById(R.id.btnLogout);

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                logout();
            }
        });

		Button btnGetAllProducts = (Button) findViewById(R.id.btnGetAllProducts);

        btnGetAllProducts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getAllProducts();
            }
        });

		Button btnGetProduct = (Button) findViewById(R.id.btnGetProduct);

        btnGetProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getProduct();
            }
        });

		Button btnGetAllProviders = (Button) findViewById(R.id.btnGetAllProviders);

        btnGetAllProviders.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getAllProviders();
            }
        });

		Button btnGetProvider = (Button) findViewById(R.id.btnGetProvider);

        btnGetProvider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getProvider();
            }
        });

		Button btnCheckOut = (Button) findViewById(R.id.btnCheckOut);

        btnCheckOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkOut();
            }
        });

		Button btnGetUserCart = (Button) findViewById(R.id.btnGetUserCart);

        btnGetUserCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getUserCart();
            }
        });
        

    }

	private void login() {
		Toast.makeText(RestInterfaceActivity.this, "Completar login()", Toast.LENGTH_SHORT).show();
		
		/*
		 *  Complete this method to make the call to the corresponding service
		 */

       /* Call<Boolean> call = apiService.login();
        call.enqueue(new Callback<Boolean>() {
            @Override
            public void onResponse(Call<Boolean> call, Response<Boolean> response) {
                //TODO do something

            }

            @Override
            public void onFailure(Call<Boolean> call, Throwable t) {
                // Log error here since request failed
                Log.e("Rest", t.toString());
				//TODO do something
            }
        }); */
	}

	private void logout() {
		Toast.makeText(RestInterfaceActivity.this, "Completar logout()", Toast.LENGTH_SHORT).show();
		
		/*
		 *  Complete this method to make the call to the corresponding service
		 */

       /* Call<Boolean> call = apiService.logout();
        call.enqueue(new Callback<Boolean>() {
            @Override
            public void onResponse(Call<Boolean> call, Response<Boolean> response) {
                //TODO do something

            }

            @Override
            public void onFailure(Call<Boolean> call, Throwable t) {
                // Log error here since request failed
                Log.e("Rest", t.toString());
				//TODO do something
            }
        }); */
	}

	private void getAllProducts() {
		Toast.makeText(RestInterfaceActivity.this, "Completar getAllProducts()", Toast.LENGTH_SHORT).show();
		
		/*
		 *  Complete this method to make the call to the corresponding service
		 */

       /* Call<List<Product>> call = apiService.getAllProducts();
        call.enqueue(new Callback<List<Product>>() {
            @Override
            public void onResponse(Call<List<Product>> call, Response<List<Product>> response) {
                //TODO do something

            }

            @Override
            public void onFailure(Call<List<Product>> call, Throwable t) {
                // Log error here since request failed
                Log.e("Rest", t.toString());
				//TODO do something
            }
        }); */
	}

	private void getProduct() {
		Toast.makeText(RestInterfaceActivity.this, "Completar getProduct()", Toast.LENGTH_SHORT).show();
		
		/*
		 *  Complete this method to make the call to the corresponding service
		 */

       /* Call<Product> call = apiService.getProduct();
        call.enqueue(new Callback<Product>() {
            @Override
            public void onResponse(Call<Product> call, Response<Product> response) {
                //TODO do something

            }

            @Override
            public void onFailure(Call<Product> call, Throwable t) {
                // Log error here since request failed
                Log.e("Rest", t.toString());
				//TODO do something
            }
        }); */
	}

	private void getAllProviders() {
		Toast.makeText(RestInterfaceActivity.this, "Completar getAllProviders()", Toast.LENGTH_SHORT).show();
		
		/*
		 *  Complete this method to make the call to the corresponding service
		 */

       /* Call<List<Provider>> call = apiService.getAllProviders();
        call.enqueue(new Callback<List<Provider>>() {
            @Override
            public void onResponse(Call<List<Provider>> call, Response<List<Provider>> response) {
                //TODO do something

            }

            @Override
            public void onFailure(Call<List<Provider>> call, Throwable t) {
                // Log error here since request failed
                Log.e("Rest", t.toString());
				//TODO do something
            }
        }); */
	}

	private void getProvider() {
		Toast.makeText(RestInterfaceActivity.this, "Completar getProvider()", Toast.LENGTH_SHORT).show();
		
		/*
		 *  Complete this method to make the call to the corresponding service
		 */

       /* Call<Provider> call = apiService.getProvider();
        call.enqueue(new Callback<Provider>() {
            @Override
            public void onResponse(Call<Provider> call, Response<Provider> response) {
                //TODO do something

            }

            @Override
            public void onFailure(Call<Provider> call, Throwable t) {
                // Log error here since request failed
                Log.e("Rest", t.toString());
				//TODO do something
            }
        }); */
	}

	private void checkOut() {
		Toast.makeText(RestInterfaceActivity.this, "Completar checkOut()", Toast.LENGTH_SHORT).show();
		
		/*
		 *  Complete this method to make the call to the corresponding service
		 */

       /* Call<Boolean> call = apiService.checkOut();
        call.enqueue(new Callback<Boolean>() {
            @Override
            public void onResponse(Call<Boolean> call, Response<Boolean> response) {
                //TODO do something

            }

            @Override
            public void onFailure(Call<Boolean> call, Throwable t) {
                // Log error here since request failed
                Log.e("Rest", t.toString());
				//TODO do something
            }
        }); */
	}

	private void getUserCart() {
		Toast.makeText(RestInterfaceActivity.this, "Completar getUserCart()", Toast.LENGTH_SHORT).show();
		
		/*
		 *  Complete this method to make the call to the corresponding service
		 */

       /* Call<List<ShoppingCart>> call = apiService.getUserCart();
        call.enqueue(new Callback<List<ShoppingCart>>() {
            @Override
            public void onResponse(Call<List<ShoppingCart>> call, Response<List<ShoppingCart>> response) {
                //TODO do something

            }

            @Override
            public void onFailure(Call<List<ShoppingCart>> call, Throwable t) {
                // Log error here since request failed
                Log.e("Rest", t.toString());
				//TODO do something
            }
        }); */
	}

  	@Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);

    }
    
}
