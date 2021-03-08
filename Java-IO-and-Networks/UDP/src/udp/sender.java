package udp;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.Arrays;

public class sender {
    public static void main(String[] args) throws Exception {

        DatagramSocket datagramSocket = new DatagramSocket(8189);
        byte[] bytebuffer = new byte[1000];
        DatagramPacket datarequest = new DatagramPacket(bytebuffer, bytebuffer.length);
        datagramSocket.receive(datarequest);


        FileReader fileReader = new FileReader(new File("C:\\Users\\Hadeer\\Desktop\\iti\\UDP\\text"));
        BufferedReader reader = new BufferedReader(fileReader);

        reader.lines().forEach(line -> {
            System.out.println(line);

            try {
                DatagramPacket data = new DatagramPacket(line.getBytes(), line.length(), datarequest.getAddress(), datarequest.getPort());
                datagramSocket.send(data);
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        });
        String end = "EOF";
        DatagramPacket data = new DatagramPacket(end.getBytes(), end.length(), datarequest.getAddress(), datarequest.getPort());
        datagramSocket.send(data);

    }
}
