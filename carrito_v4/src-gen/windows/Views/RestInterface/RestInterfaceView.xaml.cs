//Start of user code imports
using System;
using Kulman.WPA81.BaseRestService.Services.Exceptions;
using Data.Common;
using Data.Model;
using Windows.UI.Xaml;
using Windows.UI.Xaml.Controls;
using Windows.UI.Xaml.Navigation;
using Windows.UI.Popups;
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
            MessageDialog ms = new MessageDialog("Completar login()");
            ms.ShowAsync();
			/*
			*	TODO completar metodo
			*/
			/*try
            {
                Boolean data = await apiInterface.login( User user);			
                loginTbx.Text = data.ToString();
            }
            catch (DeserializationException d)
            {
                System.Diagnostics.Debug.WriteLine(d.ToString());
            }*/
        }

        private void btnLogout_Click(object sender, RoutedEventArgs e)
        {
            logout();          
        }

        private async void logout() {
            MessageDialog ms = new MessageDialog("Completar logout()");
            ms.ShowAsync();
			/*
			*	TODO completar metodo
			*/
			/*try
            {
                Boolean data = await apiInterface.logout();			
                logoutTbx.Text = data.ToString();
            }
            catch (DeserializationException d)
            {
                System.Diagnostics.Debug.WriteLine(d.ToString());
            }*/
        }

        private void btnGetAllProducts_Click(object sender, RoutedEventArgs e)
        {
            getAllProducts();          
        }

        private async void getAllProducts() {
            MessageDialog ms = new MessageDialog("Completar getAllProducts()");
            ms.ShowAsync();
			/*
			*	TODO completar metodo
			*/
			/*try
            {
                List<Product> data = await apiInterface.getAllProducts();			
                getAllProductsTbx.Text = data.ToString();
            }
            catch (DeserializationException d)
            {
                System.Diagnostics.Debug.WriteLine(d.ToString());
            }*/
        }

        private void btnGetProduct_Click(object sender, RoutedEventArgs e)
        {
            getProduct();          
        }

        private async void getProduct() {
            MessageDialog ms = new MessageDialog("Completar getProduct()");
            ms.ShowAsync();
			/*
			*	TODO completar metodo
			*/
			/*try
            {
                Product data = await apiInterface.getProduct();			
                getProductTbx.Text = data.ToString();
            }
            catch (DeserializationException d)
            {
                System.Diagnostics.Debug.WriteLine(d.ToString());
            }*/
        }

        private void btnGetAllProviders_Click(object sender, RoutedEventArgs e)
        {
            getAllProviders();          
        }

        private async void getAllProviders() {
            MessageDialog ms = new MessageDialog("Completar getAllProviders()");
            ms.ShowAsync();
			/*
			*	TODO completar metodo
			*/
			/*try
            {
                List<Provider> data = await apiInterface.getAllProviders();			
                getAllProvidersTbx.Text = data.ToString();
            }
            catch (DeserializationException d)
            {
                System.Diagnostics.Debug.WriteLine(d.ToString());
            }*/
        }

        private void btnGetProvider_Click(object sender, RoutedEventArgs e)
        {
            getProvider();          
        }

        private async void getProvider() {
            MessageDialog ms = new MessageDialog("Completar getProvider()");
            ms.ShowAsync();
			/*
			*	TODO completar metodo
			*/
			/*try
            {
                Provider data = await apiInterface.getProvider();			
                getProviderTbx.Text = data.ToString();
            }
            catch (DeserializationException d)
            {
                System.Diagnostics.Debug.WriteLine(d.ToString());
            }*/
        }

        private void btnConfirmCart_Click(object sender, RoutedEventArgs e)
        {
            confirmCart();          
        }

        private async void confirmCart() {
            MessageDialog ms = new MessageDialog("Completar confirmCart()");
            ms.ShowAsync();
			/*
			*	TODO completar metodo
			*/
			/*try
            {
                Boolean data = await apiInterface.confirmCart( Product products);			
                confirmCartTbx.Text = data.ToString();
            }
            catch (DeserializationException d)
            {
                System.Diagnostics.Debug.WriteLine(d.ToString());
            }*/
        }

        private void btnGetUserCart_Click(object sender, RoutedEventArgs e)
        {
            getUserCart();          
        }

        private async void getUserCart() {
            MessageDialog ms = new MessageDialog("Completar getUserCart()");
            ms.ShowAsync();
			/*
			*	TODO completar metodo
			*/
			/*try
            {
                List<ShoppingCart> data = await apiInterface.getUserCart();			
                getUserCartTbx.Text = data.ToString();
            }
            catch (DeserializationException d)
            {
                System.Diagnostics.Debug.WriteLine(d.ToString());
            }*/
        }

    }

}
