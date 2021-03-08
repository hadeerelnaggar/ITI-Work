package client;

import remote.CalculatorInt;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Calc {
    public static void main(String[] args) {
        Calc calc  = new Calc();
        CalculatorInt calcRef = calc.getCalculatorref();
        if(args.length==3){
            System.out.print(args[0]+args[1]+args[2]);
            int firstNum = Integer.parseInt(args[0]);
            int secondNum = Integer.parseInt(args[2]);
            int result = 0;
            if(args[1].equals("+")){
                try {
                    result = calcRef.add(firstNum,secondNum);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
            else if(args[1].equals("-")){
                try {
                    result = calcRef.subtract(firstNum,secondNum);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
            else if(args[1].equals("*")){
                try {
                    result = calcRef.multiply(firstNum,secondNum);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
            else if(args[1].equals("/")){
                try {
                    result = calcRef.divide(firstNum,secondNum);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(" = "+result);
        }
    }
    public CalculatorInt getCalculatorref(){
        CalculatorInt calcref=null;
        try {
            Registry reg = LocateRegistry.getRegistry("localhost",1234);
            String [] services = reg.list();
            for(int i=0;i<services.length;i++){
                System.out.println(services[i]);
            }
            calcref = (CalculatorInt) reg.lookup("CalculatorService");
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (NotBoundException e) {
            e.printStackTrace();
        }
        return calcref;
    }
}
