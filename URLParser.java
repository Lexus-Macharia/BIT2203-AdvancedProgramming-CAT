import java.net.URL;
import java.util.HashMap;
import java.util.Map;
 
/**
 * URLParser.java
 *
 * This simple program takes a web address (URL) and breaks it
 * down into its different parts using Java's built-in URL class.
 *
 * Example URL used:
 * https://api.techstore.com:8443/products/category/electronics?sort=price&limit=20#reviews
 */
public class URLParser {
 
    public static void main(String[] args) throws Exception {
 
        // Step 1: Store the URL as a String
        String link = "https://api.techstore.com:8443/products/category/electronics?sort=price&limit=20#reviews";
 
        // Step 2: Create a URL object from the String
        URL url = new URL(link);
 
        // Step 3: Print each part of the URL using simple built-in methods
        System.out.println("Protocol: " + url.getProtocol());   // https
        System.out.println("Host: " + url.getHost());           // api.techstore.com
        System.out.println("Port: " + url.getPort());           // 8443
        System.out.println("Path: " + url.getPath());           // /products/category/electronics
 
        // Step 4: Break the query string into key-value pairs
        // getQuery() returns something like "sort=price&limit=20"
        String query = url.getQuery();
        System.out.println("Query Parameters:");
 
        if (query != null) {
            Map<String, String> queryMap = new HashMap<>();
 
            // Split the query string on "&" to get each "key=value" pair
            String[] pairs = query.split("&");
 
            for (String pair : pairs) {
                // Split each pair on "=" to separate the key from the value
                String[] keyValue = pair.split("=");
                if (keyValue.length == 2) {
                    queryMap.put(keyValue[0], keyValue[1]);
                }
            }
 
            // Print every key and value we collected
            for (Map.Entry<String, String> entry : queryMap.entrySet()) {
                System.out.println("   " + entry.getKey() + " = " + entry.getValue());
            }
        }
 
        // Step 5: Print the fragment (the part after the # symbol)
        // Note: Java's URL class calls this the "reference"
        System.out.println("Fragment: " + url.getRef());  // reviews
    }
}
 
