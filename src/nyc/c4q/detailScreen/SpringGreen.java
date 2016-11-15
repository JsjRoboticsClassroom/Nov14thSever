package nyc.c4q.detailScreen;

import nyc.c4q.JsonTools;

import java.io.PrintWriter;

public class SpringGreen {
    private static String response = "grass and leaves";
    public static void writeResponse(PrintWriter printWriter) {
        printWriter.println(JsonTools.buildValueJson(response));
    }
}
