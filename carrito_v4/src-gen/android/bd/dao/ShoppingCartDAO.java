//Start of user code imports
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
//End of user code
	
public class ShoppingCartDAO {

	private SQLiteHelper mySQLiteHelper;

		public ShoppingCartDAO(SQLiteHelper mySQLiteHelper) {
			this.mySQLiteHelper = mySQLiteHelper;
		}

		// Adding new ShoppingCart
		public void addShoppingCart(ShoppingCart shoppingCart) {
			SQLiteDatabase db = mySQLiteHelper.getWritableDatabase();

			ContentValues values = new ContentValues();
			values.put(ShoppingCartTable.COLUMN_IDCART, shoppingCart.getIdCart().toString());		
			values.put(ShoppingCartTable.COLUMN_QUANTITY, shoppingCart.getQuantity().toString());		
			values.put(ShoppingCartTable.COLUMN_SYNCTIME, shoppingCart.getSyncTime().toString());		
			
			// Inserting Row
			db.insert(ShoppingCartTable.TABLE_NAME, null, values);
			db.close(); // Closing database connection
		}

		// Getting single ShoppingCart    
		public ShoppingCart getShoppingCart(int id) {   
			SQLiteDatabase db = mySQLiteHelper.getReadableDatabase();

			ShoppingCart shoppingCart = new ShoppingCart();

			Cursor cursor = db.query(ShoppingCartTable.TABLE_NAME, new String[] {
					ShoppingCartTable.COLUMN_IDCART, ShoppingCartTable.COLUMN_QUANTITY, ShoppingCartTable.COLUMN_SYNCTIME
					},	ShoppingCartTable.COLUMN_IDCART + "=?",			
					new String[] { String.valueOf(id) }, null, null, null, null);
			
			if (cursor != null) {
				cursor.moveToFirst();
				
				shoppingCart = new ShoppingCart(
						Integer.parseInt(cursor.getString(0)), Integer.parseInt(cursor.getString(1)), new BigDecimal(cursor.getString(2))				
				); 

				cursor.close();
			}

			return shoppingCart;
		}


			// Getting All ShoppingCart
			public List<ShoppingCart> getAllShoppingCart() {
				SQLiteDatabase db = mySQLiteHelper.getReadableDatabase();

				List<ShoppingCart> shoppingCartList = new ArrayList<ShoppingCart>();
				// Select All Query
				String selectQuery = "SELECT  * FROM " + ShoppingCartTable.TABLE_NAME;

				Cursor cursor = db.rawQuery(selectQuery, null);

				// looping through all rows and adding to list
				if (cursor.moveToFirst()) {
					do {
						ShoppingCart shoppingCart = new ShoppingCart(
						Integer.parseInt(cursor.getString(1)), Integer.parseInt(cursor.getString(2)), new BigDecimal(cursor.getString(3))
						); 
						
						// Adding shoppingCart to list
						 shoppingCartList.add( shoppingCart);
					} while (cursor.moveToNext());
				}

				cursor.close();

				//return shoppingCart list
				return shoppingCartList;
			}



			// Getting shoppingCart Count
			public int getShoppingCartCount() {
				SQLiteDatabase db = mySQLiteHelper.getReadableDatabase();

				String countQuery = "SELECT  * FROM " + ShoppingCartTable.TABLE_NAME;
				Cursor cursor = db.rawQuery(countQuery, null);

				int count = cursor.getCount();

				cursor.close();

				// return count
				return count;
			}


			// Updating single shoppingCart
			public int updateShoppingCart(ShoppingCart shoppingCart) {
				SQLiteDatabase db = mySQLiteHelper.getWritableDatabase();

				ContentValues values = new ContentValues();
				values.put(ShoppingCartTable.COLUMN_IDCART, shoppingCart.getIdCart().toString());		
				values.put(ShoppingCartTable.COLUMN_QUANTITY, shoppingCart.getQuantity().toString());		
				values.put(ShoppingCartTable.COLUMN_SYNCTIME, shoppingCart.getSyncTime().toString());		

				// updating row
				return db.update(ShoppingCartTable.TABLE_NAME, values,
							ShoppingCartTable.COLUMN_IDCART + "=?",
							new String[] { String.valueOf(shoppingCart.getIdCart()) });		
						

			}

			// Deleting single shoppingCart
			public void deleteShoppingCart(ShoppingCart shoppingCart) {
				SQLiteDatabase db = mySQLiteHelper.getWritableDatabase();

				db.delete(ShoppingCartTable.TABLE_NAME,
						ShoppingCartTable.COLUMN_IDCART + "=?",
						new String[] { String.valueOf(shoppingCart.getIdCart()) });		

				db.close();
			}

			// Deleting all shoppingCart
			public void deleteAllShoppingCart() {
				SQLiteDatabase db = mySQLiteHelper.getWritableDatabase();

				db.delete(ShoppingCartTable.TABLE_NAME, null, null);
				db.close();
			}

}
