
//Start of user code imports
using Data.Views;
using Data.Views.Rest;
using Data.Views.Sensors;
using Windows.UI.Xaml;
using Windows.UI.Xaml.Controls;
using Windows.UI.Xaml.Navigation;
//End of user code

namespace Data
{
    public sealed partial class MainPage : Page
    {
        public MainPage()
        {
            this.InitializeComponent();

            this.NavigationCacheMode = NavigationCacheMode.Required;
        }

        protected override void OnNavigatedTo(NavigationEventArgs e)
        {
            // TODO: Prepare page for display here.
        }
	
	
		private void btnRestInterface_click(object sender, RoutedEventArgs e)
        {
            Frame.Navigate(typeof(RestInterfaceView));
        }


		private void btnProduct_click(object sender, RoutedEventArgs e)
        {
            Frame.Navigate(typeof(ProductView));
        }

		private void btnShoppingCart_click(object sender, RoutedEventArgs e)
        {
            Frame.Navigate(typeof(ShoppingCartView));
        }

		private void btnProvider_click(object sender, RoutedEventArgs e)
        {
            Frame.Navigate(typeof(ProviderView));
        }

		private void btnUser_click(object sender, RoutedEventArgs e)
        {
            Frame.Navigate(typeof(UserView));
        }

		private void btnImageProduct_click(object sender, RoutedEventArgs e)
        {
            Frame.Navigate(typeof(ImageProductView));
        }
	
	
    }
}

