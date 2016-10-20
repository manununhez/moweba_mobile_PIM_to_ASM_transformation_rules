
//Start of user code imports
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
//End of user code

public class ShoppingCartActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ShoppingCartAdapter mAdapter;
    private List<ShoppingCart> shoppingCartList = new ArrayList<>();
    private MySQLiteHelper db;
    private TextView tvDataCount;
    private ShoppingCartDAO shoppingCartDAO;

    private int REQUEST_CODE = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shoppingcart);

        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null) {
            actionBar.setTitle("ShoppingCart");
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        db = new MySQLiteHelper(this);
        shoppingCartDAO = new ShoppingCartDAO(db);

        tvDataCount = (TextView) findViewById(R.id.tvDataCount);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        ImageView ivNew = (ImageView) findViewById(R.id.ivNew);
		ivNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ShoppingCartActivity.this, ShoppingCartFormActivity.class);
                intent.putExtra("typeOperation","add");
                startActivityForResult(intent, REQUEST_CODE);
            }
        });

		setupRecyclerView();

        loadShoppingCartData();
        
		
    }

    private void setupRecyclerView() {
        mAdapter = new ShoppingCartAdapter(this, shoppingCartList, shoppingCartDAO);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
		recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);
    }

	private void loadShoppingCartData() {
		getShoppingCartCount();
		getShoppingCart();
	}


    public void getShoppingCartCount() {
        tvDataCount.setText(String.valueOf(shoppingCartDAO.getShoppingCartCount()));
    }

    private void getShoppingCart() {
        Toast.makeText(ShoppingCartActivity.this, "Retrieving data from database", Toast.LENGTH_SHORT).show();

        shoppingCartList.addAll(shoppingCartDAO.getAllShoppingCart());

        mAdapter.notifyDataSetChanged();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_CODE) {
            // Make sure the request was successful
            if (resultCode == RESULT_OK) {
                shoppingCartList.clear();
                
				loadShoppingCartData();
            }
        }
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

