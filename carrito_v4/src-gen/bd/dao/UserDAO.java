//Start of user code imports
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;
//End of user code
	
public class UserDAO {

	private MySQLiteHelper mySQLiteHelper;

		public UserDAO(MySQLiteHelper mySQLiteHelper) {
			this.mySQLiteHelper = mySQLiteHelper;
		}

		// Adding new User
		public void addUser(User user) {
			SQLiteDatabase db = mySQLiteHelper.getWritableDatabase();

			ContentValues values = new ContentValues();
			values.put(UserTable.COLUMN_USERNAME, user.getUsername());		
			values.put(UserTable.COLUMN_PASSWORD, user.getPassword());		
			
			// Inserting Row
			db.insert(UserTable.TABLE_NAME, null, values);
			db.close(); // Closing database connection
		}

		// Getting single User    
		public User getUser(int id) {   
			SQLiteDatabase db = mySQLiteHelper.getReadableDatabase();

			User user = new User();

			Cursor cursor = db.query(UserTable.TABLE_NAME, new String[] {
					UserTable.COLUMN_USERNAME, UserTable.COLUMN_PASSWORD
					},		
					new String[] { String.valueOf(id) }, null, null, null, null);
			
			if (cursor != null) {
				cursor.moveToFirst();
				
				user = new User(
						cursor.getString(0), cursor.getString(1)				
				); 

				cursor.close();
			}

			return user;
		}


			// Getting All User
			public List<User> getAllUser() {
				SQLiteDatabase db = mySQLiteHelper.getReadableDatabase();

				List<User> userList = new ArrayList<User>();
				// Select All Query
				String selectQuery = "SELECT  * FROM " + UserTable.TABLE_NAME;

				Cursor cursor = db.rawQuery(selectQuery, null);

				// looping through all rows and adding to list
				if (cursor.moveToFirst()) {
					do {
						User user = new User(
						cursor.getString(1), cursor.getString(2)
						); 
						
						// Adding user to list
						 userList.add( user);
					} while (cursor.moveToNext());
				}

				cursor.close();

				//return user list
				return userList;
			}



			// Getting user Count
			public int getUserCount() {
				SQLiteDatabase db = mySQLiteHelper.getReadableDatabase();

				String countQuery = "SELECT  * FROM " + UserTable.TABLE_NAME;
				Cursor cursor = db.rawQuery(countQuery, null);

				int count = cursor.getCount();

				cursor.close();

				// return count
				return count;
			}


			// Updating single user
			public int updateUser(User user) {
				SQLiteDatabase db = mySQLiteHelper.getWritableDatabase();

				ContentValues values = new ContentValues();
				values.put(UserTable.COLUMN_USERNAME, user.getUsername());		
				values.put(UserTable.COLUMN_PASSWORD, user.getPassword());		

				// updating row
				return db.update(UserTable.TABLE_NAME, values,
						

			}

			// Deleting single user
			public void deleteUser(User user) {
				SQLiteDatabase db = mySQLiteHelper.getWritableDatabase();

				db.delete(UserTable.TABLE_NAME,

				db.close();
			}

}
