public class ShoppingCartTable {
		private ContentResolver contentResolver;
		
		//    DATABASE TABLE
		public static final String TABLE_NAME = "shoppingCart";   -- CamelCase

		public static final String COLUMN_ID = "_id";
			public static final String COLUMN_ID = "id" --camelcase
			public static final String COLUMN_QUANTITY = "quantity" --camelcase
			public static final String COLUMN_SYNCTIME = "syncTime" --camelcase
			public static final String COLUMN_IDPRODUCT = "idProduct" --camelcase

		//    DATABASE CREATION SQL STATEMENT
		private static final String CREATE_TABLE = "create table "
				+ TABLET_NAME
				+ "("
				+ COLUMN_ID + " integer primary key autoincrement,"
				+ COLUMN_ID + " String (aca se hace el IF para machear los tipos de datos) <EntityName>.<Atributo>(i).not null (y otras propiedades) ,"
				+ COLUMN_QUANTITY + " String (aca se hace el IF para machear los tipos de datos) <EntityName>.<Atributo>(i).not null (y otras propiedades) ,"
				+ COLUMN_SYNCTIME + " String (aca se hace el IF para machear los tipos de datos) <EntityName>.<Atributo>(i).not null (y otras propiedades) ,"
				+ COLUMN_IDPRODUCT + " String (aca se hace el IF para machear los tipos de datos) <EntityName>.<Atributo>(i).not null (y otras propiedades) ,"
				+ ");";

		public ShoppingCartTable(ContentResolver contentResolver) {
			this.contentResolver = contentResolver;
		}

		public static void onCreate(SQLiteDatabase database) {
			database.execSQL(CREATE_TABLE);
		}

		public static void onUpgrade(SQLiteDatabase database, int oldVersion, int newVersion) {
			database.execSQL("DROP TABLE IF EXISTS " + TABLET_NAME);
			onCreate(database);
		}
		
}
