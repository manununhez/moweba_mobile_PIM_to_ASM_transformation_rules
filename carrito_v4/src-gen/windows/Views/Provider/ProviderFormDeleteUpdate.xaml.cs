
//Start of user code imports
using Data.Common;
using Data.Model;
using Data.ViewModels;
using System;
using Windows.UI.Xaml;
using Windows.UI.Xaml.Controls;
using Windows.UI.Xaml.Navigation;
//End of user code


namespace Data.Views
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
            if (e != null)
            {
                selectedProvider = e.Parameter as Provider;
				idProviderTbx.Text = selectedProvider.idProvider;
				nombreTbx.Text = selectedProvider.nombre;
				descriptionTbx.Text = selectedProvider.description;
				rucTbx.Text = selectedProvider.ruc;
            }
        }

        protected override void OnNavigatedFrom(NavigationEventArgs e)
        {
            this.navigationHelper.OnNavigatedFrom(e);
        }

        private void btnDelete_click(object sender, RoutedEventArgs e)
        {
            providerDAO.DeleteProvider(selectedProvider.Id);//Delete selected DB contact Id. 
            Frame.Navigate(typeof(ProviderView));
        }

        private void btnUpdate_click(object sender, RoutedEventArgs e)
        {
            Product currentProvider = new Provider();
			currentProvider.idProvider = idProviderTbx.Text
, 			currentProvider.nombre = nombreTbx.Text
, 			currentProvider.description = descriptionTbx.Text
, 			currentProvider.ruc = rucTbx.Text

			providerDAO.updateProvider(currentProvider);//Update selected DB current provider
            Frame.Navigate(typeof(ProviderView));
        }
    }
}
