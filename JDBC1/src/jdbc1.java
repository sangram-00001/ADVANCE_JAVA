import java.sql.*;
import java.util.*;
import java.sql.Connection;

public class jdbc1 {
    private static final String url="jdbc:mysql://localhost:3306/bapi";
    private static final  String username="root";
    private static final String password="12345678";
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch (ClassNotFoundException e){
            System.out.println(e.getMessage());
        }
        try{

            Connection connection=DriverManager.getConnection(url,username,password);
            Statement st=connection.createStatement();
            String query="select * from learner";
            //String qurey="INSERT INTO LEARNER(name,age,salary) value('Sangram',22,30000)";

            ResultSet resultSet=st.executeQuery(query);

            while (resultSet.next())
            {
                int id =resultSet.getInt("ID");
                String name=resultSet.getString("name");
                int age=resultSet.getInt("age");
                double salary=resultSet.getDouble("salary");
                System.out.println("ID: "+id);
                System.out.println("Name: "+name);
                System.out.println("Age: "+age);
                System.out.println("Salary: "+salary);
                System.out.println("------------------------");
            }
        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }
}
