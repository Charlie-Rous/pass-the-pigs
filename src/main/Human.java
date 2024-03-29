import java.util.Scanner;
import java.util.ArrayList;

public class Human extends Player {
    private static Scanner scanner;

    public Human(String name) {
        super(name);
        scanner = new Scanner(System.in);
        strategy = "Human";
    }

    public boolean wantsToRoll(int myScore, int handScore, ArrayList<Integer> otherScores, int winningScore) {
        while (true) {
            System.out.println("Do you want to roll? [1] yes | [2] no");
            int answer = scanner.nextInt();
            if (answer == 1) {
                return true;
            } else if (answer == 2) {
                return false;
            } else {
                System.out.println("Enter a valid answer. (1 or 2)");
            }
        }

    }
}