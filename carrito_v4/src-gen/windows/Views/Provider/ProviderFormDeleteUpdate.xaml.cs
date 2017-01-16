//Start of user code imports
using CarritoDeCompras.Common;
using CarritoDeCompras.Model;
using CarritoDeCompras.ViewModels;
using System;
using System.Diagnostics;
using System.Globalization;
using Windows.UI.Popups;
using Windows.UI.Xaml;
using Windows.UI.Xaml.Controls;
using Windows.UI.Xaml.Navigation;
//End of user code


namespace CarritoDeCompras.Views
{

    public sealed partial class ProviderFormDeleteUpdate : Page
    {
        private NavigationHelper navigationHelper;
        private ProviderDAO providerDAO = new ProviderDAO();
        private Provider selectedProvider;

        public ProviderFormDeleteUpdate()
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
			// Receiving data from the bd pageView
            if (e != null)
            {
                selectedProvider = e.Parameter as Provider;
				if (selectedProvider != null)
                {
				//Fill the form with the received data
					descriptionTbx.Text = selectedProvider.description;
					idProviderTbx.Text = Convert.ToString(selectedProvider.idProvider);
					rucTbx.Text = selectedProvider.ruc;
					nombreTbx.Text = selectedProvider.nombre;
				}
            }
        }

        protected override void OnNavigatedFrom(NavigationEventArgs e)
        {
            this.navigationHelper.OnNavigatedFrom(e);
        }

		/*
		* Deleting an specific entry of the database
		*/
        private async void btnDelete_click(object sender, RoutedEventArgs e)
        {
			try{
	            providerDAO.deleteProvider(selectedProvider);//Delete selected DB contact Id. 
	            Frame.Navigate(typeof(ProviderView));
			}
			catch (Exception ex)
            {
                await new MessageDialog((ex.Message + " " + ex.StackTrace), "Unknown Error").ShowAsync();
                Debug.WriteLine((ex.Message + " " + ex.StackTrace));
            }
	     }

		/*
		* Updating an specific entry of the database
		*/
        private async void btnUpdate_click(object sender, RoutedEventArgs e)
        {
			//Create an object with data from form
            Provider currentProvider = new Provider();
			currentProvider.description = descriptionTbx.Text;
			currentProvider.idProvider = Int32.Parse(idProviderTbx.Text);
			currentProvider.ruc = rucTbx.Text;
			currentProvider.nombre = nombreTbx.Text;

			try{
				providerDAO.updateProvider(currentProvider);//Update selected DB current provider
	            Frame.Navigate(typeof(ProviderView));
			}
			catch (Exception ex)
            {
                await new MessageDialog((ex.Message + " " + ex.StackTrace), "Unknown Error").ShowAsync();
                Debug.WriteLine((ex.Message + " " + ex.StackTrace));
            }
        }
    }
}
