package com.capstone.bikespace.ui.feed;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.capstone.bikespace.R;
import com.capstone.bikespace.model.ActivityFeed;
import com.capstone.bikespace.utils.Constants;
import com.firebase.client.Firebase;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ComposeActivity extends AppCompatActivity {
    private EditText activity_name;
    private EditText activity_description;
    private DatabaseReference mDatabase;

    /**
     * Check if text fields are empty or not
     */
    private TextWatcher textWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }

        @Override
        public void afterTextChanged(Editable editable) {
            //Run to disable if text fields are empty
            checkFieldsForEmptyValues();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compose);

        mDatabase = FirebaseDatabase.getInstance().getReference();

        initializeScreen();

        activity_name = (EditText) findViewById(R.id.activity_name);
        activity_description = (EditText) findViewById(R.id.activity_description);

        //Set listeners
        activity_name.addTextChangedListener(textWatcher);
        activity_description.addTextChangedListener(textWatcher);

        // run once to disable if empty
        checkFieldsForEmptyValues();

        final Button btn_create_activity = (Button) findViewById(R.id.btnCreateActivity);
        btn_create_activity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View view) {
                final String activityName = activity_name.getText().toString();
                final String activityDesc = activity_description.getText().toString();
                ActivityFeed activityFeed = new ActivityFeed();
                activityFeed.setActivityName(activityName);
                activityFeed.setActivityDesc(activityDesc);
                activityFeed.setActivityOwner("Jalo");
                mDatabase.child("activity").push().setValue(activityFeed);
                finish();
            }
        });
    }

    private void checkFieldsForEmptyValues() {
        Button btn_create_activity = (Button) findViewById(R.id.btnCreateActivity);

        String name = activity_name.getText().toString();
        String desc = activity_description.getText().toString();

        if (name.isEmpty() || desc.isEmpty()) {
            btn_create_activity.setEnabled(false);
        }
        else {
            btn_create_activity.setEnabled(true);
        }
    }

    public void initializeScreen() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.app_bar);
        Toolbar bottom_toolbar = (Toolbar) findViewById(R.id.bottom_bar);
        if (bottom_toolbar != null) {
            setSupportActionBar(bottom_toolbar);
        }
        if (toolbar != null) {
            setSupportActionBar(toolbar);
            getSupportActionBar().setTitle("Add Activity");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                //overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    /**
     * When create button is clicked
     */
    public void getUpdates(DataSnapshot dataSnapshot) {

        //finish();
    }
}
