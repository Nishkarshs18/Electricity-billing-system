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
import java.util.*;

public class NewCt extends JFrame implements ActionListener {
    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9;
    JTextField t1,t2,t3,t4,t5,t6,t7;
    JButton b1,b2;
    NewCt(){
        super("New Customer");
        setLocation(550,200);
        setSize(700,630);
        
        JPanel p = new JPanel();
        p.setLayout(null);
        p.setBackground(Color.getHSBColor(216.09f, 8.05f, 30.27f));
        p.setBounds(500,150,650,580);
        
        JLabel title = new JLabel("New customer");
        title.setBounds(200,10,400,26);
        title.setFont(new Font("Tahoma",Font.BOLD,24));
        p.add(title);
        l1 = new JLabel("Name");
        t1 = new JTextField();
        l1.setBounds(10, 60, 100, 30);
        t1.setBounds(210, 60, 150, 30);
        p.add(l1);
        p.add(t1);
        
        l2 = new JLabel("Meter no.");
        l2.setBounds(10, 100, 100, 30);
        l9 = new JLabel();
        
        Random ran = new Random();
        long first = (ran.nextLong()%100000);
        l9.setText(""+Math.abs(first));
        l9.setBounds(210, 100, 100, 30);
        p.add(l2);
        p.add(l9);
        
        l3 = new JLabel("Address");
        t3 = new JTextField();
        l3.setBounds(10, 140, 100, 30);
        t3.setBounds(210,140, 150, 30);
        p.add(l3);
        p.add(t3);
        
        l4 = new JLabel("City");
        t4 = new JTextField();
        l4.setBounds(10, 180, 100, 30);
        t4.setBounds(210, 180, 150, 30);
        p.add(l4);
        p.add(t4);
        
        l5 = new JLabel("State");
        t5 = new JTextField();
        l5.setBounds(10, 220, 100, 30);
        t5.setBounds(210, 220, 150, 30);
        p.add(l5);
        p.add(t5);
        
        l6 = new JLabel("Email");
        t6 = new JTextField();
        l6.setBounds(10, 260, 100, 30);
        t6.setBounds(210, 260, 150, 30);
        p.add(l6);
        p.add(t6);
        
        l7 = new JLabel("Phone no.");
        t7 = new JTextField();
        l7.setBounds(10, 300, 100, 30);
        t7.setBounds(210, 300, 150, 30);
        p.add(l7);
        p.add(t7);
        
        b1 = new JButton("Submit");
        b1.setBackground(Color.getHSBColor(204.09f, 86.57f, 60.73f));
        b1.setForeground(Color.BLACK);
        b1.setBounds(70, 400, 120, 30);
        
        b2 = new JButton("Cancel");
        b2.setBackground(Color.getHSBColor(215.09f, 19.57f, 70.73f));
        b2.setForeground(Color.BLACK);
        b2.setBounds(240, 400, 120, 30);
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        p.add(b1);
        p.add(b2);
        setLayout(new BorderLayout());
        add(p,"Center");
        
        ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("electricity/billing/system/icon/newct.png"));
        Image im = icon.getImage().getScaledInstance(250, 300, Image.SCALE_DEFAULT);
        ImageIcon ic1 = new ImageIcon(im);
        l8 = new JLabel(ic1);
        
        add(l8,"East");
        getContentPane().setBackground(Color.getHSBColor(216.09f, 8.05f, 30.27f));
        
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b1){
            String a = t1.getText();
            String meter = l9.getText();
            String c = t3.getText();
            String d = t4.getText();
            String e = t5.getText();
            String f = t6.getText();
            String g = t7.getText();
            String q = "Insert into emp values('"+a+"','"+meter+"','"+c+"','"+e+"','"+d+"','"+f+"','"+g+"')";
            String q2 = "Insert into login values('"+meter+"','','','','')";
            try{
                Conn c1 = new Conn();
                c1.s.executeUpdate(q);
                c1.s.executeUpdate(q2);
                JOptionPane.showMessageDialog(null, "Customer Added");
                this.setVisible(false);
                new MeterInfo(meter).setVisible(true);

            }catch(Exception ex){
            ex.printStackTrace();
            }
        }else if(ae.getSource()==b2){
            this.setVisible(false);
        }
    }
    public static void main(String[] args){
        new NewCt().setVisible(true);
    }
}
