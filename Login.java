 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package electricity.billing.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {
    JLabel l1,l2,l3,l4;
    Choice c1;
    JTextField t1;
    JPasswordField pf1;
    JButton b1,b2,b3;
    JPanel p1,p2,p3,p4;
    Login(){
        super("Login page");
        setLayout(null);
        l1 = new JLabel("Username");
        l1.setBounds(250,30,100,20);
        add(l1);
        l2 = new JLabel("Password");
        l2.setBounds(250,70,100,20);
        add(l2);
        t1 = new JTextField(15);
        t1.setBounds(350,30,150,20);
        add(t1);
        pf1 = new JPasswordField(15);
        pf1.setBounds(350, 70, 150, 20);
        add(pf1);
        l4 = new JLabel("Logging as");
        l4.setBounds(250,110,100,20);
        add(l4);
        c1 = new Choice();
        c1.add("Admin");
        c1.add("Customer");
        c1.setBounds(350, 110, 150, 20);
        add(c1);
       
        
        ImageIcon ic1 = new ImageIcon(ClassLoader.getSystemResource("electricity/billing/system/icon/login.png"));
        Image i1 = ic1.getImage().getScaledInstance(16, 16, Image.SCALE_DEFAULT);
        b1 = new JButton("Login", new ImageIcon(i1));
        b1.setBounds(270,160,100,30);
        add(b1);
        
        ImageIcon ic2 = new ImageIcon(ClassLoader.getSystemResource("electricity/billing/system/icon/cancel.png"));
        Image i2 = ic2.getImage().getScaledInstance(16, 16, Image.SCALE_DEFAULT);
        b2 = new JButton("Cancel", new ImageIcon(i2));
        b2.setBounds(330,210,100,30);
        add(b2);
        
        ImageIcon ic4 = new ImageIcon(ClassLoader.getSystemResource("electricity/billing/system/icon/sign.png"));
        Image i4 = ic4.getImage().getScaledInstance(16, 16, Image.SCALE_DEFAULT);
        b3 = new JButton("SignUp", new  ImageIcon(i4));
        b3.setBounds(390, 160, 100, 30);
        add(b3);
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        
        ImageIcon ic3 = new ImageIcon(ClassLoader.getSystemResource("electricity/billing/system/icon/user.png"));
        Image i3 =  ic3.getImage().getScaledInstance(180, 250, Image.SCALE_DEFAULT);
        ImageIcon icc3 = new ImageIcon(i3);
        l3 = new JLabel(icc3);
        l3.setBounds(0,0,200,300);
        add(l3);
        
       
        
        setSize(600,350);
        setLocation(600,300);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b1){
            try{
                Conn c = new Conn();
                String a = t1.getText();
                String b = pf1.getText();
                String type = c1.getSelectedItem();
                String q = "select * from login where Username = '"+a+"' and Password = '"+b+"' and type = '"+type+"'";
                ResultSet rs = c.s.executeQuery(q);
                if(rs.next()){
                    String meter = rs.getString("Meter_no");
                    new Project(meter,type).setVisible(true);
                    this.setVisible(false);
                }else{
                    JOptionPane.showMessageDialog(null, "Invalid Username/Password");
                    t1.setText("");
                    pf1.setText("");
                }

            }
            catch(Exception e){
                e.printStackTrace();
                System.out.println("ERROR" +e);
                JOptionPane.showMessageDialog(null,"Error " +e);
            }
        }else if(ae.getSource()==b2){
            this.setVisible(false);
        }else if(ae.getSource()==b3){
            this.setVisible(false);
            new Signup().setVisible(true);
        }
    }
    public static void main(String[] args){
        new Login().setVisible(true);
    }
}

   
   
