package br.ufc.virtual.smd.oqcomer;

import android.app.AlertDialog;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;

import br.ufc.virtual.smd.oqcomer.adapter.NavDrawerListAdapter;
import br.ufc.virtual.smd.oqcomer.fragments.MainFragment;
import br.ufc.virtual.smd.oqcomer.model.NavDrawerItem;


public class MainActivity extends AppCompatActivity {

    public static final int HOME = 0;
    public static final int LOGOUT = 1;
    private static NavDrawerListAdapter adapter;
    protected Toolbar toolbarActionbar;
    private CharSequence mTitle;
    private CharSequence mDrawerTitle;
    private String[] navMenuTitles;
    private TypedArray navMenuIcons;
    private DrawerLayout mDrawerLayout;
    private ListView mDrawerList;
    private ArrayList<NavDrawerItem> navDrawerItems;
    private ActionBarDrawerToggle mDrawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getToolbarActionBar();
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setHomeButtonEnabled(true);

        prepareNavigationDrawer();

        displayView(HOME);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void novoProdutoOnClick(View v) {
        Fragment fragment = new NovoProdutoFragment();
        FragmentTransaction transaction =  getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_container, fragment).addToBackStack(fragment.getClass().getName()).commit();
        mDrawerLayout.closeDrawer(mDrawerList);
    }

    public Toolbar getToolbarActionBar() {
        if (toolbarActionbar == null) {
            toolbarActionbar = (Toolbar) findViewById(R.id.toolbar);
            setSupportActionBar(toolbarActionbar);
        }
        return toolbarActionbar;
    }

    private void prepareNavigationDrawer(){
        mTitle = mDrawerTitle = getTitle();
        getSupportActionBar().setTitle(mTitle);

        navMenuTitles = getResources().getStringArray(R.array.nav_drawer_items);

        navMenuIcons = getResources()
                .obtainTypedArray(R.array.nav_drawer_icons);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerList = (ListView) findViewById(R.id.list_slidermenu);

        navDrawerItems = new ArrayList<>();

        navDrawerItems.add(new NavDrawerItem(navMenuTitles[0], navMenuIcons.getResourceId(0, -1)));
        navDrawerItems.add(new NavDrawerItem(navMenuTitles[1], navMenuIcons.getResourceId(1, -1)));

        navMenuIcons.recycle();

        adapter = new NavDrawerListAdapter(getApplicationContext(),
                navDrawerItems);
        View header = LayoutInflater.from(this).inflate(R.layout.header_list_layout, null);
        mDrawerList.addHeaderView(header, null, false);
        mDrawerList.setAdapter(adapter);
        getSupportActionBar().setHomeButtonEnabled(true);

        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, toolbarActionbar,
                R.string.app_name,
                R.string.app_name
        ) {
            public void onDrawerClosed(View view) {
                getSupportActionBar().setTitle(mTitle);
                invalidateOptionsMenu();
            }

            public void onDrawerOpened(View drawerView) {
                getSupportActionBar().setTitle(mDrawerTitle);
                invalidateOptionsMenu();
            }
        };
        mDrawerLayout.setDrawerListener(mDrawerToggle);
        mDrawerToggle.syncState();
    }

    @Override
    public void onPostCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onPostCreate(savedInstanceState, persistentState);
        mDrawerToggle.syncState();
    }

    private void displayView(int position) {

        Fragment fragment = null;
        AlertDialog.Builder builder = null;
        switch (position) {
            case HOME:
                fragment = new MainFragment();
                break;
            case LOGOUT:
                break;
            default:
                break;
        }

        if (fragment != null) {
            FragmentTransaction transaction =  getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.frame_container, fragment).addToBackStack(fragment.getClass().getName()).commit();
            setTitle(navMenuTitles[position]);
        } else {
            if(builder != null)
                builder.show();
            else {
                Log.e("MainActivity", "Error in creating fragment");
            }
        }
        mDrawerList.setItemChecked(position, true);
        mDrawerList.setSelection(position);
        mDrawerLayout.closeDrawer(mDrawerList);
    }

}
