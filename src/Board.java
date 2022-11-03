public class Board {
    public static final String EMPTY = ".";
    public static final int NUM_ROWS = 3;
    public static final int NUM_COLS = 3;
    private String[][] board;


    public Board() {
        board = new String[NUM_ROWS][NUM_COLS];
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                board[row][col] = EMPTY;
            }
        }
    }
    public String toString() {
        String s = "  ";

        for (int i = 1; i <= NUM_ROWS; i++) {
            s = s + i + " ";
        }
        s += "\n";

        for (int row = 0; row < board.length; row++) {
            s += (row + 1) + " ";
            for (int col = 0; col < board[0].length; col++) {
                s += board[row][col] + " ";
            }
            s += "\n";
        }
        return s;

    }
    public boolean correctShoot(Shot shot, Player player1) {
        if (shot.row < 0 || shot.row >= NUM_ROWS ||
                shot.col < 0 || shot.col >= NUM_COLS) {
            System.out.println("Wrong ROW or COL");
            return false;
        }
        String symbol = player1.getSymbol();
        if (board[shot.row][shot.col] == EMPTY) {
            board[shot.row][shot.col] = symbol;
            return true;
        } else {
            System.out.println("position already in use");
            return false;
        }

    }
    public boolean wins() {
        // check rows
        for (int row = 0; row < board.length; row++) {

            String symbol = board[row][0];
            if (symbol != EMPTY) {
                int count = 1;
                for (int col = 1; col < board[0].length; col++) {
                    if (board[row][col] == symbol) {
                        count++;
                    }
                }
                if (count == NUM_COLS) {
                    return true;
                }
            }
        }
        for (int col = 0; col < board[0].length; col++) {

            String symbol = board[0][col];
            if (symbol != EMPTY) {
                int count = 1;
                for (int row = 1; row < board.length; row++) {
                    if (board[row][col] == symbol) {
                        count++;
                    }
                }
                if (count == NUM_ROWS) {
                    return true;
                }
            }
        }
        String symbol = board[0][0];
        if (symbol != EMPTY) {
            int count = 1;
            for (int i = 1; i < board.length; i++) {
                if (board[i][i] == symbol) {
                    count++;
                }
            }
        }
         symbol = board[0][board[0].length - 1];
        if (symbol != EMPTY) {
            int count = 1;
            int row = 1;
            for (int i = NUM_COLS; i > 0; i--) {
                if (board[row][i] == symbol) {
                    count++;
                    row++;
                }
            }
        }
        return false;
    }

    public boolean checkDraw() {
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                if (board[row][col] .equals(EMPTY)) {
                    return  false;
                }
            }
        }
        return  true;
    }


}
