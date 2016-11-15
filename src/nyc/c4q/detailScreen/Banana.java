package nyc.c4q.detailScreen;

import nyc.c4q.JsonTools;

import java.io.PrintWriter;

public class Banana {

    private static String response = "lemon and pineapple";

    public static void writeResponse(PrintWriter printWriter) {
        printWriter.println(JsonTools.buildValueJson(response));
    }
}
