package entity;
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

    /**
     * set the current weather condition based on latitude and longitude of the location
     * all information are retrieved from government API, which is NEA API
     * the weather condition is based on nowcast, which is weather forecast for the next 3 hours
     * the temperature and humidity is based on 12 Hours Forecast
     * @param latitude latitude of the location
     * @param longitude longitude of the location
     * @param nowcast 3-hour forecast API retrieved from NEA
     * @param forecast12 12-hour forecast retrieved from NEA
     */
    public void setWeather(double latitude, double longitude, List<List> nowcast, List forecast12) {
        double curMin = 2000000000;
        int ans = 0, counter = 0;
        for(List l: nowcast) {
            double x = latitude - Double.parseDouble(l.get(1).toString());
            double y = longitude - Double.parseDouble(l.get(2).toString());
            double min = Math.sqrt(x * x + y * y);
            if(min < curMin) {
                curMin = min;
                ans = counter;
            }
            ++counter;
        }
        condition = nowcast.get(ans).get(0).toString();
        temperature = forecast12.get(1).toString();
        humidity = forecast12.get(2).toString();
    }

    /**
     * @return the weather condition
     */
    public String getCondition() {
        return condition;
    }

    /**
     * @return the temperature
     */
    public String getTemperature() {
        return temperature;
    }

    /**
     * @return the humidity
     */
    public String getHumidity() {return humidity;}
}
