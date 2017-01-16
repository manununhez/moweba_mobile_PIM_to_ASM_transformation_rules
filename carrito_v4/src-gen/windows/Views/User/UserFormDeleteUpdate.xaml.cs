//Start of user code imports
using CarritoDeCompras.Common;
using CarritoDeCompras.Model;
using System;
using System.Diagnostics;
using System.Globalization;
using Windows.UI.Popups;
using Windows.UI.Xaml;
using Windows.UI.Xaml.Controls;
using Windows.UI.Xaml.Navigation;
using WindowsStore.Common.Storage;
//End of user code

namespace CarritoDeCompras.Views
{

    public sealed partial class UserFormDeleteUpdate : Page
    {
        private NavigationHelper navigationHelper;
        private User selectedUser;

        public UserFormDeleteUpdate()
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
			// Receiving data from the KV pageView
            if (e != null)
            {
				//Fill the form with the received data
                selectedUser = e.Parameter as User;
				if (selectedUser != null)
				{
					rucTbx.Text = selectedUser.ruc;
					mailTbx.Text = selectedUser.mail;
					usernameTbx.Text = selectedUser.username;
					passwordTbx.Text = selectedUser.password;
            	}
			}
        }

        protected override void OnNavigatedFrom(NavigationEventArgs e)
        {
            this.navigationHelper.OnNavigatedFrom(e);
        }

		/*
		* Delete an specific entry from the storemanager
		*/
        private async void btnDelete_click(object sender, RoutedEventArgs e)
        {
		 	try
            {
	            User user = new User(rucTbx.Text, mailTbx.Text, usernameTbx.Text, passwordTbx.Text);
	            StorageManager storage = new StorageManager("dataPersistence", false);
	            storage.Remove("user");
	            Frame.Navigate(typeof(UserView));
			}
            catch (Exception ex)
            {
                await new MessageDialog((ex.Message + " " + ex.StackTrace), "Unknown Error").ShowAsync();
                Debug.WriteLine((ex.Message + " " + ex.StackTrace));
            }

        }
		
		/*
		* Update an specific entry from the storemanager
		*/
        private async void btnUpdate_click(object sender, RoutedEventArgs e)
        {
			try
            {
	            User user = new User(rucTbx.Text, mailTbx.Text, usernameTbx.Text, passwordTbx.Text);
	            StorageManager storage = new StorageManager("dataPersistence", false);
	            storage.Save("user", user);
	            Frame.Navigate(typeof(UserView));
			}
            catch (Exception ex)
            {
                await new MessageDialog((ex.Message + " " + ex.StackTrace), "Unknown Error").ShowAsync();
                Debug.WriteLine((ex.Message + " " + ex.StackTrace));
            }
        }

    }
}

