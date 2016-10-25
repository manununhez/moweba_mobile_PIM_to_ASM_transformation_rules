
//Start of user code imports
using Data.Common;
using System;
using Windows.Devices.Geolocation;
using Windows.Devices.Sensors;
using Windows.Foundation;
using Windows.UI.Core;
using Windows.UI.Popups;
using Windows.UI.Xaml.Controls;
using Windows.UI.Xaml.Navigation;
//End of user code

namespace Data.Views
{
    public sealed partial class HardwareDeviceView : Page
    {
        private NavigationHelper navigationHelper;	
	    public LightSensor mAmbientLightLight { get; set; }
		public Accelerometer mAccelerometerAccelerometer { get; set; }
	    public Gyrometer mGyroscopeGyroscope { get; set; }
	    public Compass mCompassIntentCompass { get; set; }
        //Use for get efficient signal intervals between accelerometer responses
        private uint desiredReportInterval { get; set; }
        
		public HardwareDeviceView()
        {
            this.InitializeComponent();

            this.navigationHelper = new NavigationHelper(this);
            this.navigationHelper.LoadState += this.NavigationHelper_LoadState;
            this.navigationHelper.SaveState += this.NavigationHelper_SaveState;

		    mAmbientLightLight = LightSensor.GetDefault();
			mAccelerometerAccelerometer = Accelerometer.GetDefault();
		    mGyroscopeGyroscope = Gyrometer.GetDefault();
		    mCompassIntentCompass = Compass.GetDefault();

            if (accelerometer != null && gyrometer != null)
            {
                // Select a report interval that is both suitable for the purposes of the app and supported by the sensor.
                // This value will be used later to activate the sensor.
                uint minReportInterval = accelerometer.MinimumReportInterval;
                desiredReportInterval = minReportInterval > 16 ? minReportInterval : 16;

		    mAmbientLightLight.ReportInterval = desiredReportInterval;
			//add event for sensors readings
            mAmbientLightLight.ReadingChanged += new TypedEventHandler<Accelerometer, LightSensorReadingChangedEventArgs>(ReadingChanged);
			mAccelerometerAccelerometer.ReportInterval = desiredReportInterval;
			//add event for sensors readings
            mAccelerometerAccelerometer.ReadingChanged += new TypedEventHandler<Accelerometer, AccelerometerReadingChangedEventArgs>(ReadingChanged);
		    mGyroscopeGyroscope.ReportInterval = desiredReportInterval;
			//add event for sensors readings
             mGyroscopeGyroscope.ReadingChanged += new TypedEventHandler<Accelerometer, GyrometerReadingChangedEventArgs>(ReadingChanged);
		    mCompassIntentCompass.ReportInterval = desiredReportInterval;
			//add event for sensors readings
            mCompassIntentCompass.ReadingChanged += new TypedEventHandler<Accelerometer, CompassReadingChangedEventArgs>(ReadingChanged);

            }
            else
            {
                MessageDialog ms = new MessageDialog("No accelerometer Found");
                ms.ShowAsync();
            }

            this.NavigationCacheMode = NavigationCacheMode.Required;
        }

        public NavigationHelper NavigationHelper
        {
            get { return this.navigationHelper; }
        }

        private void NavigationHelper_LoadState(object sender, LoadStateEventArgs e)
        {
        }

        private void NavigationHelper_SaveState(object sender, SaveStateEventArgs e)
        {
        }

        protected override void OnNavigatedTo(NavigationEventArgs e)
        {
            this.navigationHelper.OnNavigatedTo(e);
        }

        protected override void OnNavigatedFrom(NavigationEventArgs e)
        {
            this.navigationHelper.OnNavigatedFrom(e);
        }


		/// <summary>
        /// reading accelerometer changes
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="args"></param>
        private async void ReadingChanged(Accelerometer sender, AccelerometerReadingChangedEventArgs args)
        {
            await Dispatcher.RunAsync(CoreDispatcherPriority.Normal, () =>
            {
                AccelerometerReading reading = args.Reading;
                AccelerometerTbx.Text = reading.AccelerationX+","+ reading.AccelerationY+","+ reading.AccelerationZ;
            });
        }
		
		/// <summary>
        /// reading ambient light changes
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="args"></param>
        private async void ReadingChanged(LightSensor sender, LightSensorReadingChangedEventArgs args)
        {
            await Dispatcher.RunAsync(CoreDispatcherPriority.Normal, () =>
            {
                LightSensorReading reading = args.Reading;
                AmbientLightTbx.Text = reading.IlluminanceInLux+"/"+reading.Timestamp;
            });
        }

		/// <summary>
        /// reading gyroscope changes
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="args"></param>
        private async void ReadingChanged(Gyrometer sender, GyrometerReadingChangedEventArgs args)
        {
            await Dispatcher.RunAsync(CoreDispatcherPriority.Normal, () =>
            {
                GyrometerReading reading = args.Reading;
                GyroscopeTbx.Text = reading.AngularVelocityX+","+reading.AngularVelocityY+","+reading.AngularVelocityZ;
            });
        }
	
		/// <summary>
        /// reading compass changes
        /// </summary>
        /// <param name="sender"></param>
        /// <param name="args"></param>
        private async void ReadingChanged(Compass sender, CompassReadingChangedEventArgs args)
        {
            await Dispatcher.RunAsync(CoreDispatcherPriority.Normal, () =>
            {
                CompassReading reading = args.Reading;
                CompassIntentTbx.Text = reading.HeadingAccuracy+","+reading.HeadingMagneticNorth+","+reading.HeadingTrueNorth;
            });
        }

	    private async void btnMyLocationGPS_Click(object sender, Windows.UI.Xaml.RoutedEventArgs e)
        {
            Geolocator geolocator = new Geolocator();
            geolocator.DesiredAccuracyInMeters = 50;

            try
            {
                Geoposition geoposition = await geolocator.GetGeopositionAsync(
                     maximumAge: TimeSpan.FromMinutes(5),
                     timeout: TimeSpan.FromSeconds(10)
                    );

                //With this 2 lines of code, the app is able to write on a Text Label the Latitude and the Longitude, given by {{Icode|geoposition}}
                MyLocationTbx.Text = "GPS:" + geoposition.Coordinate.Point.Position.Latitude.ToString("0.00") + ", " + geoposition.Coordinate.Point.Position.Longitude.ToString("0.00");
            }
            //If an error is catch 2 are the main causes: the first is that you forgot to include ID_CAP_LOCATION in your app manifest. 
            //The second is that the user doesn't turned on the Location Services
            catch (Exception ex)
            {
                //exception
            }
        }
	    private void btnMyMicAudioRecord_Click(object sender, Windows.UI.Xaml.RoutedEventArgs e)
        {
            Frame.Navigate(typeof(AudioRecordView));
        }
        private void btnCameraIntentCamera_Click(object sender, Windows.UI.Xaml.RoutedEventArgs e)
        {
            Frame.Navigate(typeof(CameraView));
        }

    }

}
