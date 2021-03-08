package useredit.server;

import useredit.common.CommonUser;
import useredit.common.RMIInterface;
import java.rmi.RemoteException;
import useredit.server.daos.UserDao;

public class RMIImpl implements RMIInterface {
    UserDao userDao = UserDao.getInstance();
    @Override
    public void addUser(CommonUser user) throws RemoteException {
        userDao.addUser(user);
    }

    @Override
    public void updateUser(CommonUser user) throws RemoteException {
        userDao.updateUser(user);
    }

    @Override
    public void deleteUser(CommonUser user) throws RemoteException {

    }

    @Override
    public boolean hasNext() throws RemoteException {
        return false;
    }

    @Override
    public boolean hasPrev() throws RemoteException {
        return false;
    }

    @Override
    public CommonUser getFirst() throws RemoteException {
        return null;
    }

    @Override
    public CommonUser getNext() throws RemoteException {
        return null;
    }

    @Override
    public CommonUser getPrev() throws RemoteException {
        return null;
    }

    @Override
    public CommonUser getLast() throws RemoteException {
        return null;
    }
}
