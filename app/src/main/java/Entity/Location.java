package entity;
import android.content.Context;
import android.widget.Toast;

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
    private Double x;
    private Double y;

    /**
     * default class constructor
     */
    public Location() {
        name = null;
        category = null;
        weather = new Weather();
        description = null;
        x = 0.0;
        y = 0.0;
        image = null;
    }


    /**
     * class contructor
     */

    public Location(String name, String category, Weather weather, String description, String image) throws Exception{
        this.name = name;
        this.category = category;
        //this.weather.setWeather(x, y);
        this.description = description;
        this.image = image;
    }

    public Location(String name, Double x, Double y) throws Exception{
        this.name = name;
        //this.setWeatherDetails();
        this.x = x;
        this.y = y;
    }
    public void setPos(double x, double y) {
        this.x = x;
        this.y = y;
    }
    /**
     * set the weather
     * @throws Exception
     */
    public void setName(String name) {
        this.name = name;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setWeatherDetails() {
        try {
            this.weather.setWeather(x, y);
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }
    public String getCategory() {
        return category;
    }
    public String getDescription() {
        return description;
    }
    public Weather getWeather() {
        return weather;
    }
    public String getImage() {
        return image;
    }

    /**
     * get the details of the place
     * @return details of the place in a List
     */
    public List getDetails() {
        // return details of a place
        List details = new ArrayList();
        details.add(name);
        details.add(category);
        details.add(weather);
        details.add(description);
        details.add(image);
        return details;
    }
    public double getLatitude() {
        return x;
    }
    public double getLongitude() {
        return y;
    }

}
