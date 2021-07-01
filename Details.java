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
import net.proteanit.sql.DbUtils;

public class Details extends JFrame implements ActionListener {
    JTable t1;
    JButton b1,b2;
    JLabel l1,l2;
    Choice c1,c2;
    String x[]={"Meter number","Month","Unit","Amount","Status"};
    String y[][] = new String[40][8];
    int i=0,j=0;
    Details(){
    super("Deposit Details");
    setSize(700,750);
    setLocation(200,200);
    setLayout(null);
    l1 = new JLabel("Sort by Month");
    l1.setBounds(30,20,100,30);
    l2 = new JLabel("Sort by Meter number");
    l2.setBounds(380,20,150,30);
    c1 = new Choice();
    try{
        Conn c = new Conn();
        ResultSet rs = c.s.executeQuery("Select * from emp");
        while(rs.next()){
            c1.add(rs.getString("Meter_no"));
        }
    }catch(Exception e){}
    c1.setBounds(530,20,150,30);
    add(c1);
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
    c2.setBounds(130,20,150,30);
    add(c2);
    add(l1);
    add(l2);
    t1 = new JTable(y,x);
    try{
        Conn c = new Conn();
        String q = "select * from bill";
        ResultSet rs = c.s.executeQuery(q);
//        while(rs.next()){
//            y[i][j++] = rs.getString("Meter_no");
//            y[i][j++] = rs.getString("month");
//            y[i][j++] = rs.getString("units");
//            y[i][j++] = rs.getString("amount");
//            y[i][j++] = rs.getString("status");
//            i++;
//            j = 0;
//        }
        t1.setModel(DbUtils.resultSetToTableModel(rs));
        
    }catch(Exception e){
        e.printStackTrace();
    }
    b1 = new JButton("Search");
    b1.setBounds(30,60,100,30);
    add(b1);
    b2 = new JButton("Print");
    b2.setBounds(180,60,100,30);
    add(b2);
    JScrollPane sp = new JScrollPane(t1);
    sp.setBounds(0,100,700,650);
    add(sp);
    b1.addActionListener(this);
    b2.addActionListener(this);
    
    
}
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b2){
            
            try{
                t1.print();
            }catch(Exception e){}
        }else if(ae.getSource()==b1){
            String str = "Select * from bill where Meter_no = '"+c1.getSelectedItem()+"' AND month = '"+c2.getSelectedItem()+"'";
            try{
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(str);
                t1.setModel(DbUtils.resultSetToTableModel(rs));
                
            }catch(Exception e){}
        }
    }
    public static void main(String[] args){
        new Details().setVisible(true);
    }
    
}
