package Com;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

// Java program to show JRadioButton Example.
// in java. Importing different Package
class Menu extends JFrame {

    // Declaration of object of JRadioButton class.
    ResultSet resultset;
    Connection myconn = null;
    Statement mystmt = null;
    JMenu menu;
    JComboBox c1,c2;
    JMenuItem i1, i2, i3, i4, i5;
    private JLabel sno,lc1,lc2,lct;
    private JTextField stno;
    JRadioButton jRadioButton1,jRadioButton7,jRadioButton8;
    JRadioButton jRadioButton2,jRadioButton3,jRadioButton4,jRadioButton5,jRadioButton6;
    JButton jButton;
    ButtonGroup G1,G2,G3;
    JLabel L1,lM;
    JLabel L2,L3;
    String data1,data2,data3,data4,data5;
    public Menu()
    {


        this.setLayout(null);
        lM=new JLabel();
        lM.setText("Room Selection Menu");
        lM.setBounds(125, 20, 300, 50);
        lM.setFont(new Font("Arial", Font.BOLD, 25));
        lM.setForeground(Color.blue);
        this.add(lM);
        jRadioButton1 = new JRadioButton();
        jRadioButton2 = new JRadioButton();
        jRadioButton3 = new JRadioButton();
        jButton = new JButton("Click");
        jButton.setBounds(300, 300, 80, 30);
        this.add(jButton);
        G1 = new ButtonGroup();
        G2=new ButtonGroup();
        L1 = new JLabel("Room Type");
        jRadioButton1.setText("ComputerRoom");
        jRadioButton2.setText("LectureTheatre");
        jRadioButton3.setText("MeetingRoom");
        jRadioButton1.setBounds(130, 100, 150, 50);
        jRadioButton2.setBounds(280, 100, 150, 50);
        jRadioButton3.setBounds(430, 100, 170, 50);
        jRadioButton1.setFont(new Font("Arial", Font.BOLD, 16));
        jRadioButton1.setForeground(Color.black);
        jRadioButton2.setFont(new Font("Arial", Font.BOLD, 16));
        jRadioButton2.setForeground(Color.black);
        jRadioButton3.setFont(new Font("Arial", Font.BOLD, 16));
        jRadioButton3.setForeground(Color.black);
        L1.setBounds(20, 100, 150, 50);
        L1.setFont(new Font("Arial", Font.BOLD, 16));
        L1.setForeground(Color.black);
        this.add(jRadioButton1);
        this.add(jRadioButton2);
        this.add(jRadioButton3);
        this.add(L1);
        G1.add(jRadioButton1);
        G1.add(jRadioButton2);
        G1.add(jRadioButton3);
        jRadioButton4 = new JRadioButton();
        jRadioButton5 = new JRadioButton();
        jRadioButton6 = new JRadioButton();
        G2=new ButtonGroup();
        L2 = new JLabel("Booking Days");
        L2.setBounds(20, 150, 150, 50);
        L2.setFont(new Font("Arial", Font.BOLD, 16));
        L2.setForeground(Color.black);
        jRadioButton4.setText("Weekdays");
        jRadioButton5.setText("Weekends");
        jRadioButton6.setText("Holidays");
        jRadioButton4.setBounds(130, 150, 150, 50);
        jRadioButton5.setBounds(280, 150, 150, 50);
        jRadioButton6.setBounds(430, 150, 170, 50);
        jRadioButton4.setFont(new Font("Arial", Font.BOLD, 16));
        jRadioButton4.setForeground(Color.black);
        jRadioButton5.setFont(new Font("Arial", Font.BOLD, 16));
        jRadioButton5.setForeground(Color.black);
        jRadioButton6.setFont(new Font("Arial", Font.BOLD, 16));
        jRadioButton6.setForeground(Color.black);

        this.add(jRadioButton4);
        this.add(jRadioButton5);
        this.add(jRadioButton6);
        this.add(L2);
        G2.add(jRadioButton4);
        G2.add(jRadioButton5);
        G2.add(jRadioButton6);

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

        //creat checkbox for time
        String s2[] = { "am", "pm" };
        // create checkbox
        c2 = new JComboBox(s2);
        c2.setBounds(210, 200, 50, 20);
        lct = new JLabel("Select time of booking ");
        lct.setBounds(20, 200, 220, 20);
        lct.setFont(new Font("Arial", Font.BOLD, 16));
        lct.setForeground(Color.black);
        // lc2= new JLabel("Jalpaiguri selected");
        //lc2.setBounds(100, 450, 150, 50);
        // set color of text
        lct.setForeground(Color.black);
        this.add(lct);
        this.add(c2);

        String s1[] = { "40","35", "25", "20", "15", "10" };
        // create checkbox for no of seats
        c1 = new JComboBox(s1);
        c1.setBounds(170, 250, 50, 20);
        // add ItemListener
       // c1.addItemListener(s);
        // create labels
        lc1 = new JLabel("Select no. of Seats ");
        lc1.setBounds(20, 250, 150, 20);
        lc1.setFont(new Font("Arial", Font.BOLD, 16));
        lc1.setForeground(Color.black);
        this.add(lc1);
        this.add(c1);
        jButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent a) {

                if (jRadioButton1.isSelected() && jRadioButton4.isSelected()) {
                    System.out.println("selected");
                    try {
                        String sql = "SELECT * FROM room_menu where RoomType='ComputerRoom' AND BookingDays='Weekdays'";
                        System.out.println("retrive");
                        resultset = mystmt.executeQuery(sql);
                        System.out.println(resultset);

                        while (resultset.next()) {
                            System.out.println("helo");
                            // Get the data from the current row using the column index - column data are in the VARCHAR format
                            data1 = resultset.getString(1);
                            data2 = resultset.getString(2);
                            data3 = resultset.getString(3);
                            data4 = resultset.getString(4);
                            data5 = resultset.getString(5);
                        }
                        if (c2.getSelectedItem().equals(data4)) {
                            System.out.println("Room no= " + data1 +
                                    ", Room= " + data2 +
                                    ", Term Time= " + data3 + " Time= " + data4 + "  Seats= " + data5);
                        }
                    }
                    catch(SQLException e){

                        System.out.println("Could not retrieve data from the database " + e.getMessage());
                    }
                    finally{
                        try {
                            if (myconn != null)
                                myconn.close();
                        } catch (SQLException se) {
                        }
                    }
                }
                    else if (jRadioButton1.isSelected() && jRadioButton5.isSelected()) {

                    try {
                        String sql = "SELECT * FROM room_menu where RoomType='ComputerRoom' AND BookingDays='Weekends'";
                        System.out.println("retrive");
                        resultset = mystmt.executeQuery(sql);
                        System.out.println(resultset);

                        while (resultset.next()) {
                            System.out.println("helo");
                            // Get the data from the current row using the column index - column data are in the VARCHAR format
                            data1 = resultset.getString(1);
                            data2 = resultset.getString(2);
                            data3 = resultset.getString(3);
                            data4 = resultset.getString(4);
                            data5 = resultset.getString(5);
                        }
                        if (c2.getSelectedItem().equals(data4)) {
                            System.out.println("Room no= " + data1 +
                                    ", Room= " + data2 +
                                    ", Term Time= " + data3 + " Time= " + data4 + "  Seats= " + data5);
                        }
                    }
                    catch(SQLException e){

                        System.out.println("Could not retrieve data from the database " + e.getMessage());
                    }
                    finally{
                        try {
                            if (myconn != null)
                                myconn.close();
                        } catch (SQLException se) {
                        }
                    }
                        } else if (jRadioButton1.isSelected() && jRadioButton6.isSelected()) {

                    try {
                        String sql = "SELECT * FROM room_menu where RoomType='ComputerRoom' AND BookingDays='Holidays'";
                        System.out.println("retrive");
                        resultset = mystmt.executeQuery(sql);
                        System.out.println(resultset);

                        while (resultset.next()) {
                            System.out.println("helo");
                            // Get the data from the current row using the column index - column data are in the VARCHAR format
                            data1 = resultset.getString(1);
                            data2 = resultset.getString(2);
                            data3 = resultset.getString(3);
                            data4 = resultset.getString(4);
                            data5 = resultset.getString(5);
                        }
                        if (c2.getSelectedItem().equals(data4)) {
                            System.out.println("Room no= " + data1 +
                                    ", Room= " + data2 +
                                    ", Term Time= " + data3 + " Time= " + data4 + "  Seats= " + data5);
                        }
                    }
                    catch(SQLException e){

                        System.out.println("Could not retrieve data from the database " + e.getMessage());
                    }
                    finally{
                        try {
                            if (myconn != null)
                                myconn.close();
                        } catch (SQLException se) {
                        }
                    }
                        }
                        if (jRadioButton2.isSelected() && jRadioButton4.isSelected()) {
                            try {
                                String sql = "SELECT * FROM room_menu where RoomType='LectureTheatre' AND BookingDays='Weekdays'";
                                System.out.println("retrive");
                                resultset = mystmt.executeQuery(sql);
                                System.out.println(resultset);

                                while (resultset.next()) {
                                    System.out.println("helo");
                                    // Get the data from the current row using the column index - column data are in the VARCHAR format
                                    data1 = resultset.getString(1);
                                    data2 = resultset.getString(2);
                                    data3 = resultset.getString(3);
                                    data4 = resultset.getString(4);
                                    data5 = resultset.getString(5);
                                }
                                if (c2.getSelectedItem().equals(data4)) {
                                    System.out.println("Room no= " + data1 +
                                            ", Room= " + data2 +
                                            ", Term Time= " + data3 + " Time= " + data4 + "  Seats= " + data5);
                                }
                            }
                            catch(SQLException e){

                                System.out.println("Could not retrieve data from the database " + e.getMessage());
                            }
                            finally {
                                try {
                                    if (myconn != null)
                                        myconn.close();
                                } catch (SQLException se) {
                                }
                            }
                        } else if (jRadioButton2.isSelected() && jRadioButton5.isSelected()) {
                            try {
                                String sql = "SELECT * FROM room_menu where RoomType='LectureTheatre' AND BookingDays='Weekends'";
                                System.out.println("retrive");
                                resultset = mystmt.executeQuery(sql);
                                System.out.println(resultset);

                                while (resultset.next()) {
                                    System.out.println("helo");
                                    // Get the data from the current row using the column index - column data are in the VARCHAR format
                                    data1 = resultset.getString(1);
                                    data2 = resultset.getString(2);
                                    data3 = resultset.getString(3);
                                    data4 = resultset.getString(4);
                                    data5 = resultset.getString(5);
                                }
                                if (c2.getSelectedItem().equals(data4)) {
                                    System.out.println("Room no= " + data1 +
                                            ", Room= " + data2 +
                                            ", Term Time= " + data3 + " Time= " + data4 + "  Seats= " + data5);
                                }
                            }
                            catch(SQLException e){

                                System.out.println("Could not retrieve data from the database " + e.getMessage());
                            }
                            finally{
                                try {
                                    if (myconn != null)
                                        myconn.close();
                                } catch (SQLException se) {
                                }
                            }
                        } else if (jRadioButton2.isSelected() && jRadioButton6.isSelected()) {
                            try {
                                String sql = "SELECT * FROM room_menu where RoomType='LectureTheatre' AND BookingDays='Holidays'";
                                System.out.println("retrive");
                                resultset = mystmt.executeQuery(sql);
                                System.out.println(resultset);

                                while (resultset.next()) {
                                    System.out.println("helo");
                                    // Get the data from the current row using the column index - column data are in the VARCHAR format
                                    data1 = resultset.getString(1);
                                    data2 = resultset.getString(2);
                                    data3 = resultset.getString(3);
                                    data4 = resultset.getString(4);
                                    data5 = resultset.getString(5);
                                }
                                if (c2.getSelectedItem().equals(data4)) {
                                    System.out.println("Room no= " + data1 +
                                            ", Room= " + data2 +
                                            ", Term Time= " + data3 + " Time= " + data4 + "  Seats= " + data5);
                                }
                            }
                            catch(SQLException e){

                                System.out.println("Could not retrieve data from the database " + e.getMessage());
                            }
                            finally{
                                try {
                                    if (myconn != null)
                                        myconn.close();
                                } catch (SQLException se) {
                                }
                            }
                        }
                        if (jRadioButton3.isSelected() && jRadioButton4.isSelected()) {
                            try {
                                String sql = "SELECT * FROM room_menu where RoomType='MeetingRoom' AND BookingDays='Weekdays'";
                                System.out.println("retrive");
                                resultset = mystmt.executeQuery(sql);
                                System.out.println(resultset);

                                while (resultset.next()) {
                                    System.out.println("helo");
                                    // Get the data from the current row using the column index - column data are in the VARCHAR format
                                    data1 = resultset.getString(1);
                                    data2 = resultset.getString(2);
                                    data3 = resultset.getString(3);
                                    data4 = resultset.getString(4);
                                    data5 = resultset.getString(5);
                                }
                                if (c2.getSelectedItem().equals(data4)) {
                                    System.out.println("Room no= " + data1 +
                                            ", Room= " + data2 +
                                            ", Term Time= " + data3 + " Time= " + data4 + "  Seats= " + data5);
                                }
                            }
                            catch(SQLException e){

                                System.out.println("Could not retrieve data from the database " + e.getMessage());
                            }
                            finally{
                                try {
                                    if (myconn != null)
                                        myconn.close();
                                } catch (SQLException se) {
                                }
                            }
                        } else if (jRadioButton3.isSelected() && jRadioButton5.isSelected()) {
                            try {
                                String sql = "SELECT * FROM room_menu where RoomType='MeetingRoom' AND BookingDays='Weekends'";
                                System.out.println("retrive");
                                resultset = mystmt.executeQuery(sql);
                                System.out.println(resultset);

                                while (resultset.next()) {
                                    System.out.println("helo");
                                    // Get the data from the current row using the column index - column data are in the VARCHAR format
                                    data1 = resultset.getString(1);
                                    data2 = resultset.getString(2);
                                    data3 = resultset.getString(3);
                                    data4 = resultset.getString(4);
                                    data5 = resultset.getString(5);
                                }
                                if (c2.getSelectedItem().equals(data4)) {
                                    System.out.println("Room no= " + data1 +
                                            ", Room= " + data2 +
                                            ", Term Time= " + data3 + " Time= " + data4 + "  Seats= " + data5);
                                }
                            }
                            catch(SQLException e){

                                System.out.println("Could not retrieve data from the database " + e.getMessage());
                            }
                            finally{
                                try {
                                    if (myconn != null)
                                        myconn.close();
                                } catch (SQLException se) {
                                }
                            }
                            System.out.println("");
                        } else if (jRadioButton3.isSelected() && jRadioButton6.isSelected()) {
                            try {
                                String sql = "SELECT * FROM room_menu where RoomType='MeetingRoom' AND BookingDays='Holidays'";
                                System.out.println("retrive");
                                resultset = mystmt.executeQuery(sql);
                                System.out.println(resultset);

                                while (resultset.next()) {
                                    // Get the data from the current row using the column index - column data are in the VARCHAR format
                                    data1 = resultset.getString(1);
                                    data2 = resultset.getString(2);
                                    data3 = resultset.getString(3);
                                    data4 = resultset.getString(4);
                                    data5 = resultset.getString(5);
                                }
                                if (c2.getSelectedItem().equals(data4)) {
                                    System.out.println("Room no= " + data1 +
                                            ", Room= " + data2 +
                                            ", Term Time= " + data3 + " Time= " + data4 + "  Seats= " + data5);
                                }
                            }
                            catch(SQLException e){

                                System.out.println("Could not retrieve data from the database " + e.getMessage());
                            }
                            finally{
                                try {
                                    if (myconn != null)
                                        myconn.close();
                                } catch (SQLException se) {
                                }
                            }
                            System.out.println("");

                        } else {
                            System.out.println("no selection");
                        }
                        //JOptionPane.showMessageDialog(Menu.this, qual);
                    }







        });

    }
    public static void main(String args[])
    {

    }
}

