class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] rowCheck = new boolean[9][9];
        boolean[][] columnCheck = new boolean[9][9];
        boolean[][] boxCheck = new boolean[9][9];
        for(int i = 0; i < board.length; i ++){
            for(int j = 0; j < board[0].length; j++){
                char c = board[i][j];
                if(c != '.'){
                    int num = c - '0';
                    int b_row = i / 3;
                    int c_row = j / 3;
                    int index = 3 * b_row + c_row;
                    if(rowCheck[i][num - 1] ||
                    columnCheck[j][num - 1] ||
                    boxCheck[index][num - 1]){
                        return false;
                    }
                    rowCheck[i][num - 1] = true;
                    columnCheck[j][num - 1] = true;
                    boxCheck[index][num - 1] = true;

                }
            }
        }
        return true;
    }
}
