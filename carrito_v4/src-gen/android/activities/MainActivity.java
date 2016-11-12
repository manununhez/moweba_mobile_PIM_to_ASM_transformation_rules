
//Start of user code imports
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.net.Uri;
import android.widget.Toast;
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
			


			Button btnHardwareDevice = (Button) findViewById(R.id.btnHardwareDevice);
			btnHardwareDevice.setOnClickListener(new View.OnClickListener() {
	            @Override
	            public void onClick(View view) {
	                startActivity(new Intent(MainActivity.this, HardwareDeviceActivity.class));
	            }
	        });
			
	

		
			//Handle incoming data
	        Intent intent = getIntent();
	        String action = intent.getAction();
	        String type = intent.getType();

			//all the data type options to receive
	        if (Intent.ACTION_SEND.equals(action) && type != null) {
				
				if ("text/plain".equals(type)) {
	                handleSendText(intent, "text"); // Handle text being sent
	            }
	        
				
				if (type.startsWith("audio/"))
	            {
	                handleSendData(intent,"audio" ); // Handle single audio being sent
	
	            } else if (type.startsWith("video/"))
	            {
	                handleSendData(intent,"video" ); // Handle single video being sent
	            } else if (type.startsWith("application/"))
	            {
	                handleSendData(intent,"application" ); // Handle single file being sent
	            }
	        
				
				if (type.startsWith("image/"))
	            {
	                handleSendData(intent,"image" ); // Handle single image being sent
	            }  
	        
				
				if ("text/plain".equals(type)) {
	                handleSendText(intent, "text"); // Handle text being sent
	            }
	        
			}


			Button btnUser = (Button) findViewById(R.id.btnUser);
			btnUser.setOnClickListener(new View.OnClickListener() {
	            @Override
	            public void onClick(View view) {
	                startActivity(new Intent(MainActivity.this, UserActivity.class));
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

    void handleSendText(Intent intent, String type) {
        String sharedText = intent.getStringExtra(Intent.EXTRA_TEXT);
        if (sharedText != null) {
            // Update UI to reflect text being shared
            Toast.makeText(MainActivity.this, type+" => "+sharedText, Toast.LENGTH_SHORT).show();
        }
    }

    void handleSendData(Intent intent, String type) {
        Uri imageUri = (Uri) intent.getParcelableExtra(Intent.EXTRA_STREAM);
        if (imageUri != null) {
            // Update UI to reflect image being shared
            Toast.makeText(MainActivity.this, type+" => "+imageUri.toString(), Toast.LENGTH_SHORT).show();

        }
    }

}
