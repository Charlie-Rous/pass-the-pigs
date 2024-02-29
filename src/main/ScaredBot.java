import java.util.ArrayList;

public class ScaredBot extends Bot {
    final int MINIMUM_SCORE = 21;
    int numRolls = 0;

    public ScaredBot(String s) {
        super(s);
        strategy = "Dont roll more than 5";
    }

    // basic strategy
    public boolean wantsToRoll(int myScore, int handScore, ArrayList<Integer> otherScores, int winningScore) {

        int distanceToWin = winningScore - getMax(otherScores);
        int distanceToFirst = getMax(otherScores) - (myScore + handScore);

        if (handScore == 0) {
            numRolls = 1;
            return true;
        }
        if (numRolls >= 5) {
            return false;
        }

        if (distanceToFirst > distanceToWin) {
            numRolls++;
            return true;
        }
        if (winningScore - myScore < 10) {
            numRolls++;
            return true;
        }
        if (handScore >= MINIMUM_SCORE) {
            return false;
        } else {
            numRolls++;
            return true;
        }

    }

}