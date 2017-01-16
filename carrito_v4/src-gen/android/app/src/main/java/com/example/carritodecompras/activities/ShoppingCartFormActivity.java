
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
import com.example.carritodecompras.bd.dao.ShoppingCartDAO;
import com.example.carritodecompras.beans.ShoppingCart;
import com.example.carritodecompras.helpers.SQLiteHelper;

import java.math.BigDecimal;
//End of user code

public class ShoppingCartFormActivity extends AppCompatActivity {
    private Boolean booleanEditMode = false; //Determine the type of operation to be performed

	private TextInputEditText tieIdCart; 
	private TextInputEditText tiePrice; 
	private TextInputEditText tieQuantity; 
	private TextInputEditText tieIdProduct; 
	private TextInputEditText tieSyncTime; 
	private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_shoppingcart);

        intent = getIntent();
        if (intent.getStringExtra("typeOperation").equals("edit")) {
            booleanEditMode = true;
        }

		// Setting the toolbar title
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle(booleanEditMode ? "Edit ShoppingCart" : "Add ShoppingCart"); //Change the boton label according to the operation
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

		tieIdCart =  (TextInputEditText) findViewById(R.id.tieIdCart); 
		tiePrice =  (TextInputEditText) findViewById(R.id.tiePrice); 
		tieQuantity =  (TextInputEditText) findViewById(R.id.tieQuantity); 
		tieIdProduct =  (TextInputEditText) findViewById(R.id.tieIdProduct); 
		tieSyncTime =  (TextInputEditText) findViewById(R.id.tieSyncTime); 

       
        Button btnSave = (Button) findViewById(R.id.btnSave);

        if (booleanEditMode) { //Edit mode
            btnSave.setText("Save Changes");
            loadShoppingCartData(); //Populating the form with the provided data
        }

        SQLiteHelper db = new SQLiteHelper(this); //Instantiating the helper
        final ShoppingCartDAO shoppingCartDAO = new ShoppingCartDAO(db); //Instantiating the DAO functionalities

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
				try {
	               // We use the constructor of the object to verify that the data entered are of the correct type, and then store them               
	               ShoppingCart shoppingCart = getShoppingCartFromEditext();
	                if (booleanEditMode) {
	                    shoppingCartDAO.updateShoppingCart(shoppingCart);
	                }else{
	                    shoppingCartDAO.addShoppingCart(shoppingCart);
	                }
	
	                Intent returnIntent = new Intent();
	                setResult(Activity.RESULT_OK, returnIntent);
	                finish();
				}catch (Exception e){
	                  Toast.makeText(ShoppingCartFormActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
				}
            }
        });

    }

	/*
	*	Retrieving all the data to show in form
	*/
	private void loadShoppingCartData(){
		ShoppingCart shoppingCart = (ShoppingCart) intent.getSerializableExtra("shoppingCart");
		tieIdCart.setText(String.valueOf(shoppingCart.getIdCart()));
		tiePrice.setText(shoppingCart.getPrice());
		tieQuantity.setText(String.valueOf(shoppingCart.getQuantity()));
		tieIdProduct.setText(String.valueOf(shoppingCart.getIdProduct()));
		tieSyncTime.setText(String.valueOf(shoppingCart.getSyncTime()));
	}

	/*
	*	Getting data from each field of the form, and initializing the model with these data
	*/
    private ShoppingCart getShoppingCartFromEditext() {
		Integer idCart = Integer.valueOf(tieIdCart.getText().toString());
		String price = tiePrice.getText().toString();
		Integer quantity = Integer.valueOf(tieQuantity.getText().toString());
		Integer idProduct = Integer.valueOf(tieIdProduct.getText().toString());
		BigDecimal syncTime = new BigDecimal(tieSyncTime.getText().toString());
        
        return new ShoppingCart(idCart, price, quantity, idProduct, syncTime);
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

