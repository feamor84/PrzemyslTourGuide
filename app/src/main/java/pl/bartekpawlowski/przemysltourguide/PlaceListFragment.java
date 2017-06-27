package pl.bartekpawlowski.przemysltourguide;

import android.app.ListFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class PlaceListFragment extends ListFragment {

    private ArrayList<Place> mPlaceList;
    public static final String PLACE_ARRAY_LIST = "place_array_list";

    public PlaceListFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle args = getArguments();
        mPlaceList = args.getParcelableArrayList(PLACE_ARRAY_LIST);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        PlaceAdapter placeAdapter = new PlaceAdapter(inflater.getContext(), mPlaceList, PlaceAdapter.ORIENTATION_HORIZONTAL);
        setListAdapter(placeAdapter);

        return super.onCreateView(inflater, container, savedInstanceState);
    }
}
