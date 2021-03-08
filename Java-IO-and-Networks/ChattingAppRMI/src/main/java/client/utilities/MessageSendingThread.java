package client.utilities;

import serverRemote.ChatServerInt;

import java.rmi.RemoteException;

public class MessageSendingThread extends Thread {
    ChatServerInt chatServer;
    String message;
    public MessageSendingThread(ChatServerInt chatServer,String message){
        this.chatServer = chatServer;
        this.message = message;
    }
    @Override
    public void run() {
        try {
            chatServer.tellOther(message);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
