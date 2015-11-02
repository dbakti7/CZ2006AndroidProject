package control;

import android.util.Xml;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by stefan on 10/18/2015.
 */
public class xmlParser{
    private static final String ns = null;

    public List parseWeatherXml(InputStream in,String data) throws Exception{
        List res = new ArrayList();
        try{
            XmlPullParser parser = Xml.newPullParser();
            parser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false);
            parser.setInput(in, null);
            parser.nextTag();
            if(data.equalsIgnoreCase("12hrs_forecast")) {
                res = read12HourForecast(parser);
            } else if(data.equalsIgnoreCase("nowcast")) {
                res = readNowcast(parser);
            }
            //else if(data.equalsIgnoreCase("3days_outlook")) {
            //    res=read3DaysForecast(parser);
            //}
        } finally {in.close();}
        return res;
    }

    private List readNowcast(XmlPullParser parser) throws Exception {
        List<List> forecast = new ArrayList<>();

        parser.require(XmlPullParser.START_TAG,ns,"weatherForecast");
        while(parser.next()!=XmlPullParser.END_TAG) {
            if(parser.getEventType()!=XmlPullParser.START_TAG) {continue;}
            String name = parser.getName();
            if(name.equalsIgnoreCase("area")){
                List area = new ArrayList();
                area.add(parser.getAttributeValue(null,"forecast"));
                area.add(parser.getAttributeValue(null,"lat"));
                area.add(parser.getAttributeValue(null,"lon"));
                forecast.add(area);
            }
        }
        return forecast;
    }

    private List read12HourForecast(XmlPullParser parser) throws Exception {
        List<String> forecast = new ArrayList<>();

        parser.require(XmlPullParser.START_TAG, ns, "item");
        while(parser.next() != XmlPullParser.END_TAG) {
            if(parser.getEventType() != XmlPullParser.START_TAG) {continue;}

            String name = parser.getName();
            switch(name){
                case"forecast":
                    forecast.add(parser.getText());
                    break;
                case"temperature":case"relativeHumidity":
                    String temp = parser.getAttributeValue(null,"low")+" - "+
                            parser.getAttributeValue(null,"high");
                    forecast.add(temp);
                default:
                    skip(parser);
                    break;
            }
        }
        return forecast;

    }

    private List read3DaysForecast(XmlPullParser parser) throws Exception {
        List forecast = new ArrayList();
        parser.require(XmlPullParser.START_TAG, ns, "item");
        return forecast;
    }

    private void skip(XmlPullParser parser) throws XmlPullParserException, IOException {
        if (parser.getEventType() != XmlPullParser.START_TAG) {
            throw new IllegalStateException();
        }
        int depth = 1;
        while (depth != 0) {
            switch (parser.next()) {
                case XmlPullParser.END_TAG:
                    depth--;
                    break;
                case XmlPullParser.START_TAG:
                    depth++;
                    break;
            }
        }
    }
}
