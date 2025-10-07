package hospital.management.system;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {

    JTextField textField;
    JPasswordField jPasswordField;
    JButton b1, b2;

    Login() {

        JLabel namelabel = new JLabel("Username");
        namelabel.setBounds(40, 20, 100, 30);
        namelabel.setFont(new Font("Tahoma", Font.BOLD, 16));
        namelabel.setForeground(Color.BLACK);
        add(namelabel);

        JLabel Password = new JLabel("Password");
        Password.setBounds(40, 70, 100, 30);
        Password.setFont(new Font("Tahoma", Font.BOLD, 16));
        Password.setForeground(Color.BLACK);
        add(Password);

        textField = new JTextField();
        textField.setBounds(150, 20, 150, 30);
        textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
        textField.setBackground(new Color(255, 255, 255));
        textField.setForeground(Color.black);
        add(textField);

        jPasswordField = new JPasswordField();
        jPasswordField.setBounds(150, 70, 150, 30);
        jPasswordField.setFont(new Font("Tahoma", Font.PLAIN, 15));
        jPasswordField.setBackground(new Color(255, 255, 255));
        jPasswordField.setForeground(Color.BLACK);
        add(jPasswordField);

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("Icon/IST.jpeg"));
        Image i1 = imageIcon.getImage().getScaledInstance(450, 450, Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(i1);
        JLabel label = new JLabel(imageIcon1);
        label.setBounds(320, -30, 400, 300);
        add(label);

        b1 = new JButton("Login");
        b1.setBounds(40, 140, 120, 30);
        b1.setFont(new Font("serif", Font.BOLD, 15));
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        add(b1);

        b2 = new JButton("Cancel");
        b2.setBounds(180, 140, 120, 30);
        b2.setFont(new Font("serif", Font.BOLD, 15));
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.addActionListener(this);
        add(b2);

        getContentPane().setBackground(new Color(255, 255, 255));
        setSize(750, 300);
        setLocation(400, 270);
        setLayout(null);
        setVisible(true);

    }

    public static void main(String[] args) {
        new Login();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == b1){
           try{
               dbms d = new dbms();
               String user = textField.getText();
               String Pass = jPasswordField.getText();

               String q ="select * from login where ID = '"+user+"' and PW = '"+Pass+"'";
               ResultSet resultSet = d.statement.executeQuery(q);

               if(resultSet.next()){
                   new Reception();
                   setVisible(false);
               }else{
                   JOptionPane.showMessageDialog(null,"Invalid");
               }



           }catch (Exception E){
               E.printStackTrace();
           }


        }else {
            System.exit(10);
        }

    }
}
