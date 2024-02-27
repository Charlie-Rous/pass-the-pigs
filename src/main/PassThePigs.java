public class PassThePigs {
    public static GameManager gameManager;
    public static void main(String[] args) {
        welcomeMessage();
        gameManager = new GameManager();
        gameManager.playTurn();
        gameManager.playTurn();
        gameManager.playTurn();
        gameManager.playTurn();


    }

    public static void welcomeMessage() {
        System.out.println("Welcome to Pass The Pigs!");
    }
}