//Start of user code imports
import android.content.ContentResolver;
import android.database.sqlite.SQLiteDatabase;
//End of user code

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
			+ COLUMN_SYNCTIME + " numeric NOT NULL ,"
+ COLUMN_QUANTITY + " integer NOT NULL ,"
+ COLUMN_IDCART + " integer NOT NULL  UNIQUE  DEFAULT Prueba  CHECK (idCart > 0));";  

	
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

