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
    class ProductDAO
    {
        private SQLiteConnection dbConn = new SQLiteConnection(SQLiteHelper.DbPath);

        // Insert the new product in the Product table. 
        public void addProduct(Product product)
        {
            using (dbConn)
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
                var queryResult = dbConn.Query<Product>("select * from Product where idProducto = "+ product.idProducto).FirstOrDefault();
                if (queryResult != null)
                {
					queryResult.description = product.description;		
					queryResult.idProducto = product.idProducto;		
					queryResult.name = product.name;		
					queryResult.idProvider = product.idProvider;		
					queryResult.idImageProduct = product.idImageProduct;		
					queryResult.price = product.price;		
					queryResult.code = product.code;		

                    dbConn.RunInTransaction(() =>
                    {
                        dbConn.Update(queryResult);
                    });
                }
            }
        }



        //Delete specific Product 
        public void deleteProduct(Product product)
        {
            using (dbConn)
            {
                var queryResult = dbConn.Query<Product>("select * from Product where idProducto = "+ product.idProducto).FirstOrDefault();

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
            using (dbConn)
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
