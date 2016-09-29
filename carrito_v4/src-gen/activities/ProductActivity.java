
//Start of user code imports
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
//End of user code

public class ProductActivity extends AppCompatActivity {

	private TextInputEditText tieCode; 
	private TextInputEditText tieIdProvider; 
	private TextInputEditText tieName; 
	private TextInputEditText tieDescription; 
	private TextInputEditText tieIdImageProduct; 
	private TextInputEditText tiePrice; 
	private TextInputEditText tieIdProducto; 

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null) {
            actionBar.setTitle("Product");
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

		tieCode =  (TextInputEditText) findViewById(R.id.tieCode); 
		tieIdProvider =  (TextInputEditText) findViewById(R.id.tieIdProvider); 
		tieName =  (TextInputEditText) findViewById(R.id.tieName); 
		tieDescription =  (TextInputEditText) findViewById(R.id.tieDescription); 
		tieIdImageProduct =  (TextInputEditText) findViewById(R.id.tieIdImageProduct); 
		tiePrice =  (TextInputEditText) findViewById(R.id.tiePrice); 
		tieIdProducto =  (TextInputEditText) findViewById(R.id.tieIdProducto); 

		Button btnWriteToFile = (Button) findViewById(R.id.btnWriteToFile);
        Button btnReadFromFile = (Button) findViewById(R.id.btnReadFromFile);
        
		final EditText etContent = (EditText) findViewById(R.id.etContent);


        btnReadFromFile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                etContent.setText(MyFilesHelper.readFile(getFilesDir().getPath() + FILENAME, FILE_ENCODING));
            }
        });

        btnWriteToFile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyFilesHelper.writeFile(getFilesDir().getPath() + FILENAME, getContent());
            }
        });
    }

     private String getContent() {
		return tieCode.getText() + "," + tieIdProvider.getText() + "," + tieName.getText() + "," + tieDescription.getText() + "," + tieIdImageProduct.getText() + "," + tiePrice.getText() + "," + tieIdProducto.getText();
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

