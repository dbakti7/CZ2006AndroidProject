package entity;

/**
 * Created by dbakti7 on 10/19/2015.
 * This class implements the Plan entity with the attributes finalized, date, listLocation, ETA,
 * travelTime, transport, and travelCost.
 */
public class Plan {
    private boolean finalized;
    private String date;
    private Location listLocation[] = new Location[10];
    private int[] ETA = new int[10];
    private int[] travelTime = new int[10];
    private String[] transport = new String[10];
    private double[] travelCost = new double[10];
    private int locationCount;
    /**
     * class constructor
     */
    public Plan() {
        finalized = false;
        date = null;
        locationCount = 0;
    }

    /**
     * getter functions
     * @return various attributes
     */
    public void addLocation(Location location) {
        listLocation[locationCount] = new Location();
        listLocation[locationCount].setName(location.getName());
        ++locationCount;
    }
    public int getLocationCount() {
        return locationCount;
    }
    public Location[] getListLocation() {
        return listLocation;
    }
    public boolean getState() {
        return finalized;
    }
    public String getDate() {
        return date;
    }
    public Location[] getPlaces() {
        return listLocation;
    }
    public int[] getETA() {
        return ETA;
    }
    public int[] getTravelTime() {
        return travelTime;
    }
    public String[] getTransport() {
        return transport;
    }
    public double[] getTravelCost() {
        return travelCost;
    }

    /**
     * setter functions
     */
    public void setState(boolean finalized) {
        this.finalized = finalized;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public void setPlaces(Location[] listLocation) {
        this.listLocation = listLocation;
    }
    public void setETA(){
        // get from API gothere.sg
    }
    public void setTravelTime() {
        // get from API
    }
    public void setTransport() {
        // get from API
    }
    public void setTravelCost() {
        // get from API
    }



}