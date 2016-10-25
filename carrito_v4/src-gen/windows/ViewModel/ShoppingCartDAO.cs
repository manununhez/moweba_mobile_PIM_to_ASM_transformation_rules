//Start of user code imports
using Data.Common;
using Data.Model;
using SQLite;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Linq;
//End of user code

namespace Data.ViewModels
{
    class ShoppingCartDAO
    {
        private SQLiteConnection dbConn = new SQLiteConnection(MySQLiteHelper.DbPath);

        // Insert the new shoppingCart in the ShoppingCart table. 
        public void addShoppingCart(ShoppingCart shoppingCart)
        {
            using (var dbConn = new SQLiteConnection(MySQLiteHelper.DbPath))
            {
                dbConn.RunInTransaction(() =>
                {
                    dbConn.Insert(shoppingCart);
                });
            }
        }

		// Retrieve the specific ShoppingCart from the database. 
        public ShoppingCart getShoppingCart(int id)
        {
            using (dbConn)
            {
				var queryResult = dbConn.Query<ShoppingCart>("select * from ShoppingCart where idCart =" + id).FirstOrDefault();
                return queryResult;
            }
        }

        // Retrieve the all ShoppingCart List from the database. 
        public ObservableCollection<ShoppingCart> getAllShoppingCart()
        {
            using (dbConn)
            {
                List<ShoppingCart> myCollection = dbConn.Table<ShoppingCart>().ToList<ShoppingCart>();
                ObservableCollection<ShoppingCart> shoppingCartList = new ObservableCollection<ShoppingCart>(myCollection);
                return shoppingCartList;
            }
        }

        // Retrieve the all ShoppingCart List from the database and get the Total Rows. 
        public int getShoppingCartCount()
        {
            using (dbConn)
            {
                 List<ShoppingCart> myCollection = dbConn.Table<ShoppingCart>().ToList<ShoppingCart>();
                ObservableCollection<ShoppingCart> shoppingCartList = new ObservableCollection<ShoppingCart>(myCollection);
                return shoppingCartList.Count;
            }
        }

        //Update existing ShoppingCart 
        public void updateShoppingCart(ShoppingCart shoppingCart)
        {
            using (dbConn)
            {
                var queryResult = dbConn.Query<ShoppingCart>("select * from ShoppingCart where idCart =" + shoppingCart.idCart).FirstOrDefault();
                if (queryResult != null)
                {
					queryResult.syncTime = shoppingCart.syncTime;		
					queryResult.idCart = shoppingCart.idCart;		
					queryResult.quantity = shoppingCart.quantity;		

                    dbConn.RunInTransaction(() =>
                    {
                        dbConn.Update(queryResult);
                    });
                }
            }
        }



        //Delete specific ShoppingCart 
        public void deleteShoppingCart(int id)
        {
            using (var dbConn = new SQLiteConnection(MySQLiteHelper.DbPath))
            {
                var queryResult = dbConn.Query<ShoppingCart>("select * from ShoppingCart where idCart =" + id).FirstOrDefault();

                if (queryResult != null)
                {
                    dbConn.RunInTransaction(() =>
                    {
                        dbConn.Delete(queryResult);
                    });
                }
            }
        }
        //Delete all shoppingCartList or delete ShoppingCart table 
        public void deleteAllShoppingCart()
        {
            using (var dbConn = new SQLiteConnection(MySQLiteHelper.DbPath))
            {
                //dbConn.RunInTransaction(() => 
                //   { 
                dbConn.DropTable<ShoppingCart>();
                dbConn.CreateTable<ShoppingCart>();
                dbConn.Dispose();
                dbConn.Close();
                //}); 
            }
        }
    }

}
