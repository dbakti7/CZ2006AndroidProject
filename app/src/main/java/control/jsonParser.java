package Control;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by pc lenovo on 10/20/2015.
 */
public class jsonParser {

    public String parseToken(InputStream in) throws NullPointerException,IOException,JSONException {
        BufferedReader br = null;
        StringBuilder sb = new StringBuilder();
        String line;
        try {
            br = new BufferedReader(new InputStreamReader(in));
            while ((line = br.readLine()) != null) {sb.append(line);}
        } finally {
            if(br==null) {br.close();}
        }
        String token = sb.toString();

        JSONObject obj = new JSONObject(token);
        return obj.getJSONObject("GetToken").getString("NewToken");
    }
}
