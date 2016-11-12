//Start of user code imports
using CarritoDeCompras.Common;
using CarritoDeCompras.Model;
using CarritoDeCompras.ViewModels;
using System;
using Windows.UI.Popups;
using Windows.UI.Xaml;
using Windows.UI.Xaml.Controls;
using Windows.UI.Xaml.Navigation;
//End of user code


namespace CarritoDeCompras.Views
{

    public sealed partial class ProviderFormNew : Page
    {
        private NavigationHelper navigationHelper;

        public ProviderFormNew()
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

        private async void btnAddProvider_Click(object sender, RoutedEventArgs e)
        {
     		ProviderDAO providerDAO = new ProviderDAO();
			if(idProviderTbx.Text != "" & nombreTbx.Text != "" & descriptionTbx.Text != "" & rucTbx.Text != "")
            {
				try {
					providerDAO.addProvider(new Provider(Int32.Parse(idProviderTbx.Text), nombreTbx.Text, descriptionTbx.Text, float.Parse(rucTbx.Text, CultureInfo.InvariantCulture.NumberFormat))); 			
	
	                Frame.Navigate(typeof(ProviderView));//after add provider redirect to provider listbox page
				}
                catch (Exception ex)
                {
                    await new MessageDialog((ex.Message + " " + ex.StackTrace), "Unknown Error").ShowAsync();
                    Debug.WriteLine((ex.Message + " " + ex.StackTrace));
                }
            }
            else
            {
                var dialog = new MessageDialog("Please fill the fields");//Text should not be empty 
                await dialog.ShowAsync();
            }
        }
    }
}

