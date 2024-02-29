import java.util.ArrayList;

public class SuperBot extends Bot {
    final int MINIMUM_SCORE = 10;
    final double chanceOfLosing = 2 * (.302 * .349); // the chance of rolling a dot and no dot or a no dot and dot
    final double chanceOfNonLosing = 1 - chanceOfLosing; // chance of a non losing roll
    double threshold = .55;
    int numRolls = 0;

    public SuperBot(String s) {
        super(s);
        strategy = "Flawed Statistics";
    }

    // basic strategy
    public boolean wantsToRoll(int myScore, int handScore, ArrayList<Integer> otherScores, int winningScore) {
        int distanceToWin = winningScore - getMax(otherScores);
        int distanceToFirst = getMax(otherScores) - (myScore + handScore);
        threshold = .55;
        if (handScore == 0) {
            numRolls = 1;
            return true;
        }

        // if another player is closer to winning then the bot is to that player
        // increase level of riskyness
        if (handScore >= MINIMUM_SCORE) {
            threshold *= 1.5;
        }
        if (distanceToFirst > distanceToWin) {
            threshold *= .8;
        }
        if (winningScore - myScore < MINIMUM_SCORE) { // if the bot is close to winning become more risky
            threshold *= .5;
        } else if (myScore + handScore >= getMax(otherScores)) { // if winning be safer
            threshold *= 1.5;
        }

        double chanceOfLiving = Math.pow(chanceOfNonLosing, numRolls + 1);
        System.out.println("Chance " + chanceOfLiving);
        if (chanceOfLiving > threshold) {
            numRolls++;
            return true;
        } else {
            return false;
        }

    }

}