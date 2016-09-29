
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

public class ShoppingCartFormActivity extends AppCompatActivity {
    private Boolean booleanEditMode = false;

	private TextInputEditText tieQuantity; 
	private TextInputEditText tieIdCart; 
	private TextInputEditText tieSyncTime; 

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_shoppingcart);

        Intent intent = getIntent();
        if (intent.getStringExtra("typeOperation").equals("edit")) {
            booleanEditMode = true;
        }

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle(booleanEditMode ? "Edit ShoppingCart" : "Add ShoppingCart");
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

		tieQuantity =  (TextInputEditText) findViewById(R.id.tieQuantity); 
		tieIdCart =  (TextInputEditText) findViewById(R.id.tieIdCart); 
		tieSyncTime =  (TextInputEditText) findViewById(R.id.tieSyncTime); 

       
        Button btnSave = (Button) findViewById(R.id.btnSave);

        if (booleanEditMode) {
            btnSave.setText("Save Changes");
            loadShoppingCartData();
        }

        MySQLiteHelper db = new MySQLiteHelper(this);
        final ShoppingCartDAO shoppingCartDAO = new ShoppingCartDAO(db);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               ShoppingCart shoppingCart = getShoppingCartFromEditext();
                if (booleanEditMode) {
                    shoppingCartDAO.updateShoppingCart(shoppingCart);
                }else{
                    shoppingCartDAO.addShoppingCart(shoppingCart);
                }

                Intent returnIntent = new Intent();
                setResult(Activity.RESULT_OK, returnIntent);
                finish();
            }
        });

    }

	private void loadShoppingCartData(){
		ShoppingCart shoppingCart = (ShoppingCart) intent.getSerializableExtra("shoppingCart");
		tieQuantity.setText(shoppingCart.getQuantity());
		tieIdCart.setText(String.valueOf(shoppingCart.getIdCart()));
		tieSyncTime.setText(shoppingCart.getSyncTime());
	}

    private ShoppingCart getShoppingCartFromEditext() {
		String quantity = tieQuantity.getText().toString();
		Integer idCart = Integer.valueOf(tieIdCart.getText().toString());
		String syncTime = tieSyncTime.getText().toString();
        
        return new ShoppingCart(quantity, idCart, syncTime);
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

