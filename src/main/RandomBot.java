import java.util.ArrayList;

public class RandomBot extends Bot {

    public RandomBot(String s) {
        super(s);
        strategy = "50 50 chance";
    }

    // basic strategy
    public boolean wantsToRoll(int myScore, int handScore, ArrayList<Integer> otherScores, int winningScore) {

        if (handScore == 0) {
            return true;
        } else if (Math.random() < .5) {
            return true;
        } else {
            return false;
        }

    }
}
