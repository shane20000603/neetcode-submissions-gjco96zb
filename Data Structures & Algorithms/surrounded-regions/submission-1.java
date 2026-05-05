class Solution {
    int[][] dirs = {
        {1, 0},
        {-1,0},
        {0,1},
        {0,-1}
    };
    public void solve(char[][] board) {
        int row = board.length;
        int col = board[0].length;
        boolean[][] protect = new boolean[row][col];
        for(int r = 0; r < row; r++){
            if(board[r][0] == 'O'){
                dfs(board, protect, r, 0);
            }
            if(board[r][col - 1] == 'O'){
                dfs(board, protect, r, col - 1);
            }
        }

        for(int c = 0; c < col; c++){
            if(board[0][c] == 'O'){
                dfs(board, protect, 0, c);
            }
            if(board[row - 1][c] == 'O'){
                dfs(board, protect, row - 1, c);
            }
        }

        for(int r = 0; r < row; r++){
            for(int c = 0; c < col; c++){
                if(!protect[r][c]){
                    board[r][c] = 'X';
                }
            }
        }
    }

    private void dfs(char[][] board, boolean[][] protect, int r, int c){
        System.out.println(r+ ", "+c);
        protect[r][c] = true;
        for(int[] dir: dirs){
            int nr = r + dir[0];
            int nc = c + dir[1];
            if(nr < 0 || nr >= board.length || nc < 0 || nc >= board[0].length) continue;
            if(protect[nr][nc] || board[nr][nc] == 'X') continue;
            dfs(board, protect, nr, nc);
        }
    }
}
