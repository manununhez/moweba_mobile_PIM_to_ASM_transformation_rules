
package com.example.carritodecompras.activities;

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

import com.example.carritodecompras.R;
import com.example.carritodecompras.adapters.ProductAdapter;
import com.example.carritodecompras.bd.dao.ProductDAO;
import com.example.carritodecompras.beans.Product;
import com.example.carritodecompras.helpers.SQLiteHelper;

import java.util.ArrayList;
import java.util.List;
//End of user code

public class ProductActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ProductAdapter mAdapter;
    private List<Product> productList = new ArrayList<>();
    private SQLiteHelper db;
    private TextView tvDataCount;
    private ProductDAO productDAO;

    private int REQUEST_CODE = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

		// Setting the toolbar title
        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null) {
            actionBar.setTitle("Product");
            actionBar.setDisplayHomeAsUpEnabled(true);
        }


        db = new SQLiteHelper(this); //Instantiating the helper
        productDAO = new ProductDAO(db); //Instantiating the DAO functionalities

        tvDataCount = (TextView) findViewById(R.id.tvDataCount);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        ImageView ivNew = (ImageView) findViewById(R.id.ivNew);
		ivNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
				// Go to the Form to add a new entry in the database
                Intent intent = new Intent(ProductActivity.this, ProductFormActivity.class);
                intent.putExtra("typeOperation","add");
                startActivityForResult(intent, REQUEST_CODE);
            }
        });

		setupRecyclerView();

        loadProductData();
        
		
    }

	/* 
	*	Initializing the recycler view with the data provided
	*/
    private void setupRecyclerView() {
        mAdapter = new ProductAdapter(this, productList, productDAO);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
		recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);
    }

	/*
	*	Retrieving all the data to show
	*/
	private void loadProductData() {
		getProductCount();
		getProduct();
	}


	/*
	*	Updating the total items count
	*/
    public void getProductCount() {
        tvDataCount.setText(String.valueOf(productDAO.getProductCount()));
    }


	/*
	*	Getting data  from database
	*/
    private void getProduct() {
        Toast.makeText(ProductActivity.this, "Retrieving data from database", Toast.LENGTH_SHORT).show();

        productList.addAll(productDAO.getAllProduct());

        mAdapter.notifyDataSetChanged();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_CODE) {
            // Make sure the request was successful
            if (resultCode == RESULT_OK) { //if it?s ok, we update the list to show the changes
                productList.clear(); //clear the list            
				loadProductData();	//reload data
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

