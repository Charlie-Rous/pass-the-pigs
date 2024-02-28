import java.util.ArrayList;
public class FirstPlaceBot extends Bot {

    private final String STRATEGY;
    

    public FirstPlaceBot(String s) {
        super(s);
        STRATEGY = "ChaceFirstPlace";
    }

    public boolean wantsToRoll(int myScore, int handScore, ArrayList<Integer> otherScores, int winningScore) {
        if (handScore < MINIMUM_SCORE) {
            return true;
        } else if (getMax(otherScores) > (myScore + handScore)) {
            return true;
        } else {
            return false;
        }
        
    }

}