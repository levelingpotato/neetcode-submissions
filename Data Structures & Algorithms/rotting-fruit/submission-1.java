class Solution {
    public int orangesRotting(int[][] grid) {
        ArrayList<int[]> rot = new ArrayList<>();
        int fruitCount = 0;
        int minutes = 0;

        for(int row = 0; row < grid.length; row++){
            for(int column = 0; column < grid[0].length; column++){
                int object = grid[row][column];
                if(object == 1 || object == 2){
                    fruitCount += 1;
                    if(object == 2){
                        int[] rotDex = new int[2];
                        rotDex[0] = row;
                        rotDex[1] = column;
                        rot.add(rotDex);
                    }
                }
            }
        }
        boolean stillRotting = true;
        while(stillRotting){
            stillRotting = rot(grid, rot);
            
            minutes += 1;
        }
        if(fruitCount == rot.size()){
            return minutes -1;
        }
        return -1;

    }
    public boolean rot(int[][] grid, ArrayList<int[]> rot){
        boolean rotSomething = false;
        int rotsize = rot.size();
        for(int i = 0; i < rotsize; i++){
            int row = rot.get(i)[0];
            int column = rot.get(i)[1];
            if(isValid(row - 1, column, grid)){
                if(grid[row - 1][column] == 1){
                    grid[row - 1][column] = 2;
                    int[] add = new int[2];
                    add[0] = row - 1;
                    add[1] = column;
                    rot.add(add);
                    rotSomething = true;
                }
            }
            if(isValid(row + 1, column, grid)){
                if(grid[row + 1][column] == 1){
                    grid[row + 1][column] = 2;
                    int[] add = new int[2];
                    add[0] = row + 1;
                    add[1] = column;
                    rot.add(add);
                    rotSomething = true;
                }
            }
            if(isValid(row, column - 1, grid)){
                if(grid[row][column - 1] == 1){
                    grid[row][column - 1] = 2;
                    int[] add = new int[2];
                    add[0] = row;
                    add[1] = column - 1;
                    rot.add(add);
                    rotSomething = true;
                }
            }
            if(isValid(row, column + 1, grid)){
                if(grid[row][column + 1] == 1){
                    grid[row][column + 1] = 2;
                    int[] add = new int[2];
                    add[0] = row;
                    add[1] = column + 1;
                    rot.add(add);
                    rotSomething = true;
                }
            }
        }
        return rotSomething;
    }
    public boolean isValid(int row, int column, int[][] grid){
        if(row >= 0 && row < grid.length){
            if(column >= 0 && column < grid[0].length){
                return true;
            } else {
                return false;
            }
        }
        return false;
    }
}
