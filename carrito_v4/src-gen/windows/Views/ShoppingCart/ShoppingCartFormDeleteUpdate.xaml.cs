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

    public sealed partial class ShoppingCartFormDeleteUpdate : Page
    {
        private NavigationHelper navigationHelper;
        private ShoppingCartDAO shoppingCartDAO = new ShoppingCartDAO();
        private ShoppingCart selectedShoppingCart;

        public ShoppingCartFormDeleteUpdate()
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
                selectedShoppingCart = e.Parameter as ShoppingCart;
				if (selectedShoppingCart != null)
                {
				//Fill the form with the received data
					idCartTbx.Text = Convert.ToString(selectedShoppingCart.idCart);
					priceTbx.Text = selectedShoppingCart.price;
					quantityTbx.Text = Convert.ToString(selectedShoppingCart.quantity);
					idProductTbx.Text = Convert.ToString(selectedShoppingCart.idProduct);
					syncTimeTbx.Text = Convert.ToString(selectedShoppingCart.syncTime);
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
	            shoppingCartDAO.deleteShoppingCart(selectedShoppingCart);//Delete selected DB contact Id. 
	            Frame.Navigate(typeof(ShoppingCartView));
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
            ShoppingCart currentShoppingCart = new ShoppingCart();
			currentShoppingCart.idCart = Int32.Parse(idCartTbx.Text);
			currentShoppingCart.price = priceTbx.Text;
			currentShoppingCart.quantity = Int32.Parse(quantityTbx.Text);
			currentShoppingCart.idProduct = Int32.Parse(idProductTbx.Text);
			currentShoppingCart.syncTime = double.Parse(syncTimeTbx.Text, System.Globalization.CultureInfo.InvariantCulture);

			try{
				shoppingCartDAO.updateShoppingCart(currentShoppingCart);//Update selected DB current shoppingCart
	            Frame.Navigate(typeof(ShoppingCartView));
			}
			catch (Exception ex)
            {
                await new MessageDialog((ex.Message + " " + ex.StackTrace), "Unknown Error").ShowAsync();
                Debug.WriteLine((ex.Message + " " + ex.StackTrace));
            }
        }
    }
}
