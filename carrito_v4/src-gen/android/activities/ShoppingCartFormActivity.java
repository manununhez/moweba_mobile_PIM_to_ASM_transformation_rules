
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

public class ShoppingCartFormActivity extends AppCompatActivity {
    private Boolean booleanEditMode = false;

	private TextInputEditText tieIdCart; 
	private TextInputEditText tieQuantity; 
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

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle(booleanEditMode ? "Edit ShoppingCart" : "Add ShoppingCart");
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

		tieIdCart =  (TextInputEditText) findViewById(R.id.tieIdCart); 
		tieQuantity =  (TextInputEditText) findViewById(R.id.tieQuantity); 
		tieSyncTime =  (TextInputEditText) findViewById(R.id.tieSyncTime); 

       
        Button btnSave = (Button) findViewById(R.id.btnSave);

        if (booleanEditMode) {
            btnSave.setText("Save Changes");
            loadShoppingCartData();
        }

        SQLiteHelper db = new SQLiteHelper(this);
        final ShoppingCartDAO shoppingCartDAO = new ShoppingCartDAO(db);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
				try {
	               // Utilizamos el constructor del objeto para comprobar que los datos introducidos sean del tipo correcto, para luego almacenarlos.               
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
	                  Toast.makeText(ProductFormActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
				}
            }
        });

    }

	private void loadShoppingCartData(){
		ShoppingCart shoppingCart = (ShoppingCart) intent.getSerializableExtra("shoppingCart");
		tieIdCart.setText(String.valueOf(shoppingCart.getIdCart()));
		tieQuantity.setText(String.valueOf(shoppingCart.getQuantity()));
		tieSyncTime.setText(String.valueOf(shoppingCart.getSyncTime()));
	}

    private ShoppingCart getShoppingCartFromEditext() {
		Integer idCart = Integer.valueOf(tieIdCart.getText().toString());
		Integer quantity = Integer.valueOf(tieQuantity.getText().toString());
		BigDecimal syncTime = new BigDecimal(tieSyncTime.getText().toString());
        
        return new ShoppingCart(idCart, quantity, syncTime);
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

