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

namespace Data.Views
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

				if (operation.Data.Contains(StandardDataFormats.Bitmap)) { //Image
	                IRandomAccessStreamReference sharedBitmapStream = await operation.Data.GetBitmapAsync();
	                IRandomAccessStreamWithContentType bitmapStream = await sharedBitmapStream.OpenReadAsync();
	                BitmapImage bitmapImage = new BitmapImage();
	                bitmapImage.SetSource(bitmapStream);
	                MessageDialog ms = new MessageDialog("Image:" + bitmapStream);
	                await ms.ShowAsync();
            	}
				if (operation.Data.Contains(StandardDataFormats.WebLink)) //URI
	            {
	                var uri = await operation.Data.GetWebLinkAsync();
	                if (uri != null)
	                {
	                    MessageDialog ms = new MessageDialog("WebLink: " + uri.AbsoluteUri);
	                    await ms.ShowAsync();
	                }
	            }	
				if (operation.Data.Contains(StandardDataFormats.StorageItems)) //Files being shared
	            {
	                IReadOnlyList<IStorageItem> sharedStorageItems = await operation.Data.GetStorageItemsAsync();
	                StringBuilder fileNames = new StringBuilder();
	                for (int index = 0; index < sharedStorageItems.Count; index++)
	                {
	                    fileNames.Append(sharedStorageItems[index].Name);
	                    if (index < sharedStorageItems.Count - 1)
	                    {
	                        fileNames.Append(", ");
	                    }
	                }
	                fileNames.Append(".");
	
	                MessageDialog ms = new MessageDialog("StorageItems: " + fileNames.ToString());
	                await ms.ShowAsync();
	            }
				if (operation.Data.Contains(StandardDataFormats.Text))//Text
	            {
	                MessageDialog ms = new MessageDialog("Text:" + await operation.Data.GetTextAsync());
	                await ms.ShowAsync();
	            }
        }

        private void Button_Click(object sender, RoutedEventArgs e)
        {
            operation.ReportCompleted();
        }
    }
}
