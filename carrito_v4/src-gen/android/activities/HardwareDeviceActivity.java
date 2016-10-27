
//Start of user code imports
import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.location.Location;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
//End of user code

public class HardwareDeviceActivity extends AppCompatActivity {
    private SensorManager mSensorManager;

	private Sensor mGyroscopeGyroscope;
    private TextView tvDataGyroscopeGyroscope;
    private TextView tvTestGyroscopeGyroscope;
	private Sensor mAmbientLightLight;
    private TextView tvDataAmbientLightLight;
    private TextView tvTestAmbientLightLight;
	private Button btnMyMic;
	private Sensor mCompassIntentMagneticField;
    private TextView tvDataCompassIntentMagneticField;
    private TextView tvTestCompassIntentMagneticField;
    private Location location;
    private TextView tvDataMyLocationGPS;
    private Button btnMyLocation;
	private Button btnCameraIntent;
	private Sensor mAccelerometerAccelerometer;
    private TextView tvDataAccelerometerAccelerometer;
    private TextView tvTestAccelerometerAccelerometer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hardwaredevice);

        // Get an instance of the sensor service, and use that to get an instance of a particular sensor.
        mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);

		//Gyroscope
        tvDataGyroscopeGyroscope = (TextView) findViewById(R.id.tvDataGyroscopeGyroscope);
        tvTestGyroscopeGyroscope = (TextView) findViewById(R.id.tvTestGyroscopeGyroscope);
        mGyroscopeGyroscope = mSensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE);
        if (mGyroscopeGyroscope != null) {
            //Success! There's a GYROSCOPE sensor.
            tvTestGyroscopeGyroscope.setText("Success! There's a gyroscope sensor, and it is ready to use");
        } else {
            //Failure! No GYROSCOPE sensor.
            tvTestGyroscopeGyroscope.setText("Failure! No gyroscope sensor.");
        }

		//Ambient_Light
        tvDataAmbientLightLight = (TextView) findViewById(R.id.tvDataAmbientLightLight);
        tvTestAmbientLightLight = (TextView) findViewById(R.id.tvTestAmbientLightLight);
        mAmbientLightLight = mSensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
        if (mAmbientLightLight != null) {
            //Success! There's a LIGHT sensor.
            tvTestAmbientLightLight.setText("Success! There's a light sensor, and it is ready to use");
        } else {
            //Failure! No LIGHT sensor.
            tvTestAmbientLightLight.setText("Failure! No light sensor.");
        }

		//Mic
        btnMyMic = (Button) findViewById(R.id.btnMyMic);
        btnMyMic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HardwareDeviceActivity.this, AudioRecordActivity.class));
            }
        });

		//Compass
        tvDataCompassIntentMagneticField = (TextView) findViewById(R.id.tvDataCompassIntentMagneticField);
        tvTestCompassIntentMagneticField = (TextView) findViewById(R.id.tvTestCompassIntentMagneticField);
        mCompassIntentMagneticField = mSensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD);
        if (mCompassIntentMagneticField != null) {
            //Success! There's a MAGNETIC_FIELD sensor.
            tvTestCompassIntentMagneticField.setText("Success! There's a magneticField sensor, and it is ready to use");
        } else {
            //Failure! No MAGNETIC_FIELD sensor.
            tvTestCompassIntentMagneticField.setText("Failure! No magneticField sensor.");
        }

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

		//Camara
        btnCameraIntent = (Button) findViewById(R.id.btnCameraIntent);
        btnCameraIntent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HardwareDeviceActivity.this, CameraActivity.class));
            }
        });

		//Accelerometer
        tvDataAccelerometerAccelerometer = (TextView) findViewById(R.id.tvDataAccelerometerAccelerometer);
        tvTestAccelerometerAccelerometer = (TextView) findViewById(R.id.tvTestAccelerometerAccelerometer);
        mAccelerometerAccelerometer = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        if (mAccelerometerAccelerometer != null) {
            //Success! There's a ACCELEROMETER sensor.
            tvTestAccelerometerAccelerometer.setText("Success! There's a accelerometer sensor, and it is ready to use");
        } else {
            //Failure! No ACCELEROMETER sensor.
            tvTestAccelerometerAccelerometer.setText("Failure! No accelerometer sensor.");
        }

	}

    @Override
    protected void onResume() {
        // Register a listener for the sensor.
        super.onResume();
		mSensorManager.registerListener(mGyroscopeGyroscopeListener, mGyroscopeGyroscope, SensorManager.SENSOR_DELAY_NORMAL);
		mSensorManager.registerListener(mAmbientLightLightSensorListener, mAmbientLightLight, SensorManager.SENSOR_DELAY_NORMAL);
		mSensorManager.registerListener(mCompassIntentMagneticFieldSensorListener, mCompassIntentMagneticField, SensorManager.SENSOR_DELAY_NORMAL);
		mSensorManager.registerListener(mAccelerometerAccelerometerListener, mAccelerometerAccelerometer, SensorManager.SENSOR_DELAY_NORMAL);
        
    }

    @Override
    protected void onPause() {
        // Be sure to unregister the sensor when the activity pauses.
        super.onPause();
		mSensorManager.unregisterListener(mGyroscopeGyroscopeListener);
		mSensorManager.unregisterListener(mAmbientLightLightSensorListener);
		mSensorManager.unregisterListener(mCompassIntentMagneticFieldSensorListener);
		mSensorManager.unregisterListener(mAccelerometerAccelerometerListener);

    }

			private SensorEventListener mGyroscopeGyroscopeListener = new SensorEventListener() {
		        @Override
		        public void onSensorChanged(SensorEvent event) {
		            // Do something with this sensor data.
		            String text = "values[0] :" + event.values[0] + "\nvalues[1] :" + event.values[1] + "\nvalues[2] :" + event.values[2];
		            tvDataGyroscopeGyroscope.setText(text);
		
		        }
		
		        @Override
		        public void onAccuracyChanged(Sensor sensor, int accuracy) {
		            // Do something here if sensor accuracy changes.
		            String text = tvTestGyroscopeGyroscope.getText().toString();
		            text += "\n" + "Accuracy: " + sensor.toString() + " - " + accuracy;
		            tvTestGyroscopeGyroscope.setText(text);
		        }
	    	};
			private SensorEventListener mAmbientLightLightSensorListener = new SensorEventListener() {
			        @Override
			        public void onSensorChanged(SensorEvent event) {
			            // Do something with this sensor data.
				        String text = "values[0] :" + event.values[0] + "\nvalues[1] :" + event.values[1] + "\nvalues[2] :" + event.values[2];
			            tvDataAmbientLightLight.setText(text);
			        }
			
			        @Override
			        public void onAccuracyChanged(Sensor sensor, int accuracy) {
			            // Do something here if sensor accuracy changes.
			            String text = tvTestAmbientLightLight.getText().toString();
			            text += "\n" + "Accuracy: " + sensor.toString() + " - " + accuracy;
			            tvTestAmbientLightLight.setText(text);
			        }
			    };
			private SensorEventListener mCompassIntentMagneticFieldSensorListener = new SensorEventListener() {
		        @Override
		        public void onSensorChanged(SensorEvent event) {
		            // Do something with this sensor data.
			         String text = "values[0] :" + event.values[0] + "\nvalues[1] :" + event.values[1] + "\nvalues[2] :" + event.values[2];
		            tvDataCompassIntentMagneticField.setText(text);
		        }
		
		        @Override
		        public void onAccuracyChanged(Sensor sensor, int accuracy) {
		            // Do something here if sensor accuracy changes.
		            String text = tvTestCompassIntentMagneticField.getText().toString();
		            text += "\n" + "Accuracy: " + sensor.toString() + " - " + accuracy;
		            tvTestCompassIntentMagneticField.setText(text);
		        }
	    	};
		private SensorEventListener mAccelerometerAccelerometerListener = new SensorEventListener() {
	        @Override
	        public void onSensorChanged(SensorEvent event) {
	            // Do something with this sensor data.
	            String text = "values[0] :" + event.values[0] + "\nvalues[1] :" + event.values[1] + "\nvalues[2] :" + event.values[2];
	            tvDataAccelerometerAccelerometer.setText(text);
	
	        }
	
	        @Override
	        public void onAccuracyChanged(Sensor sensor, int accuracy) {
	            // Do something here if sensor accuracy changes.
	            String text = tvTestAccelerometerAccelerometer.getText().toString();
	            text += "\n" + "Accuracy: " + sensor.toString() + " - " + accuracy;
	            tvTestAccelerometerAccelerometer.setText(text);
	        }
    	};

    
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
		}

