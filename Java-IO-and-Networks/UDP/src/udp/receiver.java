package udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Arrays;

public class receiver {
    public static void main(String[] args) {
        int serverPortNumber = 8189;

        try{
            DatagramSocket datagramSocket = new DatagramSocket();
            byte [] bytebuffer = new byte[1000];

            InetAddress serverHost = InetAddress.getLocalHost();

            DatagramPacket request = new DatagramPacket(bytebuffer,bytebuffer.length,serverHost,serverPortNumber);
            datagramSocket.send(request);
            System.out.println(new String(request.getData(),"UTF-8"));
            String fileLines = "";

            while(!fileLines.contains("EOF")){

                System.out.println("receiving...");
                byte[] receivingBuffer = new byte[1000];

                DatagramPacket data = new DatagramPacket(receivingBuffer,receivingBuffer.length);
                datagramSocket.receive(data);

                fileLines = new String(data.getData(), "UTF-8");
                System.out.println(fileLines);
            }

        }
        catch (SocketException e){
            e.printStackTrace();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
