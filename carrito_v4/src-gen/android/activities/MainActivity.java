
//Start of user code imports
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
//End of user code


public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


	

	
			Button btnRestInterface = (Button) findViewById(R.id.btnRestInterface);
			btnRestInterface.setOnClickListener(new View.OnClickListener() {
	            @Override
	            public void onClick(View view) {
	                startActivity(new Intent(MainActivity.this, RestInterfaceActivity.class));
	            }
	        });
			


			Button btnProduct = (Button) findViewById(R.id.btnProduct);
			btnProduct.setOnClickListener(new View.OnClickListener() {
	            @Override
	            public void onClick(View view) {
	                startActivity(new Intent(MainActivity.this, ProductActivity.class));
	            }
	        });

			Button btnShoppingCart = (Button) findViewById(R.id.btnShoppingCart);
			btnShoppingCart.setOnClickListener(new View.OnClickListener() {
	            @Override
	            public void onClick(View view) {
	                startActivity(new Intent(MainActivity.this, ShoppingCartActivity.class));
	            }
	        });

			Button btnUser = (Button) findViewById(R.id.btnUser);
			btnUser.setOnClickListener(new View.OnClickListener() {
	            @Override
	            public void onClick(View view) {
	                startActivity(new Intent(MainActivity.this, UserActivity.class));
	            }
	        });

			Button btnProvider = (Button) findViewById(R.id.btnProvider);
			btnProvider.setOnClickListener(new View.OnClickListener() {
	            @Override
	            public void onClick(View view) {
	                startActivity(new Intent(MainActivity.this, ProviderActivity.class));
	            }
	        });

			Button btnImageProduct = (Button) findViewById(R.id.btnImageProduct);
			btnImageProduct.setOnClickListener(new View.OnClickListener() {
	            @Override
	            public void onClick(View view) {
	                startActivity(new Intent(MainActivity.this, ImageProductActivity.class));
	            }
	        });
	

	
    }
}
