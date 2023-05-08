
public class Board {
    private final int board_height = 6;
    private final int board_width = 7;
    private char[][] board = new char[board_width][board_height];
    private char currentPlayer = 'X';
    private Checker chec = new Checker();

    public void setBoard(char[][] newb) {
        this.board = newb;
    }

    // colors
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_YELLOW = "\u001B[33m";

    public boolean checkBoard() {
        return chec.check(board);
    }

    public void addToken(char player, int col) {
        // only add when collumn is not full
        if (this.isCollumnFull(col) == true) {
            System.out.println("Collumn is full, please pick another one");

        } else {
            for (int i = 0; i < board_height; i++) {
                if (board[col][i] == '\0') {
                    board[col][i] = player;
                    break;
                }
            }
        }
        // check for winner
    }

    public boolean isCollumnFull(int col) {
        // only checking the top row
        if (board[col][board_height - 1] != '\0') {
            return true;
        } else {
            return false;
        }
    }

    public char[][] getBoard() {
        return board;
    }

    public void printBoard() {
        // loop through every row starting from the top
        for (int i = board_height - 1; i >= 0; i--) {
            // loop through every collumn
            for (int j = 0; j < board_width; j++) {
                // if it's an X then print it out as a red O
                if (board[j][i] == 'X') {
                    System.out.print('|' + ANSI_RED + 'O' + ANSI_RESET);
                    // else print it out as yellow
                } else if (board[j][i] == 'O') {
                    System.out.print('|' + ANSI_YELLOW + board[j][i] + ANSI_RESET);
                } else {
                    System.out.print("|_");
                }
            }
            System.out.print("| \n");
        }

        // printing index for reference
        for (int i = 0; i < board_width; i++) {
            System.out.print(" " + i);
        }
    }

    public boolean isFull() {
        for (int col = 0; col < board_width; col++) {
            if (board[col][5] == '\0') {
                return false;
            }
        }
        return true;
    }

    public void changeTurn() {
        if (currentPlayer == 'X') {
            currentPlayer = 'O';
        } else {
            currentPlayer = 'X';
        }
    }

    public char getPlayer() {
        return currentPlayer;
    }
}
