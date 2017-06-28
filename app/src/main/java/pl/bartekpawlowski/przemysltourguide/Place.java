package pl.bartekpawlowski.przemysltourguide;

import android.os.Parcel;
import android.os.Parcelable;

public class Place implements Parcelable {

    // Create single Object Place or array of objects
    public static final Parcelable.Creator<Place> CREATOR = new Parcelable.Creator<Place>() {
        public Place createFromParcel(Parcel in) {
            return new Place(in);
        }

        public Place[] newArray(int size) {
            return new Place[size];
        }
    };
    private static final int NO_IMAGE_PROVIDED = -1;
    /*
    * All of these members are IDs of resources from R
    */
    private int mTitle;
    private int mText;
    private int mImage;

    public Place(int title, int text) {
        mTitle = title;
        mText = text;
        mImage = NO_IMAGE_PROVIDED;
    }

    public Place(int title, int text, int image) {
        mTitle = title;
        mText = text;
        mImage = image;
    }

    // Get Object Place when comes from Parcelable
    public Place(Parcel in) {
        mTitle = in.readInt();
        mText = in.readInt();
        mImage = in.readInt();
    }

    // Define kind of object
    @Override
    public int describeContents() {
        return 0;
    }

    // Write Object Place content to Parcel
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(mTitle);
        dest.writeInt(mText);
        dest.writeInt(mImage);
    }

    public int getTitle() {
        return mTitle;
    }

    public int getText() {
        return mText;
    }

    public int getImage() {
        return mImage;
    }

    public boolean hasImage() {
        return mImage != NO_IMAGE_PROVIDED;
    }
}
