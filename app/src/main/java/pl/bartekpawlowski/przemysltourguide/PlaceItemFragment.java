package pl.bartekpawlowski.przemysltourguide;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class PlaceItemFragment extends Fragment {

    public static final String PLACE_ITEM = "place_item";
    private Place mPlace;

    public PlaceItemFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle args = getArguments();
        mPlace = args.getParcelable(PLACE_ITEM);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View placeItemView = inflater.inflate(R.layout.place_item, container, false);

        ImageView itemPlaceImage = (ImageView) placeItemView.findViewById(R.id.itemPlaceImage);
        if (mPlace.hasImage()) {
            itemPlaceImage.setImageResource(mPlace.getImage());
            itemPlaceImage.setVisibility(View.VISIBLE);
        } else {
            itemPlaceImage.setVisibility(View.GONE);
        }


        TextView itemPlaceHeading = (TextView) placeItemView.findViewById(R.id.itemPlaceHeading);
        itemPlaceHeading.setText(getResources().getText(mPlace.getTitle()));

        TextView itemPlaceText = (TextView) placeItemView.findViewById(R.id.itemPlaceText);
        itemPlaceText.setText(getResources().getText(mPlace.getText()));

        return placeItemView;
    }
}
