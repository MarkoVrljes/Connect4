import java.util.Scanner;

public class GamePlayer {
    public static void main(String[] args) {
        Game game = new Game();
        Scanner userInput = new Scanner(System.in);
        System.out.println("Beginning the game!");
        char P1 = 'b';
        char P2 = 'r';
        char activePlayer = P1;
        while (game.isPlaying()) {
            game.showBoard();
            if (activePlayer == P2) {
                System.out.println("Player 1's move:");
                activePlayer = P1;
            } else {
                System.out.println("Player 2's move:");
                activePlayer = P2;
            }
            int move = userInput.nextInt();
            game.pickColumn(activePlayer, move);
        }
        game.showBoard();
        System.out.println("Winner is: " + game.getWinner());   
    }
}
