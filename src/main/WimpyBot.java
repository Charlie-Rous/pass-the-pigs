import java.util.ArrayList;

public class WimpyBot extends Bot {
    final int MINIMUM_SCORE = 5;

    public WimpyBot(String s) {
        super(s);
        strategy = "Pass if handscore is over " + MINIMUM_SCORE;
    }

    public boolean wantsToRoll(int myScore, int handScore, ArrayList<Integer> otherScores, int winningScore) {

        // if another player is closer to winning then the bot is to that player
        if (handScore >= MINIMUM_SCORE) {
            return false;
        } else {
            return true;
        }

    }
}
