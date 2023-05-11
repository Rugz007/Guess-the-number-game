import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class GuessGameServer {
    public static void main(String[] args) {
        try {
            LocateRegistry.createRegistry(1099);
            java.util.Scanner scanner = new java.util.Scanner(System.in);
            System.out.print("Enter minimum number: ");
            int min = scanner.nextInt();
            System.out.print("Enter maximum number: ");
            int max = scanner.nextInt();
            System.out.print("Enter answer number: ");
            int answer = scanner.nextInt();
            GuessGame game = new GuessGameImpl(min,max,answer);
            Naming.rebind("GuessGame", game);
            System.out.println("GuessGame server started");
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
