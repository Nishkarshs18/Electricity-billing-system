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

public class MeterInfo extends JFrame implements ActionListener {
    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10;
    Choice c1,c2,c3,c4;
    JButton b1,b2;
    MeterInfo(String meter){
        super("Meter Info");
        setLocation(550,200);
        setSize(700,630);
        
        JPanel p = new JPanel();
        p.setLayout(null);
        p.setBackground(Color.getHSBColor(216.09f, 8.05f, 30.27f));
        p.setBounds(500,150,650,580);
        
        JLabel title = new JLabel("Meter Info");
        title.setBounds(200,10,400,26);
        title.setFont(new Font("Tahoma",Font.BOLD,24));
        p.add(title);
        l1 = new JLabel("Meter number");
        l10 = new JLabel(meter);
        l1.setBounds(10, 60, 100, 30);
        l10.setBounds(210, 60, 150, 30);
        p.add(l1);
        p.add(l10);
        
        l2 = new JLabel("Meter Location");
        l2.setBounds(10, 100, 100, 30);
        c1 = new Choice();
        c1.add("Inside");
        c1.add("Outside");
        c1.setBounds(210, 100, 100, 30);
        p.add(l2);
        p.add(c1);
        
        l3 = new JLabel("Meter type");
        c2 = new Choice();
        c2.add("Electric");
        c2.add("Solor Meter");
        c2.add("Smart Meter");
        l3.setBounds(10, 140, 100, 30);
        c2.setBounds(210,140, 150, 30);
        p.add(l3);
        p.add(c2);
        
        l4 = new JLabel("Phase code");
        c3 = new Choice();
        c3.add("011");
        c3.add("022");
        c3.add("033");
        c3.add("044");
        c3.add("055");
        l4.setBounds(10, 180, 100, 30);
        c3.setBounds(210, 180, 150, 30);
        p.add(l4);
        p.add(c3);
        
        l5 = new JLabel("Bill type");
        c4 = new Choice();
        c4.add("Domestic");
        c4.add("Comercial");
        l5.setBounds(10, 220, 100, 30);
        c4.setBounds(210, 220, 150, 30);
        p.add(l5);
        p.add(c4);
        
        l6 = new JLabel("Days");
        l9 = new JLabel("30");
        l6.setBounds(10, 260, 100, 30);
        l9.setBounds(210, 260, 150, 30);
        p.add(l6);
        p.add(l9);
        
       
        
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
        
        ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("electricity/billing/system/icon/meter.png"));
        Image im = icon.getImage().getScaledInstance(250, 300, Image.SCALE_DEFAULT);
        ImageIcon ic1 = new ImageIcon(im);
        l8 = new JLabel(ic1);
        l8.setBounds(400,80,250,300);
        
        p.add(l8);
        getContentPane().setBackground(Color.getHSBColor(216.09f, 8.05f, 30.27f));
        
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b1){
            String a = l10.getText();
            String b = c1.getSelectedItem();
            String c = c2.getSelectedItem();
            String d =c3.getSelectedItem();
            String e = c4.getSelectedItem();
            String f = "30";
            String q = "Insert into meterinfo values('"+a+"','"+b+"','"+c+"','"+e+"','"+d+"','"+f+"')";
            
            try{
                Conn c9 = new Conn();
                c9.s.executeUpdate(q);
                
                JOptionPane.showMessageDialog(null, "Meter information Added");
                this.setVisible(false);

            }catch(Exception ex){
            ex.printStackTrace();
            }
        }else if(ae.getSource()==b2){
            this.setVisible(false);
        }
    }
    public static void main(String[] args){
        new MeterInfo("").setVisible(true);
    }
}