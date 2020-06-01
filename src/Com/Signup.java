package Com;
import java.util.regex.Pattern;

import java.util.regex.Matcher;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class Signup extends  JFrame {

    JLabel l1, lname, lpassword1, lpassword2, lemail, lphone_no, l7, l8;
    JTextField tname, temail, tphone_no, tf5, tf6;
    JButton btn1, btn2;
    JPasswordField p1, p2;
    Connection myconn = null;
    Statement mystmt = null;
    private Container c;
    private static final String PASSWORD_REGEX = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=_])(?=\\S+$).{8,16}$";
    private static final Pattern PASSWORD_PATTERN = Pattern.compile(PASSWORD_REGEX);

    private static final String ph_no="^(\\+\\d{1,3}( )?)?((\\(\\d{1,3}\\))|\\d{1,3})[- .]?\\d{3,4}[- .]?\\d{4}$";
    private static final Pattern p = Pattern.compile(ph_no);

    private static final String email = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
    private static final Pattern em = Pattern.compile(email);


    Signup()
    {

        try {
            System.out.println("before");
            //DriverManager.getConnection("jdbc:mysql://localhost:3306/datatest");
            Class.forName("com.mysql.jdbc.Driver");
            myconn = DriverManager.getConnection("jdbc:mysql://localhost/datatest?" +
                    "user=root&password=rootpassword");
            mystmt = myconn.createStatement();
        } catch (Exception exc) {

        }
        setTitle("Sign Up");
        setSize(700, 500);
        //setBounds(300, 90, 1200, 800);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        //setResizable(false);
        c = getContentPane();
        c.setLayout(null);
        l1 = new JLabel("Signup Page:");
        l1.setForeground(Color.blue);
        l1.setFont(new Font("Serif", Font.BOLD, 20));
        lname = new JLabel("User Name:");
        lpassword1 = new JLabel("Create Passowrd:");
        lpassword2 = new JLabel("Confirm Password:");
        lemail= new JLabel("Email-ID:");
        lphone_no = new JLabel("Phone No:");
        tname = new JTextField();
        p1 = new JPasswordField();
        p2 = new JPasswordField();
        //tf3 = new JTextField();

        temail = new JTextField();
        tphone_no = new JTextField();
        btn1 = new JButton("Submit");
        btn2 = new JButton("Clear");
       // btn1.addActionListener(this);
        //btn2.addActionListener(this);
        l1.setBounds(300, 30, 400, 30);
        lname.setBounds(80, 70, 200, 30);
        lpassword1.setBounds(80, 110, 200, 30);
        lpassword2.setBounds(80, 150, 200, 30);
        lemail.setBounds(80, 190, 200, 30);
        lphone_no.setBounds(80, 230, 200, 30);

        //tf2.setBounds(300, 70, 200, 30);
        tname.setBounds(300, 70, 200, 30);
        p1.setBounds(300, 110, 200, 30);
        p2.setBounds(300, 150, 200, 30);
       // tf3.setBounds(300, 110, 200, 30);
        temail.setBounds(300, 190, 200, 30);
        tphone_no.setBounds(300, 230, 200, 30);
        btn1.setBounds(250,300,100,30);
        btn2.setBounds(400,300,100,30);
        //btn1.setBounds(50, 350, 100, 30);
        //btn2.setBounds(170, 350, 100, 30);
        c.add(l1);
        c.add(lname);
        c.add(tname);
        c.add(lpassword1);
        c.add(p1);
        c.add(lpassword2);
        c.add(p2);
        c.add(lemail);
        c.add(temail);
        c.add(lphone_no);
        c.add(tphone_no);
        c.add(btn1);
        c.add(btn2);
        setVisible(true);


     btn1.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent a) {


            int x = 0;
            String s1 = tname.getText();
            // String s2 = tf2.getText();
            char[] sp1 = p1.getPassword();
            char[] sp2 = p2.getPassword();
            String s3 = new String(sp1);
            String s4 = new String(sp2);
            String s5 = temail.getText();
            String s6 = tphone_no.getText();

            System.out.println("before if");

            // Validate a password
            if (PASSWORD_PATTERN.matcher(s3).matches()&&s3.matches(s4)) {
                if(p.matcher(s6).matches()) {
                    if (em.matcher(s5).matches()) {
                        try {

                            String sql = "insert into signup_reg(user_name,password1,password2,email_id,mobile_number) values(?,?,?,?,?)";
                            PreparedStatement ps = myconn.prepareStatement(sql);
                            ps.setString(1, s1);
                            ps.setString(2, s3);
                            ps.setString(3, s4);
                            ps.setString(4, s5);
                            ps.setString(5, s6);
                            ps.execute();

                            myconn.close();
                            x++;
                            if (x > 0) {
                                JOptionPane.showMessageDialog(btn1, "Registered Successfully");
                                dispose();
                            } else {
                                JOptionPane.showMessageDialog(btn1, "Password Does Not Match");
                            }
                        } catch (Exception ex) {
                            System.out.println(ex);
                        }
                    } else {
                        JOptionPane.showMessageDialog(btn1, "Email is incorrect");

                    }
                }
                else{
                    JOptionPane.showMessageDialog(btn1, "phone number incorrect");
                }
            }else{
                JOptionPane.showMessageDialog(btn1, "Password incorrect");
            }


        }});

    }

    public static void main(String args[])
    {
        new Signup();
    }
}



