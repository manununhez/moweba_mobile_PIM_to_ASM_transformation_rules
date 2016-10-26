
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

public class ImageProductActivity extends AppCompatActivity {

	private TextInputEditText tieIdImageProduct; 
	private TextInputEditText tieImage; 
 	private static String FILENAME = "prueba.txt";
    private static String FILE_ENCODING = "UTF-8";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imageproduct);

        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null) {
            actionBar.setTitle("ImageProduct");
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

		tieIdImageProduct =  (TextInputEditText) findViewById(R.id.tieIdImageProduct); 
		tieImage =  (TextInputEditText) findViewById(R.id.tieImage); 

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
		return tieIdImageProduct.getText() + "," + tieImage.getText();
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

