/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package electricity.billing.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;
import javax.swing.border.TitledBorder;
import java.sql.*;
 

public class Signup extends JFrame implements ActionListener {
    JLabel l1,l2,l3,l4,l5,l6;
    Choice c1;
    JTextField t1,t2,t3,t4;
    JPanel p1;
    JButton b1,b2;
    Signup(){
        super("Signup");
        //getContentPane().setBackground(Color.white);
        setBounds(600,300,700,450);
        p1 = new JPanel();
        p1.setBounds(30,30,650,400);
        p1.setLayout(null);
        p1.setBackground(Color.white);
      //  p1.setForeground(Color.white);
        p1.setBorder(new TitledBorder(new LineBorder(new Color(216, 8, 30),2), "Create-Account", TitledBorder.LEADING, TitledBorder.TOP ,null, new Color(216,8,30)));
        add(p1);
        
        l1 = new JLabel("Username");
        l1.setFont(new Font("Tahoma",Font.BOLD,14));
        l1.setBounds(100, 50, 100, 20);
        p1.add(l1);
        
        l2 = new JLabel("Name");
        l2.setFont(new Font("Tahoma",Font.BOLD,14));
        l2.setBounds(100, 90, 100, 20);
        p1.add(l2);
        
        l3 = new JLabel("Password");
        l3.setFont(new Font("Tahoma",Font.BOLD,14));
        l3.setBounds(100, 130, 100, 20);
        p1.add(l3);
        l4 = new JLabel("User Type");
        l4.setFont(new Font("Tahoma",Font.BOLD,14));
        l4.setBounds(100, 170, 100, 20);
        p1.add(l4);
        
        t1 = new JTextField();
        t1.setBounds(250,50,150,20);
        p1.add(t1);
        
        t2 = new JTextField();
        t2.setBounds(250,90,150,20);
        p1.add(t2);
        
        t3 = new JTextField();
        t3.setBounds(250,130,150,20);
        p1.add(t3);
        
        l5 = new JLabel("Meter Number");
        l5.setFont(new Font("Tahoma",Font.BOLD,14));
        l5.setBounds(100, 210, 100, 20);
        l5.setVisible(false);
        p1.add(l5);
        
        t4 = new JTextField();
        t4.setBounds(250, 210, 150, 20);
        t4.setVisible(false);
        p1.add(t4);
        
        c1 = new Choice();
        c1.add("Admin");
        c1.add("Customer");
        c1.setBounds(250, 170, 150, 20);
        p1.add(c1);
        c1.addItemListener(new ItemListener(){
            public void itemStateChanged(ItemEvent ae){
                String user = c1.getSelectedItem();
                if(user.equals("Customer")){
                    l5.setVisible(true);
                    t4.setVisible(true);
                }
            }
        });
        
        
       
        
        ImageIcon ic = new ImageIcon(ClassLoader.getSystemResource("electricity/billing/system/icon/signup1.png"));
        Image ic1 = ic.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
        ImageIcon ic2 = new ImageIcon(ic1);
        l6 = new JLabel(ic2);
        l6.setBounds(420,50,250,250);
        p1.add(l6);
        
        b1 = new JButton("Create Account");
        b1.setBackground(Color.black);
        b1.setForeground(Color.white);
        b1.setBounds(100,320,130,30);
        p1.add(b1);
         
        b2 = new JButton("Back");
        b2.setBackground(Color.black);
        b2.setForeground(Color.white);
        b2.setBounds(250,320,130,30);
        p1.add(b2);
        b1.addActionListener(this);
        b2.addActionListener(this);
        
        
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b1){
            String uname = t1.getText();
            String name = t2.getText();
            String pass = t3.getText();
            String type = c1.getSelectedItem();
            String meter = t4.getText();
            try{
                Conn c = new Conn();
                String q = null;
                if(type.equals("Admin")){
                  q = "insert into login values('"+meter+"','"+uname+"','"+pass+"','"+name+"','"+type+"')";  
                }else{
                    q = "update login set Username ='"+uname+"', Password = '"+pass+"',name = '"+name+"',type = '"+type+"' where Meter_no ='"+t4.getText()+"'";
                }
               
                c.s.executeUpdate(q);
                JOptionPane.showMessageDialog(null,"Account created successfully");
                this.setVisible(false);
                new Login().setVisible(true);
                
            }catch(Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e);}
        }else if(ae.getSource()==b2){
            this.setVisible(false);
            new Login().setVisible(true);
        }
        
    }
    public static void main(String[] args){
        new Signup().setVisible(true);
    }
}
