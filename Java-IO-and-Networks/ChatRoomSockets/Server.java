package chatRoom;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {
    private ArrayList<Socket> clientSockets=new ArrayList<>();
    private static Server server = new Server();
    private static int clientCount = 0;
    private Server(){

    }
    public static Server getInstance(){
        return server;
    }
    public static void main(String[] args) {
        try(ServerSocket serverSocket = new ServerSocket(8189)) {
            while (true){
                Socket s = serverSocket.accept();
                server.clientSockets.add(s);
                clientCount++;
                System.out.println("Serving "+clientCount+" clients");
                ThreadedClientHandling threadedClientHandler = new ThreadedClientHandling(s);
                threadedClientHandler.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void broadcast(String message){
        try {
            for (int i = 0; i < clientSockets.size(); i++) {
                OutputStream outputStream = clientSockets.get(i).getOutputStream();
                PrintWriter out = new PrintWriter(new OutputStreamWriter(outputStream, "UTF-8"), true);
                System.out.println(message);
                out.println(message);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public void removeClient(Socket client){
        clientSockets.remove(client);
        clientCount--;

    }
}
