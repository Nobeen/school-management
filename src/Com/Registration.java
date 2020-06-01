package Com;
import javax.swing.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
class Registration
        extends JFrame {

    private Container c;
    private JLabel title;
    private JLabel fname;
    private JLabel name;
    private JTextField ftname;
    private JTextField tname;
    private JLabel mno;
    private JTextField tmno;
    private JLabel sno;
    private JTextField stno;
    private JLabel gender;
    private JRadioButton male;
    private JRadioButton female;
    private ButtonGroup gengp;
    private JLabel dob;
    private JComboBox date;
    private JComboBox month;
    private JComboBox year;
    private JLabel add;
    private JTextArea tadd;
    private JLabel nt;
    private JTextArea tnt;
    private JCheckBox term;
    private JButton sub;
    private JButton reset;
    private JTextArea tout;
    private JLabel res;
    private JTextArea resadd;
    Connection myconn = null;
    Statement mystmt = null;

    private String dates[]
            = {"1", "2", "3", "4", "5",
            "6", "7", "8", "9", "10",
            "11", "12", "13", "14", "15",
            "16", "17", "18", "19", "20",
            "21", "22", "23", "24", "25",
            "26", "27", "28", "29", "30",
            "31"};
    private String months[]
            = {"Jan", "feb", "Mar", "Apr",
            "May", "Jun", "July", "Aug",
            "Sup", "Oct", "Nov", "Dec"};
    private String years[]
            = {"1995", "1996", "1997", "1998",
            "1999", "2000", "2001", "2002",
            "2003", "2004", "2005", "2006",
            "2007", "2008", "2009", "2010",
            "2011", "2012", "2013", "2014",
            "2015", "2016", "2017", "2018",
            "2019"};

    // constructor, to initialize the components
    // with default values.
    public Registration() {
        try {
            System.out.println("before");
            //DriverManager.getConnection("jdbc:mysql://localhost:3306/datatest");
            Class.forName("com.mysql.jdbc.Driver");
            myconn = DriverManager.getConnection("jdbc:mysql://localhost/datatest?" +
                    "user=root&password=rootpassword");
            mystmt = myconn.createStatement();
        } catch (Exception exc) {

        }
        setTitle("Registration Form");
        setSize(700, 750);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);


        c = getContentPane();
        c.setLayout(null);
        title = new JLabel("Registration Form");
        title.setFont(new Font("Arial", Font.PLAIN, 30));
        title.setSize(100, 30);
        title.setBounds(250, 25, 400, 30);
        c.add(title);

        fname = new JLabel("First Name");
        fname.setFont(new Font("Arial", Font.PLAIN, 20));
        fname.setBounds(20, 100, 100, 20);
        fname.setSize(100, 20);
        c.add(fname);

        ftname = new JTextField();
        ftname.setFont(new Font("Arial", Font.PLAIN, 15));
        ftname.setBounds(170, 100, 100, 20);
        ftname.setSize(190, 20);
        c.add(ftname);

        name = new JLabel("Last Name");
        name.setFont(new Font("Arial", Font.PLAIN, 20));
        name.setBounds(20, 150, 100, 20);
        name.setSize(100, 20);
        c.add(name);

        tname = new JTextField();
        tname.setFont(new Font("Arial", Font.PLAIN, 15));
        tname.setBounds(170, 150, 100, 20);
        tname.setSize(190, 20);
        c.add(tname);

        mno = new JLabel("Mobile");
        mno.setFont(new Font("Arial", Font.PLAIN, 20));
        mno.setBounds(20, 200, 100, 20);
        mno.setSize(100, 20);
        c.add(mno);

        tmno = new JTextField();
        tmno.setFont(new Font("Arial", Font.PLAIN, 15));
        tmno.setBounds(170, 200, 100, 20);
        tmno.setSize(190, 20);
        c.add(tmno);

        sno = new JLabel("No of Seats");
        sno.setFont(new Font("Arial", Font.PLAIN, 20));
        sno.setBounds(20, 300, 100, 20);
        sno.setSize(150, 20);

        c.add(sno);
        stno = new JTextField();
        stno.setFont(new Font("Arial", Font.PLAIN, 15));
        stno.setBounds(170, 300, 100, 20);
        stno.setSize(50, 20);
        c.add(stno);

        add = new JLabel("Address");
        add.setFont(new Font("Arial", Font.PLAIN, 20));
        add.setBounds(20, 250, 100, 20);
        add.setSize(150, 20);
        c.add(add);

        tadd = new JTextArea();
        tadd.setFont(new Font("Arial", Font.PLAIN, 15));
        tadd.setBounds(170, 250, 50, 20);
        tadd.setSize(200, 40);
        tadd.setLineWrap(true);
        c.add(tadd);
        nt = new JLabel("note");
        nt.setFont(new Font("Arial", Font.PLAIN, 20));
        nt.setBounds(20, 350, 100, 10);
        nt.setSize(150, 20);

        c.add(nt);
        tnt = new JTextArea();
        tnt.setFont(new Font("Arial", Font.PLAIN, 15));
        tnt.setBounds(170, 350, 100, 20);
        tnt.setSize(200, 75);
        tnt.setLineWrap(true);
        c.add(tnt);
        term = new JCheckBox("Accept Terms And Conditions.");
        term.setFont(new Font("Arial", Font.PLAIN, 15));
        term.setBounds(170, 510, 100, 20);
        term.setSize(250, 20);
        c.add(term);

        sub = new JButton("Submit");
        sub.setFont(new Font("Arial", Font.PLAIN, 15));
        sub.setSize(100, 20);
        sub.setBounds(300, 460, 100, 20);
        c.add(sub);

        reset = new JButton("Reset");
        reset.setFont(new Font("Arial", Font.PLAIN, 15));
        reset.setSize(100, 20);
        reset.setBounds(120, 460, 100, 20);
        c.add(reset);
        setVisible(true);

     sub.addActionListener(new ActionListener() {
        public void actionPerformed (ActionEvent a)
        {
            try
            {
            String fname = ftname.getText();
            String lname = tname.getText();
            String m_no = tmno.getText();
            String no_seats = tadd.getText();
            String addr = stno.getText();
            String note = tnt.getText();
            String query = " insert into registration (fName, lName, m_no,no_seats,address,note)"
                    + " values (?, ?, ?, ?, ?,?)";

            PreparedStatement preparedStmt = myconn.prepareStatement(query);
            preparedStmt.setString (1, fname);
            preparedStmt.setString (2, lname);
            preparedStmt.setString   (3, m_no);
            preparedStmt.setString(4, no_seats);
            preparedStmt.setString   (5, addr);
            preparedStmt.setString    (6, note);
                preparedStmt.execute();

                myconn.close();
            }
            catch (Exception e)
            {
                System.err.println("Got an exception!");
                System.err.println(e.getMessage());
            }
        }


    });

}
    public static void main(String[] args) throws Exception
    {

    }
}
