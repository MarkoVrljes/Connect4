public class Game {
    private char[][] board;
    private boolean gameActive;
    private char winner;

    public Game() {
        board = new char[6][7];
        gameActive = true;
        winner = '-';
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                board[i][j] = '-';
            }
        }
    }

    public boolean isPlaying() {
        return gameActive;
    }

    public void pickColumn(char player, int column) {
        for (int i = 5; i >= 0; i--) {
            if (board[i][column] == '-') {
                board[i][column] = player;
                if (checkForWinner(i, column)) {
                    winner = player;
                    gameActive = false;
                }
                return;
            }
        }
    }

    public char getWinner() {
        return winner;
    }

    // Check if player had 4 in a row
    public boolean checkForWinner(int row, int col) {
        char player = board[row][col];
        // Check horizontally
        int count = 0;
        for (int i = 0; i < 7; i++) {
            if (board[row][i] == player) {
                count++;
                if (count == 4) {
                    return true;
                }
            } else {
                count = 0;
            }
        }
        // Check vertically
        count = 0;
        for (int i = 0; i < 6; i++) {
            if (board[i][col] == player) {
                count++;
                if (count == 4) {
                    return true;
                }
            } else {
                count = 0;
            }
        }
        // Check diagonal (top-left to bottom-right)
        count = 0;
        int rowIndex = row;
        int colIndex = col;
        while (rowIndex > 0 && colIndex > 0) {
            rowIndex--;
            colIndex--;
        }
        while (rowIndex < 6 && colIndex < 7) {
            if (board[rowIndex][colIndex] == player) {
                count++;
                if (count == 4) {
                    return true;
                }
            } else {
                count = 0;
            }
            rowIndex++;
            colIndex++;
        }
        // Check diagonal (bottom-left to top-right)
        count = 0;
        rowIndex = row;
        colIndex = col;
        while (rowIndex < 5 && colIndex > 0) {
            rowIndex++;
            colIndex--;
        }
        while (rowIndex >= 0 && colIndex < 7) {
            if (board[rowIndex][colIndex] == player) {
                count++;
                if (count == 4) {
                    return true;
                }
            } else {
                count = 0;
            }
            rowIndex--;
            colIndex++;
        }
        return false;
    }

    // Print the board before each turn
    public void showBoard() {
        System.out.println("Connect 4 board:");
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("0|1|2|3|4|5|6");
        System.out.println("--Positions--");
        System.out.println();
    }
    
}