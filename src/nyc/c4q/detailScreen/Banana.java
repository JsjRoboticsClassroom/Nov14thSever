package nyc.c4q.detailScreen;

import java.io.PrintWriter;

public class Banana {

    private static String response = "lemon and pineapple";

    public static void writeResponse(PrintWriter printWriter) {
        printWriter.println(response);
    }
}
