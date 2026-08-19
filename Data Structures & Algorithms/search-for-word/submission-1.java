class Solution {
    boolean found = false;
    public boolean exist(char[][] board, String word) {
        boolean[][] seen = new boolean[board.length][board[0].length]; 
        for(int row = 0; row < board.length; row++){
            for(int column = 0; column < board[0].length; column++){
                if(board[row][column] == word.charAt(0)){
                    seen[row][column] = true;
                    backtrack(board, row, column, 1, seen, word);
                    seen[row][column] = false;
                    if(found){
                        return true;
                    }
                    
                }
            }
        }
        return false;
    }
    public void backtrack(
        char[][] board, int row, int column, int chardex, boolean[][] seen, String word) {
            if(chardex == word.length()){
                found = true;
                return;
            }
            int r = row;
            int c = column;
            if(isValid(board, r - 1, c) && seen[r - 1][c] == false){
                if(board[r - 1][c] == word.charAt(chardex)){
                    seen[r - 1][c] = true;
                    chardex += 1;
                    backtrack(board, r - 1, c, chardex, seen, word);
                    chardex -= 1;
                    seen[r - 1][c] = false;
                }
            }
            if(isValid(board, r + 1, c) && seen[r + 1][c] == false){
                if(board[r + 1][c] == word.charAt(chardex)){
                    seen[r +1][c] = true;
                    chardex += 1;
                    backtrack(board, r + 1, c, chardex, seen, word);
                    chardex -= 1;
                    seen[r + 1][c] = false;
                }
            }
            if(isValid(board, r, c + 1) && seen[r][c + 1] == false){
                if(board[r][c + 1] == word.charAt(chardex)){
                    seen[r][c + 1] = true;
                    chardex += 1;
                    backtrack(board, r, c + 1, chardex, seen, word);
                    chardex -= 1;
                    seen[r][c + 1] = false;
                }
            }
            if(isValid(board, r, c - 1) && seen[r][c - 1] == false){
                if(board[r][c - 1] == word.charAt(chardex)){
                    seen[r][c - 1] = true;
                    chardex += 1;
                    backtrack(board, r, c - 1, chardex, seen, word);
                    chardex -= 1;
                    seen[r][c - 1] = false;
                }
            }
        }
    public boolean isValid(char[][] board, int row, int column){
        if(row >= 0 && row < board.length){
            if(column >= 0 && column < board[0].length){
                return true;
            }
        }
        return false;
    }
}
