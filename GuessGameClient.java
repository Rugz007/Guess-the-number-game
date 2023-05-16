import java.rmi.Naming;
import java.util.Scanner;

public class GuessGameClient {
    public static void main(String[] args) {
        try {
            GuessGame game = (GuessGame) Naming.lookup("//localhost/GuessGame");
            int playerNumber = 0;
            int temp = game.setPlayerNumber();
            playerNumber = game.getPlayerNumber();

            GuessGameServer.printPlayerJoined(playerNumber);
            int min = game.getMin();    
            int max = game.getMax();
            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.printf("Guess a number between %d and %d: ", min, max);
                int guess = scanner.nextInt();
                boolean correct = game.guess(guess);
                if (correct) {
                    System.out.println("Congratulations, you guessed the number!");
                    GuessGameServer.printPlayerWon(playerNumber);
                    break;
                } else {    
                    min = game.getMin();
                    max = game.getMax();
                    System.out.printf("HINT: The range is  %d to %d", min, max);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
