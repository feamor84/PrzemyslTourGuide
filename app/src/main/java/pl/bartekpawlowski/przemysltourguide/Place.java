package pl.bartekpawlowski.przemysltourguide;

public class Place {

    /*
    * All of these members are IDs of resources from R
    */
    private int mTitle;
    private int mText;
    private int mImage;
    private static final int NO_IMAGE_PROVIDED = -1;

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
