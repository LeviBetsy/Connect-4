public class Board {
    private char[][] board = new char[7][6];

    // colors
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_YELLOW = "\u001B[33m";

    public void addToken(char player, int col) {
        // only add when collumn is not full
        if (this.isCollumnFull(col) == true) {
            System.out.println("Collumn is full");
        } else {
            for (int i = 0; i < 6; i++) {
                if (board[col][i] == '\0') {
                    board[col][i] = player;
                    break;
                }
            }
        }
        // need to do check if collumn is full
    }

    public boolean isCollumnFull(int col) {
        // only checking the top row
        if (board[col][5] != '\0') {
            return true;
        } else {
            return false;
        }
    }

    public char[][] returnBoard() {
        return board;
    }

    public void printBoard() {
        // loop through every row starting from the top
        for (int i = 5; i >= 0; i--) {
            // loop through every collumn
            for (int j = 0; j < 7; j++) {
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
    }

    public boolean isFull() {
        for (int col = 0; col < 7; col++) {
            if (board[col][5] == '\0') {
                return false;
            }
        }
        return true;
    }
}

class BoardTester {
    public static void main(String[] args) {
        Board b = new Board();
        b.addToken('X', 0);
        b.addToken('O', 0);
        b.addToken('X', 3);
        b.printBoard();

    }
}