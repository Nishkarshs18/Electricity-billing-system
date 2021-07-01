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

public class Bill extends JFrame implements ActionListener{
    JLabel l1,l2;
    JTextArea a;
    Choice c2;
    JButton b1;
    JPanel p;
    String meter;
    Bill(String meter){
        setSize(500,900);
        setLayout(new BorderLayout());
        this.meter=meter;
        p = new JPanel();
        l1 = new JLabel("Generate Bill");
        l2 = new JLabel(meter);
        
       
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
        b1 = new JButton("Generate Bill");
        b1.addActionListener(this);
        
        a = new JTextArea(150,15);
        a.setText("\n\n\t-----------Click on the---------\n\tGenerate bill button to get\n\t  bill of selected month");
        JScrollPane sp = new JScrollPane(a);
        a.setFont(new Font("Sanserif",Font.ITALIC,18));
        
        p.add(l1);
        p.add(l2);
        p.add(c2);
        
        add(p,"North");
        add(sp,"Center");
        add(b1,"South");
        
        setLocation(750,100);
                
        
        
    }
    public void actionPerformed(ActionEvent ae){
        try{
            Conn c  = new Conn();
            
            String b = c2.getSelectedItem();
            a.setText("\tNishkarsh Power ltd.\n            Electricty bill of month "+b+" 2021 \n\n\n");
            ResultSet rs = c.s.executeQuery("select * from emp where Meter_no ="+meter);
            if(rs.next()){
                a.append("\n   Customer Name: "+rs.getString("Name"));
                a.append("\n   Meter number: "+rs.getString("Meter_no"));
                a.append("\n   Address: "+rs.getString("Address"));
                a.append("\n   City: "+rs.getString("City"));
                a.append("\n   State: "+rs.getString("State"));
                a.append("\n   Email: "+rs.getString("Email"));
                a.append("\n   Phone number: "+rs.getString("Phone"));
                a.append("\n-------------------------------------------------\n");
                
            }
            rs = c.s.executeQuery("select * from meterinfo where Meter_no = "+meter);
            if(rs.next()){
                a.append("\n   Meter Location: "+rs.getString("location"));
                a.append("\n   Meter Type: "+rs.getString("type"));
                a.append("\n   Phase code: "+rs.getString("phase code"));
                a.append("\n   Bill type: "+rs.getString("bill type"));
                a.append("\n   Days: "+rs.getString("days"));
                a.append("\n-------------------------------------------------\n\n");
            }
            rs = c.s.executeQuery("select * from tax");
            if(rs.next()){
                a.append("\n   Unit Charge:  RS."+rs.getString("unit_charge"));
                a.append("\n   Meter Rent:  RS."+rs.getString("mrent"));
                a.append("\n   MCB Rent:  RS."+rs.getString("mcbrent"));
                a.append("\n   Service cost:  RS."+rs.getString("sercost"));
                a.append("\n   GST@9%:  RS."+rs.getString("gst"));
                a.append("\n\n");
            }
            rs = c.s.executeQuery("select * from bill where Meter_no = "+meter+" AND month ='"+c2.getSelectedItem()+"'");
            if(rs.next()){
                  a.append("\n   Month: "+rs.getString("month"));
                  a.append("\n   Unit consumed: "+rs.getString("units"));
                  a.append("\n   Total charge:  RS."+rs.getString("amount"));
                  a.append("\n------------------------------------------------\n");
                  a.append("\n   Amount Payable:  RS."+rs.getString("amount"));
            }
            
        }catch(Exception e){e.printStackTrace();}
    }
    public static void main(String[] args){
        new Bill("").setVisible(true);
    }
}
