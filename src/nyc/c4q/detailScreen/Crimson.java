package nyc.c4q.detailScreen;

import nyc.c4q.JsonTools;

import java.io.PrintWriter;

public class Crimson {
    private static String response = "cranberries and plums";
    public static void writeResponse(PrintWriter printWriter) {
        printWriter.print(JsonTools.buildValueJson(response));
    }
}
