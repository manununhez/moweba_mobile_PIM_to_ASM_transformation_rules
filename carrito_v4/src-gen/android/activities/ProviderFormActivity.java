
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

public class ProviderFormActivity extends AppCompatActivity {
    private Boolean booleanEditMode = false;

	private TextInputEditText tieIdProvider; 
	private TextInputEditText tieRuc; 
	private TextInputEditText tieDescription; 
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

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle(booleanEditMode ? "Edit Provider" : "Add Provider");
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

		tieIdProvider =  (TextInputEditText) findViewById(R.id.tieIdProvider); 
		tieRuc =  (TextInputEditText) findViewById(R.id.tieRuc); 
		tieDescription =  (TextInputEditText) findViewById(R.id.tieDescription); 
		tieNombre =  (TextInputEditText) findViewById(R.id.tieNombre); 

       
        Button btnSave = (Button) findViewById(R.id.btnSave);

        if (booleanEditMode) {
            btnSave.setText("Save Changes");
            loadProviderData();
        }

        MySQLiteHelper db = new MySQLiteHelper(this);
        final ProviderDAO providerDAO = new ProviderDAO(db);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Provider provider = getProviderFromEditext();
                if (booleanEditMode) {
                    providerDAO.updateProvider(provider);
                }else{
                    providerDAO.addProvider(provider);
                }

                Intent returnIntent = new Intent();
                setResult(Activity.RESULT_OK, returnIntent);
                finish();
            }
        });

    }

	private void loadProviderData(){
		Provider provider = (Provider) intent.getSerializableExtra("provider");
		tieIdProvider.setText(String.valueOf(provider.getIdProvider()));
		tieRuc.setText(provider.getRuc());
		tieDescription.setText(provider.getDescription());
		tieNombre.setText(provider.getNombre());
	}

    private Provider getProviderFromEditext() {
		Integer idProvider = Integer.valueOf(tieIdProvider.getText().toString());
		String ruc = tieRuc.getText().toString();
		String description = tieDescription.getText().toString();
		String nombre = tieNombre.getText().toString();
        
        return new Provider(idProvider, ruc, description, nombre);
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

