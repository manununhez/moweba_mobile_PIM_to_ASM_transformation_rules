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

    public sealed partial class ProductFormNew : Page
    {
        private NavigationHelper navigationHelper;

        public ProductFormNew()
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

        private async void btnAddProduct_Click(object sender, RoutedEventArgs e)
        {
     		ProductDAO productDAO = new ProductDAO();
			if(idProviderTbx.Text != "" & priceTbx.Text != "" & descriptionTbx.Text != "" & idProductoTbx.Text != "" & codeTbx.Text != "" & nameTbx.Text != "" & idImageProductTbx.Text != "")
            {
				productDAO.addProduct(new Product(Int32.Parse(idProviderTbx.Text), priceTbx.Text, descriptionTbx.Text, Int32.Parse(idProductoTbx.Text), Int32.Parse(codeTbx.Text), nameTbx.Text, Int32.Parse(idImageProductTbx.Text))); 			

                Frame.Navigate(typeof(ProductView));//after add product redirect to product listbox page
            }
            else
            {
                var dialog = new MessageDialog("Please fill the fields");//Text should not be empty 
                await dialog.ShowAsync();
            }
        }
    }
}

