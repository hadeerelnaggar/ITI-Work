package serverRemote;

import clientRemote.ChatClientInt;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ChatServerInt extends Remote {
    public void register(ChatClientInt c) throws RemoteException;
    public void unregister(ChatClientInt c) throws RemoteException;
    public void tellOther(String msg) throws RemoteException;
    public void sendImage(byte[] imagebytes,String formatName) throws RemoteException;
}
