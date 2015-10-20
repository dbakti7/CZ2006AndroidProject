package control;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Stefan on 10/18/2015.
 */
public class accessGovAPI {
    private static List result = new ArrayList();

    private static void weatherAPIHandler(String dataset) throws Exception{
        String keyref = "781CF461BB6606ADBC7C75BF9D4F60DBD179D04B183282AD";
        String url = "http://www.nea.gov.sg/api/WebAPI?dataset=" + dataset + "&keyref=" + keyref;

        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection)obj.openConnection();
        con.setRequestMethod("GET");
        con.setConnectTimeout(15000);
        con.connect();

        int responseCode = con.getResponseCode();
        if(responseCode == 200) {
            xmlParser temp = new xmlParser();
            result = temp.parseWeatherXml(con.getInputStream(), dataset);
        } else {
            System.out.println("Error in accessing API");
        }
    }

    private static String getToken() throws Exception {
        String key = "N+FyIMvpuzYtw0L28rr3MdH/ND1JgyUZpgzIGLGc/ViD1ze78hEfPykspkzC7ffnVHbpoW9VQFkfAwWYw1T/OGquGThn0eCEmFqUBq98F7zohefJh4A4awNXpyNuQfR4GZcC8hTlDl+MnTf9WAErH9/1S8xx00/PoEdELI94sbo=|mv73ZvjFcSo=";
        String myToken = null;

        URL obj = new URL("http://www.onemap.sg/API/services.svc/getToken?accessKEY=" + key);
        HttpURLConnection con = (HttpURLConnection)obj.openConnection();
        con.setRequestMethod("GET");
        con.connect();
        jsonParser temp = new jsonParser();
        myToken = temp.parseToken(con.getInputStream());

        return myToken
    }

    public static List searchAPIHandler(String entry) throws Exception {
        String result = null;
        String
    }

    public static List get12HourForecast() throws Exception{
        weatherAPIHandler("12hrs_forecast");
        return result;
    }

    public static List get3DaysForecast() throws Exception{
        weatherAPIHandler("3days_outlook");
        return result;
    }

}