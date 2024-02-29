import java.util.ArrayList;

public class GameManager {
    private ArrayList<Player> players = new ArrayList<Player>();
    private ArrayList<Integer> scores = new ArrayList<Integer>(20);
    private Pigs pigs;
    private final int WINNING_SCORE;

    public GameManager(int w) {
        WINNING_SCORE = w;
        pigs = new Pigs();
        populatePlayers();
    }

    private void populatePlayers() {
        players.add(new Bot("BasicBot"));
        players.add(new CharlieBot("Charlie"));
        players.add(new FirstPlaceBot("FirstPlaceBot"));
        players.add(new RiskyBotCR("RiskyBot"));
        players.add(new WimpyBotCR("WimpyBot"));
        players.add(new RandomBot("RandomBot"));
        players.add(new MinBot("MinBot"));
        players.add(new SuperBot("SuperBot"));
        

        for (int i = 0; i < 8; i++) {
            scores.add(0);
        }

    }

    public void playTurn() {
        for (int i = 0; i < players.size(); i++) {
            int handScore = 0;
            Player player = players.get(i);
            while (player.wantsToRoll(scores.get(i), handScore, scores, WINNING_SCORE)) {
                String[] roll = pigs.roll();

                int score = calcScore(roll);
                handScore += score;

                if (score == 0) {
                    handScore = 0;
                    System.out.printf("%s rolls a %s and a %s. That's a pig out!\n", player.getName(), roll[0],
                            roll[1]);
                    break;
                } else {
                    System.out.printf("%s rolls a %s and a %s for a roll of %d. Hand Score: %d | Total Score: %d\n",
                            player.getName(), roll[0], roll[1], score, handScore, scores.get(i) + handScore);
                    System.out.println();
                }

                if (handScore + scores.get(i) >= WINNING_SCORE) {
                    scores.set(i, scores.get(i) + handScore);
                    System.out.println(player.getName() + " Wins!!! Their strategy was " + player.getStrategy());
                    return;
                }
            }

            if (handScore > 0) {
                System.out.println(player.getName() + " passes.");
                scores.set(i, scores.get(i) + handScore);
            }

            System.out.println();
            printScore();

            System.out.println("----------------------------------------------------");
        }

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

    public int calcScore(String[] roll) {

        int sum = 0;
        if ((roll[0].equals("No Dot") && roll[1].equals("Dot"))
                || (roll[1].equals("No Dot") && roll[0].equals("Dot"))) {
            return sum;
        }

        switch (roll[0]) {
            case "Trotter":
                sum += 5;
                break;
            case "Razorback":
                sum += 5;
                break;
            case "Snouter":
                sum += 10;
                break;
            case "Jowler":
                sum += 15;
                break;
        }

        switch (roll[1]) {
            case "Trotter":
                sum += 5;
                break;
            case "Razorback":
                sum += 5;
                break;
            case "Snouter":
                sum += 10;
                break;
            case "Jowler":
                sum += 15;
                break;
        }

        if (sum == 0) {
            return 1;
        } else if (roll[0].equals(roll[1])) {
            return sum * 2;
        }
        return sum;

    }
}
