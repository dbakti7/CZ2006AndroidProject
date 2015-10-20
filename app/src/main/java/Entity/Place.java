package Entity;
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
<<<<<<< HEAD

    /**
     * class contructor
     */
    public Place(String name, String category, Weather weather, String description, String image) {
        // constructor
        this.name = name;
        this.category = category;
        this.weather.setWeather();
=======
    public Place(String name, String category, String description, String image) throws Exception{
        this.name = name;
        this.category = category;
        this.setDetails();
>>>>>>> f28fc74caa9f56b3c08c63dd7d6f764a0fa917f7
        this.description = description;
        this.image = image;
    }

    /**
     * set the weather
     * @throws Exception
     */
    public void setDetails() throws Exception{
        this.weather.setWeather();
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
