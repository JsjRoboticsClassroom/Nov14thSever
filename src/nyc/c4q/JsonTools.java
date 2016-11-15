package nyc.c4q;

public class JsonTools {
    public static String colon(){
        return ":";
    }

    public static String quote(String string) {
        return "\"" + string +"\"";
    }

    public static String buildValueJson(String string){
        return "{" +
                 quote("value") + colon() + quote(string) +
                "}";
    }
}
