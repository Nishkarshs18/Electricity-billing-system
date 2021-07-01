/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package electricity.billing.system;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class Update extends JFrame implements ActionListener  {
    JButton b1,b2;
    JTextField t1,t2,t3,t4,t5;
    JLabel l9,l10;
    String meter;
    Update(String meter){
        setBounds(500,250,800,550);
        getContentPane().setBackground(Color.white);
        setLayout(null);
        this.meter = meter;
        JLabel l1 = new JLabel("UPDATE INFORMATION");
        l1.setFont(new Font("Tahoma",Font.PLAIN,26));
        l1.setBounds(30,10,400,40);
        add(l1);
        JLabel l2 = new JLabel("Name");
        l2.setBounds(40,70,100,20);
        add(l2);
        
        JLabel l3 = new JLabel("Meter No.");
        l3.setBounds(40,120,100,20);
        add(l3);
        
        JLabel l4 = new JLabel("Adress");
        l4.setBounds(40,170,100,20);
        add(l4);
        
        JLabel l5 = new JLabel("City");
        l5.setBounds(40,220,100,20);
        add(l5);
        
        JLabel l6 = new JLabel("State");
        l6.setBounds(40,270,100,20);
        add(l6);
        
        JLabel l7 = new JLabel("Email");
        l7.setBounds(40,320,100,20);
        add(l7);
        
        JLabel l8 = new JLabel("Phone");
        l8.setBounds(40,370,100,20);
        add(l8);
        
        l9 = new JLabel();
        l9.setBounds(140,70,150,20);
        add(l9);
        
        l10 = new JLabel();
        l10.setBounds(140,120,150,20);
        add(l10);
        
        t1 = new JTextField();
        t1.setBounds(140,170,150,20);
        add(t1);
        
        t2 = new JTextField();
        t2.setBounds(140,220,150,20);
        add(t2);
        
        t3 = new JTextField();
        t3.setBounds(140,270,150,20);
        add(t3);
        
        t4 = new JTextField();
        t4.setBounds(140,320,150,20);
        add(t4);
        
        t5 = new JTextField();
        t5.setBounds(140,370,150,20);
        add(t5);
        
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("Select * from emp where Meter_no = '"+meter+"'");
            while(rs.next()){
                l9.setText(rs.getString("Name"));
                l10.setText(rs.getString("Meter_no"));
                t1.setText(rs.getString("Address"));
                t2.setText(rs.getString("City"));
                t3.setText(rs.getString("State"));
                t4.setText(rs.getString("Email"));
                t5.setText(rs.getString("Phone"));
            }
        }catch(Exception e){}
        
        b1 = new JButton("Update");
        b1.setBackground(Color.blue);
        b1.setForeground(Color.white);
        b1.setBounds(40,420,100,30);
        add(b1);
        b2 = new JButton("Back");
        b2.setBackground(Color.blue);
        b2.setForeground(Color.white);
        b2.setBounds(180,420,100,30);
        add(b2);
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        
        ImageIcon ic = new ImageIcon(ClassLoader.getSystemResource("electricity/billing/system/icon/update.JPG"));
        Image ic1 = ic.getImage().getScaledInstance(420, 350, Image.SCALE_DEFAULT);
        ImageIcon ic2 = new ImageIcon(ic1);
        JLabel l11 = new JLabel(ic2);
        l11.setBounds(320,00,420,350);
        add(l11);
        
        
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b1){
            String s1 = t1.getText();
            String s2 = t2.getText();
            String s3 = t3.getText();
            String s4 = t4.getText();
            String s5 = t5.getText();
            String s6 = l10.getText();
            try{
                Conn c = new Conn();
                c.s.executeUpdate("update emp set Address = '"+s1+"',State ='"+s3+"',City = '"+s2+"',Email = '"+s4+"',Phone = '"+s5+"' where Meter_no = '"+meter+"' ");
                JOptionPane.showMessageDialog(null, "Updated Successfully");
                this.setVisible(false);
            }catch(Exception e){
            e.printStackTrace();}
        }
        if(ae.getSource()==b2){
            this.setVisible(false);
        }
    }
    public static void main(String[] args){
        new Update("").setVisible(true);
    }
}
