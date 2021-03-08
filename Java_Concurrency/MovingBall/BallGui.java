package Day2.lab2;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class BallGui extends JFrame implements Runnable {
    private JLabel ballImage;
    private JButton pause;
    private JButton resume;
    private Boolean ballpaused=false;
    public BallGui() {
        Thread th;
        JPanel panel;
        panel = new JPanel();
        ballImage=new JLabel();
        th=new Thread(this);
        pause=new JButton();
        pause.setText("Pause");
        resume=new JButton();
        resume.setText("Resume");
        ballImage.setIcon(new ImageIcon("/soccerball.jpg"));
        panel.add(pause);
        pause.setBounds(100,30,100,30);
        panel.add(resume);
        resume.setBounds(300,30,100,30);
        pause.addActionListener(this::pauseButton);
        resume.addActionListener(this::resumeButton);
        panel.add(ballImage);
        this.add(panel);
        this.setTitle("Ball Gui app");
        th.start();
    }
    private synchronized void pauseButton(ActionEvent e){
        System.out.println(Thread.currentThread().getName());
        System.out.println("pausee");
        ballpaused=true;
        //notifyAll();
    }
    private synchronized void resumeButton(ActionEvent e){
        System.out.println(Thread.currentThread().getName()+" "+"resume");
        ballpaused=false;
        notifyAll();
    }
    @Override
    public void run() {
        ballImage.setSize(20,20);
        int x=1;
        int y=1;
        System.out.println(this.getWidth());
        while(true) {
            System.out.println(Thread.currentThread().getName());
            if(ballpaused){
                synchronized (this){
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            else if(!ballpaused) {
                System.out.println("move");
                if (ballImage.getX() == this.getWidth() - this.getBounds().getX() - ballImage.getIcon().getIconWidth() / 2 || ballImage.getX() == (0 - ballImage.getIcon().getIconWidth() / 2)) {
                    x *= -1;
                    //System.out.println("right");
                }
                if (ballImage.getY() == this.getHeight() - ballImage.getIcon().getIconHeight() || ballImage.getY() == 0-ballImage.getIcon().getIconWidth() / 2) {
                    y *= -1;
                    //System.out.println("bottom");
                }
                ballImage.setLocation((int) ballImage.getLocation().getX() + x, (int) ballImage.getLocation().getY() + y);
                //System.out.println(ballImage.getLocation());
                try {
                    Thread.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
