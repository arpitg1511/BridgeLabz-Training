import java.util.*;

public class SnakeAndLadder {

    // Constants for the game
    private static final int WINNING_POSITION = 100;
    private static final int NO_PLAY = 0;
    private static final int LADDER = 1;
    private static final int SNAKE = 2;

    public static void main(String[] args) {
        // Player positions and dice roll count
        int player1Position = 0; // UC 1: Game played with single player at start position 0
        int player2Position = 0;
        int diceRolls = 0;

        // Player ID for tracking the current player (1 or 2)
        int currentPlayer = 1;

        // Random number generator
        Random random = new Random();

        System.out.println("--- Snake and Ladder Game Start ---");
        System.out.println("Player 1 starts at position: " + player1Position);
        System.out.println("Player 2 starts at position: " + player2Position);
        System.out.println();

        // UC 4: Repeat till the Player reaches the winning position 100
        while (player1Position < WINNING_POSITION && player2Position < WINNING_POSITION) {

            int currentPosition;
            String currentPlayerName;

            // Determine the current player's state
            if (currentPlayer == 1) {
                currentPosition = player1Position;
                currentPlayerName = "Player 1";
            } else {
                currentPosition = player2Position;
                currentPlayerName = "Player 2";
            }

            System.out.println(currentPlayerName + "'s Turn (Current Position: " + currentPosition + ")");

            // UC 2: The Player rolls the die to get a number between 1 to 6
            int dieRoll = random.nextInt(6) + 1; // Use ((RANDOM)) to get the number between 1 to 6
            diceRolls++; // UC 6: Report the number of times the dice was played

            System.out.println("  Dice Roll: " + dieRoll + " (Total Rolls: " + diceRolls + ")");

            // UC 3: The Player then checks for a Option: No Play, Ladder or Snake
            int option = random.nextInt(3); // Use ((RANDOM)) to check for Options

            int nextPosition = currentPosition;
            boolean isLadder = false;

            switch (option) {
                case NO_PLAY:
                    // In Case of No Play the player stays in the same position
                    System.out.println("  Option: No Play. Position remains " + nextPosition);
                    break;

                case LADDER:
                    // In Case of Ladder the player moves ahead by the number of position received in the die
                    nextPosition += dieRoll;
                    isLadder = true;
                    System.out.println("  Option: Ladder! New position before check: " + nextPosition);
                    break;

                case SNAKE:
                    // In Case of Snake the player moves behind by the number of position received in the die
                    nextPosition -= dieRoll;
                    System.out.println("  Option: Snake! New position before check: " + nextPosition);
                    break;
            }

            // UC 5: Ensure the player gets to exact winning position 100
            if (nextPosition > WINNING_POSITION) {
                // Note in case the player position go above 100, the player stays in the same previous position
                nextPosition = currentPosition;
                System.out.println("  Bounced back! Position stays at " + nextPosition + " to wait for exact roll.");
            }

            // UC 3: Note In case the player position moves below 0, then the player restarts from 0
            if (nextPosition < 0) {
                nextPosition = 0;
                System.out.println("  Fell below 0! Restarting from 0.");
            }

            // Update the player's position
            if (currentPlayer == 1) {
                player1Position = nextPosition;
            } else {
                player2Position = nextPosition;
            }

            // UC 6: Report the position after every die role
            System.out.println("  " + currentPlayerName + "'s position after roll: " + nextPosition);

            // UC 7: In this case if a Player gets a Ladder then plays again
            if (isLadder) {
                System.out.println("  LADDER! " + currentPlayerName + " plays again.");
                // currentPlayer remains the same
            } else {
                // Switch to the next player
                currentPlayer = (currentPlayer == 1) ? 2 : 1;
            }

            System.out.println();
        }

        System.out.println("--- Game Over ---");

        // UC 7: Finally report which Player won the game
        if (player1Position == WINNING_POSITION) {
            System.out.println("Player 1 won the game!");
        } else if (player2Position == WINNING_POSITION) {
            System.out.println("Player 2 won the game!");
        }

        System.out.println("Total Dice Rolls: " + diceRolls);
    }
}
