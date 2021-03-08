package server;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ServerMain {
    public static void main(String[] args) {
        new ServerMain();
    }
    ServerMain(){
        try {
            ChatServerImpl obj  = new ChatServerImpl();

            Registry registry = LocateRegistry.createRegistry(8189);
            registry.bind("ChatService",obj);


        } catch (RemoteException e) {
            e.printStackTrace();
        }
        catch(AlreadyBoundException e){
            e.printStackTrace();
        }
    }
}
