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
            if (e != null)
            {
                selectedProduct = e.Parameter as Product;
				if (selectedProduct != null)
                {
					idProviderTbx.Text = Convert.ToString(selectedProduct.idProvider);
					priceTbx.Text = selectedProduct.price;
					descriptionTbx.Text = selectedProduct.description;
					idProductoTbx.Text = Convert.ToString(selectedProduct.idProducto);
					codeTbx.Text = Convert.ToString(selectedProduct.code);
					nameTbx.Text = selectedProduct.name;
					idImageProductTbx.Text = Convert.ToString(selectedProduct.idImageProduct);
				}
            }
        }

        protected override void OnNavigatedFrom(NavigationEventArgs e)
        {
            this.navigationHelper.OnNavigatedFrom(e);
        }

        private void btnDelete_click(object sender, RoutedEventArgs e)
        {
            productDAO.deleteProduct(selectedProduct);//Delete selected DB contact Id. 
            Frame.Navigate(typeof(ProductView));
        }

        private void btnUpdate_click(object sender, RoutedEventArgs e)
        {
            Product currentProduct = new Product();
			currentProduct.idProvider = Int32.Parse(idProviderTbx.Text);
			currentProduct.price = priceTbx.Text;
			currentProduct.description = descriptionTbx.Text;
			currentProduct.idProducto = Int32.Parse(idProductoTbx.Text);
			currentProduct.code = Int32.Parse(codeTbx.Text);
			currentProduct.name = nameTbx.Text;
			currentProduct.idImageProduct = Int32.Parse(idImageProductTbx.Text);

			productDAO.updateProduct(currentProduct);//Update selected DB current product
            Frame.Navigate(typeof(ProductView));
        }
    }
}
