import java.sql.*;
import java.util.Scanner;

public class BankManagement {

    // SHOW ALL DATA
    public void showAll(Connection con) {
        try {
            String sql = "SELECT * FROM bank_employee";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);

            System.out.println("\nID | Name | Age | Salary | Dept | Designation Code");
            while (rs.next()) {
                System.out.println(
                        rs.getInt("emp_id") + " | " +
                                rs.getString("name") + " | " +
                                rs.getInt("age") + " | " +
                                rs.getDouble("salary") + " | " +
                                rs.getString("dept") + " | " +
                                rs.getInt("designation_code")
                );
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    // ADD EMPLOYEE
    public void addEmployee(Connection con, Scanner sc) {
        try {
            String sql = "INSERT INTO bank_employee(name, age, salary, dept, designation_code) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);

            System.out.print("Name: ");
            sc.nextLine();
            ps.setString(1, sc.nextLine());

            System.out.print("Age: ");
            ps.setInt(2, sc.nextInt());

            System.out.print("Salary: ");
            ps.setDouble(3, sc.nextDouble());

            System.out.print("Department: ");
            sc.nextLine();
            ps.setString(4, sc.nextLine());

            System.out.print("Designation Code: ");
            ps.setInt(5, sc.nextInt());

            ps.executeUpdate();
            System.out.println("Employee Added Successfully");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    // REMOVE EMPLOYEE
    public void removeEmployee(Connection con, Scanner sc) {
        try {
            String sql = "DELETE FROM bank_employee WHERE emp_id = ?";
            PreparedStatement ps = con.prepareStatement(sql);

            System.out.print("Enter Employee ID to remove: ");
            ps.setInt(1, sc.nextInt());

            int rows = ps.executeUpdate();
            if (rows > 0)
                System.out.println("Employee Removed");
            else
                System.out.println("Employee Not Found");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    // UPDATE EMPLOYEE SALARY
    public void updateEmployee(Connection con, Scanner sc) {
        try {
            String sql = "UPDATE bank_employee SET salary = ? WHERE emp_id = ?";
            PreparedStatement ps = con.prepareStatement(sql);

            System.out.print("Enter Employee ID: ");
            int id = sc.nextInt();

            System.out.print("Enter New Salary: ");
            double salary = sc.nextDouble();

            ps.setDouble(1, salary);
            ps.setInt(2, id);

            int rows = ps.executeUpdate();
            if (rows > 0)
                System.out.println("Salary Updated");
            else
                System.out.println("Employee Not Found");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}