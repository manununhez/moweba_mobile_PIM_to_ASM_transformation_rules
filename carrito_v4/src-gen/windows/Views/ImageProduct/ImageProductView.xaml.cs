//Start of user code imports
using CarritoDeCompras.Common;
using System;
using Windows.UI.Xaml;
using Windows.UI.Xaml.Controls;
using Windows.UI.Xaml.Navigation;
//End of user code

namespace CarritoDeCompras.Views
{

    public sealed partial class ImageProductView : Page
    {
        private NavigationHelper navigationHelper;
        private string FILENAME = "ImageProductFile.txt";

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
		
		/*
		* Writing data in file.
		*	Data Format: <data1> , <data2>, <data3>, so on...
		*/
        private async void btnWriteFile_Click(object sender, RoutedEventArgs e)
        {
			String content = imageTbx.Text + "," + idImageProductTbx.Text;
            await FilesHelper.WriteTextFile(FILENAME, content);
        }
		
		/*
		* Reading data from file
		*/
        private async void btnReadFile_Click(object sender, RoutedEventArgs e)
        {
            ResultTbx.Text = await FilesHelper.ReadTextFile(FILENAME);
        }
    }
}
