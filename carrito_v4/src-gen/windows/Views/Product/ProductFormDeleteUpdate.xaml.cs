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

    public sealed partial class ProductFormDeleteUpdate : Page
    {
        private NavigationHelper navigationHelper;
        private ProductDAO productDAO = new ProductDAO();
        private Product selectedProduct;

        public ProductFormDeleteUpdate()
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
                selectedProduct = e.Parameter as Product;
				if (selectedProduct != null)
                {
				//Fill the form with the received data
					priceTbx.Text = selectedProduct.price;
					codeTbx.Text = Convert.ToString(selectedProduct.code);
					descriptionTbx.Text = selectedProduct.description;
					taxPercentageTbx.Text = Convert.ToString(selectedProduct.taxPercentage);
					nameTbx.Text = selectedProduct.name;
					idProviderTbx.Text = Convert.ToString(selectedProduct.idProvider);
					idProductTbx.Text = Convert.ToString(selectedProduct.idProduct);
					idImageProductTbx.Text = Convert.ToString(selectedProduct.idImageProduct);
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
	            productDAO.deleteProduct(selectedProduct);//Delete selected DB contact Id. 
	            Frame.Navigate(typeof(ProductView));
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
            Product currentProduct = new Product();
			currentProduct.price = priceTbx.Text;
			currentProduct.code = Int32.Parse(codeTbx.Text);
			currentProduct.description = descriptionTbx.Text;
			currentProduct.taxPercentage = Int32.Parse(taxPercentageTbx.Text);
			currentProduct.name = nameTbx.Text;
			currentProduct.idProvider = Int32.Parse(idProviderTbx.Text);
			currentProduct.idProduct = Int32.Parse(idProductTbx.Text);
			currentProduct.idImageProduct = Int32.Parse(idImageProductTbx.Text);

			try{
				productDAO.updateProduct(currentProduct);//Update selected DB current product
	            Frame.Navigate(typeof(ProductView));
			}
			catch (Exception ex)
            {
                await new MessageDialog((ex.Message + " " + ex.StackTrace), "Unknown Error").ShowAsync();
                Debug.WriteLine((ex.Message + " " + ex.StackTrace));
            }
        }
    }
}
