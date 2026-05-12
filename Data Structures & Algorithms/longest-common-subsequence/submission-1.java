class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        //      a b c d
        // e    0 0 0 0
        // f
        // a    1 1 1 1
        // g    1 1 1 1
        // d    1 1 1 2

        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[m + 1][n + 1];
        for(int i = m - 1; i >= 0; i--){
            for(int j = n - 1; j >= 0; j--){
                if(text1.charAt(i) == text2.charAt(j)){
                    dp[i][j] = dp[i + 1][j + 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j + 1]);
                }
            }
        }

        for(int i = 0; i < m + 1; i++){
            for(int j = 0; j < n + 1; j++){
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }

        return dp[0][0];
    }
}
