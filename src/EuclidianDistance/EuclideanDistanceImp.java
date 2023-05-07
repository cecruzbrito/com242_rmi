package EuclidianDistance;

import java.rmi.RemoteException;

public class EuclideanDistanceImp implements EuclideanDistance {
    @Override
    public double makeCalc(double ax,double ay,double bx,double by)  throws RemoteException {
        return Math.sqrt((Math.pow((bx - ax), 2) + Math.pow((by - ay), 2)));
    }
}

