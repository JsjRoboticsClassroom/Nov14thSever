package nyc.c4q;

import nyc.c4q.detailScreen.*;
import nyc.c4q.homeScreen.HomeScreenInteraction;
import org.eclipse.jetty.server.Request;

import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.function.Consumer;

public enum  ResponseGenerators {
    HOMESCREEN("homescreen", writer -> {
        new HomeScreenInteraction().writeResponse(writer);
    }),
    CRIMSON("crimson", Crimson::writeResponse),
    SKYBLUE("skyblue", SkyBlue::writeResponse),
    SPRING_GREEN("springgreen", SpringGreen::writeResponse),
    BANANA("banana", Banana::writeResponse),
    WHEAT("wheat", Wheat::writeResponse),
    SADDLE_BROWN("saddlebrown", SaddleBrown::writeResponse),
    DARK_SALMON("darksalmon", DarkSalmon::writeResponse);

    public boolean canHandle(Request request){
        return request.getPathInfo().substring(1).toLowerCase().equals(getPath());
    }

    public String getPath() {
        return mPath;
    }

    public Consumer<PrintWriter> getHandler() {
        return mHandler;
    }

    private final String mPath;
    private final Consumer<PrintWriter> mHandler;

    private ResponseGenerators(String path, Consumer<PrintWriter> handler){
        mPath = path;
        mHandler = handler;
    }
}
