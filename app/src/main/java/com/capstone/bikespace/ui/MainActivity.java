package com.capstone.bikespace.ui;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.capstone.bikespace.R;
import com.capstone.bikespace.ui.feed.ComposeActivity;
import com.capstone.bikespace.ui.feed.feedFragment;
import com.capstone.bikespace.ui.map.mapFragment;
import com.capstone.bikespace.ui.me.meFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeScreen();
    }

    public void initializeScreen() {
        ViewPager viewPager = (ViewPager) findViewById(R.id.pager);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        Toolbar toolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        /**
         * Create SectionPagerAdapter, set it as adapter to viewPager with setOffscreenPageLimit(3)
         **/
        SectionPagerAdapter adapter = new SectionPagerAdapter(getSupportFragmentManager());
        viewPager.setOffscreenPageLimit(3);
        viewPager.setAdapter(adapter);
        /**
         * Setup the mTabLayout with view pager
         */
        tabLayout.setupWithViewPager(viewPager);
    }

    /**
     * Show Shopping Cart icon and Settings icon
     * @param menu
     * @return
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main_menu, menu);

        return true;
    }

    /**
     * Call the activity for shopping cart or settings if clicked/touched
     * @param item
     * @return
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int res_id = item.getItemId();
        if(res_id == R.id.settings) {
            Toast.makeText(getApplicationContext(), "Settings menu selected", Toast.LENGTH_SHORT).show();
        }
        else if (res_id == R.id.shopping_cart) {
            Toast.makeText(getApplicationContext(), "Shopping cart selected", Toast.LENGTH_SHORT).show();
        }
        return true;
    }

    /**
     * Create instance of AddActivity fragment and show
     */
    public void showComposeActivity(View view) {
        Intent intent = new Intent(MainActivity.this, ComposeActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in, R.anim.fade_out);
    }


    /**
     * SectionPagerAdapter class that extends FragmentStatePagerAdapter to save fragments state
     */
    public class SectionPagerAdapter extends FragmentStatePagerAdapter {

        public SectionPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        /**
         * Use positions (0 and 1) to find and instantiate fragments with newInstance()
         *
         * @param position
         */
        @Override
        public Fragment getItem(int position) {

            Fragment fragment = null;

            /**
             * Set fragment to different fragments depending on position in ViewPager
             */
            switch (position) {
                case 0:
                    fragment = feedFragment.newInstance();
                    break;
                case 1:
                    fragment = mapFragment.newInstance();
                    break;
                case 2:
                    fragment = meFragment.newInstance();
                    break;
                default:
                    fragment = feedFragment.newInstance();
                    break;
            }

            return fragment;
        }

        /**
         * Number of pages
         *
         * @return 3
         */
        @Override
        public int getCount() {
            return 3;
        }

        /**
         * Set string resources as titles for each fragment by it's position
         *
         * @param position
         */
        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return getString(R.string.pager_title_feed);
                case 1:
                    return getString(R.string.pager_title_map);
                case 2:
                default:
                    return getString(R.string.pager_title_me);
            }
        }
    }
}
