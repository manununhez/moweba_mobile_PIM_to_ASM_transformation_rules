
//Start of user code imports
using Kulman.WPA81.BaseRestService.Services.Exceptions;
using Data.Common;
using Data.Model;
using Windows.UI.Xaml;
using Windows.UI.Xaml.Controls;
using Windows.UI.Xaml.Navigation;
//End of user code



namespace Data.Views
{

    public sealed partial class RestInterfaceView : Page
    {
        private NavigationHelper navigationHelper;
        private ApiInterface apiInterface = new ApiInterface();

        public RestInterfaceView()
        {
            this.InitializeComponent();
            this.navigationHelper = new NavigationHelper(this);
            this.navigationHelper.LoadState += this.NavigationHelper_LoadState;
            this.navigationHelper.SaveState += this.NavigationHelper_SaveState;
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

        private void btnLogin_Click(object sender, RoutedEventArgs e)
        {
            login();          
        }

        private async void login() {
            try
            {
                Boolean data = await apiInterface.login( User user);
				/*
				*	TODO completar
				*/
                loginTbx.Text = data.ToString();
            }
            catch (DeserializationException d)
            {
                System.Diagnostics.Debug.WriteLine(d.ToString());
            }
        }

        private void btnLogout_Click(object sender, RoutedEventArgs e)
        {
            logout();          
        }

        private async void logout() {
            try
            {
                Boolean data = await apiInterface.logout();
				/*
				*	TODO completar
				*/
                logoutTbx.Text = data.ToString();
            }
            catch (DeserializationException d)
            {
                System.Diagnostics.Debug.WriteLine(d.ToString());
            }
        }

        private void btnGetAllProducts_Click(object sender, RoutedEventArgs e)
        {
            getAllProducts();          
        }

        private async void getAllProducts() {
            try
            {
                List<Product> data = await apiInterface.getAllProducts();
				/*
				*	TODO completar
				*/
                getAllProductsTbx.Text = data.ToString();
            }
            catch (DeserializationException d)
            {
                System.Diagnostics.Debug.WriteLine(d.ToString());
            }
        }

        private void btnGetProduct_Click(object sender, RoutedEventArgs e)
        {
            getProduct();          
        }

        private async void getProduct() {
            try
            {
                Product data = await apiInterface.getProduct();
				/*
				*	TODO completar
				*/
                getProductTbx.Text = data.ToString();
            }
            catch (DeserializationException d)
            {
                System.Diagnostics.Debug.WriteLine(d.ToString());
            }
        }

        private void btnGetAllProviders_Click(object sender, RoutedEventArgs e)
        {
            getAllProviders();          
        }

        private async void getAllProviders() {
            try
            {
                List<Provider> data = await apiInterface.getAllProviders();
				/*
				*	TODO completar
				*/
                getAllProvidersTbx.Text = data.ToString();
            }
            catch (DeserializationException d)
            {
                System.Diagnostics.Debug.WriteLine(d.ToString());
            }
        }

        private void btnGetProvider_Click(object sender, RoutedEventArgs e)
        {
            getProvider();          
        }

        private async void getProvider() {
            try
            {
                Provider data = await apiInterface.getProvider();
				/*
				*	TODO completar
				*/
                getProviderTbx.Text = data.ToString();
            }
            catch (DeserializationException d)
            {
                System.Diagnostics.Debug.WriteLine(d.ToString());
            }
        }

        private void btnConfirmCart_Click(object sender, RoutedEventArgs e)
        {
            confirmCart();          
        }

        private async void confirmCart() {
            try
            {
                Boolean data = await apiInterface.confirmCart( Product products);
				/*
				*	TODO completar
				*/
                confirmCartTbx.Text = data.ToString();
            }
            catch (DeserializationException d)
            {
                System.Diagnostics.Debug.WriteLine(d.ToString());
            }
        }

        private void btnGetUserCart_Click(object sender, RoutedEventArgs e)
        {
            getUserCart();          
        }

        private async void getUserCart() {
            try
            {
                List<ShoppingCart> data = await apiInterface.getUserCart();
				/*
				*	TODO completar
				*/
                getUserCartTbx.Text = data.ToString();
            }
            catch (DeserializationException d)
            {
                System.Diagnostics.Debug.WriteLine(d.ToString());
            }
        }

    }

}
