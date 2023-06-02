package university.manegement.system;

import com.toedter.calendar.JDateChooser;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;


public class StudentLeave extends JFrame implements ActionListener{
    
    Choice crollno, ctime;
    JDateChooser dcdate;
    JButton submit,Cancel;
    
    StudentLeave(){
        
        setSize(500,500);
        setLocation(550,100);
        setLayout(null);
        
        getContentPane().setBackground(Color.WHITE);
        
        JLabel heading = new JLabel("Apply leave (Student)");
        heading.setBounds(40,50,300,30);
        heading.setFont(new Font("Tahoma",Font.BOLD,20));
        add(heading);
        
        JLabel lblrollno = new JLabel("Search by Roll Number");
        lblrollno.setBounds(60,100,250,20);
        lblrollno.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(lblrollno);
         
        crollno = new Choice();
        crollno.setBounds(60,130,200,20);
        add(crollno);
        
        
        try{
            Conne c = new Conne();
            ResultSet rs = c.s.executeQuery("select * from student");
            while(rs.next()){
                crollno.add(rs.getString("rollno"));
                
            }
        }catch (Exception e){
            e.printStackTrace();;
            
        }
        
        JLabel lbldate = new JLabel("Date");
        lbldate.setBounds(60,180,200,20);
        lbldate.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(lbldate);
        
        dcdate = new JDateChooser();
        dcdate.setBounds(60,210,150,25);
        add(dcdate);
        
        JLabel lbltime = new JLabel("Time Duration");
        lbltime.setBounds(60,260,200,20);
        lbltime.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(lbltime);
         
        ctime = new Choice();
        ctime.setBounds(60,290,200,20);
        ctime.add("Full Day");
        ctime.add("Half Day");
        add(ctime);
        
        //submit
        
        submit = new JButton("submit");
        submit.setBounds(60,350,100,25);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        submit.setFont(new Font("Tahoma", Font.BOLD,16));
        add(submit);
        
        //cancel
        
        Cancel = new JButton("cancel");
        Cancel.setBounds(200,350,100,25);
        Cancel.setBackground(Color.BLACK);
        Cancel.setForeground(Color.WHITE);
        Cancel.addActionListener(this);
        Cancel.setFont(new Font("Tahoma", Font.BOLD,16));
        add(Cancel);
        
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == submit ){
            
            String rollno = crollno.getSelectedItem();
            String Date = ((JTextField) dcdate.getDateEditor().getUiComponent()).getText();
            String Duration = ctime.getSelectedItem();
            
            String query = "insert into studentleave values('"+rollno+"','"+Date+"','"+Duration+"')";
            
            try{
                Conne c = new Conne();
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Leave Confirmed");
                setVisible(false);
            }catch(Exception e){
                e.printStackTrace();
            }
            
        }else {
            setVisible(false);
        }
    }
 
    public static void main(String[] args){
       new StudentLeave();
    }
    
}
