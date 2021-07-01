/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package electricity.billing.system;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Project extends JFrame implements ActionListener {
    String meter;
     Project(String meter, String type){
         super("Electricity Billing System");
         setSize(1930,1030);
         this.meter=meter;
         
         ImageIcon ic1 = new ImageIcon(ClassLoader.getSystemResource("electricity/billing/system/icon/main.JPG"));
         Image i1 = ic1.getImage().getScaledInstance(1930, 1030, Image.SCALE_DEFAULT);
         ImageIcon icc1 = new ImageIcon(i1);
         JLabel l1 = new JLabel(icc1);
         add(l1);
         
         /* 1st menu coloum*/
         JMenuBar mb = new JMenuBar();
         JMenu master = new JMenu("Master");
         JMenuItem m1 = new JMenuItem("New Customer");
         JMenuItem m2 = new JMenuItem("Customer Details");
         JMenuItem m4 = new JMenuItem("Update Bill");
         JMenuItem m3 = new JMenuItem("Deposit Info");
         master.setForeground(Color.black);
         
         
         m1.setFont(new Font("monospaced",Font.PLAIN,12));
         ImageIcon icon1 = new ImageIcon(ClassLoader.getSystemResource("electricity/billing/system/icon/nc.JPG"));
         Image image1 = icon1.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
         m1.setIcon(new ImageIcon(image1));
         m1.setMnemonic('D');
         m1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D,ActionEvent.CTRL_MASK));
         m1.setBackground(Color.white);
         
         m2.setFont(new Font("monospaced",Font.PLAIN,12));
         ImageIcon icon2 = new ImageIcon(ClassLoader.getSystemResource("electricity/billing/system/icon/cd.JPG"));
         Image image2 = icon2.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
         m2.setIcon(new ImageIcon(image2));
         m2.setMnemonic('J');
         m2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_J,ActionEvent.CTRL_MASK));
         m2.setBackground(Color.white);
         
         m3.setFont(new Font("monospaced",Font.PLAIN,12));
         ImageIcon icon3 = new ImageIcon(ClassLoader.getSystemResource("electricity/billing/system/icon/di.JPG"));
         Image image3 = icon3.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
         m3.setIcon(new ImageIcon(image3));
         m3.setMnemonic('K');
         m3.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_K,ActionEvent.CTRL_MASK));
         m3.setBackground(Color.white);
         
         m4.setFont(new Font("monospaced", Font.PLAIN,12));
         ImageIcon uicon2 = new ImageIcon(ClassLoader.getSystemResource("electricity/billing/system/icon/cb.JPG"));
         Image uimage2 = uicon2.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
         m4.setIcon(new ImageIcon(uimage2));
         m4.setMnemonic('I');
         m4.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I,ActionEvent.CTRL_MASK));
         m4.setBackground(Color.white);
         
         m1.addActionListener(this);
         m2.addActionListener(this);
         m3.addActionListener(this);
         m4.addActionListener(this);
         //----------------------------------------------------------------------
         JMenu info = new JMenu("Profile");
         JMenuItem info1 = new JMenuItem("Update Profile");
       
         JMenuItem info2 = new JMenuItem("View Profile");
         info.setForeground(Color.black);
         
         info1.setFont(new Font("monospaced", Font.PLAIN,12));
         ImageIcon uicon12 = new ImageIcon(ClassLoader.getSystemResource("electricity/billing/system/icon/pb.JPG"));
         Image uimage12 = uicon12.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
         info1.setIcon(new ImageIcon(uimage12));
         info1.setMnemonic('O');
         info1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O,ActionEvent.CTRL_MASK));
         info1.setBackground(Color.white);
         
       
         
         info2.setFont(new Font("monospaced", Font.PLAIN,12));
         ImageIcon uicon31 = new ImageIcon(ClassLoader.getSystemResource("electricity/billing/system/icon/lb.JPG"));
         Image uimage31 = uicon31.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
         info2.setIcon(new ImageIcon(uimage31));
         info2.setMnemonic('p');
         info2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P,ActionEvent.CTRL_MASK));
         info2.setBackground(Color.white);
         
         info1.addActionListener(this);
        
         info2.addActionListener(this);
         
         
         /* 2nd menu coloum*/
         JMenu user = new JMenu("User");
         JMenuItem u1 = new JMenuItem("Pay Bill");
       
         JMenuItem u3 = new JMenuItem("Bill Details");
         user.setForeground(Color.red);
         
         u1.setFont(new Font("monospaced", Font.PLAIN,12));
         ImageIcon uicon1 = new ImageIcon(ClassLoader.getSystemResource("electricity/billing/system/icon/pb.JPG"));
         Image uimage1 = uicon1.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
         u1.setIcon(new ImageIcon(uimage1));
         u1.setMnemonic('O');
         u1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O,ActionEvent.CTRL_MASK));
         u1.setBackground(Color.white);
         
       
         
         u3.setFont(new Font("monospaced", Font.PLAIN,12));
         ImageIcon uicon3 = new ImageIcon(ClassLoader.getSystemResource("electricity/billing/system/icon/lb.JPG"));
         Image uimage3 = uicon3.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
         u3.setIcon(new ImageIcon(uimage3));
         u3.setMnemonic('p');
         u3.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P,ActionEvent.CTRL_MASK));
         u3.setBackground(Color.white);
         
         u1.addActionListener(this);
        
         u3.addActionListener(this);
         
         /* 3rd coloum*/
         JMenu report = new JMenu("Report");
         JMenuItem r1 = new JMenuItem("Generate Bill");
         report.setForeground(Color.black);
         
         r1.setFont(new Font("monospaced", Font.PLAIN,12));
         ImageIcon ricon = new ImageIcon(ClassLoader.getSystemResource("electricity/billing/system/icon/gb.JPG"));
         Image rimage = ricon.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
         r1.setMnemonic('L');
         r1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L,ActionEvent.CTRL_MASK));
         r1.setBackground(Color.white);
         
         r1.addActionListener(this);
         
         /*4th coloum*/
         JMenu utility = new JMenu("Utility");
         JMenuItem ut1 = new JMenuItem("Notepad");
         JMenuItem ut2 = new JMenuItem("Calculator");
         JMenuItem ut3 = new JMenuItem("Browser");
         utility.setForeground(Color.red);
         
         ut1.setFont(new Font("monospaced",Font.PLAIN,12));
         ImageIcon uti1 = new ImageIcon(ClassLoader.getSystemResource("electricity/billing/system/icon/note.png"));
         Image utimage1 = uti1.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
         ut1.setIcon(new ImageIcon(utimage1));
         ut1.setMnemonic('N');
         ut1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,ActionEvent.CTRL_MASK));
         ut1.setBackground(Color.white);
         
         ut2.setFont(new Font("monospaced",Font.PLAIN,12));
         ImageIcon uti2 = new ImageIcon(ClassLoader.getSystemResource("electricity/billing/system/icon/calc.png"));
         Image utimage2 = uti2.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
         ut2.setIcon(new ImageIcon(utimage2));
         ut2.setMnemonic('G');
         ut2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_G,ActionEvent.CTRL_MASK));
         ut2.setBackground(Color.white);
         
         ut3.setFont(new Font("monospaced",Font.PLAIN,12));
         ImageIcon uti3 = new ImageIcon(ClassLoader.getSystemResource("electricity/billing/system/icon/chrome.png"));
         Image utimage3 = uti3.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
         ut3.setIcon(new ImageIcon(utimage3));
         ut3.setMnemonic('B');
         ut3.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B,ActionEvent.CTRL_MASK));
         ut3.setBackground(Color.white);
         
         ut1.addActionListener(this);
         ut2.addActionListener(this);
         ut3.addActionListener(this);
         
         /* 5th coloum*/
         JMenu about = new JMenu("About");
         about.setForeground(Color.black);
         JMenuItem About = new JMenuItem("About us");
         About.setFont(new Font("monospaced",Font.PLAIN,12));
         About.setBackground(Color.white);
         
         About.addActionListener(this);
         
         /* 6th coloum*/
         JMenu log = new JMenu("Logout");
         JMenuItem lo = new JMenuItem("Yes");
         log.setForeground(Color.red);
         lo.setFont(new Font("monospaced",Font.BOLD,14));
         lo.addActionListener(this);
         
         
         master.add(m1);
         master.add(m2);
         master.add(m3);
         master.add(m4);
         
         info.add(info1);
         info.add(info2);
         
         user.add(u1);
         
         user.add(u3);
         
         report.add(r1);
         
         utility.add(ut1);
         utility.add(ut2);
         utility.add(ut3);
         about.add(About);
         
         log.add(lo);
         if(type.equals("Admin")){
              mb.add(master);
         }
         else{
             mb.add(info);
             mb.add(user);
             mb.add(report);
         }
        
         
         mb.add(utility);
         mb.add(about);
         mb.add(log);
         mb.setSize(1930,100);
         setJMenuBar(mb);
         
         setFont(new Font("Senserif",Font.BOLD,16));
         setLayout(new FlowLayout());
         setVisible(false);
                 
     }
     public void actionPerformed(ActionEvent ae){
         String msg = ae.getActionCommand();
         if(msg.equals("New Customer")){
            new NewCt().setVisible(true);
         }else if(msg.equals("Customer Details")){
             new CtDetails().setVisible(true);
         }else if(msg.equals("Deposit Info")){
             new Details().setVisible(true);
         }else if(msg.equals("Pay Bill")){
             new Pay(meter).setVisible(true);
         }else if(msg.equals("Update Bill")){
             new Calculate().setVisible(true);
         }else if(msg.equals("Bill Details")){
             new BillDetails(meter).setVisible(true);
             
         }else if(msg.equals("Generate Bill")){
             new Bill(meter).setVisible(true);
             
         }else if(msg.equals("Notepad")){
             try{
                 Runtime.getRuntime().exec("notepad.exe");
             } catch(Exception e){}
         }else if(msg.equals("Calculator")){
             try{
                 Runtime.getRuntime().exec("calc.exe");
             } catch(Exception e){}
         }else if(msg.equals("Browser")){
             try{
                 Runtime.getRuntime().exec("C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");
             }catch(Exception e){}
         }else if(msg.equals("About us")){
             new About().setVisible(true);
         }else if(msg.equals("Yes")){
            this.setVisible(false);
            new Login().setVisible(true);
            
         }else if(msg.equals("View Profile")){
             new ViewInfo(meter).setVisible(true);
         }else if(msg.equals("Update Profile")){
             new Update(meter).setVisible(true);
         }
     }
     public static void main(String[] args){
       
        new Project("","").setVisible(true);
        
     }
}
