package entity;

/**
 * Created by dbakti7 on 10/19/2015.
 * This class implements the Plan entity
 */
public class Plan {
    private String date;
    private Location locationList[];
    private int locationCount;
    /**
     * class constructor
     */
    public Plan() {
        date = null;
        locationList = new Location[20];
        locationCount = 0;
    }

    /**
     * Add a new location into the current travel plan
     * @param location location to be added
     */
    public void addLocation(Location location) {
        locationList[locationCount] = new Location();
        locationList[locationCount].setName(location.getName());
        ++locationCount;
    }

    /**
     * @return number of location in the travel plan
     */
    public int getLocationCount() {
        return locationCount;
    }

    /**
     * @return the date of the travel plan
     */
    public String getDate() {
        return date;
    }

    /**
     * @return the names of the locations in the plan
     */
    public String[] getlocationList() {
        String[] locationNames = new String[locationCount];
        for(int i = 0;i<locationCount;++i)
            locationNames[i] = locationList[i].getName();
        return locationNames;
    }

    /**
     * set the date of the travel plan
     * @param date date of the travel plan
     */
    public void setDate(String date) {
        this.date = date;
    }
}