package br.ufc.virtual.smd.oqcomer;

import android.app.AlertDialog;
import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
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

    protected Toolbar toolbarActionbar;
    private CharSequence mTitle;
    private CharSequence mDrawerTitle;
    private String[] navMenuTitles;
    private TypedArray navMenuIcons;
    private DrawerLayout mDrawerLayout;
    private ListView mDrawerList;
    private ArrayList<NavDrawerItem> navDrawerItems;
    private static NavDrawerListAdapter adapter;
    private ActionBarDrawerToggle mDrawerToggle;

    private ListView produtoLista;
    private String[] itemName ={
            "Safari",
            "Camera",
            "Global",
            "FireFox",
            "UC Browser",
            "Android Folder",
            "VLC Player",
            "Cold War"
    };
    private String[] imagemPath ={
            "http://e.cdn-hardware.com.br/static/20110413/m55ac8604.png",
            "http://e.cdn-hardware.com.br/static/20110413/m55ac8604.png",
            "http://e.cdn-hardware.com.br/static/20110413/m55ac8604.png",
            "http://e.cdn-hardware.com.br/static/20110413/m55ac8604.png",
            "http://e.cdn-hardware.com.br/static/20110413/m55ac8604.png",
            "http://e.cdn-hardware.com.br/static/20110413/m55ac8604.png",
            "http://e.cdn-hardware.com.br/static/20110413/m55ac8604.png",
            "http://e.cdn-hardware.com.br/static/20110413/m55ac8604.png"
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getToolbarActionBar();

        prepareNavigationDrawer();

        displayView(HOME);

        /*
        HttpGet uri = new HttpGet("http://example.com");

        try {
            DefaultHttpClient client = new DefaultHttpClient();
            HttpResponse resp = client.execute(uri);

            StatusLine status = resp.getStatusLine();
            if (status.getStatusCode() != 200) {
                //"HTTP error, invalid server status code: " + resp.getStatusLine();
            }

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(resp.getEntity().getContent());
        } catch(Exception ex) {

        }
        */

//        ProdutoListaAdapter adapter=new ProdutoListaAdapter(this, itemName, imagemPath);
//        produtoLista =(ListView) findViewById(R.id.produtoLista);
//        produtoLista.setAdapter(adapter);
//
//        produtoLista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                String selectedItem = itemName[+position];
//                Toast.makeText(getApplicationContext(), selectedItem, Toast.LENGTH_SHORT).show();
//            }
//        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void novoProdutoOnClick(View v) {
        Intent telaAlvo = new Intent(MainActivity.this, NovoProdutoActivity.class);
        startActivity(telaAlvo);
    }

    public Toolbar getToolbarActionBar() {
        if (toolbarActionbar == null) {
            toolbarActionbar = (Toolbar) findViewById(R.id.toolbar);
            if (toolbarActionbar != null) {
                setSupportActionBar(toolbarActionbar);
            }
        }
        return toolbarActionbar;
    }

    private void prepareNavigationDrawer(){
        mTitle = mDrawerTitle = getTitle();

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

        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout,
                R.string.app_name, // nav drawer open - description for accessibility
                R.string.app_name // nav drawer close - description for accessibility
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

        getSupportActionBar().setDisplayShowHomeEnabled(false);
        getSupportActionBar().setHomeButtonEnabled(true);

    }

    private void displayView(int position) {
        // update the main content by replacing fragments

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
            // update selected item and title, then close the drawer
            setTitle(navMenuTitles[position]);
        } else {
            if(builder != null)
                builder.show();
            else {
                // error in creating fragment
                Log.e("MainActivity", "Error in creating fragment");
            }
        }
        mDrawerList.setItemChecked(position, true);
        mDrawerList.setSelection(position);
        //TODO Remove this when change navigation drawer to fragment
        mDrawerLayout.closeDrawer(mDrawerList);
    }

}
