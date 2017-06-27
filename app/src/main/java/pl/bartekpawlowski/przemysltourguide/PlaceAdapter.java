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

public class PlaceAdapter extends ArrayAdapter<Place> {

    public static final int ORIENTATION_HORIZONTAL = 0;
    public static final int ORIENTATION_VERTICAL = 1;
    private int mOrientation = ORIENTATION_VERTICAL;

    public PlaceAdapter(Context context, ArrayList<Place> places) {
        super(context, 0, places);
    }

    public PlaceAdapter(Context context, ArrayList<Place> places, int orientation) {
        super(context, 0, places);
        mOrientation = orientation;
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
        if (currentPlace.hasImage()) {
            placeImage.setImageResource(currentPlace.getImage());
            placeImage.setVisibility(View.VISIBLE);
        } else {
            placeImage.setVisibility(View.GONE);
        }

        TextView placeHeading = (TextView) listPlaces.findViewById(R.id.placeHeading);
        placeHeading.setText(getContext().getResources().getText(currentPlace.getTitle()));

        TextView placeText = (TextView) listPlaces.findViewById(R.id.placeText);
        placeHeading.setText(getContext().getResources().getText(currentPlace.getText()));

        return listPlaces;
    }
}
