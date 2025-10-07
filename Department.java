package hospital.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Department extends JFrame {
    Department(){

        JPanel panel = new JPanel();
        panel.setBounds(5,5,690,490);
        panel.setLayout(null);
        panel.setBackground(new Color(90,156,163));
        add(panel);

        JTable table = new JTable();
        table.setBounds(0,50,690,490);
        table.setBackground(new Color(90,156,163));
        table.setFont(new Font("Tahoma",Font.BOLD,14));
        table.setForeground(Color.BLACK);
        panel.add(table);

        try{
            dbms d = new dbms();
            String q = "Select * from Department";
            ResultSet resultSet = d.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        }catch(Exception e){
            e.printStackTrace();
        }


        JLabel label1 = new JLabel("Department");
        label1.setBounds(145,11,105,20);
        label1.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label1);

        JLabel label2 = new JLabel("Phone Number");
        label2.setBounds(431,11,150,20);
        label2.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label2);



        //setUndecorated(true);
        setSize(700,500);
        setLayout(null);
        setLocation(350,250);
        setVisible(true);
    }
    public static void main(String [] args){
        new Department();
    }
}
