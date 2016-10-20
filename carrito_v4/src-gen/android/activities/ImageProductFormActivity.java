
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

public class ImageProductFormActivity extends AppCompatActivity {
    private Boolean booleanEditMode = false;

	private TextInputEditText tieIdImageProduct; 
	private TextInputEditText tieImage; 

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_imageproduct);

        Intent intent = getIntent();
        if (intent.getStringExtra("typeOperation").equals("edit")) {
            booleanEditMode = true;
        }

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle(booleanEditMode ? "Edit ImageProduct" : "Add ImageProduct");
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

		tieIdImageProduct =  (TextInputEditText) findViewById(R.id.tieIdImageProduct); 
		tieImage =  (TextInputEditText) findViewById(R.id.tieImage); 

       
        Button btnSave = (Button) findViewById(R.id.btnSave);

        if (booleanEditMode) {
            btnSave.setText("Save Changes");
            loadImageProductData();
        }

        MySQLiteHelper db = new MySQLiteHelper(this);
        final ImageProductDAO imageProductDAO = new ImageProductDAO(db);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               ImageProduct imageProduct = getImageProductFromEditext();
                if (booleanEditMode) {
                    imageProductDAO.updateImageProduct(imageProduct);
                }else{
                    imageProductDAO.addImageProduct(imageProduct);
                }

                Intent returnIntent = new Intent();
                setResult(Activity.RESULT_OK, returnIntent);
                finish();
            }
        });

    }

	private void loadImageProductData(){
		ImageProduct imageProduct = (ImageProduct) intent.getSerializableExtra("imageProduct");
		tieIdImageProduct.setText(imageProduct.getIdImageProduct());
		tieImage.setText(imageProduct.getImage());
	}

    private ImageProduct getImageProductFromEditext() {
		String idImageProduct = tieIdImageProduct.getText().toString();
		String image = tieImage.getText().toString();
        
        return new ImageProduct(idImageProduct, image);
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

