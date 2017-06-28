package pl.bartekpawlowski.przemysltourguide;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.ListFragment;
import android.content.res.Configuration;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private CharSequence mTitle;
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mDrawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawerContainer);
        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.drawer_open, R.string.drawer_close) {

            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                getSupportActionBar().setTitle(mTitle);
            }

            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                getSupportActionBar().setTitle(mTitle);
            }
        };

        mDrawerLayout.addDrawerListener(mDrawerToggle);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        Place przemysl = new Place(R.string.przemysl_heading, R.string.przemysl_text, R.drawable.przemysl_logo);

        PlaceItemFragment placeItemFragment = new PlaceItemFragment();
        Bundle args = new Bundle();
        args.putParcelable(PlaceItemFragment.PLACE_ITEM, przemysl);
        placeItemFragment.setArguments(args);

        FragmentManager fragmentManager = getFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.contentContainer, placeItemFragment).commit();

        /*
        * Create ArrayList<MenuItem> which contains menu items, resources gets from drawable and string
         */
        final ArrayList<DrawerMenuItem> menuItems = new ArrayList<DrawerMenuItem>();
        menuItems.add(new DrawerMenuItem(R.string.menu_tourist_attractions, R.drawable.ic_grade_black_24dp));
        menuItems.add(new DrawerMenuItem(R.string.menu_monuments, R.drawable.ic_filter_black_24dp));
        menuItems.add(new DrawerMenuItem(R.string.menu_museums, R.drawable.ic_account_balance_black_24dp));
        menuItems.add(new DrawerMenuItem(R.string.menu_food_and_drink, R.drawable.ic_local_bar_black_24dp));

        ListView menuView = (ListView) findViewById(R.id.drawerMenu);
        DrawerMenuItemAdapter drawerMenuItemAdapter = new DrawerMenuItemAdapter(this, menuItems);
        menuView.setAdapter(drawerMenuItemAdapter);

        /*
        * ArrayList<Place> which contains item to attraction ListFragment
        */
        final ArrayList<Place> attractions = new ArrayList<Place>();
        attractions.add(new Place(R.string.t_kazmierzowski_castle_heading, R.string.t_kazmierzowski_castele_text, R.drawable.zamek_kazmierzowski));
        attractions.add(new Place(R.string.t_przemysl_fortress_heading, R.string.t_przemysl_fortress_text, R.drawable.twierdza_przemysl));
        attractions.add(new Place(R.string.t_clock_tower_heading, R.string.t_clock_tower_text, R.drawable.wieza_zegarowa));

        /*
        * ArrayList<Place> which contains item to monuments ListFragment
        */
        final ArrayList<Place> monuments = new ArrayList<Place>();
        monuments.add(new Place(R.string.mo_bench_of_jozef_szwejk_heading, R.string.mo_bench_of_jozef_szwejk_text, R.drawable.laweczka_jozefa_szwejka));
        monuments.add(new Place(R.string.mo_monument_of_orleta_przemyskie_heading, R.string.mo_monument_of_orleta_przemyskie_text, R.drawable.pomnik_orlat_przemyskich));
        monuments.add(new Place(R.string.mo_taraski_hill_heading, R.string.mo_tatarski_hill_text, R.drawable.kopiec_tatarski));

        /*
        * ArrayList<Place> which contains item to museums ListFragment
        */
        final ArrayList<Place> museums = new ArrayList<Place>();
        museums.add(new Place(R.string.mu_archdiocese_museum_heading, R.string.mu_archdiocese_museum_text, R.drawable.muzeum_archidiecezji_przemyskiej));
        museums.add(new Place(R.string.mu_museum_of_przemysl_fortress_heading, R.string.mu_museum_of_przemysl_fortress_text, R.drawable.muzeum_twierdzy_przemysl));
        museums.add(new Place(R.string.mu_national_museum_of_przemysl_land_heading, R.string.mu_national_museum_of_przemysl_land_text, R.drawable.muzeum_ziemi_przemskiej));

        /*
        * ArrayList<Place> which contains item to food and drink ListFragment
        */
        final ArrayList<Place> foodAndDrink = new ArrayList<Place>();
        foodAndDrink.add(new Place(R.string.f_fiore_bakery_heading, R.string.f_fiore_bakery_text, R.drawable.cukiernia_fiore));
        foodAndDrink.add(new Place(R.string.f_restaurant_cuda_wianki_heading, R.string.f_restaurant_cuda_wianki_text, R.drawable.cuda_wianki));
        foodAndDrink.add(new Place(R.string.f_restaurant_monaricha_heading, R.string.f_restaurant_monarchia_text, R.drawable.monarchia_przemysl));

        menuView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ArrayList<Place> listToPopulate = null;

                switch (position) {
                    case 0:
                        listToPopulate = attractions;
                        mTitle = getResources().getString(R.string.menu_tourist_attractions);
                        break;
                    case 1:
                        listToPopulate = monuments;
                        mTitle = getResources().getString(R.string.menu_monuments);
                        break;
                    case 2:
                        listToPopulate = museums;
                        mTitle = getResources().getString(R.string.menu_museums);
                        break;
                    case 3:
                        listToPopulate = foodAndDrink;
                        mTitle = getResources().getString(R.string.menu_food_and_drink);
                        break;
                }

                ListFragment listFragment = new PlaceListFragment();
                Bundle args = new Bundle();
                args.putParcelableArrayList(PlaceListFragment.PLACE_ARRAY_LIST, listToPopulate);
                listFragment.setArguments(args);

                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.contentContainer, listFragment).commit();

                mDrawerLayout.closeDrawer(GravityCompat.START);
                getSupportActionBar().setTitle(mTitle);
            }
        });
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

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Pass the event to ActionBarDrawerToggle, if it returns
        // true, then it has handled the app icon touch event
        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
