package pl.bartekpawlowski.przemysltourguide;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*
        * Create ArrayList<MenuItem> which contains menu items, resources gets from drawable and string
         */
        final ArrayList<MenuItem> menuItems = new ArrayList<MenuItem>();
        menuItems.add(new MenuItem(R.string.menu_tourist_attractions, R.drawable.ic_grade_black_24dp));
        menuItems.add(new MenuItem(R.string.menu_monuments, R.drawable.ic_filter_black_24dp));
        menuItems.add(new MenuItem(R.string.menu_museums, R.drawable.ic_account_balance_black_24dp));
        menuItems.add(new MenuItem(R.string.menu_food_and_drink, R.drawable.ic_local_bar_black_24dp));

        ListView menuView = (ListView) findViewById(R.id.drawerMenu);

        MenuItemAdapter menuItemAdapter = new MenuItemAdapter(this, menuItems);

        menuView.setAdapter(menuItemAdapter);

        menuView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                
            }
        });
    }
}
