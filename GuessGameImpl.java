import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Random;

public class GuessGameImpl extends UnicastRemoteObject implements GuessGame {
    public int answer;
    private int min;
    private int max;
    public int playerNumber = 0;


    public GuessGameImpl(int min, int max,int answer) throws RemoteException {
        super();
        this.min = min;
        this.max = max;
        this.answer = answer;
        this.playerNumber = 0;
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
    public int getPlayerNumber() throws RemoteException 
    {
        return playerNumber;
    }
    public int setPlayerNumber() throws RemoteException
    {
        playerNumber++;
        return playerNumber;
    }
}
