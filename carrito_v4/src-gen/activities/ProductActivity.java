
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

	private TextInputEditText tiePrice; 
	private TextInputEditText tieDescription; 
	private TextInputEditText tieIdProvider; 
	private TextInputEditText tieIdImageProduct; 
	private TextInputEditText tieName; 
	private TextInputEditText tieCode; 
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

		tiePrice =  (TextInputEditText) findViewById(R.id.tiePrice); 
		tieDescription =  (TextInputEditText) findViewById(R.id.tieDescription); 
		tieIdProvider =  (TextInputEditText) findViewById(R.id.tieIdProvider); 
		tieIdImageProduct =  (TextInputEditText) findViewById(R.id.tieIdImageProduct); 
		tieName =  (TextInputEditText) findViewById(R.id.tieName); 
		tieCode =  (TextInputEditText) findViewById(R.id.tieCode); 
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
		return tiePrice.getText() + "," + tieDescription.getText() + "," + tieIdProvider.getText() + "," + tieIdImageProduct.getText() + "," + tieName.getText() + "," + tieCode.getText() + "," + tieIdProducto.getText();
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

