package clientRemote;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ChatClientInt extends Remote {
    public void receiveMessage(String message) throws RemoteException;
}
