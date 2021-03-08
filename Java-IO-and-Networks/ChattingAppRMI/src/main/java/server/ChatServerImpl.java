package server;

import clientRemote.ChatClientInt;
import javafx.scene.image.Image;
import org.apache.commons.io.FileUtils;
import serverRemote.ChatServerInt;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import javax.imageio.ImageIO;


public class ChatServerImpl extends UnicastRemoteObject implements ChatServerInt {
    ArrayList<ChatClientInt> clients;

    public ChatServerImpl() throws RemoteException{
        clients = new ArrayList<>();
    }
    @Override
    public void register(ChatClientInt c) throws RemoteException {
        clients.add(c);
    }

    @Override
    public void unregister(ChatClientInt c) throws RemoteException{
        clients.remove(c);
    }

    @Override
    public void tellOther(String msg) throws RemoteException{
        for(int i=0;i<clients.size();i++){
            clients.get(i).receiveMessage(msg);
        }
    }

    @Override
    public void sendImage(byte[] imageBytes,String formatName) throws RemoteException {
       File file = new File("C:\\Users\\Hadeer\\Desktop\\iti\\java io\\ChattingAppRMI\\src\\main\\resources\\photos\\photo."+formatName);
        try {
            FileUtils.writeByteArrayToFile(file,imageBytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
//        InputStream is = new ByteArrayInputStream(imageBytes);
//        try {
//            BufferedImage bufferedImage = ImageIO.read(is);
//            ImageIO.write(bufferedImage, formatName, target.toFile());
//            //Image image = new Image(is);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }
}
