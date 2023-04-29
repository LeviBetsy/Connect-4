import java.util.Scanner;

public class Board {
    private final int board_height = 6;
    private final int board_width = 7;
    private char[][] board = new char[board_width][board_height];
    private char currentPlayer = 'X';

    // colors
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_YELLOW = "\u001B[33m";

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
        // need to do check if collumn is full
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
        for (int col = 0; col < 7; col++) {
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

class BoardTester {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Player 1 name: ");
        String player1Name = scanner.nextLine();
        System.out.println("Enter Player 2 name: ");
        String player2Name = scanner.nextLine();

        Board b = new Board();

        while (!b.isFull()) {
            b.printBoard();
            System.out.println("");

            System.out.println("Enter 'r' to undo turn");
            System.out.println(playerName(b.getPlayer(), player1Name, player2Name) + ", choose a column (0-6):");

            // keep asking for input until broken out of loop
            while (true) {
                String col = scanner.nextLine();
                // if user press 'r' they want to undo
                if (col.equals("r")) {
                    System.out.println("Dipshit");
                } else {
                    // try to see if user input an integer
                    try {
                        if (b.isCollumnFull(Integer.parseInt(col))) {
                            System.out.println("Collumn is full, choose another collumn");
                        } else {
                            b.addToken(b.getPlayer(), Integer.parseInt(col));
                            break;
                        }
                    } // if they didn't put in an integer catch exception
                    catch (Exception e) {
                        System.out.println("Your input is not valid, try again");
                    }
                }
            }

            // switching player
            b.changeTurn();

        }

        // if (b.check()) {
        // System.out.println(playerName(currentPlayer, player1Name, player2Name) + "
        // wins!");
        // break;
        // }

        System.out.println("");
        scanner.close();

    }

    private static String playerName(char player, String player1Name, String player2Name) {
        if (player == 'X') {
            return player1Name;
        } else {
            return player2Name;
        }
    }
}
