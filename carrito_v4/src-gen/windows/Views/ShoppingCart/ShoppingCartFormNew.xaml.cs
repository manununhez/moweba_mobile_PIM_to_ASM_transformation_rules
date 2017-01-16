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

    public sealed partial class ShoppingCartFormNew : Page
    {
        private NavigationHelper navigationHelper;

        public ShoppingCartFormNew()
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
		* Add data to the database.
		* A object with data from form is created and then added to database.
		*/
		private async void btnAddShoppingCart_Click(object sender, RoutedEventArgs e)
        {
     		ShoppingCartDAO shoppingCartDAO = new ShoppingCartDAO();
			if(idCartTbx.Text != "" & priceTbx.Text != "" & quantityTbx.Text != "" & idProductTbx.Text != "" & syncTimeTbx.Text != "")
            {
				try {
					shoppingCartDAO.addShoppingCart(new ShoppingCart(Int32.Parse(idCartTbx.Text), priceTbx.Text, Int32.Parse(quantityTbx.Text), Int32.Parse(idProductTbx.Text), double.Parse(syncTimeTbx.Text, System.Globalization.CultureInfo.InvariantCulture))); 			
	
	                Frame.Navigate(typeof(ShoppingCartView));//after add shoppingCart redirect to shoppingCart listbox page
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

