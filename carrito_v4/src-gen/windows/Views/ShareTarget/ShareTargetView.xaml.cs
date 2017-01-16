//Start of user code imports
using System;
using System.Collections.Generic;
using System.Text;
using Windows.ApplicationModel.DataTransfer;
using Windows.ApplicationModel.DataTransfer.ShareTarget;
using Windows.Storage;
using Windows.Storage.Streams;
using Windows.UI.Popups;
using Windows.UI.Xaml;
using Windows.UI.Xaml.Controls;
using Windows.UI.Xaml.Media.Imaging;
using Windows.UI.Xaml.Navigation;

//End of user code

namespace CarritoDeCompras.Views
{
    public sealed partial class ShareTargetPageView : Page
	{
        ShareOperation operation = null;

        public ShareTargetPageView()
        {
            this.InitializeComponent();
        }

        protected override async void OnNavigatedTo(NavigationEventArgs e)
        {
            operation = (ShareOperation)e.Parameter;

				if (operation.Data.Contains(StandardDataFormats.WebLink)) //URI
	            {
	                var uri = await operation.Data.GetWebLinkAsync();
	                if (uri != null)
	                {
	                    MessageDialog ms = new MessageDialog("WebLink: " + uri.AbsoluteUri);
	                    await ms.ShowAsync();
	                }
	            }	
        }

        private void Button_Click(object sender, RoutedEventArgs e)
        {
            operation.ReportCompleted();
        }
    }
}

