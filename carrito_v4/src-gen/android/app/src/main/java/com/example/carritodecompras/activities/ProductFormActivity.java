
package com.example.carritodecompras.activities;

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

import com.example.carritodecompras.R;
import com.example.carritodecompras.bd.dao.ProductDAO;
import com.example.carritodecompras.beans.Product;
import com.example.carritodecompras.helpers.SQLiteHelper;

import java.math.BigDecimal;
//End of user code

public class ProductFormActivity extends AppCompatActivity {
    private Boolean booleanEditMode = false; //Determine the type of operation to be performed

	private TextInputEditText tiePrice; 
	private TextInputEditText tieCode; 
	private TextInputEditText tieDescription; 
	private TextInputEditText tieTaxPercentage; 
	private TextInputEditText tieName; 
	private TextInputEditText tieIdProvider; 
	private TextInputEditText tieIdProduct; 
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

		// Setting the toolbar title
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle(booleanEditMode ? "Edit Product" : "Add Product"); //Change the boton label according to the operation
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

		tiePrice =  (TextInputEditText) findViewById(R.id.tiePrice); 
		tieCode =  (TextInputEditText) findViewById(R.id.tieCode); 
		tieDescription =  (TextInputEditText) findViewById(R.id.tieDescription); 
		tieTaxPercentage =  (TextInputEditText) findViewById(R.id.tieTaxPercentage); 
		tieName =  (TextInputEditText) findViewById(R.id.tieName); 
		tieIdProvider =  (TextInputEditText) findViewById(R.id.tieIdProvider); 
		tieIdProduct =  (TextInputEditText) findViewById(R.id.tieIdProduct); 
		tieIdImageProduct =  (TextInputEditText) findViewById(R.id.tieIdImageProduct); 

       
        Button btnSave = (Button) findViewById(R.id.btnSave);

        if (booleanEditMode) { //Edit mode
            btnSave.setText("Save Changes");
            loadProductData(); //Populating the form with the provided data
        }

        SQLiteHelper db = new SQLiteHelper(this); //Instantiating the helper
        final ProductDAO productDAO = new ProductDAO(db); //Instantiating the DAO functionalities

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
				try {
	               // We use the constructor of the object to verify that the data entered are of the correct type, and then store them               
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

	/*
	*	Retrieving all the data to show in form
	*/
	private void loadProductData(){
		Product product = (Product) intent.getSerializableExtra("product");
		tiePrice.setText(product.getPrice());
		tieCode.setText(String.valueOf(product.getCode()));
		tieDescription.setText(product.getDescription());
		tieTaxPercentage.setText(String.valueOf(product.getTaxPercentage()));
		tieName.setText(product.getName());
		tieIdProvider.setText(String.valueOf(product.getIdProvider()));
		tieIdProduct.setText(String.valueOf(product.getIdProduct()));
		tieIdImageProduct.setText(String.valueOf(product.getIdImageProduct()));
	}

	/*
	*	Getting data from each field of the form, and initializing the model with these data
	*/
    private Product getProductFromEditext() {
		String price = tiePrice.getText().toString();
		Integer code = Integer.valueOf(tieCode.getText().toString());
		String description = tieDescription.getText().toString();
		Integer taxPercentage = Integer.valueOf(tieTaxPercentage.getText().toString());
		String name = tieName.getText().toString();
		Integer idProvider = Integer.valueOf(tieIdProvider.getText().toString());
		Integer idProduct = Integer.valueOf(tieIdProduct.getText().toString());
		Integer idImageProduct = Integer.valueOf(tieIdImageProduct.getText().toString());
        
        return new Product(price, code, description, taxPercentage, name, idProvider, idProduct, idImageProduct);
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

