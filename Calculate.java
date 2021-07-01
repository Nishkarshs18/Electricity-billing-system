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
public class Calculate extends JFrame implements ActionListener{
    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9;
    Choice c1,c2;
    JTextField t1;
    JButton b1,b2;
    JPanel p;
    Calculate(){
        super("Calculate bill");
        p = new JPanel();
        p.setLayout(null);
        p.setBounds(400, 300, 650, 450);
        p.setBackground(Color.white);
        //setSize(650,450);
        //setLocation(400,300);
        
        l1 = new JLabel("Update bill");
        l1.setFont(new Font("Sansserif",Font.CENTER_BASELINE,26));
        l1.setHorizontalAlignment(JLabel.CENTER);
       // l1.setBounds(100,50,400,50);
        p.add(l1);
        
        l2 = new JLabel("Meter no.");
        l2.setBounds(30, 10, 100, 30);
        l3 = new JLabel("Name");
        l3.setBounds(30, 60, 100, 30);
        l4 = new JLabel("Address");
        l4.setBounds(30, 110, 100, 30);
        c1 = new Choice();
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("Select * from emp");
            while(rs.next()){
                c1.add(rs.getString("Meter_no"));
            }
        }catch(Exception e){}
        c1.setBounds(130, 10, 150, 30);
        c1.addItemListener(new ItemListener(){
            public void itemStateChanged(ItemEvent ae){
                try{
                    Conn c = new Conn();
                    ResultSet rs = c.s.executeQuery("Select * from emp where Meter_no = '"+c1.getSelectedItem()+"'");
                    while(rs.next()){
                        l6.setText(rs.getString("Name"));
                        l7.setText(rs.getString("Address"));
                }
                }catch(Exception e){}
            }
        });
        l6 = new JLabel();
        l6.setBounds(130,60,150,30);
        l7 = new JLabel();
        l7.setBounds(130, 110, 150, 30);
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("Select * from emp where Meter_no = '"+c1.getSelectedItem()+"'");
            while(rs.next()){
                l6.setText(rs.getString("Name"));
                l7.setText(rs.getString("Address"));
            }
        }catch(Exception e){}
        l8 = new JLabel("Month");
        l8.setBounds(30,160,100,30);
        l9 = new JLabel("Units");
        l9.setBounds(30, 210, 100, 30);
        c2 = new Choice();
        c2.add("January");
        c2.add("February");
        c2.add("March");
        c2.add("April");
        c2.add("May");
        c2.add("June");
        c2.add("July");
        c2.add("August");
        c2.add("September");
        c2.add("October");
        c2.add("November");
        c2.add("December");
        c2.setBounds(130,160,150,30);
        t1 = new JTextField();
        t1.setBounds(130,210,150,30);
        p.add(l2);
        p.add(c1);
        p.add(l3);
        p.add(c2);
        p.add(l4);
        p.add(t1);
        p.add(l6);
        p.add(l7);
        p.add(l8);
        p.add(l9);
        
        ImageIcon ic = new ImageIcon(ClassLoader.getSystemResource("electricity/billing/system/icon/cal.jpg"));
        Image im = ic.getImage().getScaledInstance(180, 270, Image.SCALE_DEFAULT);
        ImageIcon icc  = new ImageIcon(im);
        l5 = new JLabel(icc);
        
        b1 = new JButton("Update");
        b1.setForeground(Color.white);
        b1.setBackground(Color.black);
        b1.setBounds(30,270,100,40);
        
        b2 = new JButton("Cancel");
        b2.setForeground(Color.white);
        b2.setBackground(Color.black);
        b2.setBounds(200,270,100,40);
        
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        
        p.add(l5);
        p.add(b1);
        p.add(b2);
        
        setLayout(new BorderLayout(30,30));
        
        add(l1,"North");
        add(p,"Center");
        add(l5,"West");
        
        getContentPane().setBackground(Color.white);
        setSize(650,500);
        setLocation(350,200);
        
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b1){
            String meter = c1.getSelectedItem();
            String b = t1.getText();
            String month = c2.getSelectedItem();

            int units = Integer.parseInt(b);
            int total = 0;
            try{
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery("select * from tax");

                while(rs.next()){
                    total = units* Integer.parseInt(rs.getString("unit_charge"));
                    total+= Integer.parseInt(rs.getString("mrent"));
                    total+= Integer.parseInt(rs.getString("mcbrent"));
                    total+= Integer.parseInt(rs.getString("sercost"));
                    total+= Integer.parseInt(rs.getString("gst"));
                }
            }catch(Exception e){}

            String q = "insert into bill value('"+meter+"','"+month+"','"+b+"','"+total+"','Not Paid')";

            try{
                Conn c1 = new Conn();
                c1.s.executeUpdate(q);
                JOptionPane.showMessageDialog(null, "Customer Bill updated Successfully");
                this.setVisible(false);

            }catch(Exception e){
            e.printStackTrace();}
        }else if(ae.getSource() == b2){
            this.setVisible(false);
        } 
    }
    public static void main(String[] args){
        new Calculate().setVisible(true);
    }
}
