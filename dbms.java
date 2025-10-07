package hospital.management.system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class dbms {


    Connection connection;
    Statement statement;



    public dbms(){
       try{
           connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital_management_system", "root", "Irfan@123");
           statement =connection.createStatement();
       } catch (Exception e){
           e.printStackTrace();
       }
    }
}
