
public class TennisGame2 implements TennisGame {

    private final String player1Name;
    private final int[] playerScore;
    private final String player2Name;
    private final StringBuilder scoreBoard;
    private final String[] TENNISTERMS = {"Love", "Fifteen", "Thirty", "Forty"};

    public TennisGame2(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
        scoreBoard = new StringBuilder();
        playerScore = new int[2];
    }

    public String showBoard(){
        if ( areEquals() ) {
            scoreBoard.append(draw());
        }
        else if (areLessFour()) {
            scoreBoard.append(middleGame());
        }
        else {
            scoreBoard.append(advantageOrWinner());
        }

        return scoreBoard.toString();
    }

    private boolean areLessFour() {
        return (playerScore[0] < 4) && (playerScore[1] < 4);
    }

    private boolean areEquals() {
        return playerScore[0] == playerScore[1];
    }

    public void wonPoint(String player) {
        if (player.equals(player1Name)) {
            playerScore[0]++;
        }
        else {
            playerScore[1]++;
        }
    }

    public StringBuilder draw() {
        return (playerScore[0] >= 3)
                ? Miscellany.concatenate("Deuce")
                : Miscellany.concatenate(TENNISTERMS[playerScore[0]], "-All");
    }

    public String leader() {
        return (playerScore[0] > playerScore[1]) ? player1Name : player2Name;
    }

    public StringBuilder middleGame() {

        return Miscellany.concatenate(TENNISTERMS[playerScore[0]], "-", TENNISTERMS[playerScore[1]]);
    }

    public StringBuilder advantageOrWinner() {
        return ( Math.abs(playerScore[0] - playerScore[1]) == 1 )
                ? Miscellany.concatenate("Advantage ", leader() )
                : Miscellany.concatenate("Win for ", leader() );
    }

}