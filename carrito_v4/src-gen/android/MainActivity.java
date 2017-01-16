
//Start of user code imports
import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.net.Uri;
import android.widget.Toast;
//End of user code


public class MainActivity extends AppCompatActivity {
    static final int PERMISSIONS_REQUEST = 0x3;

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
	        
			}

			Button btnProvider = (Button) findViewById(R.id.btnProvider);
			btnProvider.setOnClickListener(new View.OnClickListener() {
	            @Override
	            public void onClick(View view) {
	                startActivity(new Intent(MainActivity.this, ProviderActivity.class));
	            }
	        });

			Button btnUser = (Button) findViewById(R.id.btnUser);
			btnUser.setOnClickListener(new View.OnClickListener() {
	            @Override
	            public void onClick(View view) {
	                startActivity(new Intent(MainActivity.this, UserActivity.class));
	            }
	        });

			Button btnImageProduct = (Button) findViewById(R.id.btnImageProduct);
			btnImageProduct.setOnClickListener(new View.OnClickListener() {
	            @Override
	            public void onClick(View view) {
	                startActivity(new Intent(MainActivity.this, ImageProductActivity.class));
	            }
	        });

			Button btnShoppingCart = (Button) findViewById(R.id.btnShoppingCart);
			btnShoppingCart.setOnClickListener(new View.OnClickListener() {
	            @Override
	            public void onClick(View view) {
	                startActivity(new Intent(MainActivity.this, ShoppingCartActivity.class));
	            }
	        });

			Button btnProduct = (Button) findViewById(R.id.btnProduct);
			btnProduct.setOnClickListener(new View.OnClickListener() {
	            @Override
	            public void onClick(View view) {
	                startActivity(new Intent(MainActivity.this, ProductActivity.class));
	            }
	        });
	

	
//Asking permissions for all the hardware in use
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED ||
                ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED 


			
			
    || ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED  //GPS
		    
			


				) {
                askForPermission(PERMISSIONS_REQUEST);
            }
        }
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


    private void askForPermission(Integer requestCode) {

        String[] permission = {
				Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.READ_EXTERNAL_STORAGE


			
			
    , Manifest.permission.ACCESS_FINE_LOCATION  //GPS
		    
			


};

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED
           || ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED


			
			
    ||   ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED  //GPS
		    
			


) {

            ActivityCompat.requestPermissions(MainActivity.this, permission, requestCode);

        } else {
            Toast.makeText(this, "Permissions are already granted.", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (ActivityCompat.checkSelfPermission(this, permissions[0]) == PackageManager.PERMISSION_GRANTED) {
            switch (requestCode) {
                //Permission granted
                case PERMISSIONS_REQUEST:
                    break;
            }

            Toast.makeText(this, "Permission granted", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Permission denied", Toast.LENGTH_SHORT).show();
        }
    }
}
