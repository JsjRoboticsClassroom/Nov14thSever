package nyc.c4q.detailScreen;

import nyc.c4q.JsonTools;

import java.io.PrintWriter;

public class DarkSalmon {
    private static String response = "blooming tulips and newborn pups";

    public static void writeResponse(PrintWriter printWriter) {
        printWriter.println(JsonTools.buildValueJson(response));
    }
}
