package main;


import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class MyFrame extends JFrame implements MouseListener{

    JLabel label;

    MyFrame(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500, 500);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setLayout(null);

        label = new JLabel();
        label.setBounds(0, 0, 100, 100);
        label.setBackground(Color.red);
        label.setOpaque(true);
        label.addMouseListener(this);


        this.add(label);

        this.setVisible(true);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // TODO Auto-generated method stub
        System.out.println("U clicked to mouth");
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub
       
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }



}
