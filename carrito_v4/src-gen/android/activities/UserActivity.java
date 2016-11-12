
//Start of user code imports
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.widget.Toast;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
//End of user code

public class UserActivity extends AppCompatActivity {
    private  RecyclerView recyclerView;
    private UserAdapter mAdapter;
    private List<User> userList = new ArrayList<>();
    private static int REQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null) {
            actionBar.setTitle("User");
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        
		setupRecyclerView();

        loadUserData();
        
		
    }

    private void setupRecyclerView() {
        mAdapter = new UserAdapter(this, userList);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
		recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);
    }

	private void loadUserData(){
		Toast.makeText(UserActivity.this, "Retrieving data from sharedPreferences", Toast.LENGTH_SHORT).show();
		String username = StorageManager.getValue(this, "username");
		String password = StorageManager.getValue(this, "password");
        
		User user = new User(username == null ? 0f : Float.parseFloat(username), password == null ? new BigDecimal (0) : new BigDecimal(password));
        
		userList.add(user);

        mAdapter.notifyDataSetChanged();
	}

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_CODE) {
            // Make sure the request was successful
            if (resultCode == RESULT_OK) {
                userList.clear();
                loadUserData();
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

