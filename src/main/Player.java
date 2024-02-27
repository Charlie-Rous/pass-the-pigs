import java.util.ArrayList;
public class Player {
    String name;
    String strategy;

    public Player(String name, String strategy) {
        this.name = name;
        this.strategy = strategy;
    }
    public boolean wantsToRoll(int myScore, int handScore, ArrayList<Integer> otherScores, int winningScore) {
        return true;
    }
    public String getName() {
        return name;
    }
    public String getStrategy() {
        return strategy;
    }
}
