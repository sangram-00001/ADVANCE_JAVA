import java.sql.*;
import java.util.*;
import java.sql.Connection;

public class deletion{
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
            String qurey="delete from learner where id =1";
            int afterdrows=st.executeUpdate(qurey);
            if(afterdrows>0)
            {
                System.out.println("Deleted data successfully ");
            }
            else {
                System.out.println("Data not deleted yet !!!!! ");
            }

        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }
}
