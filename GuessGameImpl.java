import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Random;

public class GuessGameImpl extends UnicastRemoteObject implements GuessGame {
    public int answer;
    private int min;
    private int max;

    public GuessGameImpl(int min, int max,int answer) throws RemoteException {
        super();
        this.min = min;
        this.max = max;
        this.answer = answer;
    }

    public boolean guess(int number) throws RemoteException {
        if (number == answer) {
            return true;
        } else if (number < answer) {
            min = number + 1;
        } else {
            max = number - 1;
        }
        return false;
    }

    public int getMin() throws RemoteException {
        return min;
    }

    public int getMax() throws RemoteException {
        return max;
    }
}
