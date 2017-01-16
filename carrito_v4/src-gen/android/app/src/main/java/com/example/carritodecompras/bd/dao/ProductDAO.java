
package com.example.carritodecompras.bd.dao;//Start of user code imports

//Start of user code imports
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.carritodecompras.bd.tables.ProductTable;
import com.example.carritodecompras.beans.Product;
import com.example.carritodecompras.helpers.SQLiteHelper;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
//End of user code
	
public class ProductDAO {

	private SQLiteHelper mySQLiteHelper;

		public ProductDAO(SQLiteHelper mySQLiteHelper) {
			this.mySQLiteHelper = mySQLiteHelper;
		}

		// Adding new Product
		public void addProduct(Product product) {
			SQLiteDatabase db = mySQLiteHelper.getWritableDatabase();

			ContentValues values = new ContentValues();
			values.put(ProductTable.COLUMN_PRICE, product.getPrice().toString());		
			values.put(ProductTable.COLUMN_CODE, product.getCode().toString());		
			values.put(ProductTable.COLUMN_DESCRIPTION, product.getDescription().toString());		
			values.put(ProductTable.COLUMN_TAXPERCENTAGE, product.getTaxPercentage().toString());		
			values.put(ProductTable.COLUMN_NAME, product.getName().toString());		
			values.put(ProductTable.COLUMN_IDPROVIDER, product.getIdProvider().toString());		
			values.put(ProductTable.COLUMN_IDPRODUCT, product.getIdProduct().toString());		
			values.put(ProductTable.COLUMN_IDIMAGEPRODUCT, product.getIdImageProduct().toString());		
			
			// Inserting Row
			db.insert(ProductTable.TABLE_NAME, null, values);
			db.close(); // Closing database connection
		}

		// Getting single Product    
		public Product getProduct(int id) {   
			SQLiteDatabase db = mySQLiteHelper.getReadableDatabase();

			Product product = new Product();

			Cursor cursor = db.query(ProductTable.TABLE_NAME, new String[] {
					ProductTable.COLUMN_PRICE, ProductTable.COLUMN_CODE, ProductTable.COLUMN_DESCRIPTION, ProductTable.COLUMN_TAXPERCENTAGE, ProductTable.COLUMN_NAME, ProductTable.COLUMN_IDPROVIDER, ProductTable.COLUMN_IDPRODUCT, ProductTable.COLUMN_IDIMAGEPRODUCT
					},							ProductTable.COLUMN_IDPRODUCT + "=?",		
					new String[] { String.valueOf(id) }, null, null, null, null);
			
			if (cursor != null) {
				cursor.moveToFirst();
				
				product = new Product(
						cursor.getString(0), Integer.parseInt(cursor.getString(1)), cursor.getString(2), Integer.parseInt(cursor.getString(3)), cursor.getString(4), Integer.parseInt(cursor.getString(5)), Integer.parseInt(cursor.getString(6)), Integer.parseInt(cursor.getString(7))				
				); 

				cursor.close();
			}

			return product;
		}


		// Getting All Product
		public List<Product> getAllProduct() {
			SQLiteDatabase db = mySQLiteHelper.getReadableDatabase();

			List<Product> productList = new ArrayList<Product>();
			// Select All Query
			String selectQuery = "SELECT  * FROM " + ProductTable.TABLE_NAME;

			Cursor cursor = db.rawQuery(selectQuery, null);

			// looping through all rows and adding to list
			if (cursor.moveToFirst()) {
				do {
					Product product = new Product(
					cursor.getString(1), Integer.parseInt(cursor.getString(2)), cursor.getString(3), Integer.parseInt(cursor.getString(4)), cursor.getString(5), Integer.parseInt(cursor.getString(6)), Integer.parseInt(cursor.getString(7)), Integer.parseInt(cursor.getString(8))
					); 
					
					// Adding product to list
					 productList.add( product);
				} while (cursor.moveToNext());
			}

			cursor.close();

			//return product list
			return productList;
		}



		// Getting product Count
		public int getProductCount() {
			SQLiteDatabase db = mySQLiteHelper.getReadableDatabase();

			String countQuery = "SELECT  * FROM " + ProductTable.TABLE_NAME;
			Cursor cursor = db.rawQuery(countQuery, null);

			int count = cursor.getCount();

			cursor.close();

			// return count
			return count;
		}


		// Updating single product
		public int updateProduct(Product product) {
			SQLiteDatabase db = mySQLiteHelper.getWritableDatabase();

			ContentValues values = new ContentValues();
			values.put(ProductTable.COLUMN_PRICE, product.getPrice().toString());		
			values.put(ProductTable.COLUMN_CODE, product.getCode().toString());		
			values.put(ProductTable.COLUMN_DESCRIPTION, product.getDescription().toString());		
			values.put(ProductTable.COLUMN_TAXPERCENTAGE, product.getTaxPercentage().toString());		
			values.put(ProductTable.COLUMN_NAME, product.getName().toString());		
			values.put(ProductTable.COLUMN_IDPROVIDER, product.getIdProvider().toString());		
			values.put(ProductTable.COLUMN_IDPRODUCT, product.getIdProduct().toString());		
			values.put(ProductTable.COLUMN_IDIMAGEPRODUCT, product.getIdImageProduct().toString());		

			// updating row
			return db.update(ProductTable.TABLE_NAME, values,
						ProductTable.COLUMN_IDPRODUCT + "=?",
						new String[] { String.valueOf(product.getIdProduct()) });		
					

		}

		// Deleting single product
		public void deleteProduct(Product product) {
			SQLiteDatabase db = mySQLiteHelper.getWritableDatabase();

			db.delete(ProductTable.TABLE_NAME,
					ProductTable.COLUMN_IDPRODUCT + "=?",
					new String[] { String.valueOf(product.getIdProduct()) });		

			db.close();
		}

		// Deleting all product
		public void deleteAllProduct() {
			SQLiteDatabase db = mySQLiteHelper.getWritableDatabase();

			db.delete(ProductTable.TABLE_NAME, null, null);
			db.close();
		}

}
