
package com.example.carritodecompras.activities;

//Start of user code imports
import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.location.Location;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.carritodecompras.R;
import com.example.carritodecompras.utils.GPSTracker;

//End of user code

public class HardwareDeviceActivity extends AppCompatActivity {
    private SensorManager mSensorManager;

    private Location location;
    private TextView tvDataMyLocationGPS;
    private Button btnMyLocation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hardwaredevice);

		// Setting the toolbar title
		ActionBar actionBar = getSupportActionBar();
        if(actionBar != null) {
            actionBar.setTitle("HardwareDevice");
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        // Get an instance of the sensor service, and use that to get an instance of a particular sensor.
        mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);

        //GPS
        btnMyLocation = (Button) findViewById(R.id.btnMyLocation);
        tvDataMyLocationGPS = (TextView) findViewById(R.id.tvDataMyLocationGPS);
        btnMyLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String locationText = "Latitude:" + String.valueOf(location.getLatitude()) + " Longitude:" + String.valueOf(location.getLongitude());
                tvDataMyLocationGPS.setText(locationText);
            }
        });

        getLocation();

	}

    @Override
    protected void onResume() {
        super.onResume();

        // Register a listener for the sensor.
        
    }

    @Override
    protected void onPause() {
        super.onPause();

        // Be sure to unregister the sensor when the activity pauses.

    }


    /*
	*	Getting our current location
	*/
	public void getLocation() {
        GPSTracker gps = new GPSTracker(HardwareDeviceActivity.this);
        if (gps.canGetLocation()) {
            location = gps.getLocation();

        } else {
            // can't get location
            // GPS or Network is not enabled
            Toast.makeText(HardwareDeviceActivity.this, "Turn on your GPS", Toast.LENGTH_SHORT).show();
        }
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

