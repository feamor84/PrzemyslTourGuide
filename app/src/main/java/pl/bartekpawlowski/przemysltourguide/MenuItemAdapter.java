package pl.bartekpawlowski.przemysltourguide;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MenuItemAdapter extends ArrayAdapter<MenuItem> {

    public MenuItemAdapter(Context context, ArrayList<MenuItem> menuItems) {
        super(context, 0, menuItems);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listMenuItem = convertView;
        if(listMenuItem == null) {
            listMenuItem = LayoutInflater.from(getContext()).inflate(R.layout.menu_item, parent, false);
        }

        final MenuItem currentMenuItem = getItem(position);

        ImageView menuIcon = (ImageView) listMenuItem.findViewById(R.id.menuIcon);
        if(currentMenuItem.hasIcon()) {
            menuIcon.setImageResource(currentMenuItem.getIconID());
            menuIcon.setVisibility(View.VISIBLE);
        } else {
            menuIcon.setVisibility(View.GONE);
        }

        TextView menuText = (TextView) listMenuItem.findViewById(R.id.menuText);
        menuText.setText(getContext().getResources().getText(currentMenuItem.getTitle()));

        return listMenuItem;
    }
}
