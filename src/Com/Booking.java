package Com;
import javax.swing.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

    class Booking
            extends JFrame
            implements ActionListener {

        // Components of the Form
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



        // constructor, to initialize the components
        // with default values.
        public Booking()
        {
             String datePattern = "yyyy-MM-dd";
             SimpleDateFormat dateFormatter = new SimpleDateFormat(datePattern);

            //frame.add(datePicker);
            setTitle("Booking Form");
            setSize(700,750);
            //setBounds(300, 90, 1200, 800);
            setLocationRelativeTo(null);
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            //setResizable(false);

            c = getContentPane();
            c.setLayout(null);
            title = new JLabel("Booking Form");
            title.setFont(new Font("Arial", Font.PLAIN, 30));
            title.setSize(100, 30);
            title.setBounds(250, 25, 400, 30);
            //title.setLocation(300, 30);
            c.add(title);

            fname = new JLabel("First Name");
            fname.setFont(new Font("Arial", Font.PLAIN, 20));
            fname.setBounds(20, 100, 100, 20);
            fname.setSize(100, 20);
            //fname.setLocation(100, 50);
            c.add(fname);
            ftname = new JTextField();
            ftname.setFont(new Font("Arial", Font.PLAIN, 15));
            ftname.setBounds(170, 100, 100, 20);
            ftname.setSize(190, 20);
            //ftname.setLocation(200, 50);
            c.add(ftname);

            name = new JLabel("Last Name");
            name.setFont(new Font("Arial", Font.PLAIN, 20));
            name.setBounds(20, 150, 100, 20);
            name.setSize(100, 20);
            //name.setLocation(100, 150);
            c.add(name);

            tname = new JTextField();
            tname.setFont(new Font("Arial", Font.PLAIN, 15));
            tname.setBounds(170, 150, 100, 20);
            tname.setSize(190, 20);
            // tname.setLocation(200, 150);
            c.add(tname);

            mno = new JLabel("Mobile");
            mno.setFont(new Font("Arial", Font.PLAIN, 20));
            mno.setBounds(20, 200, 100, 20);
            mno.setSize(100, 20);
            //mno.setLocation(100, 200);
            c.add(mno);

            tmno = new JTextField();
            tmno.setFont(new Font("Arial", Font.PLAIN, 15));
            tmno.setBounds(170, 200, 100, 20);
            tmno.setSize(190, 20);
            //tmno.setLocation(200, 250);
            c.add(tmno);

            sno = new JLabel("No of Seats");
            sno.setFont(new Font("Arial", Font.PLAIN, 20));
            sno.setBounds(20, 300, 100, 20);
            sno.setSize(150, 20);
            //mno.setLocation(100, 200);
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
            //mno.setLocation(100, 200);
            c.add(add);
            tadd = new JTextArea();
            tadd.setFont(new Font("Arial", Font.PLAIN, 15));
            tadd.setBounds(170, 250, 50, 20);
            tadd.setSize(200, 40);
            // tadd.setLocation(200, 300);
            tadd.setLineWrap(true);
            c.add(tadd);
            nt = new JLabel("note");
            nt.setFont(new Font("Arial", Font.PLAIN, 20));
            nt.setBounds(20, 350, 100, 10);
            nt.setSize(150, 20);
            //mno.setLocation(100, 200);
            c.add(nt);
            tnt = new JTextArea();
            tnt.setFont(new Font("Arial", Font.PLAIN, 15));
            tnt.setBounds(170, 350, 100, 20);
            tnt.setSize(200, 75);
            // tadd.setLocation(200, 300);
            tnt.setLineWrap(true);
            c.add(tnt);
            term = new JCheckBox("Accept Terms And Conditions.");
            term.setFont(new Font("Arial", Font.PLAIN, 15));
            term.setBounds(170, 510, 100, 20);
            term.setSize(250, 20);
            //term.setLocation(150, 400);
            c.add(term);

            sub = new JButton("Submit");
            sub.setFont(new Font("Arial", Font.PLAIN, 15));
            sub.setSize(100, 20);
            sub.setBounds(300, 460, 100, 20);
            //sub.setLocation(150, 450);
            sub.addActionListener(this);
            c.add(sub);

            reset = new JButton("Reset");
            reset.setFont(new Font("Arial", Font.PLAIN, 15));
            reset.setSize(100, 20);
            reset.setBounds(120, 460, 100, 20);
            // reset.setLocation(270, 450);
            reset.addActionListener(this);
            c.add(reset);

            setVisible(true);
        }

        // method actionPerformed()
        // to get the action performed
        // by the user and act accordingly
        public void actionPerformed(ActionEvent e)
        {
            if (e.getSource() == sub) {
                if (term.isSelected()) {
                    String data1;
                    String data
                            = "Name : "
                            + tname.getText() + "\n"
                            + "Mobile : "
                            + tmno.getText() + "\n";
                    if (male.isSelected())
                        data1 = "Gender : Male"
                                + "\n";
                    else
                        data1 = "Gender : Female"
                                + "\n";
                    String data2
                            = "DOB : "
                            + (String)date.getSelectedItem()
                            + "/" + (String)month.getSelectedItem()
                            + "/" + (String)year.getSelectedItem()
                            + "\n";

                    String data3 = "Address : " + tadd.getText();
                    tout.setText(data + data1 + data2 + data3);
                    tout.setEditable(false);
                    res.setText("Registration Successfully..");
                }
                else {
                    tout.setText("");
                    resadd.setText("");
                    res.setText("Please accept the"
                            + " terms & conditions..");
                }
            }

            else if (e.getSource() == reset) {
                String def = "";
                tname.setText(def);
                tadd.setText(def);
                tmno.setText(def);
                res.setText(def);
                tout.setText(def);
                term.setSelected(false);
                date.setSelectedIndex(0);
                month.setSelectedIndex(0);
                year.setSelectedIndex(0);
                resadd.setText(def);
            }
        }
        public static void main(String[] args) throws Exception
        {

        }
    }


