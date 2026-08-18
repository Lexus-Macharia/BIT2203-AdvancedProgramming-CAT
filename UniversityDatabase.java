import java.sql.*;
 
/**
 * UniversityDatabase.java
 *
 * This program connects to a MySQL database called "university_db",
 * creates a "courses" table, inserts three sample courses, and then
 * displays all courses that belong to the Computer Science department.
 */
public class UniversityDatabase {
 
    // Database connection details
    private static final String URL = "jdbc:mysql://localhost:3306/university_db";
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "secure123";
 
    public static void main(String[] args) {
 
        // "try-with-resources" automatically closes the connection when done
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             Statement statement = connection.createStatement()) {
 
            // Step 1: Create the courses table if it does not already exist
            String createTableSQL =
                "CREATE TABLE IF NOT EXISTS courses (" +
                "course_id INT PRIMARY KEY, " +
                "course_name VARCHAR(100), " +
                "credits INT, " +
                "department VARCHAR(50))";
            statement.executeUpdate(createTableSQL);
            System.out.println("Table 'courses' is ready.");
 
            // Step 2: Insert three sample courses.
            // We use PreparedStatement here too, because it is the safer habit
            // even when inserting data we control ourselves.
            String insertSQL =
                "INSERT INTO courses (course_id, course_name, credits, department) " +
                "VALUES (?, ?, ?, ?)";
            PreparedStatement insertStatement = connection.prepareStatement(insertSQL);
 
            insertStatement.setInt(1, 101);
            insertStatement.setString(2, "Introduction to Programming");
            insertStatement.setInt(3, 3);
            insertStatement.setString(4, "Computer Science");
            insertStatement.executeUpdate();
 
            insertStatement.setInt(1, 102);
            insertStatement.setString(2, "Database Systems");
            insertStatement.setInt(3, 3);
            insertStatement.setString(4, "Computer Science");
            insertStatement.executeUpdate();
 
            insertStatement.setInt(1, 201);
            insertStatement.setString(2, "Financial Accounting");
            insertStatement.setInt(3, 3);
            insertStatement.setString(4, "Business");
            insertStatement.executeUpdate();
 
            System.out.println("Sample courses inserted.");
            insertStatement.close();
 
            // Step 3: Retrieve and display only Computer Science courses
            String selectSQL = "SELECT * FROM courses WHERE department = ?";
            PreparedStatement selectStatement = connection.prepareStatement(selectSQL);
            selectStatement.setString(1, "Computer Science");
 
            ResultSet results = selectStatement.executeQuery();
 
            System.out.println("\nComputer Science Courses:");
            while (results.next()) {
                System.out.println(
                    "ID: " + results.getInt("course_id") +
                    " | Name: " + results.getString("course_name") +
                    " | Credits: " + results.getInt("credits")
                );
            }
 
            results.close();
            selectStatement.close();
 
        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        }
    }
}
