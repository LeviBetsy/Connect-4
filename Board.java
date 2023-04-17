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

import java.util.Scanner;

class BoardTester {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Player 1 name: ");
        String player1Name = scanner.nextLine();
        System.out.println("Enter Player 2 name: ");
        String player2Name = scanner.nextLine();

        Board b = new Board();
        char currentPlayer = 'X';

        while (!b.isFull()) {
            System.out.println(playerName(currentPlayer, player1Name, player2Name) + ", choose a column (0-6):");
            int col = scanner.nextInt();
            b.addToken(currentPlayer, col);
            b.printBoard();

            if (b.check()) {
                System.out.println(playerName(currentPlayer, player1Name, player2Name) + " wins!");
                break;
            }

            // switch the player
            if (currentPlayer == 'X') {
                currentPlayer = 'O';
            } else {
                currentPlayer = 'X';
            }
        }
    }

    private static String playerName(char player, String player1Name, String player2Name) {
        if (player == 'X') {
            return player1Name;
        } else {
            return player2Name;
        }
    }
}

}
