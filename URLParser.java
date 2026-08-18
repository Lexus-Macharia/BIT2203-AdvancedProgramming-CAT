import java.net.URL;

public class URLParser {

    public static void main(String[] args) throws Exception {

        // URL to analyze
        String link = "https://api.techstore.com:8443/products/category/electronics?sort=price&limit=20#reviews";

        // Create URL object
        URL url = new URL(link);

        // Display URL parts
        System.out.println("Protocol: " + url.getProtocol());
        System.out.println("Host: " + url.getHost());
        System.out.println("Port: " + url.getPort());
        System.out.println("Path: " + url.getPath());

        // Display query parameters
        System.out.println("Query: " + url.getQuery());

        // Display fragment
        System.out.println("Fragment: " + url.getRef());
    }
}
