package boundary;

import android.os.AsyncTask;
import android.util.Log;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Stefan on 10/18/2015.
 * This class is for accessing API from NEA to retrieve weather information,
 * both for 3-hour forecast and 12-hour forecast
 */
public class accessGovAPI {
    static List<List> nowcast = new ArrayList();

    private static class nowcastAPIHandler extends AsyncTask<String,Void,List> {
        /**
         * setting up connection with NEA API and retrieve the data for 3-hour forecast
         * @param params
         * @return 3-hour forecast data
         */
        @Override
        protected List doInBackground(String... params) {
            List<List> myReturn = null;
            try {
                String keyref = "781CF461BB6606ADBC7C75BF9D4F60DBD179D04B183282AD";
                String url = "http://www.nea.gov.sg/api/WebAPI?dataset=" + params[0] + "&keyref=" + keyref;

                URL obj = new URL(url);
                HttpURLConnection con = (HttpURLConnection)obj.openConnection();
                con.setRequestMethod("GET");
                con.connect();

                int responseCode = con.getResponseCode();
                if(responseCode == 200) {
                    control.xmlParser temp = new control.xmlParser();
                    myReturn = temp.parseWeatherXml(con.getInputStream(), params[0]);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            nowcast = myReturn;
            return myReturn;
        }

        @Override
        protected void onPostExecute(List result) {
            nowcast = result;
        }
    }

    static List forecast12 = new ArrayList();
    private static class forecast12APIHandler extends AsyncTask<String,Void,List> {
        /**
         * setting up connection with NEA API and retrieve the data for 12-hour forecast
         * @param params
         * @return 12-hour forecast data
         */
        @Override
        protected List doInBackground(String... params) {
            List myReturn = null;
            try {
                String keyref = "781CF461BB6606ADBC7C75BF9D4F60DBD179D04B183282AD";
                String url = "http://www.nea.gov.sg/api/WebAPI?dataset=" + params[0] + "&keyref=" + keyref;

                URL obj = new URL(url);
                HttpURLConnection con = (HttpURLConnection)obj.openConnection();
                con.setRequestMethod("GET");
                con.connect();

                int responseCode = con.getResponseCode();
                if(responseCode == 200) {
                    control.xmlParser temp = new control.xmlParser();
                    forecast12 = temp.parseWeatherXml(con.getInputStream(), params[0]);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            Log.d("FORECAST12", forecast12.get(0).toString());
            Log.d("FORECAST12", forecast12.get(1).toString());
            Log.d("FORECAST12",forecast12.get(2).toString());
            return myReturn;
        }
    }

    /**
     * @return the 3-hour forecast that consist of weather condition, latitude and longiture for
     * various area in Singapore
     */
    public static List<List> getNowcast() {
        return nowcast;
    }

    /**
     *
     * @return the 12-hour forecast that consist of weather condition, temperature and humidity
     * in Singapore
     */
    public static List get12HourForecast() {
        return forecast12;
    }

    /**
     * retrieving data from NEA API
     */
    public static void getWeatherData() {
        new nowcastAPIHandler().execute("nowcast");
        new forecast12APIHandler().execute("12hrs_forecast");
    }

}