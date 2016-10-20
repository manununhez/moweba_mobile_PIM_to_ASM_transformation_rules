
//Start of user code imports
using Data.Common;
using Data.Model;
using Data.ViewModels;
using System;
using System.Collections.ObjectModel;
using System.Linq;
using Windows.UI.Xaml;
using Windows.UI.Xaml.Controls;
using Windows.UI.Xaml.Navigation;
//End of user code

namespace Data.Views
{

    public sealed partial class ImageProductView : Page
    {
        private NavigationHelper navigationHelper;
        private ObservableCollection<ImageProduct> imageProductList;
        private ImageProductDAO imageProduct = new ImageProductDAO();
        
		public ImageProductView()
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


        private void ReadAllImageProduct_Loaded(object sender, RoutedEventArgs e)
        {        
            imageProductList = imageProduct.getAllImageProduct();//Get all DB imageProduct  
            listBoxobj.ItemsSource = imageProductList.OrderByDescending(i => i.Id).ToList();//Binding DB data to LISTBOX and Latest imageProduct ID can Display first.  
            loadedElementsCount();
        }

        private void btnAddImageProduct_click(object sender, RoutedEventArgs e)
        {
            Frame.Navigate(typeof(ImageProductFormNew));
        }

        private void listBoxobj_SelectionChanged(object sender, SelectionChangedEventArgs e)
        {
            if (listBoxobj.SelectedIndex != -1)
            {
                ImageProduct listItem = listBoxobj.SelectedItem as ImageProduct;//Get selected listbox item contact ID 
                Frame.Navigate(typeof(ImageProductFormDeleteUpdate), listItem);
            }
        }

        private void loadedElementsCount()
        {
            txbQuantity.Text = Convert.ToString(imageProductList.Count);//Text should not be empty 
        }


    }
}


