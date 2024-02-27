import java.util.ArrayList;
public class GameManager {
    private ArrayList<Player> players = new ArrayList<Player>(); 
    private ArrayList<Integer> scores = new ArrayList<Integer>();
    private Pigs pigs;


    public GameManager() {
        pigs = new Pigs();
        populatePlayers();
    }

    private void populatePlayers() {
        players.add(new Human("Dave", "basic"));
    }

    public void playTurn() {
        for (Player player : players) {
            if (player.wantsToRoll(0, 0, scores, 0)) {
               String[] roll = pigs.roll();
               System.out.printf("%s rolls a %s and a %s for a roll of %d\n", player.getName(), roll[0], roll[1], calcScore(roll));
            }
        }
    }

    private int calcScore(String[] roll) {
        int sum = 0;
        if((roll[0].equals("No Dot") && roll[1].equals("Dot")) || (roll[1].equals("No Dot") && roll[0].equals("Dot"))) {
            return sum;
        }
        switch (roll[0]) {
            case "Trotter" :
                sum += 5;
                break;
            case "Razorback" :
                sum += 5;
                break;
            case "Snouter" :
                sum += 10;
                break;
            case "Jowler" :
                sum += 15;
                break;       
        }
        switch (roll[1]) {
            case "Trotter" :
                sum += 5;
                break;
            case "Razorback" :
                sum += 5;
                break;
            case "Snouter" :
                sum += 10;
                break;
            case "Jowler" :
                sum += 15;
                break;       
        }
        if (sum == 0) {
            return 1;
        } else if (roll[0].equals(roll[1])) {
            sum *= 2;
        }
        return sum;

        
    }
}