import java.sql.*;
import java.util.*;

public class student {

    // 🔹 ADD STUDENT
    public static void addStudent(Connection con, Scanner sc) {
        try {
            String sql =
                    "INSERT INTO student (sname, scourse, smail) VALUES (?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);

            System.out.print("Enter name: ");
            String name = sc.nextLine();

            System.out.print("Enter course: ");
            String course = sc.nextLine();

            System.out.print("Enter email: ");
            String mail = sc.nextLine();

            ps.setString(1, name);
            ps.setString(2, course);
            ps.setString(3, mail);

            ps.executeUpdate();
            System.out.println("Student added successfully");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    public static void showAllStudents(Connection con) {
        try {
            String sql = "SELECT * FROM student";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            System.out.println("\nID | Name | Course | Email");
            System.out.println("------------------------");

            while (rs.next()) {
                System.out.println(
                        rs.getInt("sid")+" | "+
                        rs.getString("sname") + " | " +
                                rs.getString("scourse") + " | " +
                                rs.getString("smail")
                );
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    public static void updateStudent(Connection con, Scanner sc) {
        try {
            String sql =
                    "UPDATE student SET scourse=? WHERE smail=?";
            PreparedStatement ps = con.prepareStatement(sql);

            System.out.print("Enter email: ");
            String mail = sc.nextLine();

            System.out.print("Enter new course: ");
            String course = sc.nextLine();

            ps.setString(1, course);
            ps.setString(2, mail);

            int rows = ps.executeUpdate();
            System.out.println(rows > 0
                    ? "Student updated successfully"
                    : "Student not found");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    public static void removeStudent(Connection con, Scanner sc) {
        try {
            String sql =
                    "DELETE FROM student WHERE smail=?";
            PreparedStatement ps = con.prepareStatement(sql);

            System.out.print("Enter email: ");
            String mail = sc.nextLine();

            ps.setString(1, mail);

            int rows = ps.executeUpdate();
            System.out.println(rows > 0
                    ? "Student removed successfully"
                    : "Student not found");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}