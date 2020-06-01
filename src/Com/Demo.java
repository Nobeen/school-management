package Com;
import java.sql.*;
public class Demo {
    public static void main(String[] args) {
        try {
            System.out.println("before");
            Connection myconn = null;
           Statement mystmt=null;
            //DriverManager.getConnection("jdbc:mysql://localhost:3306/datatest");
            Class.forName("com.mysql.jdbc.Driver");
            myconn = DriverManager.getConnection("jdbc:mysql://localhost/datatest?" +
                    "user=root&password=rootpassword");
            mystmt = myconn.createStatement();
            String sql ="INSERT INTO employee " +
                    "VALUES (101, 'Mahnaz', 'Fatma', 25)";

            System.out.println("before run");
            mystmt.executeUpdate(sql);

            //Statement stmt = myconn.createStatement();
            //ResultSet rs = stmt.executeQuery("SELECT * FROM employee");
            System.out.println("id  name    job");


            // myconn.close();
            System.out.println("done");
        } catch (Exception exc) {

        }
    }


    }
