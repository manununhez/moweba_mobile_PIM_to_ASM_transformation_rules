//Start of user code imports
import android.content.ContentResolver;
import android.database.sqlite.SQLiteDatabase;
//End of user code

public class UserTable {
	private ContentResolver contentResolver;
	
	//    DATABASE TABLE
	public static final String TABLE_NAME = "user"; 
	
	public static final String COLUMN_ID = "_id";
		public static final String COLUMN_PASSWORD = "password"; 
		public static final String COLUMN_USERNAME = "username"; 
	
	//    DATABASE CREATION SQL STATEMENT
	private static final String CREATE_TABLE = "create table "
			+ TABLE_NAME
			+ "("
			+ COLUMN_ID + " integer primary key autoincrement,"
			+ COLUMN_PASSWORD + " text,"
+ COLUMN_USERNAME + " text);";  

	
	public UserTable(ContentResolver contentResolver) {
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

