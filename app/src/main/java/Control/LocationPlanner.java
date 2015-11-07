package control;

import android.content.Context;

import entity.Location;
import entity.SQLiteHelper;

/**
 * Created by dbakti7 on 10/20/2015.
 * This class implements the control class to edit the data about locations selected by user
 */
public class LocationPlanner {
    /**
     * add location from popular places provided into current travel plan
     * @param location location to be added
     * @param context context needed to access database
     */
    public void addPlaceFromPopularPlaces(Location location, Context context) {
        SQLiteHelper db = new SQLiteHelper(context);
        db.getWritableDatabase();
        db.addLocationToCurrentPlan(location);
        db.close();
    }

    /**
     * add location from search result into current travel plan
     * @param location location to be added
     * @param context context needed to access database
     */
    public void addPlaceFromSearchResult(Location location, Context context) {
        SQLiteHelper db = new SQLiteHelper(context);
        db.getWritableDatabase();
        db.addLocationToOtherPlaces(location);
        db.addLocationToCurrentPlan(location);
        db.close();
    }

    /**
     * remove a location from current plan
     * @param location location to be removed
     * @param context context needed to access the database
     */
    public void removePlaceFromCurrentPlan(Location location, Context context) {
        SQLiteHelper db = new SQLiteHelper(context);
        db.getWritableDatabase();
        db.deleteLocationFromCurrentPlan(location);
        db.close();
    }

}
