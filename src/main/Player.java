import java.util.ArrayList;
public class Player {
    String name;
    private final String STRATEGY;

    public Player(String name) {
        this.name = name;
        STRATEGY = "Basic";
    }
    public boolean wantsToRoll(int myScore, int handScore, ArrayList<Integer> otherScores, int winningScore) {
        return true;
    }
    public String getName() {
        return name;
    }
    public String getStrategy() {
        return STRATEGY;
    }
}
