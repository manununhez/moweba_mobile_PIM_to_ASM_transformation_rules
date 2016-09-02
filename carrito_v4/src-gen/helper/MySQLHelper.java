

Data

no tiene persistentEntity

no tiene Mobile Profile::persistentEntity

public class MySQLiteHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "emarket.db";  ##Nombre de la BD ????????
    public static final int DATABASE_VERSION = 1;

    public MySQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        Tools.Logger.i("Creating database " + DATABASE_NAME + "with version " + DATABASE_VERSION);

    }


    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        Tools.Logger.i("Upgrading database " + DATABASE_NAME + "from  version " + oldVersion + "to version" + newVersion);

    }




Carrito de compras

no tiene persistentEntity

no tiene Mobile Profile::persistentEntity

public class MySQLiteHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "emarket.db";  ##Nombre de la BD ????????
    public static final int DATABASE_VERSION = 1;

    public MySQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        Tools.Logger.i("Creating database " + DATABASE_NAME + "with version " + DATABASE_VERSION);

    }


    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        Tools.Logger.i("Upgrading database " + DATABASE_NAME + "from  version " + oldVersion + "to version" + newVersion);

    }




Proveedor de datos

no tiene persistentEntity

no tiene Mobile Profile::persistentEntity

public class MySQLiteHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "emarket.db";  ##Nombre de la BD ????????
    public static final int DATABASE_VERSION = 1;

    public MySQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        Tools.Logger.i("Creating database " + DATABASE_NAME + "with version " + DATABASE_VERSION);

    }


    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        Tools.Logger.i("Upgrading database " + DATABASE_NAME + "from  version " + oldVersion + "to version" + newVersion);

    }




Persistencia

no tiene persistentEntity

no tiene Mobile Profile::persistentEntity

public class MySQLiteHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "emarket.db";  ##Nombre de la BD ????????
    public static final int DATABASE_VERSION = 1;

    public MySQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        Tools.Logger.i("Creating database " + DATABASE_NAME + "with version " + DATABASE_VERSION);

					ShoppingCartTable.onCreate(sqLiteDatabase);
					ProviderTable.onCreate(sqLiteDatabase);
    }


    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        Tools.Logger.i("Upgrading database " + DATABASE_NAME + "from  version " + oldVersion + "to version" + newVersion);
					ShoppingCartTable.onUpgrade(sqLiteDatabase, oldVersion, newVersion);
					ProviderTable.onUpgrade(sqLiteDatabase, oldVersion, newVersion);

    }




UML Standard Profile

no tiene persistentEntity

no tiene Mobile Profile::persistentEntity

public class MySQLiteHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "emarket.db";  ##Nombre de la BD ????????
    public static final int DATABASE_VERSION = 1;

    public MySQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        Tools.Logger.i("Creating database " + DATABASE_NAME + "with version " + DATABASE_VERSION);

    }


    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        Tools.Logger.i("Upgrading database " + DATABASE_NAME + "from  version " + oldVersion + "to version" + newVersion);

    }

