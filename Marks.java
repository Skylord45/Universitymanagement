package university.manegement.system;

import java.awt.*;
import java.sql.*;
import javax.swing.*;
import java.awt.event.*;
import net.proteanit.sql.DbUtils;
import java.awt.event.*;


public class Marks extends JFrame implements ActionListener{
    
    JLabel lblrollno,lblsemester,sub1,sub2,sub3,sub4,sub5;
    String rollno;
    JButton Cancel;
    
    Marks(String rollno){
        this.rollno= rollno;
        setSize(500,600);
        setLocation(500,100);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
           JLabel heading = new JLabel("Gujarat Technological University");
           heading.setBounds(100,30,500,25);
           heading.setFont(new Font("Tahuma",Font.BOLD,20));
           add(heading);
           
           JLabel subheading = new JLabel("Results of Examination ");
           subheading.setBounds(145,70,500,20);
           subheading.setFont(new Font("Tahuma",Font.BOLD,18));
           add(subheading);
         
           lblrollno = new JLabel("Roll Number "+rollno);
           lblrollno.setBounds(60,120,500,20);
           lblrollno.setFont(new Font("Tahuma",Font.PLAIN,18));
           add(lblrollno);
           
           lblsemester = new JLabel("");
           lblsemester.setBounds(60,150,500,20);
           lblsemester.setFont(new Font("Tahuma",Font.PLAIN,18));
           add(lblsemester);
           
           sub1 = new JLabel();
           sub1.setBounds(100,220,500,20);
           sub1.setFont(new Font("Tahuma",Font.PLAIN,18));
           add(sub1);
           
           sub2 = new JLabel();
           sub2.setBounds(100,250,500,20);
           sub2.setFont(new Font("Tahuma",Font.PLAIN,18));
           add(sub2);
           
           sub3 = new JLabel();
           sub3.setBounds(100,280,500,20);
           sub3.setFont(new Font("Tahuma",Font.PLAIN,18));
           add(sub3);
           
           sub4 = new JLabel();
           sub4.setBounds(100,310,500,20);
           sub4.setFont(new Font("Tahuma",Font.PLAIN,18));
           add(sub4);
           
           sub5 = new JLabel();
           sub5.setBounds(100,340,500,20);
           sub5.setFont(new Font("Tahuma",Font.PLAIN,18));
           add(sub5);
           
           try{
               Conne c = new Conne();
               ResultSet rs1=c.s.executeQuery("select * from subject where rollno='"+rollno+"'");
               while(rs1.next()){
                   sub1.setText(rs1.getString("subject1"));
                   sub2.setText(rs1.getString("subject2"));
                   sub3.setText(rs1.getString("subject3"));
                   sub4.setText(rs1.getString("subject4"));
                   sub5.setText(rs1.getString("subject5"));
               }
               ResultSet rs2=c.s.executeQuery("select * from marks where rollno='"+rollno+"'");
               while(rs2.next()){
                   sub1.setText(sub1.getText()+"------------>"+rs2.getString("marks1"));
                   sub2.setText(sub2.getText()+"------------>"+rs2.getString("marks2"));
                   sub3.setText(sub3.getText()+"------------>"+rs2.getString("marks3"));
                   sub4.setText(sub4.getText()+"------------>"+rs2.getString("marks4"));
                   sub5.setText(sub5.getText()+"------------>"+rs2.getString("marks5"));
               }
               
           }catch(Exception e){
               e.printStackTrace();
           }
        
        Cancel = new JButton("Back");
        Cancel.setBounds(250,500,120,25);
        Cancel.setBackground(Color.BLACK);
        Cancel.setForeground(Color.WHITE);
        Cancel.addActionListener(this);
        Cancel.setFont(new Font("Tahoma", Font.BOLD,16));
        add(Cancel);
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        
    }
 
    public static void main(String[] args){
        new Marks("");
    }
}
