import java.rmi.Remote;
import java.rmi.RemoteException;

public interface GuessGame extends Remote {
    public boolean guess(int number) throws RemoteException;
    public int getMin() throws RemoteException;
    public int getMax() throws RemoteException;
    public int getPlayerNumber() throws RemoteException;
    public int setPlayerNumber() throws RemoteException;
}
