import java.sql.*;
import java.util.*;

public class Main {

    // 🔹 Database details
    private static final String URL = "jdbc:mysql://localhost:3306/bapi";
    private static final String USER = "root";
    private static final String PASS = "12345678";

    // 🔹 JDBC Connection method
    public static Connection getConnection() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(URL, USER, PASS);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try (Connection con = getConnection()) {

            while (true) {
                System.out.println("\n--- STUDENT MENU ---");
                System.out.println("1. Add Student");
                System.out.println("2. Show All Students");
                System.out.println("3. Update Student");
                System.out.println("4. Remove Student");
                System.out.println("5. Exit");
                System.out.print("Enter choice: ");

                int choice = sc.nextInt();
                sc.nextLine(); // clear buffer

                switch (choice) {
                    case 1:
                        student.addStudent(con, sc);
                        break;
                    case 2:
                        student.showAllStudents(con);
                        break;
                    case 3:
                        student.updateStudent(con, sc);
                        break;
                    case 4:
                        student.removeStudent(con, sc);
                        break;
                    case 5:
                        System.out.println("Program terminated");
                        sc.close();
                        System.exit(0);
                    default:
                        System.out.println("Invalid choice");
                }
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}