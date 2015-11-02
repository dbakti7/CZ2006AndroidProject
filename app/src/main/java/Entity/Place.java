package entity;
import java.util.*;
/**
 * Created by dbakti7 on 10/19/2015.
 * This class implements the Place entity with the attributes name, category, weather, description,
 * and image.
 */
public class Place {
    private String name;
    private String category;
    private Weather weather;
    private String description;
    private String image;

    /**
     * default class constructor
     */
    public Place() {
        name = null;
        category = null;
        weather = null;
        description = null;
        image = null;
    }


    /**
     * class contructor
     */

    public Place(String name, String category, Weather weather, String description, String image) throws Exception{
        this.name = name;
        this.category = category;
        this.weather.setWeather();
        this.description = description;
        this.image = image;
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

    public void setWeather() throws Exception{
        this.weather.setWeather();
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
}
