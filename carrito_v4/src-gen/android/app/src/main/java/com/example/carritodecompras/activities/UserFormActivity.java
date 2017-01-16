
package com.example.carritodecompras.activities;

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
import android.widget.Toast;

import com.example.carritodecompras.R;
import com.example.carritodecompras.beans.User;
import com.example.carritodecompras.helpers.StorageManager;

import java.math.BigDecimal;
//End of user code

public class UserFormActivity extends AppCompatActivity {
	private TextInputEditText tieRuc; 
	private TextInputEditText tieMail; 
	private TextInputEditText tieUsername; 
	private TextInputEditText tiePassword; 

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_user);

		// Setting the toolbar title
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle("Edit User");
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

		tieRuc =  (TextInputEditText) findViewById(R.id.tieRuc); 
		tieMail =  (TextInputEditText) findViewById(R.id.tieMail); 
		tieUsername =  (TextInputEditText) findViewById(R.id.tieUsername); 
		tiePassword =  (TextInputEditText) findViewById(R.id.tiePassword); 

       
        Button btnSave = (Button) findViewById(R.id.btnSave);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveData();

            }
        });

		loadData();

    }

	/*
	*	Populating the form with the stored data
	*/
    private void loadData() {
		String ruc = StorageManager.getValue(UserFormActivity.this, "ruc"); 
		String mail = StorageManager.getValue(UserFormActivity.this, "mail"); 
		String username = StorageManager.getValue(UserFormActivity.this, "username"); 
		String password = StorageManager.getValue(UserFormActivity.this, "password"); 

		tieRuc.setText(ruc == null ? "" : ruc); 
		tieMail.setText(mail == null ? "" : mail); 
		tieUsername.setText(username == null ? "" : username); 
		tiePassword.setText(password == null ? "" : password); 
    }

	/*
	* Saving data in sharedPreferences
	*/
    private void saveData() {
		
		String ruc = tieRuc.getText().toString(); 
		String mail = tieMail.getText().toString(); 
		String username = tieUsername.getText().toString(); 
		String password = tiePassword.getText().toString(); 
	
		try {
	        // We use the constructor of the object to verify that the data entered are of the correct type, and then store them               
		    User user = new User(ruc == null ? "" : ruc, mail == null ? "" : mail, username == null ? "" : username, password == null ? "" : password);

			StorageManager.save(UserFormActivity.this, "ruc", ruc); 
			StorageManager.save(UserFormActivity.this, "mail", mail); 
			StorageManager.save(UserFormActivity.this, "username", username); 
			StorageManager.save(UserFormActivity.this, "password", password); 
	

	        Intent returnIntent = new Intent();
	        setResult(Activity.RESULT_OK, returnIntent);
	        finish();
		}catch (Exception e){
            Toast.makeText(UserFormActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
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

