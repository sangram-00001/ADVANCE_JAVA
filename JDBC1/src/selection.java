import java.sql.*;
import java.util.*;

public class selection {
    private static final String url = "jdbc:mysql://localhost:3306/bapi";
    private static final String username = "root";
    private static final String password = "12345678";

    public static void main(String[] args) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection connection = DriverManager.getConnection(url, username, password);
            Statement st = connection.createStatement();

            String query = "SELECT * FROM learner WHERE id = 2";
            ResultSet rs = st.executeQuery(query);

            if (rs.next()) {
                System.out.println("ID: " + rs.getInt("id"));
                System.out.println("Name: " + rs.getString("name"));

            } else {
                System.out.println("No data found");
            }

            rs.close();
            st.close();
            connection.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}