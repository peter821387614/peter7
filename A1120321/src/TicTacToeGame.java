import java.util.Scanner;

public class TicTacToeGame {
    private static char[][] board = new char[3][3];
    private static int row = 0, col = 0;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        initializeBoard();
        System.out.println("Welcome to Tic Tac Toe Game! You will be playing against the computer.");
        printBoard();
        while (true) {
            playerTurn();
            printBoard();
            if (isGameOver()) {
                break;
            }
            computerTurn();
            printBoard();
            if (isGameOver()) {
                break;
            }
        }
    }

    private static void initializeBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '-';
            }
        }
    }

    private static void printBoard() {
       // System.out.println("-------------");
        for (int i = 0; i < 3; i++) {
          //  System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j]+" " );
            }
            System.out.println();
           //System.out.println("-------------");
        }
    }

    private static void playerTurn() {
        System.out.print("Your turn: Enter row (0-2): ");
        row = scanner.nextInt();
        System.out.print("Your turn: Enter column (0-2): ");
        col = scanner.nextInt();
        while (board[row][col] != '-') {
            System.out.print("Invalid move. Please try again.\n");
            System.out.print("Your turn: Enter row (0-2): ");
            row = scanner.nextInt();
            System.out.print("Your turn: Enter column (0-2): ");
            col = scanner.nextInt();
        }
        board[row][col] = 'X';
    }

    private static void computerTurn() {
        boolean found = false;
        while (!found) {
            row = (int) (Math.random() * 3);
            col = (int) (Math.random() * 3);
            if (board[row][col] == '-') {
                found = true;
            }
        }
        board[row][col] = 'O';
        System.out.println("Computer's turn: Row " + row + ", Column " + col);
    }

    public static boolean isGameOver() {
        if (isWinner('X')) {
            System.out.println("Congratulations! You won!");
            return true;
        } else if (isWinner('O')) {
            System.out.println("Sorry, the computer won.");
            return true;
        } else if (isBoardFull()) {
            System.out.println("It's a draw.");
            return true;
        }
        return false;
    }
    
    public static boolean isBoardFull() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (board[row][col] == '-') {
                    return false; // if any cell is empty, board is not full
                }
            }
        }
        return true; // no empty cells, board is full
    }


    public static boolean isWinner(char player) {
        // check rows
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == player && board[i][1] == player && board[i][2] == player) {
                return true;
            }
        }

        // check columns
        for (int i = 0; i < 3; i++) {
            if (board[0][i] == player && board[1][i] == player && board[2][i] == player) {
                return true;
            }
        }

        // check diagonals
        if (board[0][0] == player && board[1][1] == player && board[2][2] == player) {
            return true;
        }
        if (board[0][2] == player && board[1][1] == player && board[2][0] == player) {
            return true;
        }

        return false;
    }
}
