public class Pigs {
    final float DOT_CHANCE = 34.9f;
    final float NO_DOT_CHANCE = 30.2f;
    final float RAZORBACK_CHANCE = 22.4f;
    final float TROTTER_CHANCE = 8.8f;
    final float SNOUTER_CHANCE = 3.0f;
    final float JOWLER_CHANCE = 0.7f;

    private String rollPig() {
        double value = Math.random() * 100;
        if (value < JOWLER_CHANCE) {
            return "Jowler";
        } else if (value < JOWLER_CHANCE + SNOUTER_CHANCE) {
            return "Snouter";
        } else if (value < JOWLER_CHANCE + SNOUTER_CHANCE + TROTTER_CHANCE) {
            return "Trotter";
        } else if (value < JOWLER_CHANCE + SNOUTER_CHANCE + TROTTER_CHANCE + RAZORBACK_CHANCE) {
            return "Razorback";
        } else if (value < JOWLER_CHANCE + SNOUTER_CHANCE + TROTTER_CHANCE + RAZORBACK_CHANCE + NO_DOT_CHANCE) {
            return "No Dot";
        } else {
            return "Dot";
        }
    }

    public String[] roll() {
        String[] roll = new String[2];
        roll[0] = rollPig();
        roll[1] = rollPig();
        return roll;
    }

}