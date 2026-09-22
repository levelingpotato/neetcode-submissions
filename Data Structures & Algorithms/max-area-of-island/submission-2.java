class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        for(int row = 0; row < grid.length; row++){
            for(int col = 0;
            col < grid[0].length; col++){
                if(grid[row][col] == 1){
                    int val = flip(grid, row, col);
                    if(val > max){
                        max = val;
                    }
                }
            }
        }
        return max;
    }
    public int flip(int[][] grid, int row, int col) {
        grid[row][col] = 0;
        int one = 0;
        int two = 0;
        int three = 0;
        int four = 0;
        if(isValid(grid, row + 1, col)){
            one = flip(grid, row + 1, col);
        } 
        if(isValid(grid, row - 1, col)){
            two = flip(grid, row - 1, col);
        }
        if(isValid(grid, row, col + 1)){
            three = flip(grid, row, col + 1);
        }
        if(isValid(grid, row, col - 1)){
            four = flip(grid, row, col -1);
        }
        return 1 + one + two + three + four;
    }
    public boolean isValid(int[][] grid, int row, int col) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length) {
            return false;
        }
        if(grid[row][col] == 0){
            return false;
        }
        return true;
    }
}
