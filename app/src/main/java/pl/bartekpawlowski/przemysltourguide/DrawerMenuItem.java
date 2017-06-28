package pl.bartekpawlowski.przemysltourguide;

public class DrawerMenuItem {

    private static final int NO_IMAGE_PROVIDED = -1;
    private int mTitleID;
    private int mIconID;

    /**
     * @param titleID ID of string resource
     */

    public DrawerMenuItem(int titleID) {
        mTitleID = titleID;
        mIconID = NO_IMAGE_PROVIDED;
    }

    /**
     * @param titleID - ID of string resource
     * @param iconID  - ID of drawable (icon) resource
     */

    public DrawerMenuItem(int titleID, int iconID) {
        mTitleID = titleID;
        mIconID = iconID;
    }

    /**
     * @return int ID string resource
     */

    public int getTitle() {
        return mTitleID;
    }

    /**
     * @return int ID drawable resource
     */

    public int getIconID() {
        return mIconID;
    }

    /**
     * @return boolean true if icon exist else false
     */

    public boolean hasIcon() {
        return mIconID != NO_IMAGE_PROVIDED;
    }
}
