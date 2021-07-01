/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package electricity.billing.system;

import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;
public class ViewInfo extends JFrame implements ActionListener{
    JButton b1;
    ViewInfo(String meter){
        setBounds(600,250,850,650);
        getContentPane().setBackground(Color.white);
        setLayout(null);
        JLabel title = new JLabel("VIEW CUSTOMER INFORMATION");
        title.setBounds(250,0,500,40);
        title.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(title);
        
        JLabel l1 = new JLabel("Name");
        l1.setBounds(70,80,100,20);
        add(l1);
        
        JLabel l2 = new JLabel();
        l2.setBounds(250,80,100,20);
        add(l2);
        
        JLabel l12 = new JLabel("Meter Number");
        l12.setBounds(70,140,100,20);
        add(l12);
        
        JLabel l21 = new JLabel();
        l21.setBounds(250,140,100,20);
        add(l21);
        
        JLabel l13 = new JLabel("Adress");
        l13.setBounds(70,200,100,20);
        add(l13);
        
        JLabel l22 = new JLabel();
        l22.setBounds(250,200,100,20);
        add(l22);
        
        JLabel l14 = new JLabel("City");
        l14.setBounds(70,260,100,20);
        add(l14);
        
        JLabel l24 = new JLabel();
        l24.setBounds(250,260,100,20);
        add(l24);
        
        JLabel l5 = new JLabel("State");
        l5.setBounds(500,80,100,20);
        add(l5);
        
        JLabel l25 = new JLabel();
        l25.setBounds(650,80,100,20);
        add(l25);
        
        JLabel l6 = new JLabel("Email");
        l6.setBounds(500,140,100,20);
        add(l6);
        
        JLabel l26 = new JLabel();
        l26.setBounds(650,140,150,20);
        add(l26);
        
        JLabel l7 = new JLabel("Phone");
        l7.setBounds(500,200,100,20);
        add(l7);
        
        JLabel l27 = new JLabel();
        l27.setBounds(650,200,100,20);
        add(l27);
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from emp where Meter_no = '"+meter+"'");
            while(rs.next()){
                l2.setText(rs.getString(1));
                l21.setText(rs.getString(2));
                l22.setText(rs.getString(3));
                l24.setText(rs.getString("City"));
                l25.setText(rs.getString("State"));
                l26.setText(rs.getString("Email"));
                l27.setText(rs.getString(7));
            }
        }catch(Exception e){}
        b1 = new JButton("Back");
        b1.setBackground(Color.black);
        b1.setForeground(Color.white);
        b1.setBounds(350,340,120,25);
        add(b1);
        b1.addActionListener(this);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("electricity/billing/system/icon/view1.png"));
        Image ic1 = i1.getImage().getScaledInstance(600, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(ic1);
        JLabel l9 = new JLabel(i3);
        l9.setBounds(20,350,600,300);
        add(l9);
        
    }
    public void actionPerformed(ActionEvent ae){
        this.setVisible(false);
    }
    public static void main(String[] args){
        new ViewInfo("").setVisible(true);
    }
    
}
