package remote;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface CalculatorInt extends Remote {
    Integer add (int firstNum,int secondNum) throws RemoteException;
    int subtract(int firstNum,int secondNum)throws RemoteException;
    int multiply(int firstNum,int secondNum)throws RemoteException;
    int divide(int firstNum,int secondNum)throws RemoteException;
}
