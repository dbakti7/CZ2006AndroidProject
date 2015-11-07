package control;

import android.util.Xml;

import org.xmlpull.v1.XmlPullParser;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by stefan on 10/18/2015.
 */
public class xmlParser {

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