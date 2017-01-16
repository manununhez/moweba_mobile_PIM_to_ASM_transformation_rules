
package com.example.carritodecompras.activities;

//Start of user code imports
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.carritodecompras.R;
import com.example.carritodecompras.helpers.FilesHelper;

//End of user code

public class ImageProductActivity extends AppCompatActivity {

	private TextInputEditText tieImage; 
	private TextInputEditText tieIdImageProduct; 
 	private static String FILENAME = "ImageProductFile.txt";
    private static String FILE_ENCODING = "UTF-8";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imageproduct);

		// Setting the toolbar title
        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null) {
            actionBar.setTitle("ImageProduct");
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

		tieImage =  (TextInputEditText) findViewById(R.id.tieImage); 
		tieIdImageProduct =  (TextInputEditText) findViewById(R.id.tieIdImageProduct); 

		Button btnWriteToFile = (Button) findViewById(R.id.btnWriteToFile);
        Button btnReadFromFile = (Button) findViewById(R.id.btnReadFromFile);
        
		final EditText etContent = (EditText) findViewById(R.id.etContent);


        btnReadFromFile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                etContent.setText(FilesHelper.readFile(getFilesDir().getPath() + FILENAME, FILE_ENCODING));
                Toast.makeText(ImageProductActivity.this, "Reading from: "+getFilesDir().getPath() + FILENAME, Toast.LENGTH_SHORT).show();
            }
        });

        btnWriteToFile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FilesHelper.writeFile(getFilesDir().getPath() + FILENAME, getContent());
                Toast.makeText(ImageProductActivity.this, "Writing in: "+getFilesDir().getPath() + FILENAME, Toast.LENGTH_SHORT).show();
            }
        });
    }

	/*
	*	Getting data from the form.
	*	Return Content Format: <data1> , <data2>, <data3>, so on...
	*/
     private String getContent() {
		return tieImage.getText() + "," + tieIdImageProduct.getText();
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

