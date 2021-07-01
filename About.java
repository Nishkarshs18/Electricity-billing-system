/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package electricity.billing.system;

import java.awt.*;
import javax.swing.*;
public class About extends JFrame {
    About(){
        setBounds(550,250,800,700);
        setLayout(null);
        
        JLabel title = new JLabel("About us");
        title.setFont(new Font("Tahoma",Font.BOLD,26));
        title.setForeground(Color.black);
        title.setBounds(300,10,200,40);
        add(title);
        ImageIcon ic = new ImageIcon(ClassLoader.getSystemResource("electricity/billing/system/icon/me.JPG"));
        Image ic1 = ic.getImage().getScaledInstance(400, 400, Image.SCALE_DEFAULT);
        ImageIcon ic2 = new ImageIcon(ic1);
        JLabel l1 = new JLabel(ic2);
        l1.setBounds(350,80,400,400);
        add(l1);
        
        JTextArea t1 = new JTextArea(01,01);
        t1.setText("This project is created by ");
//        t1.setText("\n This project is created by \n "
//                + "NISHKARSH SHARMA, \n "
//                + "this project can be used as \n"
//                + " Electricity billing system. "
//                + "\n This project has two different pannel \n"
//                + " one for admin and one for customer."
//                + "\n where Admin can perform operations like "
//                + "\n 1. Add customer"
//                + "\n 2. Update bill"
//                + "\n And Customer can perform operations like "
//                + "\n 1. View Information"
//                + "\n 2. Update Information"
//                + "\n 3. Pay bills "
//                + "\n 4. View bill Details "
//                + "\n this project build with the help of JAVA swings.");
        t1.setFont(new Font("Sansserif",Font.PLAIN,20));
        t1.setEditable(false);
        t1.setBackground(Color.getHSBColor(225.09f, 80.0f, 10.27f));
        t1.setBounds(10,80,320,30);
        add(t1);
        
        JLabel l2 = new JLabel("Nishkarsh sharma");
        l2.setFont(new Font("Sansserif",Font.BOLD,25));
        l2.setForeground(Color.red);
        l2.setBackground(Color.getHSBColor(225.09f, 80.0f, 10.27f));
        l2.setBounds(10,110,320,30);
        add(l2);
        
        JTextArea t2 = new JTextArea(50,01);
        t2.setText("The project is named as Electricity\n"
                + "billing System "
                + "and can be used by \n"
                + "Admin panel and power consumers. \n"
                + "Admin can perform operatios as \nfollows: \n"
                + "1. Add Customers \n"
                + "2. Update Bills \n"
                + "3. View Bill Status \n"
                + "Where as Customers can perform \noperations like: \n"
                + "1. Pay Bill \n"
                + "2. View profile \n"
                + "3. Update profile \n"
                + "4. View Bill Details \n"
                + "5. Generate Bill \n"
                + ""
                );
        t2.setFont(new Font("Sansserif",Font.PLAIN,20));
        t2.setEditable(false);
        t2.setBackground(Color.getHSBColor(225.09f, 80.0f, 10.27f));
        t2.setBounds(10,140,320,390);
        add(t2); 
        JLabel l3 = new JLabel("This project has body of JAVA swings and soul of JAVA AWT");
        l3.setFont(new Font("Sansserif",Font.BOLD,25));
        l3.setForeground(Color.black);
        l3.setBackground(Color.getHSBColor(225.09f, 80.0f, 10.27f));
        l3.setBounds(10,550,750,30);
        add(l3);
        getContentPane().setBackground(Color.getHSBColor(225.09f, 80.0f, 10.27f));
        
        ImageIcon ic3 = new ImageIcon(ClassLoader.getSystemResource("electricity/billing/system/icon/border2.jpg"));
        Image ic4 = ic3.getImage().getScaledInstance(800, 700, Image.SCALE_DEFAULT);
        ImageIcon ic5 = new ImageIcon(ic4);
        JLabel l4 = new JLabel(ic5);
        l4.setBounds(00,00,800,900);
        l4.setBackground(Color.getHSBColor(225.09f, 80.0f, 10.27f));
       // add(l4);
        getContentPane().setBackground(Color.getHSBColor(225.09f, 80.0f, 10.27f));
    }
    public static void main(String[] args){
        new About().setVisible(true);
    }
}
