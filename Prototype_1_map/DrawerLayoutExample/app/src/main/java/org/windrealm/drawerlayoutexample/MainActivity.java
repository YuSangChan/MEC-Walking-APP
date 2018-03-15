package org.windrealm.drawerlayoutexample;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ActionBarDrawerToggle mDrawerToggle;
    DrawerLayout mDrawer;
    TextView messageTextView;
    ListView mDrawerListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get references to the TextView and DrawerLayout
        messageTextView = (TextView) findViewById(R.id.messageTextView);
        mDrawer = (DrawerLayout) findViewById(R.id.drawer_layout);

        // These lines are needed to display the top-left button
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // Make the button work
        mDrawerToggle = new ActionBarDrawerToggle(this,mDrawer,R.string.app_name,R.string.app_name){
            @Override
            public void onDrawerClosed(View drawerView) {
            }

            @Override
            public void onDrawerOpened(View drawerView) {
            }
        };
        mDrawer.setDrawerListener(mDrawerToggle);
        mDrawerToggle.syncState();

        // Change the TextView message when ListView item is clicked
        mDrawerListView = (ListView) findViewById(R.id.left_drawer);
        mDrawerListView.setOnItemClickListener(new ListView.OnItemClickListener() {
           @Override
           public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               if (position==0)
               {
                   Intent intent = new Intent(MainActivity.this,MapsActivity.class);
                   startActivity(intent);
               }else
               {
                   messageTextView.setText("Menu Item at position " + position + " clicked.");;
                   mDrawer.closeDrawer(GravityCompat.START);
               }

           }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Pass the event to ActionBarDrawerToggle, if it returns
        // true, then it has handled the app icon touch event
        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        // Handle your other action bar items...
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState has occurred.
        mDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mDrawerToggle.onConfigurationChanged(newConfig);
    }

}