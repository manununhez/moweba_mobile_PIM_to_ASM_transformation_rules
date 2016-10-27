//Start of user code imports
using CarritoDeCompras.Common;
using CarritoDeCompras.Model;
using CarritoDeCompras.ViewModels;
using System;
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
            if (e != null)
            {
                selectedShoppingCart = e.Parameter as ShoppingCart;
				if (selectedShoppingCart != null)
                {
					syncTimeTbx.Text = Convert.ToString(selectedShoppingCart.syncTime);
					quantityTbx.Text = Convert.ToString(selectedShoppingCart.quantity);
					idCartTbx.Text = Convert.ToString(selectedShoppingCart.idCart);
				}
            }
        }

        protected override void OnNavigatedFrom(NavigationEventArgs e)
        {
            this.navigationHelper.OnNavigatedFrom(e);
        }

        private void btnDelete_click(object sender, RoutedEventArgs e)
        {
            shoppingCartDAO.deleteShoppingCart(selectedShoppingCart);//Delete selected DB contact Id. 
            Frame.Navigate(typeof(ShoppingCartView));
        }

        private void btnUpdate_click(object sender, RoutedEventArgs e)
        {
            ShoppingCart currentShoppingCart = new ShoppingCart();
			currentShoppingCart.syncTime = double.Parse(syncTimeTbx.Text, System.Globalization.CultureInfo.InvariantCulture);
			currentShoppingCart.quantity = Int32.Parse(quantityTbx.Text);
			currentShoppingCart.idCart = Int32.Parse(idCartTbx.Text);

			shoppingCartDAO.updateShoppingCart(currentShoppingCart);//Update selected DB current shoppingCart
            Frame.Navigate(typeof(ShoppingCartView));
        }
    }
}
