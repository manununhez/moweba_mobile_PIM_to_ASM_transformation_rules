//Start of user code imports
using CarritoDeCompras.Common;
using CarritoDeCompras.Model;
using CarritoDeCompras.ViewModels;
using System;
using System.Collections.ObjectModel;
using System.Linq;
using System.Diagnostics;
using System.Globalization;
using Windows.UI.Popups;
using Windows.UI.Xaml;
using Windows.UI.Xaml.Controls;
using Windows.UI.Xaml.Navigation;
//End of user code

namespace CarritoDeCompras.Views
{

    public sealed partial class ShoppingCartView : Page
    {
        private NavigationHelper navigationHelper;
        private ObservableCollection<ShoppingCart> shoppingCartList;
        private ShoppingCartDAO shoppingCart = new ShoppingCartDAO();
        
		public ShoppingCartView()
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

		/*
		* When the page is loaded, the list is loaded with data from database.
		*/
        private async void ReadAllShoppingCart_Loaded(object sender, RoutedEventArgs e)
        {     
			try {   
	            shoppingCartList = shoppingCart.getAllShoppingCart();//Get all DB shoppingCart  
	            listBoxobj.ItemsSource = shoppingCartList.OrderByDescending(i => i.Id).ToList();//Binding DB data to LISTBOX and Latest shoppingCart ID can Display first.  
	            loadedElementsCount();
			}
			catch (Exception ex)
            {
                await new MessageDialog((ex.Message + " " + ex.StackTrace), "Unknown Error").ShowAsync();
                Debug.WriteLine((ex.Message + " " + ex.StackTrace));
            }
        }

		/*
		* Go to the form to create an entry in the database
		*/
        private void btnAddShoppingCart_click(object sender, RoutedEventArgs e)
        {
            Frame.Navigate(typeof(ShoppingCartFormNew));
        }

		/*
		* When an item of the list is selected, go to the update page form
		*/
        private void listBoxobj_SelectionChanged(object sender, SelectionChangedEventArgs e)
        {
            if (listBoxobj.SelectedIndex != -1)
            {
                ShoppingCart listItem = listBoxobj.SelectedItem as ShoppingCart;//Get selected listbox item contact ID 
                Frame.Navigate(typeof(ShoppingCartFormDeleteUpdate), listItem);
            }
        }

		/*
		* Update the total items count from list
		*/
        private void loadedElementsCount()
        {
            txbQuantity.Text = Convert.ToString(shoppingCartList.Count);//Text should not be empty 
        }


    }
}