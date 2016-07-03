package com.capstone.bikespace.ui.feed;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.capstone.bikespace.R;
import com.capstone.bikespace.model.ActivityFeed;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
/**
 * A simple {@link Fragment} subclass that shows a list of all shopping lists a user can see.
 * Use the {@link feedFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class feedFragment extends Fragment {
    private RecyclerView recyclerView;

    private DatabaseReference mDatabase;
    //private ListView mListView;
    private TextView NameText, DescText, OwnerText;


    public feedFragment(){
        //Required empty constructor
    }

    /**
     * Create fragment and pass bundle with data as it's arguments
     * Right now there are not arguments...but eventually there will be.
     */
    public static feedFragment newInstance() {
        feedFragment fragment = new feedFragment();
        /*Bundle args = new Bundle();
        args.putString(Constants.KEY_ENCODED_EMAIL, encodedEmail);
        fragment.setArguments(args);*/
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //Initialize UI elements here (Inflate layout fragment)
        View rootView = inflater.inflate(R.layout.fragment_feed, container, false);
        recyclerView = (RecyclerView) rootView.findViewById(R.id.RecyclerViewFeed);


        initializeScreen(rootView);


        mDatabase = FirebaseDatabase.getInstance().getReference("activity");
        mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                ActivityFeed activityFeed = dataSnapshot.getValue(ActivityFeed.class);
                NameText.setText(activityFeed.getActivityName());
                DescText.setText(activityFeed.getActivityDesc());
                OwnerText.setText(activityFeed.getActivityOwner());
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });

        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    private void initializeScreen(View rootView){
        //mListView = (ListView) rootView.findViewById(R.id.list_view_feed);
        //recyclerView = (recyclerView) rootView.findViewById();
        NameText = (TextView) rootView.findViewById(R.id.name);
        DescText = (TextView) rootView.findViewById(R.id.desc);
        OwnerText = (TextView) rootView.findViewById(R.id.owner);
    }
}
