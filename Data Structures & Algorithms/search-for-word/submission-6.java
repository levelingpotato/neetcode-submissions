class Solution {
    boolean wordt = false;
    public boolean exist(char[][] board, String word) {
        boolean[][] seen = new boolean[board.length][board[0].length];

        for (int row = 0; row < board.length; row++) {
            for (int column = 0; column < board[0].length; column++) {
                char curr = board[row][column];
                if (curr == word.charAt(0)) {
                    seen[row][column] = true;
                    verify(board, word, row, column, 1, seen);
                    seen[row][column] = false;
                    if (wordt) {
                        return true;
                    }
                }
            }
        }
        return wordt;
    }

    public void verify(char[][] board, String word, int row, int column, int wordex, boolean[][] seen) {
        if (!isValid(board, row, column)){
            return;
        }
        if(wordex >= word.length()){
            wordt = true;
            return;
        }
        if(isValid(board, row - 1, column)){
            if(board[row - 1][column] == word.charAt(wordex) && !seen[row - 1][column]){
                seen[row - 1][column] = true;
                verify(board, word, row - 1, column, wordex + 1, seen);
                seen[row - 1][column] = false;
            }
        }
        if(isValid(board, row + 1, column)){
            if(board[row + 1][column] == word.charAt(wordex) && !seen[row + 1][column]){
                seen[row + 1][column] = true;
                verify(board, word, row + 1, column, wordex + 1, seen);
                seen[row + 1][column] = false;
            }
        }
        if(isValid(board, row, column - 1)){
            if(board[row][column - 1] == word.charAt(wordex) && !seen[row][column - 1]){
                seen[row][column - 1] = true;
                verify(board, word, row, column - 1, wordex + 1, seen);
                seen[row][column - 1] = false;
            }
        }
        if(isValid(board, row, column + 1)){
            if(board[row][column + 1] == word.charAt(wordex) && !seen[row][column + 1]){
                seen[row][column + 1] = true;
                verify(board, word, row, column + 1, wordex + 1, seen);
                seen[row][column + 1] = false;
            }
        }


    }

    public boolean isValid(char[][] board, int row, int column) {
        if (row < board.length && row >= 0) {
            if (column < board[0].length && column >= 0) {
                return true;
            }
        }
        return false;
    }
}
