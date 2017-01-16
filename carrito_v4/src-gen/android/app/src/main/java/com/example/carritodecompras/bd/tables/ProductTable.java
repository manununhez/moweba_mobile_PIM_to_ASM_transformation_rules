
package com.example.carritodecompras.bd.tables;


//Start of user code imports
import android.content.ContentResolver;
import android.database.sqlite.SQLiteDatabase;
//End of user code

public class ProductTable {
	private ContentResolver contentResolver;
	
	//    DATABASE TABLE
	public static final String TABLE_NAME = "product"; 
	
	public static final String COLUMN_ID = "_id";
		public static final String COLUMN_PRICE = "price"; 
		public static final String COLUMN_CODE = "code"; 
		public static final String COLUMN_DESCRIPTION = "description"; 
		public static final String COLUMN_TAXPERCENTAGE = "taxPercentage"; 
		public static final String COLUMN_NAME = "name"; 
		public static final String COLUMN_IDPROVIDER = "idProvider"; 
		public static final String COLUMN_IDPRODUCT = "idProduct"; 
		public static final String COLUMN_IDIMAGEPRODUCT = "idImageProduct"; 
	
	//    DATABASE CREATION SQL STATEMENT
	private static final String CREATE_TABLE = "create table "
			+ TABLE_NAME
			+ "("
			+ COLUMN_ID + " integer primary key autoincrement,"
			+ COLUMN_PRICE + " text,"
+ COLUMN_CODE + " integer NOT NULL ,"
+ COLUMN_DESCRIPTION + " text,"
+ COLUMN_TAXPERCENTAGE + " integer,"
+ COLUMN_NAME + " text,"
+ COLUMN_IDPROVIDER + " integer,"
+ COLUMN_IDPRODUCT + " integer NOT NULL ,"
+ COLUMN_IDIMAGEPRODUCT + " integer);";  

	
	public ProductTable(ContentResolver contentResolver) {
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

