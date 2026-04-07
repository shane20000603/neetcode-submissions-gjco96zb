class Solution {
    boolean res = false;
    public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                res = backtracking(board, word, 0, visited, i, j);
                if(res == true) return true;
            }
        }
        return false;
    }

    private boolean backtracking(char[][] board, String word, int index, boolean[][] visited,
    int row, int column){
        if(row < 0 || column < 0 || row >= board.length || column >= board[0].length
        || visited[row][column] || board[row][column] != word.charAt(index)
        ){
            return false;
        } else {
            if(index == word.length() - 1){
                return true;
            }
            visited[row][column] = true;
            boolean found =  backtracking(board, word, index + 1, visited, row + 1, column)
            || backtracking(board, word, index + 1, visited, row - 1, column)
            || backtracking(board, word, index + 1, visited, row, column + 1)
            || backtracking(board, word, index + 1, visited, row, column - 1);
            visited[row][column] = false;
            return found;
        }
    }
}
