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

    public sealed partial class ProductView : Page
    {
        private NavigationHelper navigationHelper;
        private ObservableCollection<Product> productList;
        private ProductDAO product = new ProductDAO();
        
		public ProductView()
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
        private async void ReadAllProduct_Loaded(object sender, RoutedEventArgs e)
        {     
			try {   
	            productList = product.getAllProduct();//Get all DB product  
	            listBoxobj.ItemsSource = productList.OrderByDescending(i => i.Id).ToList();//Binding DB data to LISTBOX and Latest product ID can Display first.  
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
        private void btnAddProduct_click(object sender, RoutedEventArgs e)
        {
            Frame.Navigate(typeof(ProductFormNew));
        }

		/*
		* When an item of the list is selected, go to the update page form
		*/
        private void listBoxobj_SelectionChanged(object sender, SelectionChangedEventArgs e)
        {
            if (listBoxobj.SelectedIndex != -1)
            {
                Product listItem = listBoxobj.SelectedItem as Product;//Get selected listbox item contact ID 
                Frame.Navigate(typeof(ProductFormDeleteUpdate), listItem);
            }
        }

		/*
		* Update the total items count from list
		*/
        private void loadedElementsCount()
        {
            txbQuantity.Text = Convert.ToString(productList.Count);//Text should not be empty 
        }


    }
}
