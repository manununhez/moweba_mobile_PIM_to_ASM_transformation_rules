//Start of user code imports
using CarritoDeCompras.Common;
using CarritoDeCompras.Model;
using CarritoDeCompras.ViewModels;
using System;
using System.Collections.ObjectModel;
using System.Linq;
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


        private void ReadAllProduct_Loaded(object sender, RoutedEventArgs e)
        {        
            productList = product.getAllProduct();//Get all DB product  
            listBoxobj.ItemsSource = productList.OrderByDescending(i => i.Id).ToList();//Binding DB data to LISTBOX and Latest product ID can Display first.  
            loadedElementsCount();
        }

        private void btnAddProduct_click(object sender, RoutedEventArgs e)
        {
            Frame.Navigate(typeof(ProductFormNew));
        }

        private void listBoxobj_SelectionChanged(object sender, SelectionChangedEventArgs e)
        {
            if (listBoxobj.SelectedIndex != -1)
            {
                Product listItem = listBoxobj.SelectedItem as Product;//Get selected listbox item contact ID 
                Frame.Navigate(typeof(ProductFormDeleteUpdate), listItem);
            }
        }

        private void loadedElementsCount()
        {
            txbQuantity.Text = Convert.ToString(productList.Count);//Text should not be empty 
        }


    }
}


