import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class ShoppingCartServlet extends HttpServlet {

    // Add item to cart
    protected void doPost(HttpServletRequest request,
                           HttpServletResponse response)
                           throws ServletException, IOException {

        HttpSession session = request.getSession();

        List<String> cart = (List<String>) session.getAttribute("cart");

        if (cart == null) {
            cart = new ArrayList<>();
        }

        String item = request.getParameter("item");

        if (item != null && !item.isEmpty()) {
            cart.add(item);
        }

        session.setAttribute("cart", cart);

        response.getWriter().println(
            "Item added. Cart has " + cart.size() + " item(s)."
        );
    }

    // Display cart
    protected void doGet(HttpServletRequest request,
                          HttpServletResponse response)
                          throws ServletException, IOException {

        HttpSession session = request.getSession(false);

        response.setContentType("text/plain");

        if (session == null) {
            response.getWriter().println("Your cart is empty.");
            return;
        }

        List<String> cart =
            (List<String>) session.getAttribute("cart");

        if (cart == null || cart.isEmpty()) {
            response.getWriter().println("Your cart is empty.");
        } else {

            response.getWriter().println("Items in your cart:");

            for (String item : cart) {
                response.getWriter().println("- " + item);
            }
        }
    }
}
