
package com.example.carritodecompras.bd.tables;


//Start of user code imports
import android.content.ContentResolver;
import android.database.sqlite.SQLiteDatabase;
//End of user code

public class ProviderTable {
	private ContentResolver contentResolver;
	
	//    DATABASE TABLE
	public static final String TABLE_NAME = "provider"; 
	
	public static final String COLUMN_ID = "_id";
		public static final String COLUMN_DESCRIPTION = "description"; 
		public static final String COLUMN_IDPROVIDER = "idProvider"; 
		public static final String COLUMN_RUC = "ruc"; 
		public static final String COLUMN_NOMBRE = "nombre"; 
	
	//    DATABASE CREATION SQL STATEMENT
	private static final String CREATE_TABLE = "create table "
			+ TABLE_NAME
			+ "("
			+ COLUMN_ID + " integer primary key autoincrement,"
			+ COLUMN_DESCRIPTION + " text,"
+ COLUMN_IDPROVIDER + " integer NOT NULL ,"
+ COLUMN_RUC + " text,"
+ COLUMN_NOMBRE + " text);";  

	
	public ProviderTable(ContentResolver contentResolver) {
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
