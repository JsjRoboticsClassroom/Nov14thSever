package nyc.c4q;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.AbstractHandler;

public class StudentRequestHandler extends AbstractHandler
{
    @Override
    public void handle( String target,
                        Request baseRequest,
                        HttpServletRequest request,
                        HttpServletResponse response ) throws IOException,
            ServletException
    {
        // Declare response encoding and types
        response.setContentType("text/html; charset=utf-8");
        // Declare response status code
        response.setStatus(HttpServletResponse.SC_OK);
        handleRequest(baseRequest, response);

        // Inform jetty that this request has now been handled
        baseRequest.setHandled(true);
    }

    private void handleRequest(Request baseRequest, HttpServletResponse response) throws IOException {
        PrintWriter writer = response.getWriter();
        writer.println("<!DOCTYPE html>");
        for (ResponseGenerators r : ResponseGenerators.values()){
            if (r.canHandle(baseRequest)){
                r.getHandler().accept(response.getWriter());
                return;
            }
        }
        response.getWriter().println("<h1>Welcome to the Path of Prosperity</h1>");


    }
}
