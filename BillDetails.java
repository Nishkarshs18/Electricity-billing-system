/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package electricity.billing.system;


import javax.swing.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;

public class BillDetails extends JFrame{
    JTable t1;
   
    String x[]={"Meter number","Month","Unit","Amount","Status"};
    String y[][] = new String[40][8];
    int i=0,j=0;
    BillDetails(String meter){
    super("Bill Details");
    setSize(700,650);
    setLocation(200,200);
    setLayout(null);
  
    t1 = new JTable(y,x);
    try{
        Conn c = new Conn();
        String q = ("select * from bill where Meter_no = "+meter);
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
    JScrollPane sp = new JScrollPane(t1);
    sp.setBounds(0,0,700,650);
    add(sp);
   
    
    
}
  
    public static void main(String[] args){
        new BillDetails("").setVisible(true);
    }
    
}
