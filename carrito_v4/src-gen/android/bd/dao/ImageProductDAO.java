//Start of user code imports
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;
//End of user code
	
public class ImageProductDAO {

	private MySQLiteHelper mySQLiteHelper;

		public ImageProductDAO(MySQLiteHelper mySQLiteHelper) {
			this.mySQLiteHelper = mySQLiteHelper;
		}

		// Adding new ImageProduct
		public void addImageProduct(ImageProduct imageProduct) {
			SQLiteDatabase db = mySQLiteHelper.getWritableDatabase();

			ContentValues values = new ContentValues();
			values.put(ImageProductTable.COLUMN_IDIMAGEPRODUCT, imageProduct.getIdImageProduct());		
			values.put(ImageProductTable.COLUMN_IMAGE, imageProduct.getImage());		
			
			// Inserting Row
			db.insert(ImageProductTable.TABLE_NAME, null, values);
			db.close(); // Closing database connection
		}

		// Getting single ImageProduct    
		public ImageProduct getImageProduct(int id) {   
			SQLiteDatabase db = mySQLiteHelper.getReadableDatabase();

			ImageProduct imageProduct = new ImageProduct();

			Cursor cursor = db.query(ImageProductTable.TABLE_NAME, new String[] {
					ImageProductTable.COLUMN_IDIMAGEPRODUCT, ImageProductTable.COLUMN_IMAGE
					},		
					new String[] { String.valueOf(id) }, null, null, null, null);
			
			if (cursor != null) {
				cursor.moveToFirst();
				
				imageProduct = new ImageProduct(
						cursor.getString(0), cursor.getString(1)				
				); 

				cursor.close();
			}

			return imageProduct;
		}


			// Getting All ImageProduct
			public List<ImageProduct> getAllImageProduct() {
				SQLiteDatabase db = mySQLiteHelper.getReadableDatabase();

				List<ImageProduct> imageProductList = new ArrayList<ImageProduct>();
				// Select All Query
				String selectQuery = "SELECT  * FROM " + ImageProductTable.TABLE_NAME;

				Cursor cursor = db.rawQuery(selectQuery, null);

				// looping through all rows and adding to list
				if (cursor.moveToFirst()) {
					do {
						ImageProduct imageProduct = new ImageProduct(
						cursor.getString(1), cursor.getString(2)
						); 
						
						// Adding imageProduct to list
						 imageProductList.add( imageProduct);
					} while (cursor.moveToNext());
				}

				cursor.close();

				//return imageProduct list
				return imageProductList;
			}



			// Getting imageProduct Count
			public int getImageProductCount() {
				SQLiteDatabase db = mySQLiteHelper.getReadableDatabase();

				String countQuery = "SELECT  * FROM " + ImageProductTable.TABLE_NAME;
				Cursor cursor = db.rawQuery(countQuery, null);

				int count = cursor.getCount();

				cursor.close();

				// return count
				return count;
			}


			// Updating single imageProduct
			public int updateImageProduct(ImageProduct imageProduct) {
				SQLiteDatabase db = mySQLiteHelper.getWritableDatabase();

				ContentValues values = new ContentValues();
				values.put(ImageProductTable.COLUMN_IDIMAGEPRODUCT, imageProduct.getIdImageProduct());		
				values.put(ImageProductTable.COLUMN_IMAGE, imageProduct.getImage());		

				// updating row
				return db.update(ImageProductTable.TABLE_NAME, values,
						

			}

			// Deleting single imageProduct
			public void deleteImageProduct(ImageProduct imageProduct) {
				SQLiteDatabase db = mySQLiteHelper.getWritableDatabase();

				db.delete(ImageProductTable.TABLE_NAME,

				db.close();
			}

			// Deleting all imageProduct
			public void deleteAllImageProduct() {
				SQLiteDatabase db = mySQLiteHelper.getWritableDatabase();

				db.delete(ImageProductTable.TABLE_NAME, null, null);
				db.close();
			}

}
