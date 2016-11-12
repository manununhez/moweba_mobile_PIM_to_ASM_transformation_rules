
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

import java.math.BigDecimal;
//End of user code

public class ProviderFormActivity extends AppCompatActivity {
    private Boolean booleanEditMode = false;

	private TextInputEditText tieIdProvider; 
	private TextInputEditText tieNombre; 
	private TextInputEditText tieDescription; 
	private TextInputEditText tieRuc; 
	private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_provider);

        intent = getIntent();
        if (intent.getStringExtra("typeOperation").equals("edit")) {
            booleanEditMode = true;
        }

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle(booleanEditMode ? "Edit Provider" : "Add Provider");
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

		tieIdProvider =  (TextInputEditText) findViewById(R.id.tieIdProvider); 
		tieNombre =  (TextInputEditText) findViewById(R.id.tieNombre); 
		tieDescription =  (TextInputEditText) findViewById(R.id.tieDescription); 
		tieRuc =  (TextInputEditText) findViewById(R.id.tieRuc); 

       
        Button btnSave = (Button) findViewById(R.id.btnSave);

        if (booleanEditMode) {
            btnSave.setText("Save Changes");
            loadProviderData();
        }

        SQLiteHelper db = new SQLiteHelper(this);
        final ProviderDAO providerDAO = new ProviderDAO(db);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
				try {
	               // Utilizamos el constructor del objeto para comprobar que los datos introducidos sean del tipo correcto, para luego almacenarlos.               
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
	                  Toast.makeText(ProductFormActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
				}
            }
        });

    }

	private void loadProviderData(){
		Provider provider = (Provider) intent.getSerializableExtra("provider");
		tieIdProvider.setText(String.valueOf(provider.getIdProvider()));
		tieNombre.setText(provider.getNombre());
		tieDescription.setText(provider.getDescription());
		tieRuc.setText(String.valueOf(provider.getRuc()));
	}

    private Provider getProviderFromEditext() {
		Integer idProvider = Integer.valueOf(tieIdProvider.getText().toString());
		String nombre = tieNombre.getText().toString();
		String description = tieDescription.getText().toString();
		Float ruc = Float.valueOf(tieRuc.getText().toString());
        
        return new Provider(idProvider, nombre, description, ruc);
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

