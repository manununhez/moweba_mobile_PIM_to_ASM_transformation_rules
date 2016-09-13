package Carrito de compras.Persistencia

//Start of user code imports
//End of user code
	
public class ShoppingCartDAO {

	private MySQLiteHelper mySQLiteHelper;

		public ShoppingCartDAO(MySQLiteHelper mySQLiteHelper) {
			this.mySQLiteHelper = mySQLiteHelper;
		}

		// Adding new ShoppingCart
		public void addShoppingCart(ShoppingCart shoppingCart) {
			SQLiteDatabase db = mySQLiteHelper.getWritableDatabase();

			ContentValues values = new ContentValues();
			values.put(ProductTable.COLUMN_SYNCTIME, shoppingCart.getSyncTime());		
			values.put(ProductTable.COLUMN_QUANTITY, shoppingCart.getQuantity());		
			values.put(ProductTable.COLUMN_IDCART, shoppingCart.getIdCart());		
			
			// Inserting Row
			db.insert(ProductTable.TABLE_NAME, null, values);
			db.close(); // Closing database connection
		}

		// Getting single ShoppingCart    
		public Product getShoppingCart(int id) {   
			SQLiteDatabase db = mySQLiteHelper.getReadableDatabase();

			ShoppingCart shoppingCart = new ShoppingCart();
			
			Cursor cursor = db.query(ProductTable.TABLET_NAME, new String[ ] {
                    ProductTable.COLUMN_PRODUCTO_ID, ProductTable.COLUMN_NOMBRE,
                    ProductTable.COLUMN_PRECIO,ProductTable.COLUMN_CODIGO,
                    ProductTable.COLUMN_PROVEEDOR_ID},
            ProductTable.COLUMN_PRODUCTO_ID + "=?",
            new String[ ] { String.valueOf(id) }, null, null, null, null);

			Cursor cursor = db.query(ShoppingCartTable.TABLE_NAME, new String[ ] {
						ShoppingCartTable.COLUMN_SYNCTIME		
,						ShoppingCartTable.COLUMN_QUANTITY		
,						ShoppingCartTable.COLUMN_IDCART		
						},
						ShoppingCartTable.COLUMN_IDCART + "=?",		
					new String[ ] { String.valueOf(id) }, null, null, null, null);
			
			if (cursor != null) {
				cursor.moveToFirst();
				
				ShoppingCart shoppingCart = new ShoppingCart(
						cursor.getString(0)
,						cursor.getString(1)
,						Integer.parseInt(cursor.getString(2))
						
				); //TODO la ultima coma no genera bien

				cursor.close();
			}

			return product;
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
						cursor.getString(1)
,						cursor.getString(2)
,						Integer.parseInt(cursor.getString(3))
						
						); //TODO la ultima coma no genera bien
						
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
				values.put(ProductTable.COLUMN_SYNCTIME, shoppingCart.getSyncTime());		
				values.put(ProductTable.COLUMN_QUANTITY, shoppingCart.getQuantity());		
				values.put(ProductTable.COLUMN_IDCART, shoppingCart.getIdCart());		

				// updating row
				return db.update(ShoppingCartTable.TABLE_NAME, values,
							ShoppingCartTable.COLUMN_IDCART + "=?",
							new String[ ] { String.valueOf(shoppingCart.getIdCart()) });		
						

			}

			// Deleting single shoppingCart
			public void deleteShoppingCart(ShoppingCart shoppingCart) {
				SQLiteDatabase db = mySQLiteHelper.getWritableDatabase();

				db.delete(ShoppingCartTable.TABLE_NAME,
						ShoppingCartTable.COLUMN_IDCART + "=?",
						new String[ ] { String.valueOf(shoppingCart.getIdCart()) });		

				db.close();
			}

}
