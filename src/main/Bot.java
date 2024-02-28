import java.util.ArrayList;
public class Bot extends Player {
    final int MINIMUM_SCORE = 10;
    private final String STRATEGY;

    public Bot(String s) {
        super(s);
        STRATEGY = "BasicBot";
    }

    //basic strategy
    public boolean wantsToRoll(int myScore, int handScore, ArrayList<Integer> otherScores, int winningScore) {
        int distanceToWin = winningScore - getMax(otherScores);
        int distanceToFirst = getMax(otherScores) - (myScore + handScore);
        
        if (distanceToWin < distanceToFirst) {
            return true;
        } else if (handScore > MINIMUM_SCORE) {
            return false;
        } else {
            return true;
        }
        
    }


    public int getMax(ArrayList<Integer> scores) {
        int maximum = Integer.MIN_VALUE;
        for (Integer i : scores) {
            if (i > maximum) {
                maximum = i;
            }
        }
        return maximum;
    }
}