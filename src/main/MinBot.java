import java.util.ArrayList;
public class MinBot extends Bot{
    

    public MinBot(String s) {
        super(s);
        strategy = "Always Roll";
    }

    
    public boolean wantsToRoll(int myScore, int handScore, ArrayList<Integer> otherScores, int winningScore) {
        
        return true;

    }

}
