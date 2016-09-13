package Carrito de compras.Persistencia

import android.content.ContentResolver;
import android.database.sqlite.SQLiteDatabase;


public class ShoppingCartTable {
	private ContentResolver contentResolver;
	
	//    DATABASE TABLE
	public static final String TABLE_NAME = "shoppingCart"; 
	
	public static final String COLUMN_ID = "_id";
		public static final String COLUMN_SYNCTIME = "syncTime"; 
		public static final String COLUMN_QUANTITY = "quantity"; 
		public static final String COLUMN_IDCART = "idCart"; 
	
	//    DATABASE CREATION SQL STATEMENT
	private static final String CREATE_TABLE = "create table "
			+ TABLE_NAME
			+ "("
			+ COLUMN_ID + " integer primary key autoincrement,"
			+ COLUMN_SYNCTIME + "text(1) 
," 			+ COLUMN_QUANTITY + "text(1) 
," 			+ COLUMN_IDCART + "integer(1) NOT NULL UNIQUE DEFAULT Prueba CHECK (asdasd)
"			+ ");";  //TODO no genera bien la ultima coma

	
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

