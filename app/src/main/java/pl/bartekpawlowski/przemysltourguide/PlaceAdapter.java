package pl.bartekpawlowski.przemysltourguide;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class PlaceAdapter extends ArrayAdapter<Place> {

    public static final int ORIENTATION_HORIZONTAL = 0;
    public static final int ORIENTATION_VERTICAL = 1;
    private int mOrientation = ORIENTATION_VERTICAL;
    private Context mContext;

    public PlaceAdapter(Context context, ArrayList<Place> places) {
        super(context, 0, places);
        mContext = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listPlaces = convertView;
        if (listPlaces == null) {
            if (mOrientation == ORIENTATION_VERTICAL) {
                listPlaces = LayoutInflater.from(getContext()).inflate(R.layout.place_list_vertical, parent, false);
            } else if (mOrientation == ORIENTATION_HORIZONTAL) {
                listPlaces = LayoutInflater.from(getContext()).inflate(R.layout.place_list_horizontal, parent, false);
            }
        }


        final Place currentPlace = getItem(position);

        ImageView placeImage = (ImageView) listPlaces.findViewById(R.id.placeImage);
        View placeDivider = (View) listPlaces.findViewById(R.id.placeDivider);
        if (currentPlace.hasImage()) {
            placeImage.setImageResource(currentPlace.getImage());
            placeImage.setVisibility(View.VISIBLE);
            if (placeDivider != null) {
                placeDivider.setVisibility(View.VISIBLE);
            }
        } else {
            placeImage.setVisibility(View.GONE);
            if (placeDivider != null) {
                placeDivider.setVisibility(View.GONE);
            }
        }

        TextView placeHeading = (TextView) listPlaces.findViewById(R.id.placeHeading);
        placeHeading.setText(getContext().getResources().getText(currentPlace.getTitle()));

        listPlaces.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PlaceItemFragment placeItemFragment = new PlaceItemFragment();
                Bundle args = new Bundle();
                args.putParcelable(PlaceItemFragment.PLACE_ITEM, currentPlace);
                placeItemFragment.setArguments(args);

                FragmentManager fragmentManager = ((Activity) mContext).getFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.contentContainer, placeItemFragment).commit();
            }
        });

        return listPlaces;
    }
}
