import java.util.ArrayList;

public class FirstPlaceBot extends Bot {
    private final int MINIMUM_SCORE = 21;

    public FirstPlaceBot(String s) {
        super(s);
        strategy = "Chace First Place";
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