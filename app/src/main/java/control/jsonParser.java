package control;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by pc lenovo on 10/20/2015.
 */
public class jsonParser {
    private static String getStringFromInput(InputStream in) throws IOException{
        BufferedReader br = null;
        StringBuilder sb = new StringBuilder();
        String line;
        try {
            br = new BufferedReader(new InputStreamReader(in));
            while ((line = br.readLine()) != null) {sb.append(line);}
        } finally {
            if(br==null) {br.close();}
        }
        String result = sb.toString();

        return result;
    }

    public static String parseToken(InputStream in) throws NullPointerException,IOException,JSONException {
        String token = getStringFromInput(in);
        JSONObject obj = new JSONObject(token);
        return obj.getJSONObject("GetToken").getString("NewToken");
    }

    public List parseSearchResult(InputStream in) throws Exception {
        List<List> searchResult = new ArrayList<>();
        String response = getStringFromInput(in);
        JSONArray res = new JSONArray(new JSONObject(response).getJSONArray("SearchResults"));
        for(int i=1;i<res.length();i++) {
            List temp = new ArrayList();
            JSONObject resObj = res.getJSONObject(i);
            temp.add(resObj.getString("SEARCHVAL"));
            temp.add(resObj.getString("X"));
            temp.add(resObj.getString("Y"));
            searchResult.add(temp);
        }
        return searchResult;
    }
}
