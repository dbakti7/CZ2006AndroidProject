package Entity;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by dbakti7 on 10/19/2015.
 */
public class Weather {
    private String condition;
    private double windSpeed;
    private double precipitation;
    private double humidity;
    public Weather() {
        condition = null;
        windSpeed = 0;
        precipitation = 0;
        humidity = 0;
    }
    public void setWeather() {
        // from API
    }
    public List getWeatherDetails(){
        List weatherDetails = new ArrayList();
        weatherDetails.add(condition);
        weatherDetails.add(windSpeed);
        weatherDetails.add(precipitation);
        weatherDetails.add(humidity);
        return weatherDetails;
    }
    public String toString() {
        return this.condition;
    }
}
