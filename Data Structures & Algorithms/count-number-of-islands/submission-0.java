class Solution {
    public int numIslands(char[][] grid) {
        int res = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == '1'){
                    traverse(grid, i, j);
                    res++;
                }
            }
        }
        return res;
    }

    private void traverse(char[][] grid, int row, int column){
        if(row < 0 || column < 0 
        || row >= grid.length 
        || column>=grid[0].length){
            return;
        }
        if(grid[row][column] == '0' || grid[row][column] == '#'){
            return;
        } else {
            grid[row][column] = '#';
            traverse(grid, row + 1, column);
            traverse(grid, row - 1, column);
            traverse(grid, row, column + 1);
            traverse(grid, row, column - 1);
        }

    }
}
