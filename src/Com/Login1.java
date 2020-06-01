package Com;

import javax.swing.*;
import java.awt.*;
import java.awt.color.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;


public class Login1  extends JFrame {
    private JTextField username;
    private JPasswordField password;
    private JButton buttonl;
    private JButton signup;
    String u_name=null;
    String passw=null;
    ResultSet resultset;
    Connection myconn = null;
    Statement mystmt = null;
    String data1,data2,data3,data4,data5;
    Login1() {
        try {
            System.out.println("before");
            Class.forName("com.mysql.jdbc.Driver");
            myconn = DriverManager.getConnection("jdbc:mysql://localhost/datatest?" +
                    "user=root&password=rootpassword");
            mystmt = myconn.createStatement();

            System.out.println("before run");
            System.out.println("done");
        } catch (Exception exc) {

        }
        //Header
        Font f = new Font("", Font.BOLD, 50);
        JPanel heading;
        heading = new JPanel();
        heading.setBackground(new Color(0, 0, 0, 80));
        heading.setBounds(0, 0, 900, 130);
        JLabel name = new JLabel("Login");
        name.setBounds(350, 20, 250, 100);
        name.setForeground(Color.WHITE);
        name.setFont(f);
        add(name);

        //login

        JPanel login = new JPanel();
        login.setLayout(null);
        //  login.setSize(350,350);
        login.setBackground(new Color(0, 0, 0, 60));
        login.setBounds(200, 150, 450, 350);

        username = new JTextField("Enter UserName");
        username.setBounds(50, 50, 300, 40);
        login.add(username);

        password = new JPasswordField("Enter password");
        password.setBounds(50, 150, 300, 40);
        login.add(password);

        signup = new JButton("Sign up");
        signup.setBounds(50, 250, 100, 50);
        signup.setBackground(new Color(162, 182, 45));
        login.add(signup);
        buttonl = new JButton("Log In");
        buttonl.setBounds(250, 250, 100, 50);
        buttonl.setBackground(new Color(162, 182, 45));
        login.add(buttonl);


        //Image setting

        setSize(900, 600);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        ImageIcon background_image = new ImageIcon(getClass().getResource("image2.jpg"));
        Image img = background_image.getImage();
        Image temp = img.getScaledInstance(900, 600, Image.SCALE_SMOOTH);
        background_image = new ImageIcon(temp);
        JLabel background = new JLabel("", background_image, JLabel.CENTER);
        background.setBounds(0, 0, 900, 600);
        background.add(heading);
        background.add(login);
        add(background);
        setVisible(true);



        buttonl.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent a) {

                u_name=username.getText();
                char[] p=password.getPassword();
                passw=new String(p);


                try {

                    String sql = "SELECT user_name,password1 FROM signup_reg ";
                    System.out.println("retrive");
                    resultset = mystmt.executeQuery(sql);
                    System.out.println(resultset);
                        while (resultset.next()) {
                            data1 = resultset.getString(1);
                            data2 = resultset.getString(2);
                          if(u_name.equals(data1)){
                              System.out.println("log in");

                              Menu f = new Menu();
                              f.setBounds(500, 200, 700, 440);
                              f.setTitle("Menu");
                              f.setVisible(true);
                              dispose();

                          }
                            // Get the data from the current row using the column index - column data are in the VARCHAR format


                        }



                } catch(SQLException e){

                        System.out.println("Could not retrieve data from the database " + e.getMessage());
                    }finally{
                    try {
                        if (myconn != null)
                            myconn.close();
                    } catch (SQLException se) {
                    }
                }


            }
        });
        signup.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent a) {
                new Signup();
                dispose();
            }
            });
    }

    public static void main(String[] args) {
        Login1 l=new Login1();
    }
}
