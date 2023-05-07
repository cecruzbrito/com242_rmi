package Client;

import EuclidianDistance.EuclideanDistance;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;

public class Client {
    private Client(){}

    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            send(createPoint(scanner, "A"), createPoint(scanner, "B"));
            scanner.close();
        } catch (RemoteException | NotBoundException | MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
    private static void send(EuclideanDistance.Point a, EuclideanDistance.Point b) throws RemoteException, NotBoundException, MalformedURLException {
        EuclideanDistance stub = (EuclideanDistance) Naming.lookup("rmi://192.168.74.1:10833/EuclidianDistance");
        System.out.print("A distancia euclediana dessas pontos: " + stub.makeCalc(a.x, a.y, b.x, b.y));
    }
    private static EuclideanDistance.Point createPoint(Scanner scanner, String name) {
        System.out.println("Digite a coordenada de eixo X do ponto " + name + ": ");
        int x = scanner.nextInt();
        System.out.println("Digite a coordenada de eixo Y do ponto " + name + ": ");
        int y = scanner.nextInt();
        return new EuclideanDistance.Point(x,y);
    }
}
