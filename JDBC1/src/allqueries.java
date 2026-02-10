import java.util.*;
import java.sql.*;

public class allqueries {

            //int num=sc.nextInt();

            while (true)
            {
                System.out.println("1.Insert");
                System.out.println("2.Select");
                System.out.println("3.Delete");
                System.out.println("4.Update");
                System.out.println("5.Exit");

                System.out.print("Enter the number to excute the query :");

                int x=sc.nextInt();
                sc.nextLine();
                switch (x)
                {
                    case 1:
                        String inquery="Insert into learner (name,age,salary) values (?,?,?)";
                        PreparedStatement psin=connection.prepareStatement(inquery);

                        System.out.print("Enter the name: ");
                        String name=sc.nextLine();

                        System.out.print("Enter the age: ");
                        int age=sc.nextInt();

                        System.out.print("Enter the Salary: ");
                        int salary=sc.nextInt();

                        psin.setString(1,name);
                        psin.setInt(2,age);
                        psin.setInt(3,salary);

                        int rows=psin.executeUpdate();
                        if(rows>0)
                        {
                            System.out.println("Inserted Successfully  ");
                        }
                        else {
                            System.out.println("Not inserted !!!! ");
                        }
                        break;
                    case 2:
                        String seQuery="SELECT id, name, age, salary FROM learner WHERE id = ?";
                        PreparedStatement selps=connection.prepareStatement(seQuery);

                        System.out.print("Enter the id :");
                        int id=sc.nextInt();

                        selps.setInt(1,id);
                        ResultSet rs= selps.executeQuery();

                        if(rs.next())
                        {
                            System.out.println("ID : "+rs.getInt("id"));
                            System.out.println("Name : "+rs.getString("name"));
                            System.out.println("Age : "+rs.getInt("age"));
                            System.out.println("Salary : "+rs.getInt("Salary"));
                            System.out.println("-------------------------");
                        }
                        else {
                            System.out.println("NO record found .......... ");
                        }
                        break;
                    case 3:
                        String delqurey="delete from learner where id = ?";
                        PreparedStatement delps=connection.prepareStatement(delqurey);

                        System.out.print("Enter the id: ");
                        int lid=sc.nextInt();

                        delps.setInt(1,lid);

                        int delrows=delps.executeUpdate();
                        if(delrows>0)
                        {
                            System.out.println("Deleted Successfully  ");
                        }
                        else {
                            System.out.println("Not Deleted !!!! ");
                        }
                        break;
                    case 4:
                        String update="update learner set name=? where id =?";
                        PreparedStatement updps=connection.prepareStatement(update);

                        System.out.print("Enter the id : ");
                        int nid=sc.nextInt();
                        sc.nextLine();

                        System.out.print("Enter the new name : ");
                        String lname=sc.nextLine();
                        sc.nextLine();

                        updps.setString(1,lname);
                        updps.setInt(2,nid);
                        int uprow=updps.executeUpdate();
                        if(uprow>0)
                        {
                            System.out.println("Updated Successfully ......... ");
                        }
                        else {
                            System.out.println("Not yet updated !!!!! ");
                        }
                        break;
                    case 5:
                        System.out.println("Program Terminated");
                        System.exit(0);
                    default:
                        System.out.println("Invalid number ............  ");
                }
            }

        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

}
