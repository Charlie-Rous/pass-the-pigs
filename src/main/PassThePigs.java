public class PassThePigs {
    public static GameManager gameManager;
    public static final int WINNING_SCORE = 100;

    public static void main(String[] args) {
        welcomeMessage();
        gameManager = new GameManager(WINNING_SCORE);
        while (gameManager.getMaxScore() < WINNING_SCORE) {
            gameManager.playTurn();
        }

    }

    public static void welcomeMessage() {
        System.out.println("Welcome to Pass The Pigs!");
    }
}