import java.util.ArrayList;

public class RiskyBot extends Bot {
    final int MINIMUM_SCORE = 20;
    private String strategy;

    public RiskyBot(String s) {
        super(s);
        strategy = "Pass if handscore is over " + MINIMUM_SCORE;
    }

    
    public boolean wantsToRoll(int myScore, int handScore, ArrayList<Integer> otherScores, int winningScore) {
        int distanceToWin = winningScore - getMax(otherScores);
        int distanceToFirst = getMax(otherScores) - (myScore + handScore);

        // if another player is closer to winning then the bot is to that player
        if (distanceToWin < distanceToFirst) {
            return true;
        } else if (handScore >= MINIMUM_SCORE) {
            return false;
        } else {
            return true;
        }

    }
}
