//Start of user code imports
using System;
using System.IO;
using System.Threading.Tasks;
using Windows.Storage;
//End of user code

namespace Data.Common
{
    class MySQLiteHelper
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
					connection.CreateTable<Model.ShoppingCart>();
					connection.CreateTable<Model.Provider>();
					connection.CreateTable<Model.ImageProduct>();
                    });
                }

                connection.Close();
                return true;
            }
            else
                return false;
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
            }
            return false;
        }

    }
}

