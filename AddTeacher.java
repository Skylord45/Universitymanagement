package university.manegement.system;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;


public class AddTeacher extends JFrame implements ActionListener{
    
    JTextField tfname,tffname,tfaddress,tfphone,tfemail,tfx,tfxII,tfaadhar;
    JLabel labelempId,Qualification,Department;
    JDateChooser dcdob;
    JComboBox ccourse,cbranch;
    JButton submit,Cancel;
    
    Random ran = new Random();
    long first4 =Math.abs(ran.nextLong()% 9000L)+1000L;
    
    AddTeacher(){
    
        getContentPane().setBackground(Color.WHITE);
        
        setSize(900,700);
        setLocation(350,50);
        
        setLayout(null);
        
        //name
        
        JLabel heading = new JLabel("New Teacher Details");
        heading.setBounds(310,30,500,50);
        heading.setFont(new Font("serif",Font.BOLD,30));
        add(heading);
        
        JLabel lblname = new JLabel("Name");
        lblname.setBounds(50,150,100,30);
        lblname.setFont(new Font("serif",Font.BOLD,20));
        add(lblname);
        
        tfname = new JTextField();
        tfname.setBounds(200,150,150,30);
        add(tfname);
        
        // father name
        
        JLabel lblfname = new JLabel("Father's Name");
        lblfname.setBounds(400,150,200,30);
        lblfname.setFont(new Font("serif",Font.BOLD,20));
        add(lblfname);
        
        tffname = new JTextField();
        tffname.setBounds(600,150,150,30);
        add(tffname);
        
        //emp id 
        
        JLabel lblempId = new JLabel("Employee Id ");
        lblempId.setBounds(50,200,200,30);
        lblempId.setFont(new Font("serif",Font.BOLD,20));
        add(lblempId);
        
        labelempId = new JLabel("101"+first4);
        labelempId.setBounds(200,200,200,30);
        labelempId.setFont(new Font("serif",Font.BOLD,20));
        add(labelempId);
        
        // date of birth
        
        JLabel lbldob = new JLabel("Date Of Birth ");
        lbldob.setBounds(400,200,200,30);
        lbldob.setFont(new Font("serif",Font.BOLD,20));
        add(lbldob);
        
        dcdob = new JDateChooser();
        dcdob.setBounds(600,200,150,30);
        add(dcdob);
        
        //address
        
        JLabel lbladdress = new JLabel("Address");
        lbladdress.setBounds(50,250,200,30);
        lbladdress.setFont(new Font("serif",Font.BOLD,20));
        add(lbladdress);
        
        tfaddress = new JTextField();
        tfaddress.setBounds(200,250,150,30);
        add(tfaddress);
        
        //phone number
        
        JLabel lblfphone = new JLabel("Phone");
        lblfphone.setBounds(400,250,200,30);
        lblfphone.setFont(new Font("serif",Font.BOLD,20));
        add(lblfphone);
        
        tfphone = new JTextField();
        tfphone.setBounds(600,250,150,30);
        add(tfphone);
        
        //email id
        
        JLabel lblemail = new JLabel("Email Id");
        lblemail.setBounds(50,300,200,30);
        lblemail.setFont(new Font("serif",Font.BOLD,20));
        add(lblemail);
        
        tfemail = new JTextField();
        tfemail.setBounds(200,300,150,30);
        add(tfemail);
        
        //class 12th %(pr)
        
        JLabel lblxII= new JLabel("Class XII (%)");
        lblxII.setBounds(400,300,200,30);
        lblxII.setFont(new Font("serif",Font.BOLD,20));
        add(lblxII);
        
        tfxII = new JTextField();
        tfxII.setBounds(600,300,150,30);
        add(tfxII);
        
        //class 10th %(pr)
        
        JLabel lblx= new JLabel("Class X (%)");
        lblx.setBounds(50,350,200,30);
        lblx.setFont(new Font("serif",Font.BOLD,20));
        add(lblx);
        
        tfx = new JTextField();
        tfx.setBounds(200,350,150,30);
        add(tfx);
        
        // aadhar number
        
        JLabel lblaadhar= new JLabel("Aadhar Number");
        lblaadhar.setBounds(400,350,200,30);
        lblaadhar.setFont(new Font("serif",Font.BOLD,20));
        add(lblaadhar);
        
        tfaadhar = new JTextField();
        tfaadhar.setBounds(600,350,150,30);
        add(tfaadhar);
        
        // drop down
        //Qualification
        
        JLabel lblcourse= new JLabel("Qualification");
        lblcourse.setBounds(50,400,200,30);
        lblcourse.setFont(new Font("serif",Font.BOLD,20));
        add(lblcourse);
        
        String course[] ={"B.Tech","M.Tech","BCA","MCA","Msc","Bsc"};
        ccourse = new JComboBox(course);
        ccourse.setBounds(200,400,150,30);
        ccourse.setBackground(Color.WHITE);
        add(ccourse);
        
        //Branch
       // Department
        
        JLabel lblbranch= new JLabel("Department");
        lblbranch.setBounds(400,400,200,30);
        lblbranch.setFont(new Font("serif",Font.BOLD,20));
        add(lblbranch);
        
        String branch[] ={"Information & Tech.","Computer Science","Mechnical","Civil","Chemical","Electronics"};
        cbranch = new JComboBox(branch);
        cbranch.setBounds(600,400,150,30);
        cbranch.setBackground(Color.WHITE);
        add(cbranch);
        
        //submit
        
        submit = new JButton("submit");
        submit.setBounds(250,530,120,30);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        submit.setFont(new Font("Tahoma", Font.BOLD,16));
        add(submit);
        
        //cancel
        
        Cancel = new JButton("cancel");
        Cancel.setBounds(450,530,120,30);
        Cancel.setBackground(Color.BLACK);
        Cancel.setForeground(Color.WHITE);
        Cancel.addActionListener(this);
        Cancel.setFont(new Font("Tahoma", Font.BOLD,16));
        add(Cancel);
        
        
        
        
        
        setVisible(true);
        
    }
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == submit){
        
            String name = tfname.getText();
            String fname = tffname.getText();
            String empId = labelempId.getText();
            String dob = ((JTextField)dcdob.getDateEditor().getUiComponent()).getText();
            String address = tfaddress.getText();
            String phone = tfphone.getText();
            String email = tfemail.getText();
            String X = tfx.getText();
            String XII = tfxII.getText();
            String aadhar = tfaadhar.getText();
            String qualification = (String) ccourse.getSelectedItem();
            String department = (String) cbranch.getSelectedItem();
            try{
                
                String query = "insert into teacher values('"+name+"','"+fname+"','"+empId+"','"+dob+"','"+address+"','"+phone+"','"+email+"','"+X+"','"+XII+"','"+aadhar+"','"+qualification+"','"+department+"')";
                
                
                Conne c = new Conne();
                c.s.executeUpdate(query);
                
                JOptionPane.showMessageDialog(null, "Teacher Details Inserted Successfully");
                setVisible(false);
                
            }catch(Exception e){
                e.printStackTrace();
            }
            
        }else {
            setVisible(false);
        }
    }
    
    public static void main(String[] args){
        new AddTeacher();
    }
    
}
