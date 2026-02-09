import java.sql.*;
import java.util.*;

public class preparedstatement {
    private static final String url = "jdbc:mysql://localhost:3306/bapi";
    private static final String username = "root";
    private static final String password = "12345678";

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection connection = DriverManager.getConnection(url, username, password);

            String query = "INSERT INTO learner (name,age,salary) VALUES (?, ? ,?)";
            PreparedStatement ps = connection.prepareStatement(query);

            while(true) {
                System.out.print("Enter name: ");
                String name = sc.nextLine();

                System.out.print("Enter age: ");
                int age = sc.nextInt();

                System.out.print("Enter Salary: ");
                int salary = sc.nextInt();
                sc.nextLine();

                ps.setString(1, name);
                ps.setInt(2, age);
                ps.setInt(3,salary);

                ps.addBatch();
                System.out.print("Do you want to add insert more data (yes/no) : ");
                String Choice=sc.nextLine();

                if(Choice.toUpperCase().equals("NO"))
                {
                    break;
                }

            }
            ps.executeBatch();
            System.out.println("Insertion executed ");

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Data inserted successfully");
            } else {
                System.out.println("Insertion failed");
            }
            /*String query = "UPDATE learner SET name = ? WHERE id = ?";
            PreparedStatement ps = connection.prepareStatement(query);

            System.out.print("Enter the name: ");
            String name = sc.nextLine();

            System.out.print("Enter the id: ");
            int id = sc.nextInt();

            ps.setString(1, name);
            ps.setInt(2, id);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Updated Successfully");
            } else {
                System.out.println("No record found to update");
            }*/
            /*String query="delete from learner where id =?";
            PreparedStatement ps=connection.prepareStatement(query);

            System.out.print("Enter the id to be deleted : ");
            int id=sc.nextInt();

            ps.setInt(1,id);
            String query = "SELECT id, name, age, salary FROM learner WHERE id = ?";
            PreparedStatement ps = connection.prepareStatement(query);

            System.out.println("Enter the id : ");
            int id= sc.nextInt();

            ps.setInt(1,id);
            ResultSet rs=ps.executeQuery();

            if (rs.next()) {
                System.out.println("ID: " + rs.getInt("id"));
                System.out.println("Name: " + rs.getString("name"));
                System.out.println("Age: " + rs.getInt("age"));
                System.out.println("Salary: " + rs.getInt("salary"));
            } else {
                System.out.println("No record found");
            }*/

            //rs.close();
            ps.close();
            connection.close();
            sc.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}