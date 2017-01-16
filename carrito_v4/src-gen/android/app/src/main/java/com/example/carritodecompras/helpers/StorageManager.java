
package com.example.carritodecompras.helpers;

//Start of user code imports
import android.content.Context;
import android.content.SharedPreferences;
//End of user code
	
public class StorageManager {
    
	/*
	* Saving data in sharedPreferences
	*/
	public static void save(Context context, String key, String value) {
        SharedPreferences preferences = context.getSharedPreferences(context.getPackageName(),
                Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(key, value);
        editor.apply();
    }

	/*
	* Getting value from sharedPreferences
	*/
    public static String getValue(Context context, String key) {
        SharedPreferences preferences = context.getSharedPreferences(context.getPackageName(),
                Context.MODE_PRIVATE);
        return preferences.getString(key, null);
    }

    /*
	* Clear the sharedPreferences. Delete all the saved data in sharedPreferences
	*/
	public static void clearSharedPreference(Context context) {

        SharedPreferences preferences = context.getSharedPreferences(context.getPackageName(),
                Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();

        editor.clear();
        editor.apply();
    }

	/*
	* Remove or delete an specific value from the sharedPreferences
	*/
    public static void removeValue(Context context, String key) {
        SharedPreferences preferences = context.getSharedPreferences(context.getPackageName(),
                Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();

        editor.remove(key);
        editor.apply();
    }
}
