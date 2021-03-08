package program;

import javafx.scene.layout.VBox;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClientSocket {
    PrintWriter out;
    private static ClientSocket clientSocket;
    private ClientSocket(){
        try {
            Socket socket = new Socket("localhost",8189);
            InputStream inputStream = socket.getInputStream();
            Scanner in = new Scanner(inputStream);
            out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(),"UTF-8"),true);
            //Scanner userInput = new Scanner(System.in);

            MessageReceiver messageReceiver = new MessageReceiver(in);
            messageReceiver.start();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public synchronized static ClientSocket getInstance(){
        if(clientSocket==null){
            clientSocket = new ClientSocket();
        }
        return clientSocket;
    }
    public void sendMessage(String message){
        out.println(message);
    }
}
