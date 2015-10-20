package Entity;


import java.util.ArrayList;
import java.util.List;


/**
 * Created by dbakti7 on 10/19/2015.
 * This class implements Weather entity.
 */
public class Weather {
    private String condition;
    private String temperature;
    private String humidity;
    public Weather() {
        condition = null;
        temperature = null;
        humidity = null;
    }

    public void setWeather() {
        // from API
        /* This part is still under development
        List container = accessGovAPI.get12HourForecast();
        condition = container.get(0).toString();
        temperature = container.get(1).toString();
        humidity = container.get(2).toString();*/
    }

    public List getWeatherDetails(){
        List weatherDetails = new ArrayList();
        weatherDetails.add(condition);
        weatherDetails.add(temperature);
        weatherDetails.add(humidity);
        return weatherDetails;
    }

    public String toString() {
        return this.condition;
    }
}
