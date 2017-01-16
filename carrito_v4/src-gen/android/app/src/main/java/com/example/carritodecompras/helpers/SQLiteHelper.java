
package com.example.carritodecompras.helpers;

//Start of user code imports
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.carritodecompras.bd.tables.ProviderTable;
import com.example.carritodecompras.bd.tables.ShoppingCartTable;
import com.example.carritodecompras.bd.tables.ProductTable;

//End of user code
	

public class SQLiteHelper extends SQLiteOpenHelper {
    
	public static final String TAG = "Tag"; 
    public static final String DATABASE_NAME = "persistencia.db";  
    public static final int DATABASE_VERSION = 1;

    public SQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        Log.d(TAG,"Creating database " + DATABASE_NAME + "with version " + DATABASE_VERSION);
		ProviderTable.onCreate(sqLiteDatabase);
		ShoppingCartTable.onCreate(sqLiteDatabase);
		ProductTable.onCreate(sqLiteDatabase);
    }


    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        Log.d(TAG,"Upgrading database " + DATABASE_NAME + "from  version " + oldVersion + "to version" + newVersion);
		ProviderTable.onUpgrade(sqLiteDatabase, oldVersion, newVersion);
		ShoppingCartTable.onUpgrade(sqLiteDatabase, oldVersion, newVersion);
		ProductTable.onUpgrade(sqLiteDatabase, oldVersion, newVersion);
    }
}
