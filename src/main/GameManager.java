import java.util.ArrayList;
public class GameManager {
    private ArrayList<Player> players = new ArrayList<Player>(); 
    private ArrayList<Integer> scores = new ArrayList<Integer>(20);
    private Pigs pigs;
    private final int WINNINGSCORE;


    public GameManager(int w) {
        WINNINGSCORE = w;
        pigs = new Pigs();
        populatePlayers();
    }

    private void populatePlayers() {
        players.add(new Human("Dave"));
        players.add(new Bot("BasicBot"));
        players.add(new Bot("BasicBot2"));
        players.add(new FirstPlaceBot("FirstPlaceBot"));
        scores.add(0);
        scores.add(0);
        scores.add(0);
        scores.add(0);
        


    }

    public void playTurn() {
        printScore();
        for (int i = 0; i < players.size(); i++) {
            int currentScore = scores.get(i);
            int handScore = 0;
            while (players.get(i).wantsToRoll(currentScore, handScore, scores, WINNINGSCORE)) {
                String[] roll = pigs.roll();

                int score = calcScore(roll);
                scores.set(i, scores.get(i) + score);
                handScore += score;

                System.out.printf("%s rolls a %s and a %s for a roll of %d\n", players.get(i).getName(), roll[0], roll[1], score);

                if (score == 0) {
                    scores.set(i, currentScore);
                    printScore();
                    break;
                } else {
                    printScore();
                }
                System.out.println();

                if(scores.get(i) > WINNINGSCORE) {
                    System.out.println(players.get(i).getName() + " Wins!!!");
                    return;
                }
            }
            System.out.println("---------------");
            
            
        }
        System.out.println("----------------------------------------------------");
    }

    private void printScore() {
        for (int i = 0; i < players.size(); i++) {
            System.out.printf("%s: %d | ", players.get(i).getName(), scores.get(i));
        }
        System.out.println();
    }

    public int getMaxScore() {
        int maximum = Integer.MIN_VALUE;
        for (Integer i : scores) {
            if (i > maximum) {
                maximum = i;
            }
        }
        return maximum;
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
