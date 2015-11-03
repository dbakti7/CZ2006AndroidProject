package entity;


import android.content.Context;

import java.util.ArrayList;
import java.util.List;

import boundary.accessGovAPI;


/**
 * Created by dbakti7 on 10/19/2015.
 * This class implements Weather entity.
 */
public class Weather {
    private String condition;
    private String temperature;
    private String humidity;

    public Weather() {
        condition = "default";
        temperature = null;
        humidity = null;
    }

    public Weather(String condition, String temperature, String humidity) {
        this.condition = condition;
        this.temperature = temperature;
        this.humidity = humidity;
    }

    public void setWeather(double latitude, double longitude) throws Exception{
        // from API

        List<List> temp = accessGovAPI.getNowcast();
        double curMin = 2000000000;
        int ans = 0, counter = 0;
        for(List l: temp) {
            double x = latitude - Double.parseDouble(l.get(1).toString());
            double y = longitude - Double.parseDouble(l.get(2).toString());
            double min = Math.sqrt(x * x + y * y);
            if(min < curMin) {
                curMin = min;
                ans = counter;
            }
            ++counter;
        }

        List<List> container = accessGovAPI.get12HourForecast();
        condition = temp.get(ans).get(0).toString();
        temperature = "skldjfljsdlfj";
        temperature = container.get(1).toString();
        humidity = container.get(2).toString();

    }

    public List getWeatherDetails(){
        List weatherDetails = new ArrayList();
        weatherDetails.add(condition);
        weatherDetails.add(temperature);
        weatherDetails.add(humidity);
        return weatherDetails;
    }

    public String toString() {
        return condition;
    }
    public String getTemperature() {
        return temperature;
    }
}
