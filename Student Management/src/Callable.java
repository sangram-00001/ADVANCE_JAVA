import java.util.*;
import java.sql.*;

public class Callable {

    private static final String URL = "jdbc:mysql://localhost:3306/bapi";
    private static final String USER = "root";
    private static final String PASS = "12345678";

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(URL, USER, PASS);

            while (true) {
                System.out.println("\n========== STUDENT DETAILS ==========");
                System.out.println("1. Insert");
                System.out.println("2. Update");
                System.out.println("3. View");
                System.out.println("4. Delete");
                System.out.println("5. Exit");
                System.out.print("Enter choice: ");

                int choice = sc.nextInt();
                sc.nextLine();

                switch (choice) {


                    case 1:
                        CallableStatement cs1 =
                                con.prepareCall("{call student_create(?,?,?,?)}");

                        System.out.print("Enter ID: ");
                        cs1.setInt(1, sc.nextInt());
                        sc.nextLine();

                        System.out.print("Enter Name: ");
                        cs1.setString(2, sc.nextLine());

                        System.out.print("Enter Course: ");
                        cs1.setString(3, sc.nextLine());

                        System.out.print("Enter Email: ");
                        cs1.setString(4, sc.nextLine());

                        cs1.execute();
                        cs1.close();
                        System.out.println("Student inserted successfully!");
                        break;


                    case 2:
                        CallableStatement cs2 =
                                con.prepareCall("{call student_update(?,?,?)}");

                        System.out.print("Enter ID: ");
                        cs2.setInt(1, sc.nextInt());
                        sc.nextLine();

                        System.out.print("Enter New Course: ");
                        cs2.setString(2, sc.nextLine());

                        System.out.print("Enter New Email: ");
                        cs2.setString(3, sc.nextLine());

                        cs2.execute();
                        cs2.close();
                        System.out.println("Student updated successfully!");
                        break;


                    case 3:
                        CallableStatement cs3 =
                                con.prepareCall("{call studentaccount(?,?,?,?)}");

                        System.out.print("Enter ID: ");
                        cs3.setInt(1, sc.nextInt());

                        cs3.registerOutParameter(2, Types.VARCHAR);
                        cs3.registerOutParameter(3, Types.VARCHAR);
                        cs3.registerOutParameter(4, Types.VARCHAR);

                        cs3.execute();

                        String name = cs3.getString(2);
                        String course = cs3.getString(3);
                        String mail = cs3.getString(4);

                        if (name != null) {
                            System.out.println("Name   : " + name);
                            System.out.println("Course : " + course);
                            System.out.println("Mail   : " + mail);
                        } else {
                            System.out.println("Student not found!");
                        }

                        cs3.close();
                        break;


                    case 4:
                        CallableStatement cs4 =
                                con.prepareCall("{call student_delete(?)}");

                        System.out.print("Enter ID: ");
                        cs4.setInt(1, sc.nextInt());

                        cs4.execute();
                        cs4.close();
                        System.out.println("Student deleted successfully!");
                        break;


                    case 5:
                        con.close();
                        sc.close();
                        System.out.println("Program exited.");
                        return;

                    default:
                        System.out.println("Invalid choice!");
                }
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}