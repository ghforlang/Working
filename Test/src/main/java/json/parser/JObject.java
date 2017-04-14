package json.parser;

import java.util.HashMap;
import java.util.Map;

/**
 * JObject
 *
 * @author fanwh
 * @create 2017-04-01 11:17
 **/
public class JObject implements Json {
    private Map<String,Value> map = new HashMap<String,Value>();

    public JObject(Map<String, Value> map) {
        this.map = map;
    }

    public int getInt(String key){
        return Integer.parseInt((String)map.get(key).value());
    }

    public String getString(String key){
        return (String)map.get(key).value();
    }

    public boolean getBoolean(String key){
        return Boolean.parseBoolean((String)map.get(key).value());
    }

    public JArray getJArray(String key){
        return (JArray)map.get(key).value();
    }


    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        int size = map.size();
        for(String key : map.keySet()){
            sb.append(key + ":" + map.get(key));
            if(--size > 0){
                sb.append(",");
            }
        }
        sb.append("}");
        return sb.toString();
    }
}
