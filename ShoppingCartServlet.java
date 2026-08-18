import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
 
/**
 * ShoppingCartServlet.java
 *
 * This servlet shows how to keep a shopping cart working correctly
 * by storing it inside the user's HttpSession, so it is not lost
 * when the customer moves from one page to the next.
 */
public class ShoppingCartServlet extends HttpServlet {
 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
 
        // Get the existing session, or create a new one if none exists yet
        HttpSession session = request.getSession(true);
 
        // Get the cart from the session, or create a new empty cart
        // if this is the customer's first item
        List<String> cart = (List<String>) session.getAttribute("cart");
        if (cart == null) {
            cart = new ArrayList<>();
        }
 
        // Add the new item sent from the "Add to Cart" form
        String item = request.getParameter("item");
        if (item != null && !item.isEmpty()) {
            cart.add(item);
        }
 
        // Save the updated cart back into the session so it is
        // remembered on the next page the customer visits
        session.setAttribute("cart", cart);
 
        response.getWriter().println("Item added. Cart now has " + cart.size() + " item(s).");
    }
 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
 
        // Reuse the existing session (do NOT create a new one here,
        // otherwise the cart from earlier pages would be lost)
        HttpSession session = request.getSession(false);
 
        List<String> cart = null;
        if (session != null) {
            cart = (List<String>) session.getAttribute("cart");
        }
 
        response.setContentType("text/plain");
        if (cart == null || cart.isEmpty()) {
            response.getWriter().println("Your cart is empty.");
        } else {
            response.getWriter().println("Items in your cart:");
            for (String cartItem : cart) {
                response.getWriter().println("- " + cartItem);
            }
        }
    }
}
