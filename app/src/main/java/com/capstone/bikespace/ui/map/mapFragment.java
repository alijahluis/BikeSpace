package com.capstone.bikespace.ui.map;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.capstone.bikespace.R;

public class mapFragment extends Fragment {
    private ListView mListView;
    //private ActiveListAdapter mActiveListAdapter;

    public mapFragment(){
        //Required empty constructor
    }

    public static mapFragment newInstance() {
        mapFragment fragment = new mapFragment();
        /*Bundle args = new Bundle();
        args.putString(Constants.KEY_ENCODED_EMAIL, encodedEmail);
        fragment.setArguments(args);*/
        return fragment;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        /* Inflate the layout for this fragment */
        View rootView = inflater.inflate(R.layout.fragment_map, container, false);

        /**
         * Link layout elements from XML and setup the toolbar
         */
        initializeScreen(rootView);

        /**
         * Set interactive bits, such as click events/adapters
         */
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

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

    private void initializeScreen(View rootView) {
        mListView = (ListView) rootView.findViewById(R.id.list_view_map);
        //View footer = getActivity().getLayoutInflater().inflate(R.layout.footer_empty, null);
        //mListView.addFooterView(footer);
    }
}
