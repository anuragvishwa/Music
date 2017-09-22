package com.hfad.music;

import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Adapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    //private Toolbar mToolbar;
    private DrawerLayout mDrawerLayout;

    //https://codelabs.developers.google.com/codelabs/material-design-style/index.html?index=..%2F..%2Findex#3
    //https://www.androidhive.info/2015/04/android-getting-started-with-material-design/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        mDrawerLayout = (DrawerLayout)findViewById(R.id.drawer);

        //Adding menu icon to the drawer:
        ActionBar supportActionBar = getSupportActionBar();
        if(supportActionBar!=null){
            supportActionBar.setHomeAsUpIndicator(R.drawable.ic_menu_white);
            supportActionBar.setDefaultDisplayHomeAsUpEnabled(true);
        }

        //Set the behaviour of Navigation drawer:
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener(){
                    //This method will trigger on item click of the navigation menu:

                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem){
                        menuItem.setChecked(true);
                        //TODO:handle navigation
                        //Closing drawer on item click
                        mDrawerLayout.closeDrawers();
                        return true;
                    }
                }
        );


        //Adding toolbar to main screen
        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
      //     getSupportActionBar().setDisplayShowHomeEnabled(true);

        //Adding Tabs
        /*TabLayout tabs = (TabLayout)findViewById(R.id.tabs);
        tabs.addTab(tabs.newTab().setText("Tab 1"));
        tabs.addTab(tabs.newTab().setText("Tab 2"));
        tabs.addTab(tabs.newTab().setText("Tab 3"));*/

        ViewPager viewPager = (ViewPager)findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        TabLayout tabs = (TabLayout)findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);

    }


    //Add fragements to tabs
    private void setupViewPager(ViewPager viewPager)
    {
        Adapter1 adapter =  new Adapter1(getSupportFragmentManager());
        adapter.addFragment(new ListContentFragment(),"List");
        adapter.addFragment(new CardContentFragment(),"Card");
        adapter.addFragment(new TileContentFragment(),"Tile");
        viewPager.setAdapter(adapter);

        }


    static class Adapter1 extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragementTitleList = new ArrayList<>();



        public Adapter1(FragmentManager manager) {
            super(manager);
        }


        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }


        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment,String title){
            mFragmentList.add(fragment);
            mFragementTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position){
            return mFragementTitleList.get(position);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menu_navigation,menu);
        return true;
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        int id = item.getItemId();

        if(id==R.id.action_settings){
            return true;
        }
        else if(id==android.R.id.home){
            mDrawerLayout.openDrawer(GravityCompat.START);
        }
        return super.onOptionsItemSelected(item);
    }

}
