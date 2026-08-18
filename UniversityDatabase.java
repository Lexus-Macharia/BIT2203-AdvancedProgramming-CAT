import java.sql.*;

public class UniversityDatabase {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/university_db";
        String username = "admin";
        String password = "secure123";

        try {
            // Connect to database
            Connection con = DriverManager.getConnection(url, username, password);
            System.out.println("Connected to database!");

            // Create table
            Statement stmt = con.createStatement();

            String sql = "CREATE TABLE IF NOT EXISTS courses (" +
                    "course_id INT PRIMARY KEY, " +
                    "course_name VARCHAR(100), " +
                    "credits INT, " +
                    "department VARCHAR(50))";

            stmt.executeUpdate(sql);

            // Insert courses
            String insert = "INSERT INTO courses VALUES (?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(insert);

            ps.setInt(1, 101);
            ps.setString(2, "Introduction to Programming");
            ps.setInt(3, 3);
            ps.setString(4, "Computer Science");
            ps.executeUpdate();

            ps.setInt(1, 102);
            ps.setString(2, "Database Systems");
            ps.setInt(3, 3);
            ps.setString(4, "Computer Science");
            ps.executeUpdate();

            ps.setInt(1, 201);
            ps.setString(2, "Financial Accounting");
            ps.setInt(3, 3);
            ps.setString(4, "Business");
            ps.executeUpdate();

            // Display Computer Science courses
            String select = "SELECT * FROM courses WHERE department = ?";
            ps = con.prepareStatement(select);
            ps.setString(1, "Computer Science");

            ResultSet rs = ps.executeQuery();

            System.out.println("\nComputer Science Courses:");

            while (rs.next()) {
                System.out.println(
                    rs.getInt("course_id") + " - " +
                    rs.getString("course_name") + " - " +
                    rs.getInt("credits") + " credits"
                );
            }

            // Close connection
            rs.close();
            ps.close();
            stmt.close();
            con.close();

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
