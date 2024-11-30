package utils;

public class APIPayloadConstans {
    public static String createUserBody(){
        String createUser = "{\n" +
                "  \"name\": \"Olek\",\n" +
                "  \"email\": \"befun@gmail.com\",\n" +
                "  \"password\": \"12345\"\n" +
                "}";
        return createUser;
    }
}
