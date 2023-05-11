import java.rmi.Naming;
import java.util.Scanner;

public class GuessGameClient {
    public static void main(String[] args) {
        try {
            GuessGame game = (GuessGame) Naming.lookup("//localhost/GuessGame");
            int min = game.getMin();
            int max = game.getMax();
            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.printf("Guess a number between %d and %d: ", min, max);
                int guess = scanner.nextInt();
                boolean correct = game.guess(guess);
                if (correct) {
                    System.out.println("Congratulations, you guessed the number!");
                    break;
                } else {
                    System.out.printf("Sorry, that's not the number.HINT: The range is  %d to %d.%n", min, max);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
