import java.sql.*;
import java.util.*;

public class customer {

    static final String URL = "jdbc:mysql://localhost:3306/bapi";
    static final String USER = "root";
    static final String PASS = "12345678";

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");


            Connection con = DriverManager.getConnection(URL, USER, PASS);


            CallableStatement cs =
                    con.prepareCall("{call customer_bill(?, ?, ?)}");

            System.out.print("Enter Customer ID: ");
            int id = sc.nextInt();


            cs.setInt(1, id);


            cs.registerOutParameter(2, Types.VARCHAR);
            cs.registerOutParameter(3, Types.INTEGER);


            cs.execute();

            String name = cs.getString(2);
            int units = cs.getInt(3);

            if (name != null) {
                System.out.println("Customer Name : " + name);
                System.out.println("Units Consumed: " + units);
            } else {
                System.out.println("Customer not found!");
            }

            cs.close();
            con.close();
            sc.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}