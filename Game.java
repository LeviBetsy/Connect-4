import java.util.Scanner;
import java.util.*;

public class Game {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Player 1 name: ");
        String player1Name = scanner.nextLine();
        System.out.println("Enter Player 2 name: ");
        String player2Name = scanner.nextLine();

        Board b = new Board();
        boolean someoneWon = false;

        // undos stack
        Stack<char[][]> undos = new Stack<char[][]>();

        while (!b.isFull() && !someoneWon) {
            b.printBoard();
            System.out.println("");

            System.out.println("Enter 'r' to undo turn");
            System.out.println(playerName(b.getPlayer(), player1Name, player2Name) + playerColor(b.getPlayer())
                    + ", choose a column (0-6):");

            // keep asking for input until broken out of loop
            while (true) {
                String col = scanner.nextLine();
                // if user press 'r' they want to undo
                if (col.equals("r")) {
                    try {
                        b.setBoard(undos.pop());
                        break;
                    } catch (Exception e) {
                        System.out.println("You can't undo an empty board");
                    }

                } else {
                    // try to see if user input an integer
                    try {
                        if (b.isCollumnFull(Integer.parseInt(col))) {
                            System.out.println("Collumn is full, choose another collumn");
                        } else {
                            // new board
                            char[][] newb = new char[7][6];
                            for (int r = 0; r < 7; r++) {
                                for (int j = 0; j < 6; j++) {
                                    newb[r][j] = b.getBoard()[r][j];
                                }
                            }
                            undos.push(newb);
                            // adding token
                            b.addToken(b.getPlayer(), Integer.parseInt(col));

                            if (b.checkBoard()) {
                                System.out.println(" ");
                                System.out.println(playerName(b.getPlayer(), player1Name, player2Name) + " "
                                        + playerColor(b.getPlayer()) + " won!");
                                someoneWon = true;
                                b.printBoard();
                            }

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

    private static String playerColor(char player) {
        if (player == 'X') {
            return " (red)";
        } else {
            return " (yellow)";
        }
    }
}
