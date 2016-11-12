
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

public class ProductFormActivity extends AppCompatActivity {
    private Boolean booleanEditMode = false;

	private TextInputEditText tieDescription; 
	private TextInputEditText tieIdProducto; 
	private TextInputEditText tieName; 
	private TextInputEditText tieIdProvider; 
	private TextInputEditText tieIdImageProduct; 
	private TextInputEditText tiePrice; 
	private TextInputEditText tieCode; 
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

		tieDescription =  (TextInputEditText) findViewById(R.id.tieDescription); 
		tieIdProducto =  (TextInputEditText) findViewById(R.id.tieIdProducto); 
		tieName =  (TextInputEditText) findViewById(R.id.tieName); 
		tieIdProvider =  (TextInputEditText) findViewById(R.id.tieIdProvider); 
		tieIdImageProduct =  (TextInputEditText) findViewById(R.id.tieIdImageProduct); 
		tiePrice =  (TextInputEditText) findViewById(R.id.tiePrice); 
		tieCode =  (TextInputEditText) findViewById(R.id.tieCode); 

       
        Button btnSave = (Button) findViewById(R.id.btnSave);

        if (booleanEditMode) {
            btnSave.setText("Save Changes");
            loadProductData();
        }

        SQLiteHelper db = new SQLiteHelper(this);
        final ProductDAO productDAO = new ProductDAO(db);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
				try {
	               // Utilizamos el constructor del objeto para comprobar que los datos introducidos sean del tipo correcto, para luego almacenarlos.               
	               Product product = getProductFromEditext();
	                if (booleanEditMode) {
	                    productDAO.updateProduct(product);
	                }else{
	                    productDAO.addProduct(product);
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

	private void loadProductData(){
		Product product = (Product) intent.getSerializableExtra("product");
		tieDescription.setText(product.getDescription());
		tieIdProducto.setText(String.valueOf(product.getIdProducto()));
		tieName.setText(product.getName());
		tieIdProvider.setText(String.valueOf(product.getIdProvider()));
		tieIdImageProduct.setText(String.valueOf(product.getIdImageProduct()));
		tiePrice.setText(String.valueOf(product.getPrice()));
		tieCode.setText(String.valueOf(product.getCode()));
	}

    private Product getProductFromEditext() {
		String description = tieDescription.getText().toString();
		Integer idProducto = Integer.valueOf(tieIdProducto.getText().toString());
		String name = tieName.getText().toString();
		Integer idProvider = Integer.valueOf(tieIdProvider.getText().toString());
		Integer idImageProduct = Integer.valueOf(tieIdImageProduct.getText().toString());
		BigDecimal price = new BigDecimal(tiePrice.getText().toString());
		Integer code = Integer.valueOf(tieCode.getText().toString());
        
        return new Product(description, idProducto, name, idProvider, idImageProduct, price, code);
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

