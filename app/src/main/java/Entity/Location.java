package entity;

import java.util.*;
/**
 * Created by dbakti7 on 10/19/2015.
 * This class implements the Location entity with the attributes name, category, weather, description,
 * and image.
 */
public class Location {
    private String name;
    private String category;
    private Weather weather;
    private String description;
    private String image;
    private Double latitude;
    private Double longitude;

    /**
     * default class constructor
     */
    public Location() {
    }

    /**
     * class constructor
     * @param name name of the location
     * @param latitude location's latitude
     * @param longitude location's longitude
     */
    public Location(String name, Double latitude, Double longitude) {
        this.name = name;
        this.category = "others";
        this.weather = new Weather();
        this.description = name;
        this.image = name;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    /**
     * set the position of the location
     * @param latitude location's latitude
     * @param longitude location's longitude
     */
    public void setPos(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    /**
     * @param name set the name of the location
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @param category set the category of the location
     */
    public void setCategory(String category) {
        this.category = category;
    }

    /**
     * set the current weather condition
     * @param nowcast 3-hour weather forecast from NEA API
     * @param forecast12 12-hour weather forecast from NEA API
     */
    public void setWeatherDetails(List<List> nowcast, List forecast12) {
        try {
            this.weather.setWeather(latitude, longitude, nowcast, forecast12);
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @param description set the description of the location
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @param image location's image url
     */
    public void setImage(String image) {
        this.image = image;
    }

    /**
     * @return name of the location
     */
    public String getName() {
        return name;
    }

    /**
     * @return category of the location
     */
    public String getCategory() {
        return category;
    }

    /**
     * @return description of the location
     */
    public String getDescription() {
        return description;
    }

    /**
     * @return weather condition of the location
     */
    public Weather getWeather() {
        return weather;
    }

    /**
     * @return image url of the location
     */
    public String getImage() {
        return image;
    }

    /**
     * @return latitude of the location
     */
    public double getLatitude() {
        return latitude;
    }

    /**
     * @return longitude of the location
     */
    public double getLongitude() {
        return longitude;
    }

}
