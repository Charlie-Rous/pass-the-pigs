import java.util.ArrayList;

public class CharlieBot extends Bot {
    final int MINIMUM_SCORE = 21;
    int numRolls = 0;

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
        if (winningScore - myScore < 10) {
            return true;
        }
        if (handScore >= MINIMUM_SCORE) {
            return false;
        } else {
            return true;
        }

    }

}