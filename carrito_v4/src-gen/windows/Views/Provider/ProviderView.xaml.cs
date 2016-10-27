//Start of user code imports
using CarritoDeCompras.Common;
using CarritoDeCompras.Model;
using CarritoDeCompras.ViewModels;
using System;
using System.Collections.ObjectModel;
using System.Linq;
using Windows.UI.Xaml;
using Windows.UI.Xaml.Controls;
using Windows.UI.Xaml.Navigation;
//End of user code

namespace CarritoDeCompras.Views
{

    public sealed partial class ProviderView : Page
    {
        private NavigationHelper navigationHelper;
        private ObservableCollection<Provider> providerList;
        private ProviderDAO provider = new ProviderDAO();
        
		public ProviderView()
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


        private void ReadAllProvider_Loaded(object sender, RoutedEventArgs e)
        {        
            providerList = provider.getAllProvider();//Get all DB provider  
            listBoxobj.ItemsSource = providerList.OrderByDescending(i => i.Id).ToList();//Binding DB data to LISTBOX and Latest provider ID can Display first.  
            loadedElementsCount();
        }

        private void btnAddProvider_click(object sender, RoutedEventArgs e)
        {
            Frame.Navigate(typeof(ProviderFormNew));
        }

        private void listBoxobj_SelectionChanged(object sender, SelectionChangedEventArgs e)
        {
            if (listBoxobj.SelectedIndex != -1)
            {
                Provider listItem = listBoxobj.SelectedItem as Provider;//Get selected listbox item contact ID 
                Frame.Navigate(typeof(ProviderFormDeleteUpdate), listItem);
            }
        }

        private void loadedElementsCount()
        {
            txbQuantity.Text = Convert.ToString(providerList.Count);//Text should not be empty 
        }


    }
}


