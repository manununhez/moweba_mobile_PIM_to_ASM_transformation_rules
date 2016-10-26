//Start of user code imports
using Data.Common;
using Data.Model;
using Windows.UI.Xaml;
using Windows.UI.Xaml.Controls;
using Windows.UI.Xaml.Navigation;
using WindowsStore.Common.Storage;
//End of user code

namespace Data.Views
{

    public sealed partial class UserFormDeleteUpdate : Page
    {
        private NavigationHelper navigationHelper;
        private Model.User selectedUser;

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
            if (e != null)
            {
                selectedUser = e.Parameter as User;
				if (selectedUser != null)
				{
					passwordTbx.Text = selectedUser.password;
					usernameTbx.Text = selectedUser.username;
            	}
			}
        }

        protected override void OnNavigatedFrom(NavigationEventArgs e)
        {
            this.navigationHelper.OnNavigatedFrom(e);
        }

        private void btnDelete_click(object sender, RoutedEventArgs e)
        {
            User user = new User(passwordTbx.Text, usernameTbx.Text);
            StorageManager storage = new StorageManager("dataPersistence", false);
            storage.Remove("user");
            Frame.Navigate(typeof(UserView));

        }

        private void btnUpdate_click(object sender, RoutedEventArgs e)
        {
            User user = new User(passwordTbx.Text, usernameTbx.Text);
            StorageManager storage = new StorageManager("dataPersistence", false);
            storage.Save("user", user);
            Frame.Navigate(typeof(UserView));
        }

    }
}

