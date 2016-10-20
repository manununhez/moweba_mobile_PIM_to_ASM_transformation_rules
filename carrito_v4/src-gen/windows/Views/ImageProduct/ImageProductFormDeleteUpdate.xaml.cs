
//Start of user code imports
using Data.Common;
using Data.Model;
using Data.ViewModels;
using System;
using Windows.UI.Xaml;
using Windows.UI.Xaml.Controls;
using Windows.UI.Xaml.Navigation;
//End of user code


namespace Data.Views
{

    public sealed partial class ImageProductFormDeleteUpdate : Page
    {
        private NavigationHelper navigationHelper;
        private ImageProductDAO imageProductDAO = new ImageProductDAO();
        private ImageProduct selectedImageProduct;

        public ImageProductFormDeleteUpdate()
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
                selectedImageProduct = e.Parameter as ImageProduct;
				idImageProductTbx.Text = selectedImageProduct.idImageProduct;
				imageTbx.Text = selectedImageProduct.image;
            }
        }

        protected override void OnNavigatedFrom(NavigationEventArgs e)
        {
            this.navigationHelper.OnNavigatedFrom(e);
        }

        private void btnDelete_click(object sender, RoutedEventArgs e)
        {
            imageProductDAO.DeleteImageProduct(selectedImageProduct.Id);//Delete selected DB contact Id. 
            Frame.Navigate(typeof(ImageProductView));
        }

        private void btnUpdate_click(object sender, RoutedEventArgs e)
        {
            Product currentImageProduct = new ImageProduct();
			currentImageProduct.idImageProduct = idImageProductTbx.Text
, 			currentImageProduct.image = imageTbx.Text

			imageProductDAO.updateImageProduct(currentImageProduct);//Update selected DB current imageProduct
            Frame.Navigate(typeof(ImageProductView));
        }
    }
}
