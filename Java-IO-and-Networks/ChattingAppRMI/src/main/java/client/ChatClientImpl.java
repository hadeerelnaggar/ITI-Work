package client;

import client.model.UserInfo;
import client.utilities.ChatPageUtilities;
import clientRemote.ChatClientInt;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ChatClientImpl extends UnicastRemoteObject implements ChatClientInt {
    protected ChatClientImpl() throws RemoteException {
    }

    @Override
    public void receiveMessage(String message) throws RemoteException {
        ChatPageUtilities chatPageUtilities = ChatPageUtilities.getInstance();
        chatPageUtilities.addMessage(new UserInfo("",null),message);
    }
}
