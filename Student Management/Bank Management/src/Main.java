import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;

public class Main {
    private static final String URL = "jdbc:mysql://localhost:3306/bapi";
    private static final String USER = "root";
    private static final String PASS = "12345678";

    // 🔹 JDBC Connection method
    public static Connection getConnection() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(URL, USER, PASS);
    }
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);

        try(Connection con = getConnection()) {


            int choice;
            while(true) {
                System.out.println("\n--- BANK MANAGEMENT SYSTEM ---");
                System.out.println("1. Show All Employees");
                System.out.println("2. Add Employee");
                System.out.println("3. Remove Employee");
                System.out.println("4. Update Employee Salary");
                System.out.println("0. Exit");
                System.out.print("Enter choice: ");
                choice = sc.nextInt();

                switch (choice) {
                    case 1:
                        bm.showAll(con);
                        break;
                    case 2:
                        bm.addEmployee(con, sc);
                        break;
                    case 3:
                        bm.removeEmployee(con, sc);
                        break;
                    case 4:
                        bm.updateEmployee(con, sc);
                        break;
                    case 0:
                        System.out.println("Exiting...");
                        break;
                    default:
                        System.out.println("Invalid choice");
                }
            } while (choice != 0);

            con.close();
            sc.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}