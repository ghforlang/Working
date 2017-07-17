package rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * TODO
 *
 * @author fanwh
 * @version V1.0
 * @create 2017-07-17 16:47
 *  
 */
public class RmiHelloWorldImpl extends UnicastRemoteObject implements RmiHelloWorld {
    /**
     * 因为UnicastRemoteObject的构造方法抛出了RemoteException异常，
     因此这里默认的构造方法必须写，
     必须声明抛出RemoteException异常
     *
     * @throws RemoteException
     */
    public RmiHelloWorldImpl() throws RemoteException{
    }

    @Override
    public String helloWorld() throws RemoteException {
        return "hello world!";
    }

    @Override
    public String sayHelloToSomeBody(String someBodyName) throws RemoteException {
        return "hello world" + someBodyName;
    }
}
