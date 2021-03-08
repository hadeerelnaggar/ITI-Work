package chatRoom;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try(Socket socket = new Socket("localhost",8189);
            InputStream inputStream = socket.getInputStream();
            Scanner in = new Scanner(inputStream);
            PrintWriter out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(),"UTF-8"),true);
            Scanner userInput = new Scanner(System.in)) {

            MessageReceiver messageReceiver = new MessageReceiver(in);
            messageReceiver.start();

            while(true){
                if(userInput.hasNextLine()){
                    out.println(userInput.nextLine());
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
