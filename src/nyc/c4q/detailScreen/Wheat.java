package nyc.c4q.detailScreen;

import java.io.PrintWriter;

public class Wheat {
    private static String response = "hay and straw";

    public static void writeResponse(PrintWriter printWriter) {
        printWriter.println(response);
    }
}
