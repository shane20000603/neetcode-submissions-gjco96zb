class Solution {
    public int climbStairs(int n) {
        return dfs(n, 0);
    }

    private int dfs(int n, int cur){
        if(cur >= n) return cur == n ? 1 : 0;
        return dfs(n, cur + 1) + dfs(n, cur + 2);
    }
}
