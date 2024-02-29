import java.util.ArrayList;

public class CharlieBot extends Bot {
    final int MINIMUM_SCORE = 21;

    public CharlieBot(String s) {
        super(s);
        strategy = "Balanced";
    }

    // basic strategy
    public boolean wantsToRoll(int myScore, int handScore, ArrayList<Integer> otherScores, int winningScore) {

        int distanceToWin = winningScore - getMax(otherScores);
        int distanceToFirst = getMax(otherScores) - (myScore + handScore);

        if (distanceToFirst > distanceToWin) {

            return true;
        }
        if (winningScore - myScore < winningScore * .1) {

            return true;
        }
        if (handScore < MINIMUM_SCORE) {
            return false;
        } else {

            return true;
        }

    }

}