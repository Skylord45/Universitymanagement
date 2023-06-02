package university.manegement.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


public class UpdateTeacher extends JFrame implements ActionListener{
    
    JTextField tfname,tffname,tfaddress,tfphone,tfemail;
    JLabel labelempId;
    JButton submit,Cancel;
    Choice cEmpId;
    
    
    UpdateTeacher(){
        
        getContentPane().setBackground(Color.WHITE);
        
        setSize(900,650);
        setLocation(350,50);
        
        setLayout(null);
        
        JLabel heading = new JLabel("Update Teacher Details");
        heading.setBounds(50,20,500,50);
        heading.setFont(new Font("Tahuma",Font.ITALIC,35));
        add(heading);
        
        JLabel lblrollnumber = new JLabel("Select Employee Id");
        lblrollnumber.setBounds(50,100,200,20);
        lblrollnumber.setFont(new Font("serif",Font.PLAIN,20));
        add(lblrollnumber);
         
        cEmpId = new Choice();
        cEmpId.setBounds(250,100,200,20);
        add(cEmpId);
        
        
        try{
            Conne c = new Conne();
            ResultSet rs = c.s.executeQuery("select * from teacher");
            while(rs.next()){
                cEmpId.add(rs.getString("Employee_Id"));
                
            }
        }catch (Exception e){
            e.printStackTrace();;
            
        }
        
         //name
        
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
        
        //roll number 
        
        JLabel lblrollno = new JLabel(" Employee Id ");
        lblrollno.setBounds(50,200,200,30);
        lblrollno.setFont(new Font("serif",Font.BOLD,20));
        add(lblrollno);
        
        labelempId = new JLabel();
        labelempId.setBounds(200,200,200,30);
        labelempId.setFont(new Font("serif",Font.BOLD,20));
        add(labelempId);
        
        // date of birth
        
        JLabel lbldob = new JLabel("Date Of Birth ");
        lbldob.setBounds(400,200,200,30);
        lbldob.setFont(new Font("serif",Font.BOLD,20));
        add(lbldob);
        
        JLabel lbldcdob = new JLabel();
        lbldcdob.setBounds(600,200,200,30);
        lbldcdob.setFont(new Font("serif",Font.PLAIN,20));
        add(lbldcdob);
        
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
        
        JLabel labelXII = new JLabel();
        labelXII.setBounds(600,300,150,30);
        labelXII.setFont(new Font("serif",Font.PLAIN,20));
        add(labelXII);
        
        //class 10th %(pr)
        
        JLabel lblx= new JLabel("Class X (%)");
        lblx.setBounds(50,350,200,30);
        lblx.setFont(new Font("serif",Font.BOLD,20));
        add(lblx);
        
        JLabel labelX = new JLabel();
        labelX.setBounds(200,350,150,30);
        labelX.setFont(new Font("serif",Font.PLAIN,20));
        add(labelX);
        
        // aadhar number
        
        JLabel lblaadhar= new JLabel("Aadhar Number");
        lblaadhar.setBounds(400,350,200,30);
        lblaadhar.setFont(new Font("serif",Font.BOLD,20));
        add(lblaadhar);
        
        JLabel labelaadhar = new JLabel();
        labelaadhar.setBounds(600,350,150,30);
        labelaadhar.setFont(new Font("serif",Font.PLAIN,20));
        add(labelaadhar);
        
        // drop down
        
        JLabel lblcourse= new JLabel("Education");
        lblcourse.setBounds(50,400,200,30);
        lblcourse.setFont(new Font("serif",Font.BOLD,20));
        add(lblcourse);
        
        
        JLabel labelcourse = new JLabel();
        labelcourse.setBounds(200,400,150,30);
        labelcourse.setFont(new Font("serif",Font.PLAIN,20));
        add(labelcourse);
        
        //Branch
        
        JLabel lblbranch= new JLabel("Department");
        lblbranch.setBounds(400,400,200,30);
        lblbranch.setFont(new Font("serif",Font.BOLD,20));
        add(lblbranch);
        
        JLabel labelbranch = new JLabel();
        labelbranch.setBounds(600,400,200,30);
        labelbranch.setFont(new Font("serif",Font.PLAIN,20));
        add(labelbranch);
        
        try{
           
            Conne c = new Conne();
            String query = "select * from teacher where Employee_Id='"+cEmpId.getSelectedItem()+"'";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()){
                lbldcdob.setText(rs.getString("dob"));
                labelempId.setText(rs.getString("Employee_Id"));
                lbldcdob.setText(rs.getString("dob"));
                labelX.setText(rs.getString("class_X"));
                labelXII.setText(rs.getString("class_XII"));
                labelaadhar.setText(rs.getString("aadhar"));
                labelcourse.setText(rs.getString("Qualification"));
                labelbranch.setText(rs.getString("department"));  
                tfname.setText(rs.getString("name"));
                tffname.setText(rs.getString("fname"));
                tfaddress.setText(rs.getString("address"));
                tfphone.setText(rs.getString("phone"));
                tfemail.setText(rs.getString("email"));
            }
           
        }catch(Exception e){
            e.printStackTrace();
            
        }
        
        cEmpId.addItemListener(new ItemListener(){
           
            @Override
            public void itemStateChanged(ItemEvent ie){
                
                try{
           
            Conne c = new Conne();
            String query = "select * from teacher where Employee_Id='"+cEmpId.getSelectedItem()+"'";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()){
                lbldcdob.setText(rs.getString("dob"));
                labelempId.setText(rs.getString("Employee_Id"));
                lbldcdob.setText(rs.getString("dob"));
                labelX.setText(rs.getString("class_X"));
                labelXII.setText(rs.getString("class_XII"));
                labelaadhar.setText(rs.getString("aadhar"));
                labelcourse.setText(rs.getString("Qualification"));
                labelbranch.setText(rs.getString("department"));  
                tfname.setText(rs.getString("name"));
                tffname.setText(rs.getString("fname"));
                tfaddress.setText(rs.getString("address"));
                tfphone.setText(rs.getString("phone"));
                tfemail.setText(rs.getString("email"));
            }
           
        }catch(Exception e){
            e.printStackTrace();
            
        }
        
                
                
            }
            
            
        });
        
        //submit as a update
        
        submit = new JButton("Update");
        submit.setBounds(250,500,120,30);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        submit.setFont(new Font("Tahoma", Font.BOLD,16));
        add(submit);
        
        //cancel
        
        Cancel = new JButton("cancel");
        Cancel.setBounds(450,500,120,30);
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
            String empId= labelempId.getText();
            String address = tfaddress.getText();
            String phone = tfphone.getText();
            String email = tfemail.getText();
//            String X = tfx.getText();              //update karva hoy to
//            String XII = tfxII.getText();         //koi pan
//            String aadhar = tfaadhar.getText();
//            String course = (String) ccourse.getSelectedItem();
//            String branch = (String) cbranch.getSelectedItem();
//            
            try{
                
                String query = "update teacher set name='"+name+"',fname='"+fname+"',address='"+address+"',phone='"+phone+"',email='"+email+"'where Employee_Id='"+empId+"'";
                
                
                Conne c = new Conne();
                c.s.executeUpdate(query);
                
                JOptionPane.showMessageDialog(null, "Teacher Details Updated Successfully");
                setVisible(false);
                
            }catch(Exception e){
                e.printStackTrace();
            }
            
        }else {
            setVisible(false);
        }
    }
    
    public static void main(String[] args){
        new UpdateTeacher();
    }
    
}

