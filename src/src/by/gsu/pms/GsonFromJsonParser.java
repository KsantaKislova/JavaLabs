package src.by.gsu.pms;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.HashMap;
import java.util.Map;

public class GsonFromJsonParser {
    public static Map<String,Object> jsonToMap(String str){
        Map<String,Object> map = new Gson().fromJson(
                str, new TypeToken<HashMap<String,Object>>() {}.getType()
        );
        return map;
    }
}
