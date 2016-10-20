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
    class ImageProductDAO
    {
        private SQLiteConnection dbConn = new SQLiteConnection(MySQLiteHelper.DbPath);

        // Insert the new imageProduct in the ImageProduct table. 
        public void addImageProduct(ImageProduct imageProduct)
        {
            using (var dbConn = new SQLiteConnection(MySQLiteHelper.DbPath))
            {
                dbConn.RunInTransaction(() =>
                {
                    dbConn.Insert(imageProduct);
                });
            }
        }

		// Retrieve the specific ImageProduct from the database. 
        public ImageProduct getImageProduct(int id)
        {
            using (dbConn)
            {
				var queryResult = dbConn.Query<ImageProduct>("select * from ImageProduct where  =" + id).FirstOrDefault();
                return queryResult;
            }
        }

        // Retrieve the all ImageProduct List from the database. 
        public ObservableCollection<ImageProduct> getAllImageProduct()
        {
            using (dbConn)
            {
                List<ImageProduct> myCollection = dbConn.Table<ImageProduct>().ToList<ImageProduct>();
                ObservableCollection<ImageProduct> imageProductList = new ObservableCollection<ImageProduct>(myCollection);
                return imageProductList;
            }
        }

        // Retrieve the all ImageProduct List from the database and get the Total Rows. 
        public int getImageProductCount()
        {
            using (dbConn)
            {
                 List<ImageProduct> myCollection = dbConn.Table<ImageProduct>().ToList<ImageProduct>();
                ObservableCollection<ImageProduct> imageProductList = new ObservableCollection<ImageProduct>(myCollection);
                return imageProductList.Count;
            }
        }

        //Update existing ImageProduct 
        public void updateImageProduct(ImageProduct imageProduct)
        {
            using (dbConn)
            {
                var queryResult = dbConn.Query<ImageProduct>("select * from ImageProduct where ).FirstOrDefault();
                if (queryResult != null)
                {
					queryResult.idImageProduct = imageProduct.idImageProduct;		
					queryResult.image = imageProduct.image;		

                    dbConn.RunInTransaction(() =>
                    {
                        dbConn.Update(queryResult);
                    });
                }
            }
        }



        //Delete specific ImageProduct 
        public void deleteImageProduct(int id)
        {
            using (var dbConn = new SQLiteConnection(MySQLiteHelper.DbPath))
            {
                var queryResult = dbConn.Query<ImageProduct>("select * from ImageProduct where  =" + id).FirstOrDefault();

                if (queryResult != null)
                {
                    dbConn.RunInTransaction(() =>
                    {
                        dbConn.Delete(queryResult);
                    });
                }
            }
        }
        //Delete all imageProductList or delete ImageProduct table 
        public void deleteAllImageProduct()
        {
            using (var dbConn = new SQLiteConnection(MySQLiteHelper.DbPath))
            {
                //dbConn.RunInTransaction(() => 
                //   { 
                dbConn.DropTable<ImageProduct>();
                dbConn.CreateTable<ImageProduct>();
                dbConn.Dispose();
                dbConn.Close();
                //}); 
            }
        }
    }

}
