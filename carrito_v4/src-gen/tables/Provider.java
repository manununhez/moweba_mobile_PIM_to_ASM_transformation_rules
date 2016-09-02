public class ProviderTable {
		private ContentResolver contentResolver;
		
		//    DATABASE TABLE
		public static final String TABLE_NAME = "provider";   -- CamelCase

		public static final String COLUMN_ID = "_id";
			public static final String COLUMN_NOMBRE = "nombre" --camelcase
			public static final String COLUMN_IDPROVIDER = "idProvider" --camelcase
			public static final String COLUMN_DESCRIPTION = "description" --camelcase
			public static final String COLUMN_RUC = "ruc" --camelcase

		//    DATABASE CREATION SQL STATEMENT
		private static final String CREATE_TABLE = "create table "
				+ TABLET_NAME
				+ "("
				+ COLUMN_ID + " integer primary key autoincrement,"
				+ COLUMN_NOMBRE + " String (aca se hace el IF para machear los tipos de datos) <EntityName>.<Atributo>(i).not null (y otras propiedades) ,"
				+ COLUMN_IDPROVIDER + " String (aca se hace el IF para machear los tipos de datos) <EntityName>.<Atributo>(i).not null (y otras propiedades) ,"
				+ COLUMN_DESCRIPTION + " String (aca se hace el IF para machear los tipos de datos) <EntityName>.<Atributo>(i).not null (y otras propiedades) ,"
				+ COLUMN_RUC + " String (aca se hace el IF para machear los tipos de datos) <EntityName>.<Atributo>(i).not null (y otras propiedades) ,"
				+ ");";

		public ProviderTable(ContentResolver contentResolver) {
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
