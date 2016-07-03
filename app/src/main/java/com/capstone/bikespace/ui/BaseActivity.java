package com.capstone.bikespace.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Used as base class for all activities
 * Implements GoogleAPIClient to enable logout
 * Define variables used in all activities
 */
public class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}
