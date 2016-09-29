
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

	private TextInputEditText tieRuc; 
	private TextInputEditText tieIdProvider; 
	private TextInputEditText tieNombre; 
	private TextInputEditText tieDescription; 

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_provider);

        Intent intent = getIntent();
        if (intent.getStringExtra("typeOperation").equals("edit")) {
            booleanEditMode = true;
        }

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle(booleanEditMode ? "Edit Provider" : "Add Provider");
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

		tieRuc =  (TextInputEditText) findViewById(R.id.tieRuc); 
		tieIdProvider =  (TextInputEditText) findViewById(R.id.tieIdProvider); 
		tieNombre =  (TextInputEditText) findViewById(R.id.tieNombre); 
		tieDescription =  (TextInputEditText) findViewById(R.id.tieDescription); 

       
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
		tieRuc.setText(provider.getRuc());
		tieIdProvider.setText(provider.getIdProvider());
		tieNombre.setText(provider.getNombre());
		tieDescription.setText(provider.getDescription());
	}

    private Provider getProviderFromEditext() {
		String ruc = tieRuc.getText().toString();
		String idProvider = tieIdProvider.getText().toString();
		String nombre = tieNombre.getText().toString();
		String description = tieDescription.getText().toString();
        
        return new Provider(ruc, idProvider, nombre, description);
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

