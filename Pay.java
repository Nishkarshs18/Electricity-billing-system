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

public class Pay extends JFrame implements ActionListener{
    JLabel l7,l8,l9,l10,l11;
    Choice c2;
    JButton b1,b2;
    String meter;
    Pay(String meter){
       setBounds(600,200,750,600);
       setLayout(null);
       getContentPane().setBackground(Color.white);
       this.meter=meter;
       JLabel title = new JLabel("ELECTRICITY BILL");
       title.setFont(new Font("Tahoma",Font.BOLD,26));
       title.setBounds(200,10,500,40);
       add(title);
       
       JLabel l1 = new JLabel("Meter no.");
       l1.setFont(new Font("Tahoma",Font.PLAIN,22));
       l1.setBounds(10,60,200,30);
       add(l1);
       
       JLabel l2 = new JLabel("Name");
       l2.setBounds(10,110,100,20);
       add(l2);
       
       JLabel l3 = new JLabel("Month");
       l3.setBounds(10,160,100,20);
       add(l3);
       
       JLabel l4 = new JLabel("Units");
       l4.setBounds(10,210,100,20);
       add(l4);
       
       JLabel l5 = new JLabel("Total Amount");
       l5.setBounds(10,260,100,20);
       add(l5);
       
       JLabel l6 = new JLabel("Status");
       l6.setBounds(10,310,100,20);
       add(l6);
       
       l7 = new JLabel(meter);
       l7.setFont(new Font("Sansserif",Font.ITALIC,22));
       l7.setBounds(130,60,100,30);
       add(l7);
       
       l8 = new JLabel();
       l8.setBounds(170,110,150,30);
       add(l8);
       
       l9 = new JLabel();
       l9.setBounds(170,210,150,30);
       add(l9);
       
       l10 = new JLabel();
       l10.setBounds(170,260,150,30);
       add(l10);
       
       l11 = new JLabel();
       l11.setForeground(Color.red);
       l11.setBounds(170,310,150,30);
       add(l11);
       
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
        c2.setBounds(170,160,150,30);
        c2.addItemListener(new ItemListener(){
            public void itemStateChanged(ItemEvent ae){
                try{
                    Conn c = new Conn();
                    ResultSet rs = c.s.executeQuery("Select * from bill where Meter_no = '"+meter+"' AND month =  '"+c2.getSelectedItem()+"'");
                    while(rs.next()){
                        l9.setText(rs.getString("units"));
                        l10.setText(rs.getString("amount"));
                        l11.setText(rs.getString("status"));
                }
                }catch(Exception e){}
            }
        });
        add(c2);
        
        ImageIcon ic = new ImageIcon(ClassLoader.getSystemResource("electricity/billing/system/icon/billp.png"));
        Image ic1 = ic.getImage().getScaledInstance(350, 400,Image.SCALE_DEFAULT);
        ImageIcon ic2 = new ImageIcon(ic1);
        JLabel l13 = new JLabel(ic2);
        l13.setBounds(350,100,350,400);
        add(l13);
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from emp where Meter_no = "+meter);
            while(rs.next()){
                l8.setText(rs.getString("Name"));
            }
            rs = c.s.executeQuery("select * from bill where Meter_no = '"+meter+"' AND month = '"+c2.getSelectedItem()+"'");
            while(rs.next()){
                l9.setText(rs.getString("units"));
                l10.setText(rs.getString("amount"));
                l11.setText(rs.getString("status"));
            }
            
        }catch(Exception e){e.printStackTrace();}
        b1 = new JButton("Pay Bill");
        b1.setBackground(Color.black);
        b1.setForeground(Color.white);
        b1.setBounds(70,400,100,30);
        add(b1);
        b2 = new JButton("Back");
        b2.setBackground(Color.black);
        b2.setForeground(Color.white);
        b2.setBounds(200,400,100,30);
        add(b2);
        
        b1.addActionListener(this);
        b2.addActionListener(this);
       
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b1){
            try{
                Conn c = new Conn();
                c.s.executeUpdate("update bill set status = Paid where Meter_no = '"+meter+"' AND month = '"+c2.getSelectedItem()+"'");
            }catch (Exception e){}
        }
        if(ae.getSource()==b2){
            this.setVisible(false);
        }
    }
    public static void main(String[] args){
        new Pay("").setVisible(true);
    }
    
}
