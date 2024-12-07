package utils;

import org.json.JSONObject;

public class APIPayloadConstans {

    public static String createUserPayload(String name,String email,String password){
        JSONObject jo=new JSONObject();
        jo.put("name",name);
        jo.put("email",email);
        jo.put("password",password);
        return jo.toString();
    }
}
