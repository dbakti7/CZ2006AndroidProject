package control;

import android.util.Xml;

import org.xmlpull.v1.XmlPullParser;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by stefan on 10/18/2015.
 * XmlParser class to handle parsing XML data from API
 */
public class xmlParser {
    /**
     * parsing the data from NEA API
     * @param in: data retrieved from NEA API in the form of input stream
     * @param data: type of API retrieved(Nowcast/12Hrs_Forecast)
     * @return: A list containing data from API
     * @throws Exception
     */
    public List<List> parseWeatherXml(InputStream in, String data) throws Exception {
        List res = null;
        try {
            XmlPullParser parser = Xml.newPullParser();
            parser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false);
            parser.setInput(in, null);
            parser.next();
            if (data.equalsIgnoreCase("nowcast")) {
                res = readNowcast(parser);
            } else if (data.equalsIgnoreCase("12hrs_forecast")) {
                res = read12HourForecast(parser);
            }
        } finally {
            in.close();
        }
        return res;
    }

    /**
     * provides 3-hour forecast in necessary data structure
     * @param parser: XmlPullParser object that parses the Xml
     * @return: A list containing 3 elements (Condition, Latitude, Longitude)
     * @throws Exception
     */
    private List<List> readNowcast(XmlPullParser parser) throws Exception {
        List<List> forecast = new ArrayList<>();
        try {
            int eventType = parser.getEventType();
            while (eventType != XmlPullParser.END_DOCUMENT) {
                String name = parser.getName();
                switch (eventType) {
                    case XmlPullParser.START_TAG:
                        break;
                    case XmlPullParser.TEXT:
                        break;
                    case XmlPullParser.END_TAG:
                        if (name.equalsIgnoreCase("area")) {
                            List temp = new ArrayList();
                            temp.add(parser.getAttributeValue(null, "forecast"));
                            temp.add(parser.getAttributeValue(null, "lat"));
                            temp.add(parser.getAttributeValue(null, "lon"));
                            forecast.add(temp);
                        }
                        break;
                    default:
                        break;
                }
                eventType = parser.next();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return forecast;
    }

    /**
     * provides 12-hour forecast in necessary data structure
     * @param parser: XmlPullParser object that parses the XML
     * @return: A list containing Forecast(12 hours), Temperature, Humidity
     * @throws Exception
     */
    private List read12HourForecast(XmlPullParser parser) throws Exception {
        List forecast = new ArrayList<>();
        String text = null;
        try {
            int eventType = parser.getEventType();
            while (eventType != XmlPullParser.END_DOCUMENT) {
                String name = parser.getName();
                switch (eventType) {
                    case XmlPullParser.START_TAG:
                        break;
                    case XmlPullParser.TEXT:
                        text = parser.getText();
                        break;
                    case XmlPullParser.END_TAG:
                        if (name.equalsIgnoreCase("forecast")) {
                            forecast.add(text);
                        } else if (name.equalsIgnoreCase("temperature") || name.equalsIgnoreCase("relativeHumidity")) {
                            forecast.add(parser.getAttributeValue(null, "high") + "-"
                                    + parser.getAttributeValue(null, "low") + " " + parser.getAttributeValue(null, "unit"));
                        }
                        break;
                    default:
                        break;
                }
                eventType = parser.next();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return forecast;
    }
}