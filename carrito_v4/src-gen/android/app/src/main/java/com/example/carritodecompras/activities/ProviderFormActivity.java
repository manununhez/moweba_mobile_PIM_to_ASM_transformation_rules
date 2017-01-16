
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
import com.example.carritodecompras.bd.dao.ProviderDAO;
import com.example.carritodecompras.beans.Provider;
import com.example.carritodecompras.helpers.SQLiteHelper;

import java.math.BigDecimal;
//End of user code

public class ProviderFormActivity extends AppCompatActivity {
    private Boolean booleanEditMode = false; //Determine the type of operation to be performed

	private TextInputEditText tieDescription; 
	private TextInputEditText tieIdProvider; 
	private TextInputEditText tieRuc; 
	private TextInputEditText tieNombre; 
	private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_provider);

        intent = getIntent();
        if (intent.getStringExtra("typeOperation").equals("edit")) {
            booleanEditMode = true;
        }

		// Setting the toolbar title
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle(booleanEditMode ? "Edit Provider" : "Add Provider"); //Change the boton label according to the operation
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

		tieDescription =  (TextInputEditText) findViewById(R.id.tieDescription); 
		tieIdProvider =  (TextInputEditText) findViewById(R.id.tieIdProvider); 
		tieRuc =  (TextInputEditText) findViewById(R.id.tieRuc); 
		tieNombre =  (TextInputEditText) findViewById(R.id.tieNombre); 

       
        Button btnSave = (Button) findViewById(R.id.btnSave);

        if (booleanEditMode) { //Edit mode
            btnSave.setText("Save Changes");
            loadProviderData(); //Populating the form with the provided data
        }

        SQLiteHelper db = new SQLiteHelper(this); //Instantiating the helper
        final ProviderDAO providerDAO = new ProviderDAO(db); //Instantiating the DAO functionalities

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
				try {
	               // We use the constructor of the object to verify that the data entered are of the correct type, and then store them               
	               Provider provider = getProviderFromEditext();
	                if (booleanEditMode) {
	                    providerDAO.updateProvider(provider);
	                }else{
	                    providerDAO.addProvider(provider);
	                }
	
	                Intent returnIntent = new Intent();
	                setResult(Activity.RESULT_OK, returnIntent);
	                finish();
				}catch (Exception e){
	                  Toast.makeText(ProviderFormActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
				}
            }
        });

    }

	/*
	*	Retrieving all the data to show in form
	*/
	private void loadProviderData(){
		Provider provider = (Provider) intent.getSerializableExtra("provider");
		tieDescription.setText(provider.getDescription());
		tieIdProvider.setText(String.valueOf(provider.getIdProvider()));
		tieRuc.setText(provider.getRuc());
		tieNombre.setText(provider.getNombre());
	}

	/*
	*	Getting data from each field of the form, and initializing the model with these data
	*/
    private Provider getProviderFromEditext() {
		String description = tieDescription.getText().toString();
		Integer idProvider = Integer.valueOf(tieIdProvider.getText().toString());
		String ruc = tieRuc.getText().toString();
		String nombre = tieNombre.getText().toString();
        
        return new Provider(description, idProvider, ruc, nombre);
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

