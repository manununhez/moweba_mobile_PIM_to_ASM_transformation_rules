//Start of user code imports
using System;
using System.Diagnostics;
using System.IO;
using System.Threading.Tasks;
using CarritoDeCompras.Model;
using Windows.Storage;
using Windows.UI.Popups;
//End of user code

namespace CarritoDeCompras.Common
{
    class SQLiteHelper
    {
        //Database name
        public static string DbName = "persistencia.sqlite";

        //Full Database Path
        public static string DbPath = Path.Combine(ApplicationData.Current.LocalFolder.Path, DbName);

        public async static Task<bool> Createdatabase()
        {
            var result = await Checkdatabase();
            if (!result)
            {
                //Creating a database
                var connection = new SQLite.SQLiteConnection(DbPath);
                {
                    //Creating a table
                    connection.RunInTransaction(() =>
                    {
					connection.CreateTable<Product>();
					connection.CreateTable<ShoppingCart>();
					connection.CreateTable<Provider>();
                    });
                }

                connection.Close();
                Debug.WriteLine("Base de datos creada correctamente.");
                return true;
            }
            else
            {
                Debug.WriteLine("Error al crear la base de datos.");
                return false;
            }
        }

        public static async Task<bool> Checkdatabase()
        {
            var dbexist = true;
            try
            {
                var storageFile = await ApplicationData.Current.LocalFolder.GetFileAsync(DbName);
                if (storageFile == null) dbexist = false;
            }
            catch (Exception ex)
            {
                await new MessageDialog((ex.Message + " " + ex.StackTrace), "Unknown Error").ShowAsync();
                Debug.WriteLine((ex.Message + " " + ex.StackTrace));
                dbexist = false;
            }

            return dbexist;
        }


        public static async Task<bool> DeleteDatabase()
        {
            try
            {
                var storageFile = await StorageFile.GetFileFromPathAsync(DbPath);
                await storageFile.DeleteAsync(StorageDeleteOption.PermanentDelete);
                return true;
            }
            catch (Exception ex)
            {
                await new MessageDialog((ex.Message + " " + ex.StackTrace), "Unknown Error").ShowAsync();
                Debug.WriteLine((ex.Message + " " + ex.StackTrace));
            }
            return false;
        }

    }
}
