
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

public class UserFormActivity extends AppCompatActivity {
    private Boolean booleanEditMode = false;

	private TextInputEditText tieUsername; 
	private TextInputEditText tiePassword; 

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_user);

        Intent intent = getIntent();
        if (intent.getStringExtra("typeOperation").equals("edit")) {
            booleanEditMode = true;
        }

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle(booleanEditMode ? "Edit User" : "Add User");
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

		tieUsername =  (TextInputEditText) findViewById(R.id.tieUsername); 
		tiePassword =  (TextInputEditText) findViewById(R.id.tiePassword); 

       
        Button btnSave = (Button) findViewById(R.id.btnSave);

        if (booleanEditMode) {
            btnSave.setText("Save Changes");
            User user = (User) intent.getSerializableExtra("user");
			tieUsername.setText(user.getUsername());
			tiePassword.setText(user.getPassword());
        }

        MySQLiteHelper db = new MySQLiteHelper(this);
        final UserDAO userDAO = new UserDAO(db);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               User user = getUserFromEditext();
                if (booleanEditMode) {
                    userDAO.updateUser(user);
                }else{
                    userDAO.addUser(user);
                }

                Intent returnIntent = new Intent();
                setResult(Activity.RESULT_OK,returnIntent);
                finish();
            }
        });

    }

    private User getUserFromEditext() {
		String username = tieUsername.getText().toString();
		String password = tiePassword.getText().toString();
        
        return new User(username, password);
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

