package EuclidianDistance;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface EuclideanDistance extends Remote {
    double makeCalc(double ax,double ay,double bx,double by) throws RemoteException;

    class Point {
        public double x, y;
        public Point(double x, double y){
            this.x = x;
            this.y = y;
        }
    }
}
