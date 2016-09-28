
//Start of user code imports
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
//End of user code

public class ProviderActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ProviderAdapter mAdapter;
    private List<Provider> providerList = new ArrayList<>();
    private MySQLiteHelper db;
    private TextView tvDataCount;
    private ProviderDAO providerDAO;

    private int REQUEST_CODE = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_provider);

        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null) {
            actionBar.setTitle("Provider");
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        db = new MySQLiteHelper(this);
        providerDAO = new ProviderDAO(db);

        tvDataCount = (TextView) findViewById(R.id.tvDataCount);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        ImageView ivNew = (ImageView) findViewById(R.id.ivNew);
		ivNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProviderActivity.this, ProviderFormActivity.class);
                intent.putExtra("typeOperation","add");
                startActivityForResult(intent, REQUEST_CODE);
            }
        });

		setupRecyclerView();

        getProviderCount();
		getProvider();
        
		
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_CODE) {
            // Make sure the request was successful
            if (resultCode == RESULT_OK) {
                // The user picked a contact.
                // The Intent's data Uri identifies which contact was selected.
                providerList.clear();
                providerList.addAll(providerDAO.getAllProvider());
                mAdapter.notifyDataSetChanged();
                getProviderCount();
                // Do something with the contact here (bigger example below)
            }
        }
    }

    public void getProviderCount() {
        tvDataCount.setText(String.valueOf(providerDAO.getProviderCount()));
    }

    private void setupRecyclerView() {
        mAdapter = new ProviderAdapter(this, providerList, providerDAO);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);

        recyclerView.setAdapter(mAdapter);
    }

    private void getProvider() {
        Toast.makeText(ProviderActivity.this, "Retrieving data from database", Toast.LENGTH_SHORT).show();

        providerList.addAll(providerDAO.getAllProvider());

        mAdapter.notifyDataSetChanged();
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

