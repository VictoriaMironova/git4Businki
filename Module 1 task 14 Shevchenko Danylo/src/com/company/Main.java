package com.company;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Main extends JFrame implements ActionListener
{
    JLabel l;
    JRadioButton jb[]=new JRadioButton[5];
    JButton b1,b2;
    ButtonGroup bg;
    int count=0,current=0;
    int m[]=new int[10];
    Main(String s)
    {
        super(s);
        l=new JLabel();
        add(l);
        bg=new ButtonGroup();
        for(int i=0;i<5;i++)
        {
            jb[i]=new JRadioButton();
            add(jb[i]);
            bg.add(jb[i]);
        }
        b1=new JButton("Next");
        b2=new JButton("Result");
        b1.addActionListener(this);
        b2.addActionListener(this);
        add(b1);add(b2);
        set();
        l.setBounds(30,40,450,20);
        jb[0].setBounds(50,80,100,20);
        jb[1].setBounds(50,110,100,20);
        jb[2].setBounds(50,140,100,20);
        jb[3].setBounds(50,170,100,20);
        b1.setBounds(100,240,100,30);
        b2.setBounds(270,240,100,30);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setLocation(250,100);
        setVisible(true);
        setSize(600,350);
    }
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==b1)
        {
            if(check())
                count=count+1;
            current++;
            set();
            if(current==9)
            {
                b1.setEnabled(false);
            }
        }

        if(e.getActionCommand().equals("Result"))
        {
            if(check())
                count=count+1;
            current++;
            JOptionPane.showMessageDialog(this,"percentage of correct answers :"+count+"0%");
            JOptionPane.showMessageDialog(this,"your mark is "+count);
            System.exit(0);
        }
    }
    void set()
    {
        jb[4].setSelected(true);
        if(current==0)
        {
            l.setText("Que1: Which one among these is not a primitive datatype?");
            jb[0].setText("int");jb[1].setText("Float");jb[2].setText("boolean");jb[3].setText("char");
        }
        if(current==1)
        {
            l.setText("Que2: Which class is available to all the class automatically?");
            jb[0].setText("Swing");jb[1].setText("Applet");jb[2].setText("Object");jb[3].setText("ActionEvent");
        }
        if(current==2)
        {
            l.setText("Que3: Which package is directly available to our class without importing it?");
            jb[0].setText("swing");jb[1].setText("applet");jb[2].setText("net");jb[3].setText("lang");
        }
        if(current==3)
        {
            l.setText("Que4: What is JVM?");
            jb[0].setText("Java virtual machine ");jb[1].setText("Java view module");jb[2].setText("Java void mass");jb[3].setText("Joyful vegan man");
        }
        if(current==4)
        {
            l.setText("Que5: Which is not the main principle of the OOP?");
            jb[0].setText("Encapsulation");jb[1].setText("Inheritance");jb[2].setText("YAGNI");jb[3].setText("Polymorphism");
        }
        if(current==5)
        {
            l.setText("Que6: Which one among these is not a keyword?");
            jb[0].setText("class");jb[1].setText("int");jb[2].setText("get");jb[3].setText("if");
        }
        if(current==6)
        {
            l.setText("Que7: Which one among these is not a class? ");
            jb[0].setText("Swing");jb[1].setText("Actionperformed");jb[2].setText("ActionEvent");
            jb[3].setText("Button");
        }
        if(current==7)
        {
            l.setText("Que8: What is not an access modifier in Java?");
            jb[0].setText("Private");jb[1].setText("Protected");jb[2].setText("Public");
            jb[3].setText("Standard");
        }
        if(current==8)
        {
            l.setText("Que9: which function is not present in Applet class?");
            jb[0].setText("init");jb[1].setText("main");jb[2].setText("start");jb[3].setText("destroy");
        }
        if(current==9)
        {
            l.setText("Que10: Which one among these is not a valid component?");
            jb[0].setText("JButton");jb[1].setText("JList");jb[2].setText("JButtonGroup");
            jb[3].setText("JTextArea");
        }
        l.setBounds(30,40,450,20);
        for(int i=0,j=0;i<=90;i+=30,j++)
            jb[j].setBounds(50,80+i,200,20);
    }
    boolean check()
    {
        if(current==0)
            return(jb[1].isSelected());
        if(current==1)
            return(jb[2].isSelected());
        if(current==2)
            return(jb[3].isSelected());
        if(current==3)
            return(jb[0].isSelected());
        if(current==4)
            return(jb[2].isSelected());
        if(current==5)
            return(jb[2].isSelected());
        if(current==6)
            return(jb[1].isSelected());
        if(current==7)
            return(jb[3].isSelected());
        if(current==8)
            return(jb[1].isSelected());
        if(current==9)
            return(jb[2].isSelected());
        return false;
    }
    public static void main(String s[])
    {
        new Main("Test Of Java");
    }
}  