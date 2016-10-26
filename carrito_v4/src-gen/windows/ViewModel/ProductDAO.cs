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
    class ProductDAO
    {
        private SQLiteConnection dbConn = new SQLiteConnection(MySQLiteHelper.DbPath);

        // Insert the new product in the Product table. 
        public void addProduct(Product product)
        {
            using (var dbConn = new SQLiteConnection(MySQLiteHelper.DbPath))
            {
                dbConn.RunInTransaction(() =>
                {
                    dbConn.Insert(product);
                });
            }
        }

		// Retrieve the specific Product from the database. 
        public Product getProduct(int id)
        {
            using (dbConn)
            {
				var queryResult = dbConn.Query<Product>("select * from Product where idProducto =" + id).FirstOrDefault();
                return queryResult;
            }
        }

        // Retrieve the all Product List from the database. 
        public ObservableCollection<Product> getAllProduct()
        {
            using (dbConn)
            {
                List<Product> myCollection = dbConn.Table<Product>().ToList<Product>();
                ObservableCollection<Product> productList = new ObservableCollection<Product>(myCollection);
                return productList;
            }
        }

        // Retrieve the all Product List from the database and get the Total Rows. 
        public int getProductCount()
        {
            using (dbConn)
            {
                 List<Product> myCollection = dbConn.Table<Product>().ToList<Product>();
                ObservableCollection<Product> productList = new ObservableCollection<Product>(myCollection);
                return productList.Count;
            }
        }

        //Update existing Product 
        public void updateProduct(Product product)
        {
            using (dbConn)
            {
                var queryResult = dbConn.Query<Product>("select * from Product where idProducto =" + product.idProducto).FirstOrDefault();
                if (queryResult != null)
                {
					queryResult.idProvider = product.idProvider;		
					queryResult.price = product.price;		
					queryResult.description = product.description;		
					queryResult.idProducto = product.idProducto;		
					queryResult.code = product.code;		
					queryResult.name = product.name;		
					queryResult.idImageProduct = product.idImageProduct;		

                    dbConn.RunInTransaction(() =>
                    {
                        dbConn.Update(queryResult);
                    });
                }
            }
        }



        //Delete specific Product 
        public void deleteProduct(int id)
        {
            using (var dbConn = new SQLiteConnection(MySQLiteHelper.DbPath))
            {
                var queryResult = dbConn.Query<Product>("select * from Product where idProducto =" + id).FirstOrDefault();

                if (queryResult != null)
                {
                    dbConn.RunInTransaction(() =>
                    {
                        dbConn.Delete(queryResult);
                    });
                }
            }
        }
        //Delete all productList or delete Product table 
        public void deleteAllProduct()
        {
            using (var dbConn = new SQLiteConnection(MySQLiteHelper.DbPath))
            {
                //dbConn.RunInTransaction(() => 
                //   { 
                dbConn.DropTable<Product>();
                dbConn.CreateTable<Product>();
                dbConn.Dispose();
                dbConn.Close();
                //}); 
            }
        }
    }

}
