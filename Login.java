package university.manegement.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*; 


public class Login extends JFrame implements ActionListener{
    
    JButton Login,Cancel;
    JTextField tusername;
    JPasswordField tuserpassword;
    
    Login(){
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null); // null hoy to auto set na kare username ne
        
        JLabel lusername = new JLabel("Username");
        lusername.setBounds(40,20,100,20);
        add(lusername);
        
        tusername = new JTextField();
        tusername.setBounds(150,20,150,20);
        add(tusername);
        
        JLabel luserpassword = new JLabel("password");
        luserpassword.setBounds(40,60,100,20);
        add(luserpassword);
        
        tuserpassword = new JPasswordField();
        tuserpassword.setBounds(150,60,150,20);
        add(tuserpassword);
        
        Login = new JButton("Login");
        Login.setBounds(40,140,120,30);
        Login.setBackground(Color.BLACK);
        Login.setForeground(Color.WHITE);
        Login.addActionListener(this);
        Login.setFont(new Font("Tahoma", Font.BOLD,16));
        add(Login);
        
        Cancel = new JButton("Cancel");
        Cancel.setBounds(180,140,120,30);
        Cancel.setBackground(Color.BLACK);
        Cancel.setForeground(Color.WHITE);
        Cancel.addActionListener(this);
        Cancel.setFont(new Font("Tahoma", Font.BOLD,16));
        add(Cancel);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350,0,200,200);
        add(image);
        
        
        
        
        setSize(600,300);
        setLocation(500,250);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == Login){
           String username = tusername.getText();
           String password = tuserpassword.getText();
           
           String query = "select * from login where username='"+username+"'and password='"+password+"'"; 
            
           
           try{
               Conne c = new Conne();
              ResultSet rs = c.s.executeQuery(query);
              
              if(rs.next()){
                  setVisible(false);
                  new Project();
              }else{
                  JOptionPane.showMessageDialog(null,"Invalid username or password");
                  setVisible(false);
              }
              
           }catch(Exception e){
               e.printStackTrace();
           }
            
        }else if(ae.getSource() == Cancel){
            setVisible(false);
            
        }
    }
    
    public static void main(String[] args){
       Login l = new Login();
    }
    
}
