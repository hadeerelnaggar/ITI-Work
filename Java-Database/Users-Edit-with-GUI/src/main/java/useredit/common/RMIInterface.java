package useredit.common;

import useredit.server.daos.UserDao;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RMIInterface extends Remote {
    public void addUser(CommonUser user) throws RemoteException;
    public void updateUser(CommonUser user) throws RemoteException;
    public void deleteUser(CommonUser user) throws RemoteException;
    public boolean hasNext() throws RemoteException;
    public boolean hasPrev() throws RemoteException;
    public CommonUser getFirst() throws RemoteException;
    public CommonUser getNext() throws RemoteException;
    public CommonUser getPrev() throws RemoteException;
    public CommonUser getLast() throws RemoteException;
}
