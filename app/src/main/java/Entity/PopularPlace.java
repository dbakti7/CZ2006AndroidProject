package entity;

/**
 * Created by dbakti7 on 11/2/2015.
 */
public class PopularPlace {
    private int id;
    private String category;
    private String name;
    private double latitude, longitude;
    public PopularPlace() {

    }
    public PopularPlace(String category, String name, double latitude, double longitude) {
        super();
        this.category = category;
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
    }
    public int getId() {
        return id;
    }

    public String getCategory() {
        return category;
    }
    public String getName() {
        return name;
    }
    public double getLatitude() {
        return latitude;
    }
    public double getLongitude() {
        return longitude;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }
    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
    public String toString() {
        return category + " " + name + " " + latitude + " " + longitude;
    }




}
