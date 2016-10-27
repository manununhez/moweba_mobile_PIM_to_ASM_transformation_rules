//Start of user code imports
using CarritoDeCompras.Common;
using CarritoDeCompras.Model;
using SQLite;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Linq;
//End of user code

namespace CarritoDeCompras.ViewModels
{
    class ProviderDAO
    {
        private SQLiteConnection dbConn = new SQLiteConnection(MySQLiteHelper.DbPath);

        // Insert the new provider in the Provider table. 
        public void addProvider(Provider provider)
        {
            using (var dbConn = new SQLiteConnection(MySQLiteHelper.DbPath))
            {
                dbConn.RunInTransaction(() =>
                {
                    dbConn.Insert(provider);
                });
            }
        }

		// Retrieve the specific Provider from the database. 
        public Provider getProvider(int id)
        {
            using (dbConn)
            {
				var queryResult = dbConn.Query<Provider>("select * from Provider where idProvider =" + id).FirstOrDefault();
                return queryResult;
            }
        }

        // Retrieve the all Provider List from the database. 
        public ObservableCollection<Provider> getAllProvider()
        {
            using (dbConn)
            {
                List<Provider> myCollection = dbConn.Table<Provider>().ToList<Provider>();
                ObservableCollection<Provider> providerList = new ObservableCollection<Provider>(myCollection);
                return providerList;
            }
        }

        // Retrieve the all Provider List from the database and get the Total Rows. 
        public int getProviderCount()
        {
            using (dbConn)
            {
                 List<Provider> myCollection = dbConn.Table<Provider>().ToList<Provider>();
                ObservableCollection<Provider> providerList = new ObservableCollection<Provider>(myCollection);
                return providerList.Count;
            }
        }

        //Update existing Provider 
        public void updateProvider(Provider provider)
        {
            using (dbConn)
            {
                var queryResult = dbConn.Query<Provider>("select * from Provider where idProvider = "+ provider.idProvider).FirstOrDefault();
                if (queryResult != null)
                {
					queryResult.idProvider = provider.idProvider;		
					queryResult.ruc = provider.ruc;		
					queryResult.description = provider.description;		
					queryResult.nombre = provider.nombre;		

                    dbConn.RunInTransaction(() =>
                    {
                        dbConn.Update(queryResult);
                    });
                }
            }
        }



        //Delete specific Provider 
        public void deleteProvider(Provider provider)
        {
            using (var dbConn = new SQLiteConnection(MySQLiteHelper.DbPath))
            {
                var queryResult = dbConn.Query<Provider>("select * from Provider where idProvider = "+ provider.idProvider).FirstOrDefault();

                if (queryResult != null)
                {
                    dbConn.RunInTransaction(() =>
                    {
                        dbConn.Delete(queryResult);
                    });
                }
            }
        }
        //Delete all providerList or delete Provider table 
        public void deleteAllProvider()
        {
            using (var dbConn = new SQLiteConnection(MySQLiteHelper.DbPath))
            {
                //dbConn.RunInTransaction(() => 
                //   { 
                dbConn.DropTable<Provider>();
                dbConn.CreateTable<Provider>();
                dbConn.Dispose();
                dbConn.Close();
                //}); 
            }
        }
    }

}
