public class Player {
    private String name;
    private String symbol;

    private static int numPlayers = 0;

    public Player(String name) {
        this.name = name;
        if (numPlayers == 0) {
            symbol = "0";
        } else {
            symbol = "X";
        }
        numPlayers ++;
    }

    public String getName() {
        return name;
    }
    @Override
    public String toString() {
        return name;
    }

    public String getSymbol() {
        return symbol;

    }

    public static int getNumPlayers() {
        return numPlayers;
    }
}