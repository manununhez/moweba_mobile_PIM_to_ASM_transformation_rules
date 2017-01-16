
package com.example.carritodecompras.bd.dao;//Start of user code imports

//Start of user code imports
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.carritodecompras.bd.tables.ProviderTable;
import com.example.carritodecompras.beans.Provider;
import com.example.carritodecompras.helpers.SQLiteHelper;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
//End of user code
	
public class ProviderDAO {

	private SQLiteHelper mySQLiteHelper;

		public ProviderDAO(SQLiteHelper mySQLiteHelper) {
			this.mySQLiteHelper = mySQLiteHelper;
		}

		// Adding new Provider
		public void addProvider(Provider provider) {
			SQLiteDatabase db = mySQLiteHelper.getWritableDatabase();

			ContentValues values = new ContentValues();
			values.put(ProviderTable.COLUMN_DESCRIPTION, provider.getDescription().toString());		
			values.put(ProviderTable.COLUMN_IDPROVIDER, provider.getIdProvider().toString());		
			values.put(ProviderTable.COLUMN_RUC, provider.getRuc().toString());		
			values.put(ProviderTable.COLUMN_NOMBRE, provider.getNombre().toString());		
			
			// Inserting Row
			db.insert(ProviderTable.TABLE_NAME, null, values);
			db.close(); // Closing database connection
		}

		// Getting single Provider    
		public Provider getProvider(int id) {   
			SQLiteDatabase db = mySQLiteHelper.getReadableDatabase();

			Provider provider = new Provider();

			Cursor cursor = db.query(ProviderTable.TABLE_NAME, new String[] {
					ProviderTable.COLUMN_DESCRIPTION, ProviderTable.COLUMN_IDPROVIDER, ProviderTable.COLUMN_RUC, ProviderTable.COLUMN_NOMBRE
					},		ProviderTable.COLUMN_IDPROVIDER + "=?",			
					new String[] { String.valueOf(id) }, null, null, null, null);
			
			if (cursor != null) {
				cursor.moveToFirst();
				
				provider = new Provider(
						cursor.getString(0), Integer.parseInt(cursor.getString(1)), cursor.getString(2), cursor.getString(3)				
				); 

				cursor.close();
			}

			return provider;
		}


		// Getting All Provider
		public List<Provider> getAllProvider() {
			SQLiteDatabase db = mySQLiteHelper.getReadableDatabase();

			List<Provider> providerList = new ArrayList<Provider>();
			// Select All Query
			String selectQuery = "SELECT  * FROM " + ProviderTable.TABLE_NAME;

			Cursor cursor = db.rawQuery(selectQuery, null);

			// looping through all rows and adding to list
			if (cursor.moveToFirst()) {
				do {
					Provider provider = new Provider(
					cursor.getString(1), Integer.parseInt(cursor.getString(2)), cursor.getString(3), cursor.getString(4)
					); 
					
					// Adding provider to list
					 providerList.add( provider);
				} while (cursor.moveToNext());
			}

			cursor.close();

			//return provider list
			return providerList;
		}



		// Getting provider Count
		public int getProviderCount() {
			SQLiteDatabase db = mySQLiteHelper.getReadableDatabase();

			String countQuery = "SELECT  * FROM " + ProviderTable.TABLE_NAME;
			Cursor cursor = db.rawQuery(countQuery, null);

			int count = cursor.getCount();

			cursor.close();

			// return count
			return count;
		}


		// Updating single provider
		public int updateProvider(Provider provider) {
			SQLiteDatabase db = mySQLiteHelper.getWritableDatabase();

			ContentValues values = new ContentValues();
			values.put(ProviderTable.COLUMN_DESCRIPTION, provider.getDescription().toString());		
			values.put(ProviderTable.COLUMN_IDPROVIDER, provider.getIdProvider().toString());		
			values.put(ProviderTable.COLUMN_RUC, provider.getRuc().toString());		
			values.put(ProviderTable.COLUMN_NOMBRE, provider.getNombre().toString());		

			// updating row
			return db.update(ProviderTable.TABLE_NAME, values,
						ProviderTable.COLUMN_IDPROVIDER + "=?",
						new String[] { String.valueOf(provider.getIdProvider()) });		
					

		}

		// Deleting single provider
		public void deleteProvider(Provider provider) {
			SQLiteDatabase db = mySQLiteHelper.getWritableDatabase();

			db.delete(ProviderTable.TABLE_NAME,
					ProviderTable.COLUMN_IDPROVIDER + "=?",
					new String[] { String.valueOf(provider.getIdProvider()) });		

			db.close();
		}

		// Deleting all provider
		public void deleteAllProvider() {
			SQLiteDatabase db = mySQLiteHelper.getWritableDatabase();

			db.delete(ProviderTable.TABLE_NAME, null, null);
			db.close();
		}

}
