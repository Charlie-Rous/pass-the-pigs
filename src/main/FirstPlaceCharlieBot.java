import java.util.ArrayList;

public class FirstPlaceCharlieBot extends Bot {
    final int MINIMUM_SCORE = 24;

    public FirstPlaceCharlieBot(String s) {
        super(s);
        strategy = "Balanced + Chace First";
    }

    // basic strategy
    public boolean wantsToRoll(int myScore, int handScore, ArrayList<Integer> otherScores, int winningScore) {

        int distanceToWin = winningScore - getMax(otherScores);
        int distanceToFirst = getMax(otherScores) - (myScore + handScore);
        
        if (distanceToFirst > distanceToWin || distanceToWin <= winningScore * .1) {
            return true;
        }
        if (winningScore - myScore < winningScore * .1) {
            return true;
        }
        if (handScore < MINIMUM_SCORE) {
            return true;
        } else if (getMax(otherScores) > (myScore + handScore)) {
            return true;
        } else {
            return false;
        }

    }

}