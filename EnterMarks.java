
package university.manegement.system;

import java.awt.*;
import java.sql.*;
import javax.swing.*;
import java.awt.event.*;


public class EnterMarks extends JFrame implements ActionListener{
    
    
    Choice crollno;
    JComboBox cbsemester;
    JTextField tfsub1,tfsub2,tfsub3,tfsub4,tfsub5,tfmarks1,tfmarks2,tfmarks3,tfmarks4,tfmarks5;
    JButton submit,Cancel;
       EnterMarks(){
         
           setSize(1000,500);
           setLocation(300,150);
           setLayout(null);
           getContentPane().setBackground(Color.WHITE);
           
           
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/exam.jpg"));
        Image i2 = i1.getImage().getScaledInstance(400, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(520,40,400,300);
        add(image);
        
        JLabel heading = new JLabel("Enter Marks of Student");
        heading.setBounds(50,0,500,50);
        heading.setFont(new Font("Tahuma",Font.BOLD,20));
        add(heading);
        
        JLabel lblrollnumber = new JLabel("Select Roll Number");
        lblrollnumber.setBounds(50,70,150,20);
        add(lblrollnumber);
         
        crollno = new Choice();
        crollno.setBounds(200,70,150,20);
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
        
        JLabel lblsemester = new JLabel("select Semester");
        lblsemester.setBounds(50, 110, 150, 20);
        add(lblsemester);
        
        String semester[]={"1st Semester","2st Semester","3st Semester","4st Semester","5st Semester","6st Semester","7st Semester","8st Semester",};
        cbsemester = new JComboBox(semester);
        cbsemester.setBounds(200,110,150,20);
        cbsemester.setBackground(Color.WHITE);
        add(cbsemester);
        
        JLabel lblentersubject = new JLabel("Enter Subject");
        lblentersubject.setBounds(100, 150, 200, 40);
        add(lblentersubject);
        
        JLabel lblentermarks = new JLabel("Enter Marks");
        lblentermarks.setBounds(320, 150, 200, 40);
        add(lblentermarks);
        
        tfsub1 = new JTextField();
        tfsub1.setBounds(50,200,200,20);
        add(tfsub1);
        
        tfmarks1 = new JTextField();
        tfmarks1.setBounds(260,200,200,20);
        add(tfmarks1);
        
        tfsub2 = new JTextField();
        tfsub2.setBounds(50,230,200,20);
        add(tfsub2);
        
        tfmarks2 = new JTextField();
        tfmarks2.setBounds(260,230,200,20);
        add(tfmarks2);
        
        tfsub3 = new JTextField();
        tfsub3.setBounds(50,260,200,20);
        add(tfsub3);
        
        tfmarks3 = new JTextField();
        tfmarks3.setBounds(260,260,200,20);
        add(tfmarks3);
        
        tfsub4 = new JTextField();
        tfsub4.setBounds(50,290,200,20);
        add(tfsub4);
        
        tfmarks4 = new JTextField();
        tfmarks4.setBounds(260,290,200,20);
        add(tfmarks4);
        
        tfsub5 = new JTextField();
        tfsub5.setBounds(50,320,200,20);
        add(tfsub5);
        
        tfmarks5 = new JTextField();
        tfmarks5.setBounds(260,320,200,20);
        add(tfmarks5);
        
        submit = new JButton("Submit");
        submit.setBounds(70,360,150,25);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        submit.setFont(new Font("Tahoma", Font.BOLD,16));
        add(submit);
        
        //cancel
        
        Cancel = new JButton("cancel");
        Cancel.setBounds(280,360,150,25);
        Cancel.setBackground(Color.BLACK);
        Cancel.setForeground(Color.WHITE);
        Cancel.addActionListener(this);
        Cancel.setFont(new Font("Tahoma", Font.BOLD,16));
        add(Cancel);
        
        setVisible(true);
           
      }
       
       public void actionPerformed(ActionEvent ae){
           if(ae.getSource() == submit){
               try{
                   Conne c =new Conne();
                   String q1 = "insert into subject values('"+crollno.getSelectedItem()+"','"+cbsemester.getSelectedItem()+"','"+tfsub1.getText()+"','"+tfsub2.getText()+"','"+tfsub3.getText()+"','"+tfsub4.getText()+"','"+tfsub5.getText()+"')";
                   String q2 = "insert into marks values('"+crollno.getSelectedItem()+"','"+cbsemester.getSelectedItem()+"','"+tfmarks1.getText()+"','"+tfmarks2.getText()+"','"+tfmarks3.getText()+"','"+tfmarks4.getText()+"','"+tfmarks5.getText()+"')";
                   
                   c.s.executeUpdate(q1);
                   c.s.executeUpdate(q2);
                   
                   JOptionPane.showMessageDialog(null,"Marks Inserted Sucessfully");
                   setVisible(false);
                   
               }catch(Exception e){
                   e.printStackTrace();
               }
           }else{
               setVisible(false);
           }
           
       }
    public static void main(String [] args){
        new EnterMarks();
    }
    
}
