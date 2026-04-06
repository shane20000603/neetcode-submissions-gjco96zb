class Solution {
    boolean res = false;
    int m, n;
    boolean[][] visited;

    public boolean exist(char[][] board, String word) {
        m = board.length;
        n = board[0].length;
        visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (backtracking(board, word, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean backtracking(char[][] board, String word, int x, int y, int index) {
        // 成功匹配整个单词
        if (index == word.length()) return true;
        // 越界/不匹配/已经访问过
        if (x < 0 || x >= m || y < 0 || y >= n || visited[x][y] || board[x][y] != word.charAt(index)) {
            return false;
        }

        visited[x][y] = true;
        // 四个方向搜索
        boolean found = backtracking(board, word, x + 1, y, index + 1) ||
                        backtracking(board, word, x - 1, y, index + 1) ||
                        backtracking(board, word, x, y + 1, index + 1) ||
                        backtracking(board, word, x, y - 1, index + 1);

        visited[x][y] = false; // 回溯
        return found;
    }
}
