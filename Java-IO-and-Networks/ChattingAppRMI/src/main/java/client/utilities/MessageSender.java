package client.utilities;

import client.model.UserInfo;
import javafx.scene.layout.VBox;
import serverRemote.ChatServerInt;

import java.rmi.RemoteException;

public class MessageSender extends Thread {
    private static MessageSender messageSender;
    private ChatServerInt chatServer;

    private MessageSender() {

    }

    public synchronized static MessageSender getInstance() {
        if (messageSender == null) {
            messageSender = new MessageSender();
        }
        return messageSender;
    }

    public void setChatServer(ChatServerInt chatServer) {
        this.chatServer = chatServer;
    }

    public void sendMessage(UserInfo user, String message) {
//        MessageSendingThread messageSendingThread = new MessageSendingThread(chatServer, message);
//        messageSendingThread.start();
        try {
            chatServer.tellOther(message);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        ChatPageUtilities chatPageUtilities = ChatPageUtilities.getInstance();
        chatPageUtilities.addMessage(user, message);
    }
    public void sendImage(byte[]imageBytes,String format){
        try {
            chatServer.sendImage(imageBytes,format);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }


}
