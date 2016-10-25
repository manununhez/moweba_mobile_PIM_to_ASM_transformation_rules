
//Start of user code imports
using Data.Common;
using Data.Model;
using Data.ViewModels;
using System;
using Windows.UI.Popups;
using Windows.UI.Xaml;
using Windows.UI.Xaml.Controls;
using Windows.UI.Xaml.Navigation;
//End of user code


namespace Data.Views
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

        private async void btnAddShoppingCart_Click(object sender, RoutedEventArgs e)
        {
     
			if(syncTimeTbx.Text != "" & idCartTbx.Text != "" & quantityTbx.Text != "")
            {
				shoppingCartDAO.addShoppingCart(new ShoppingCart(syncTimeTbx.Text, Int32.Parse(idCartTbx.Text), quantityTbx.Text)); 			

                Frame.Navigate(typeof(ShoppingCartView));//after add shoppingCart redirect to shoppingCart listbox page
            }
            else
            {
                var dialog = new MessageDialog("Please fill the fields");//Text should not be empty 
                await dialog.ShowAsync();
            }
        }
    }
}

