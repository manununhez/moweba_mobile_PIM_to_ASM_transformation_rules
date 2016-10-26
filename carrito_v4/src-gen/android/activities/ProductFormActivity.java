
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

public class ProductFormActivity extends AppCompatActivity {
    private Boolean booleanEditMode = false;

	private TextInputEditText tieIdProvider; 
	private TextInputEditText tiePrice; 
	private TextInputEditText tieDescription; 
	private TextInputEditText tieIdProducto; 
	private TextInputEditText tieCode; 
	private TextInputEditText tieName; 
	private TextInputEditText tieIdImageProduct; 
	private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_product);

        intent = getIntent();
        if (intent.getStringExtra("typeOperation").equals("edit")) {
            booleanEditMode = true;
        }

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle(booleanEditMode ? "Edit Product" : "Add Product");
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

		tieIdProvider =  (TextInputEditText) findViewById(R.id.tieIdProvider); 
		tiePrice =  (TextInputEditText) findViewById(R.id.tiePrice); 
		tieDescription =  (TextInputEditText) findViewById(R.id.tieDescription); 
		tieIdProducto =  (TextInputEditText) findViewById(R.id.tieIdProducto); 
		tieCode =  (TextInputEditText) findViewById(R.id.tieCode); 
		tieName =  (TextInputEditText) findViewById(R.id.tieName); 
		tieIdImageProduct =  (TextInputEditText) findViewById(R.id.tieIdImageProduct); 

       
        Button btnSave = (Button) findViewById(R.id.btnSave);

        if (booleanEditMode) {
            btnSave.setText("Save Changes");
            loadProductData();
        }

        MySQLiteHelper db = new MySQLiteHelper(this);
        final ProductDAO productDAO = new ProductDAO(db);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Product product = getProductFromEditext();
                if (booleanEditMode) {
                    productDAO.updateProduct(product);
                }else{
                    productDAO.addProduct(product);
                }

                Intent returnIntent = new Intent();
                setResult(Activity.RESULT_OK, returnIntent);
                finish();
            }
        });

    }

	private void loadProductData(){
		Product product = (Product) intent.getSerializableExtra("product");
		tieIdProvider.setText(String.valueOf(product.getIdProvider()));
		tiePrice.setText(product.getPrice());
		tieDescription.setText(product.getDescription());
		tieIdProducto.setText(String.valueOf(product.getIdProducto()));
		tieCode.setText(String.valueOf(product.getCode()));
		tieName.setText(product.getName());
		tieIdImageProduct.setText(String.valueOf(product.getIdImageProduct()));
	}

    private Product getProductFromEditext() {
		Integer idProvider = Integer.valueOf(tieIdProvider.getText().toString());
		String price = tiePrice.getText().toString();
		String description = tieDescription.getText().toString();
		Integer idProducto = Integer.valueOf(tieIdProducto.getText().toString());
		Integer code = Integer.valueOf(tieCode.getText().toString());
		String name = tieName.getText().toString();
		Integer idImageProduct = Integer.valueOf(tieIdImageProduct.getText().toString());
        
        return new Product(idProvider, price, description, idProducto, code, name, idImageProduct);
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

