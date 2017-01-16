
//Start of user code imports
using CarritoDeCompras.Common;
using System;
using System.Diagnostics;
using Windows.Devices.Geolocation;
using Windows.Devices.Sensors;
using Windows.Foundation;
using Windows.UI.Core;
using Windows.UI.Popups;
using Windows.UI.Xaml.Controls;
using Windows.UI.Xaml.Navigation;
//End of user code

namespace CarritoDeCompras.Views
{
    public sealed partial class HardwareDeviceView : Page
    {
        private NavigationHelper navigationHelper;	
        //Use for get efficient signal intervals between accelerometer responses
        private uint desiredReportInterval { get; set; }
        
		public HardwareDeviceView()
        {
            this.InitializeComponent();

            this.navigationHelper = new NavigationHelper(this);
            this.navigationHelper.LoadState += this.NavigationHelper_LoadState;
            this.navigationHelper.SaveState += this.NavigationHelper_SaveState;



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
                MyLocationGPSTbx.Text = "GPS:" + geoposition.Coordinate.Point.Position.Latitude.ToString("0.00") + ", " + geoposition.Coordinate.Point.Position.Longitude.ToString("0.00");
            }
            //If an error is catch 2 are the main causes: the first is that you forgot to include ID_CAP_LOCATION in your app manifest. 
            //The second is that the user doesn't turned on the Location Services
            catch (Exception ex) {
                await new MessageDialog((ex.Message + " " + ex.StackTrace), "Unknown Error").ShowAsync();
                Debug.WriteLine((ex.Message + " " + ex.StackTrace));
            }
        }
    }
}
