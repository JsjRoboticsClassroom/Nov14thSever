package nyc.c4q.detailScreen;

import nyc.c4q.JsonTools;

import java.io.PrintWriter;

public class SaddleBrown {
    private static String response = "sticks and wood";

    public static void writeResponse(PrintWriter printWriter) {
        printWriter.println(JsonTools.buildValueJson(response));
    }
}
