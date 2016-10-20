//Start of user code imports
//End of user code
	
public class MySharedPreferencesHelper {
    
	public static void save(Context context, String key, String value) {
        SharedPreferences preferences = context.getSharedPreferences(context.getPackageName(),
                Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(key, value);
        editor.apply();
    }

    public static String getValue(Context context, String key) {
        SharedPreferences preferences = context.getSharedPreferences(context.getPackageName(),
                Context.MODE_PRIVATE);
        return preferences.getString(key, null);
    }

    public static void clearSharedPreference(Context context) {

        SharedPreferences preferences = context.getSharedPreferences(context.getPackageName(),
                Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();

        editor.clear();
        editor.apply();
    }

    public static void removeValue(Context context, String key) {
        SharedPreferences preferences = context.getSharedPreferences(context.getPackageName(),
                Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();

        editor.remove(key);
        editor.apply();
    }
}