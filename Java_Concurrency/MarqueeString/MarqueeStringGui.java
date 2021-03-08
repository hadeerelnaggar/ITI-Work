package day1.lab2;

import javax.swing.*;
import java.awt.*;

public class MarqueeStringGui extends JFrame implements Runnable {
    String text;
    Thread th;
    JLabel label;

    public MarqueeStringGui() {
        this("Java World!");
    }
    public MarqueeStringGui(String text) {
        this.text=text;
        th=new Thread(this);
        label=new JLabel();
        this.setTitle("Marquee String app");
        label.setText(text);
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setVerticalAlignment(JLabel.CENTER);
        this.add(label,BorderLayout.CENTER);
        th.start();
    }

    @Override
    public void run() {
        while(true){
            System.out.println(this.getWidth());
            if(label.getLocation().getX()==this.getWidth()/2){
                label.setLocation(-label.getWidth()/2,(int)label.getLocation().getY());
            }
            else {
                label.setLocation((int) label.getLocation().getX() + 1, (int) label.getLocation().getY());
                System.out.println(label.getLocation());
            }
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
