package university.manegement.system;

import java.sql.*;


public class Conne {
    
    Connection c;
    Statement s;
    
    Conne(){
        try{
            //driver ae class che and com.mysql.cj.jdbc. ae class nu address che;
     Class.forName("com.mysql.cj.jdbc.Driver");
     c = DriverManager.getConnection("jdbc:mysql:///universitymanagementsystem","root","hemal@2004");
     s = c.createStatement();
     
     
        }catch(Exception e){
            e.printStackTrace();
        }
        
    }
    
    
    public static void main(String[] args){
        
    }
}
