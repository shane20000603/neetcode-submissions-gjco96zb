class Solution {

    List<String> res = new ArrayList();
    StringBuilder sb = new StringBuilder();

    public List<String> generateParenthesis(int n) {
        dfs(n, 0, 0);
        return res;
    }

    private void dfs(int n, int left, int right){
        if(left == n && right == n){
            res.add(sb.toString());
            return;
        }
        if(left < n){
            sb.append('(');
            dfs(n, left + 1, right);
            sb.deleteCharAt(sb.length() - 1);
        }
        if(right < left){
            sb.append(')');
            dfs(n, left, right + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
