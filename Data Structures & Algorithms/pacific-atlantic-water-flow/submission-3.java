class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int row = heights.length;
        int col = heights[0].length;
        boolean[][][] connect = new boolean[row][col][2];
        Queue<int[]> queue = new ArrayDeque();
        //0 rep pac; 1 rep atl
        List<List<Integer>> res = new ArrayList();

        //initialize
        for(int i = 0; i < row; i++){
            dfs(heights, i, 0, 0, connect, true);
            dfs(heights, i, col - 1, 0, connect, false);
        }

        for(int i = 0; i < col; i++){
            dfs(heights, 0, i, 0, connect, true);
            dfs(heights, row - 1, i, 0, connect, false);
        }

        for(int r = 0; r < row; r++){
            for(int c = 0; c < col; c++){
                if(connect[r][c][0] && connect[r][c][1]){
                    res.add(List.of(r,c));
                }
            }
        }

        return res;
         
    }

    private void dfs(int[][] heights, int r, int c, int lastHeight, boolean[][][] connect, boolean pac){
        if(r < 0 || r >= heights.length || c < 0 || c >= heights[0].length) return;
        if(heights[r][c] < lastHeight || connect[r][c][pac? 0: 1]) return;
        connect[r][c][pac? 0: 1] = true;
        dfs(heights, r + 1, c, heights[r][c], connect, pac);
        dfs(heights, r - 1, c, heights[r][c], connect, pac);
        dfs(heights, r, c + 1, heights[r][c], connect, pac);
        dfs(heights, r, c - 1, heights[r][c], connect, pac);
    }
}
