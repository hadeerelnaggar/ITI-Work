package server;

import remote.CalculatorInt;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class CalculatorImpl extends UnicastRemoteObject implements CalculatorInt {
    protected CalculatorImpl() throws RemoteException {
    }

    @Override
    public Integer add(int firstNum, int secondNum) throws RemoteException{
        return (firstNum + secondNum);
    }

    @Override
    public int subtract(int firstNum, int secondNum)throws RemoteException {
        return firstNum - secondNum;
    }

    @Override
    public int multiply(int firstNum, int secondNum)throws RemoteException {
        return firstNum * secondNum;
    }

    @Override
    public int divide(int firstNum, int secondNum)throws RemoteException {
        return firstNum/secondNum;
    }
}
