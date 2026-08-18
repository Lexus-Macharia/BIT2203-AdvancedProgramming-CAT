import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
 
/**
 * LifecycleDemoServlet.java
 * A simple servlet that logs a message at every stage of its
 * lifecycle, so we can see clearly when each method is called.
 */
public class LifecycleDemoServlet extends HttpServlet {
 
    // Stage 2: Called once, when the servlet is first created
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        System.out.println("[LIFECYCLE] init() called - Servlet is starting up.");
    }
 
    // Stage 3: Called every time a GET request is received
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("[LIFECYCLE] doGet() called - Handling a client request.");
        response.getWriter().println("Hello! This request was handled by doGet().");
    }
 
    // Stage 3 (alternative): Called every time a POST request is received
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("[LIFECYCLE] doPost() called - Handling a client request.");
        response.getWriter().println("Hello! This request was handled by doPost().");
    }
 
    // Stage 4: Called once, when the servlet is being shut down
    @Override
    public void destroy() {
        System.out.println("[LIFECYCLE] destroy() called - Servlet is shutting down.");
    }
}
