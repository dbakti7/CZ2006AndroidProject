package Entity;
import java.util.*;
/**
 * Created by dbakti7 on 10/19/2015.
 */
public class Plan {
    private boolean finalized;
    private String date;
    private Place listPlace[] = new Place[10];
    private int[] ETA = new int[10];
    private int[] travelTime = new int[10];
    private String[] transport = new String[10];
    private double[] travelCost = new double[10];
    Plan() {
        finalized = false;
        date = null;
        for(int i = 0; i < 10; ++i)
            listPlace[i] = new Place();
    }
    public boolean getState() {
        return finalized;
    }
    public void setState(boolean finalized) {
        this.finalized = finalized;
    }
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public Place[] getPlaces() {
        return listPlace;
    }
    public void setPlaces(Place[] listPlace) {
        this.listPlace = listPlace;
    }
    public void setETA(){
        // get from API gothere.sg
    }
    public int[] getETA() {
        return ETA;
    }
    public int[] getTravelTime() {
        return travelTime;
    }
    public void setTransport() {
        // get from API
    }
    public String[] getTransport() {
        return transport;
    }
    public void setTravelCost() {
        // get from API
    }
    public double[] getTravelCost() {
        return travelCost;
    }


}