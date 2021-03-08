package chatRoom;

import java.util.Scanner;

public class MessageReceiver extends Thread {
    Scanner in;
    MessageReceiver(Scanner in){
        this.in=in;
    }

    @Override
    public void run() {
        while(true){
            while (!in.hasNextLine()) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(in.nextLine());

        }
    }
}
