
package com.example.carritodecompras.bd.tables;


//Start of user code imports
import android.content.ContentResolver;
import android.database.sqlite.SQLiteDatabase;
//End of user code

public class ShoppingCartTable {
	private ContentResolver contentResolver;
	
	//    DATABASE TABLE
	public static final String TABLE_NAME = "shoppingCart"; 
	
	public static final String COLUMN_ID = "_id";
		public static final String COLUMN_IDCART = "idCart"; 
		public static final String COLUMN_PRICE = "price"; 
		public static final String COLUMN_QUANTITY = "quantity"; 
		public static final String COLUMN_IDPRODUCT = "idProduct"; 
		public static final String COLUMN_SYNCTIME = "syncTime"; 
	
	//    DATABASE CREATION SQL STATEMENT
	private static final String CREATE_TABLE = "create table "
			+ TABLE_NAME
			+ "("
			+ COLUMN_ID + " integer primary key autoincrement,"
			+ COLUMN_IDCART + " integer NOT NULL ,"
+ COLUMN_PRICE + " text NOT NULL ,"
+ COLUMN_QUANTITY + " integer NOT NULL ,"
+ COLUMN_IDPRODUCT + " integer NOT NULL ,"
+ COLUMN_SYNCTIME + " numeric);";  

	
	public ShoppingCartTable(ContentResolver contentResolver) {
		this.contentResolver = contentResolver;
	}
	
	public static void onCreate(SQLiteDatabase database) {
		database.execSQL(CREATE_TABLE);
	}
	
	public static void onUpgrade(SQLiteDatabase database, int oldVersion, int newVersion) {
		database.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
		onCreate(database);
	}
		
}

