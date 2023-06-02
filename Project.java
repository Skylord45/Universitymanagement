package university.manegement.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


public class Project extends JFrame implements ActionListener{
     
    
    Project(){
        setSize(1540,850);
        
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/it.png"));
        Image i2 = i1.getImage().getScaledInstance(1500, 760, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        add(image);
        
        JMenuBar mb = new JMenuBar();
        
        //New Information
        
        JMenu newInformation = new JMenu("New Information");
        newInformation.setForeground(Color.BLUE);
        mb.add(newInformation);
        
        JMenuItem facultyInfo = new JMenuItem("New Faculty Information");
        facultyInfo.setBackground(Color.WHITE);
        facultyInfo.addActionListener(this);
        newInformation.add(facultyInfo);
        
        JMenuItem StudentInfo = new JMenuItem("New Student Information");
        StudentInfo.setBackground(Color.WHITE);
        StudentInfo.addActionListener(this);
        newInformation.add(StudentInfo);
        
        // Details
        JMenu Details = new JMenu("View Details");
        Details.setForeground(Color.red);
        mb.add(Details);
        
        JMenuItem facultyDetails = new JMenuItem("View Faculty Details");
        facultyDetails.setBackground(Color.WHITE);
        facultyDetails.addActionListener(this);
        Details.add(facultyDetails);
        
        JMenuItem StudentDetails = new JMenuItem("View Student Details");
        StudentDetails.setBackground(Color.WHITE);
        StudentDetails.addActionListener(this);
        Details.add(StudentDetails);
        
        
        // leave
        JMenu Leave = new JMenu("Apply Leave");
        Leave.setForeground(Color.blue);
        mb.add(Leave);
        
        JMenuItem facultyLeave = new JMenuItem("Faculty Leave");
        facultyLeave.setBackground(Color.WHITE);
        facultyLeave.addActionListener(this);
        Leave.add(facultyLeave);
        
        JMenuItem StudentLeave = new JMenuItem("Student Leave");
        StudentLeave.setBackground(Color.WHITE);
        StudentLeave.addActionListener(this);
        Leave.add(StudentLeave);
        
        // leave details
        JMenu LeaveDetails = new JMenu("Leave Details");
        LeaveDetails.setForeground(Color.red);
        mb.add(LeaveDetails);
        
        JMenuItem facultyLeaveDetails = new JMenuItem("Faculty Leave Details");
        facultyLeaveDetails.setBackground(Color.WHITE);
        facultyLeaveDetails.addActionListener(this);
        LeaveDetails.add(facultyLeaveDetails);
        
        JMenuItem StudentLeaveDetails = new JMenuItem("Student Leave Details");
        StudentLeaveDetails.setBackground(Color.WHITE);
        StudentLeaveDetails.addActionListener(this);
        LeaveDetails.add(StudentLeaveDetails);
        
        
        //exam
        JMenu Exam = new JMenu("Examination");
        Exam.setForeground(Color.blue);
        mb.add(Exam);
        
        JMenuItem examinationDetails = new JMenuItem("Examination Results");
        examinationDetails.addActionListener(this);
        examinationDetails.setBackground(Color.WHITE);
        Exam.add(examinationDetails);
        
        JMenuItem enterMarks = new JMenuItem("Enter Marks");
        enterMarks.addActionListener(this);
        enterMarks.setBackground(Color.WHITE);
        Exam.add(enterMarks);
        
        
        //Update Information
        JMenu updateInfo = new JMenu("Update Details");
        updateInfo.setForeground(Color.red);
        mb.add(updateInfo);
        
        JMenuItem updatefacultyinfo = new JMenuItem("Update Faculty Details");
        updatefacultyinfo.setBackground(Color.WHITE);
        updatefacultyinfo.addActionListener(this);
        updateInfo.add(updatefacultyinfo);
        
        JMenuItem updatestudentinfo = new JMenuItem("Update Student Details");
        updatestudentinfo.setBackground(Color.WHITE);
        updatestudentinfo.addActionListener(this);
        updateInfo.add(updatestudentinfo);
        
        
        //fees 
        JMenu fee = new JMenu("Fee Details");
        fee.setForeground(Color.blue);
        mb.add(fee);
        
        JMenuItem feestructure = new JMenuItem("Fee Structure");
        feestructure.setBackground(Color.WHITE);
        fee.add(feestructure);
        
        JMenuItem feeForm = new JMenuItem("Student Fee Form");
        feeForm.setBackground(Color.WHITE);
        fee.add(feeForm);
        
        
        //Utility 
        JMenu Utility = new JMenu("Utility");
        Utility.setForeground(Color.red);
        mb.add(Utility);
        
        JMenuItem notepad = new JMenuItem("Notepad");
        notepad.setBackground(Color.WHITE);
        notepad.addActionListener(this);
        Utility.add(notepad);
        
        JMenuItem calc = new JMenuItem("Calculator");
        calc.setBackground(Color.WHITE);
        calc.addActionListener(this);
        Utility.add(calc);
        
        //exit
        JMenu Exit = new JMenu("Exit");
        Exit.setForeground(Color.blue);
        mb.add(Exit);
        
        JMenuItem ex = new JMenuItem("Exit");
        ex.setBackground(Color.WHITE);
        ex.addActionListener(this);
        Exit.add(ex);
         
        
        setJMenuBar(mb);
        
        
        setVisible(true);
    }
 
    public void actionPerformed(ActionEvent ae){
       String msg = ae.getActionCommand();
       
       if(msg.equals("Exit")){
           setVisible(false);
       }else if(msg.equals("Calculator")){
           try{
               Runtime.getRuntime().exec("calc.exe");
           }catch(Exception e){}
           
       }else if(msg.equals("Notepad")){
           try{
               Runtime.getRuntime().exec("notepad.exe");
           }catch(Exception e){}
       }
       else if(msg.equals("New Faculty Information")){
           new AddTeacher();
       }else if(msg.equals("New Student Information")){
           new AddStudent();
       }else if(msg.equals("View Faculty Details")){
           new TeacherDetails();
       }else if(msg.equals("View Student Details")){
           new StudentDetails();
       }else if (msg.equals("Student Leave")){
           new StudentLeave();
       }else if (msg.equals("Faculty Leave")){
           new TeacherLeave();
       }else if (msg.equals("Faculty Leave Details")){
           new TeacherLeaveDetails();
       }else if (msg.equals("Student Leave Details")){
           new StudentLeaveDetails();
       }else if (msg.equals("Update Faculty Details")){
           new UpdateTeacher();
       }else if (msg.equals("Update Student Details")){
           new UpdateStudent();
       }else if (msg.equals("Enter Marks")){
           new EnterMarks();
       }else if(msg.equals("Examination Results")){
           new ExaminationDetails();
       }
    }
    
    public static void main(String[] args){
        Project p = new Project();
        
    }
}
