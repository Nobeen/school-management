package Com;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class Login extends JFrame implements ActionListener
{
    JButton SUBMIT;
    JPanel panel;
    JLabel success;
    JLabel label1,label2;
    JPasswordField password;
    JTextField  text1,text2;
    JFrame jframe;
    private Container c;
    Login()
    {
        c=getContentPane();
        jframe=new JFrame();
        panel=new JPanel();
        setSize(500,500);
        setDefaultCloseOperation(jframe.EXIT_ON_CLOSE);
        //jframe.setVisible(true);
        setLocationRelativeTo(null);
        //jframe.add(panel);
        c.setLayout(null);

        label1 = new JLabel("UserName");
       // label1.setText("UserName");
        label1.setBounds(50,100,120,20);
        c.add(label1);
        text1 = new JTextField(15);
        text1.setBounds(150,100,120,20);
        c.add(text1);

        label2 = new JLabel("Password:");
        //label2.setText("Password:");
        label2.setBounds(50,150,120,20);
        c.add(label2);
        password = new JPasswordField(15);
        password.setBounds(150,150,120,20);
        c.add(password);
        SUBMIT=new JButton("Login");
        SUBMIT.setBounds(120,220,120,20);
        SUBMIT.addActionListener(this);
        c.add(SUBMIT);
        success=new JLabel("");
        success.setBounds(50,260,120,25);
        c.add(success);
        setTitle("LOGIN FORM");
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e)
    {
        String user=text1.getText();
        String Password1=password.getText();
        System.out.println(user+", "+password);
        if(user.equals("Alex")&&password.equals("hello")) {
            success.setText("Login Successful");
        }


    }

    public static void main(String arg[])
    {
        try
        {
            Login frame=new Login();
          //  frame.setSize(300,100);
          //  frame.setVisible(true);
        }
        catch(Exception e)
        {JOptionPane.showMessageDialog(null, e.getMessage());}
    }
}

