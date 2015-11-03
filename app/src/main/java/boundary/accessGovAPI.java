package boundary;

import android.content.Context;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

import control.jsonParser;

/**
 * Created by Stefan on 10/18/2015.
 * for accessing API both NEA and Onemap
 */
public class accessGovAPI {
    private static List<List> result = new ArrayList<>();
    private static String onemapToken = null;

    /*
     * get forecast based on parameter (nowcast , 12hourforecast)
     */
    private static void weatherAPIHandler(String dataset) throws Exception{
        final String dataanything = dataset;
        Thread thread = new Thread(new Runnable(){
            @Override
            public void run() {
                try {
                    String keyref = "781CF461BB6606ADBC7C75BF9D4F60DBD179D04B183282AD";
                    String url = "http://www.nea.gov.sg/api/WebAPI?dataset=" + dataanything + "&keyref=" + keyref;

                    URL obj = new URL(url);
                    HttpURLConnection con = (HttpURLConnection)obj.openConnection();
                    con.setRequestMethod("GET");
                    //con.setConnectTimeout(15000);
                    try {
                        con.connect();
                    }
                    catch(Exception e) {
                        e.printStackTrace();
                    }

                    int responseCode = con.getResponseCode();

                    if(responseCode == 200) {
                        control.xmlParser temp = new control.xmlParser();

                        /*BufferedReader br = null;
                        StringBuilder sb = new StringBuilder();
                        String line;
                        try {
                            br = new BufferedReader(new InputStreamReader(con.getInputStream()));
                            while ((line = br.readLine()) != null) {sb.append(line);}
                        } finally {
                            if(br==null) {br.close();}
                        }
                        String result = sb.toString();*/


                        result = temp.parseWeatherXml(con.getInputStream(), dataanything);
                    } else {
                        System.out.println("Error in accessing API");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        thread.start();

    }

    /* unused onemap function
    private static String getToken() throws Exception {
        String key = "N+FyIMvpuzYtw0L28rr3MdH/ND1JgyUZpgzIGLGc/ViD1ze78hEfPykspkzC7ffnVHbpoW9VQFkfAwWYw1T/OGquGThn0eCEmFqUBq98F7zohefJh4A4awNXpyNuQfR4GZcC8hTlDl+MnTf9WAErH9/1S8xx00/PoEdELI94sbo=|mv73ZvjFcSo=";
        String myToken = null;

        URL obj = new URL("http://www.onemap.sg/API/services.svc/getToken?accessKEY=" + key);
        try {
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            con.setRequestMethod("GET");
            con.connect();
            jsonParser temp = new jsonParser();
            myToken = temp.parseToken(con.getInputStream());
        } catch(Exception e){
            System.out.println("Error in trying to get Token!");
        }
        return myToken;
    }

    private static void setOnemapToken() {
        try {
            onemapToken = getToken();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static List searchAPIHandler(String entry) throws Exception {
        List result = null;
        String url ="http://www.onemap.sg/API/services.svc/basicSearch?token=" + onemapToken +
                "&searchVal=" + entry.toLowerCase() +
                "&otptFlds=SEARCHVAL,CATEGORY&returnGeom=0&rset=1";
        URL obj = new URL(url);

        try{
            HttpsURLConnection con = (HttpsURLConnection)obj.openConnection();
            con.setRequestMethod("GET");
            con.connect();
            jsonParser temp = new jsonParser();
            result = temp.parseSearchResult(con.getInputStream());
        } catch(Exception e) {
            e.printStackTrace();
        }
        return result;
    }
     */


    /*
     * return a list of forecast with lat and lon
     */
    public static List<List> getNowcast() throws Exception {
        weatherAPIHandler("nowcast");
        return result;
    }

    /*
     * return a 12 hour forecast with weather condition(temp, humidity, etc)
     */
    public static List get12HourForecast() throws Exception {
        weatherAPIHandler("12hrs_forecast");
        return result;
    }

    /*
     * unused forecast
    public static List get3DaysForecast() throws Exception{
        weatherAPIHandler("3days_outlook");
        return result;
    }*/

}