
//Start of user code imports
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
//End of user code

public class UserFormActivity extends AppCompatActivity {
	private TextInputEditText tiePassword; 
	private TextInputEditText tieUsername; 

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_user);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle("Edit User");
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

		tiePassword =  (TextInputEditText) findViewById(R.id.tiePassword); 
		tieUsername =  (TextInputEditText) findViewById(R.id.tieUsername); 

       
        Button btnSave = (Button) findViewById(R.id.btnSave);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveData();

                Intent returnIntent = new Intent();
                setResult(Activity.RESULT_OK, returnIntent);
                finish();
            }
        });

		loadData();

    }

    private void loadData() {
		String password = MySharedPreferencesHelper.getValue(UserFormActivity.this, "password"); 
		String username = MySharedPreferencesHelper.getValue(UserFormActivity.this, "username"); 

		tiePassword.setText(password == null ? "" : password); 
		tieUsername.setText(username == null ? "" : username); 
    }

    private void saveData() {
		String password = tiePassword.getText().toString(); 
		String username = tieUsername.getText().toString(); 

		MySharedPreferencesHelper.save(UserFormActivity.this, "password", password); 
		MySharedPreferencesHelper.save(UserFormActivity.this, "username", username); 
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);

    }
}

