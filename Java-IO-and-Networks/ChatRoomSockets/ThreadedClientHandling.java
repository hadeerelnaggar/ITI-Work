package chatRoom;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class ThreadedClientHandling extends Thread {
    Socket incoming;

    ThreadedClientHandling(Socket incoming) {
        this.incoming = incoming;
    }

    @Override
    public void run() {
        try (InputStream inputStream = incoming.getInputStream()) {
            Scanner in = new Scanner(inputStream, "UTF-8");
            boolean done = false;
            String line = "";
            do{
                line = in.nextLine();
                System.out.println(line + "kk");
                Server server = Server.getInstance();
                server.broadcast(line);
            } while (!line.equals("End"));
            Server server = Server.getInstance();
            server.removeClient(incoming);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
