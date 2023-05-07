package Server;

import EuclidianDistance.EuclideanDistance;
import EuclidianDistance.EuclideanDistanceImp;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Server extends EuclideanDistanceImp {
    public Server(){}

    public static void main(String[] args) {
        try {
            System.setProperty("java.rmi.server.hostname", "192.168.74.1");
            Registry registry = LocateRegistry.createRegistry(10833);
            registry.rebind("EuclidianDistance",(EuclideanDistance) UnicastRemoteObject.exportObject(new EuclideanDistanceImp(),0));
            System.out.print("Servidor pronto");
        }
        catch (RemoteException e) {
            System.out.println(e);
            throw new RuntimeException(e);
        }
    }
}
