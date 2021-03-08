package server;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server {
    public static void main(String[] args) {
        new Server();
    }
    public Server(){
        try {
            CalculatorImpl obj  = new CalculatorImpl();

            Registry registry = LocateRegistry.createRegistry(1234);
            registry.bind("CalculatorService",obj);


        } catch (RemoteException e) {
            e.printStackTrace();
        }
        catch(AlreadyBoundException e){
            e.printStackTrace();
        }
    }
}
