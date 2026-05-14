class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList();
        List<String> path = new ArrayList();
        dfs(s, 0, res, path);
        return res;
    }

    private void dfs(String s, int index, List<List<String>> res, List<String> path){
        if(index >= s.length()){
            res.add(new ArrayList(path));
            return;
        }
        for(int i = index; i < s.length(); i++){
            String cur = s.substring(index, i + 1);
            if(!isPalindrome(cur)){
                continue;
            }
            path.add(cur);
            dfs(s, i + 1, res, path);
            path.remove(path.size() - 1);
        }
    }

    private boolean isPalindrome(String str){
        int left = 0;
        int right = str.length() - 1;
        while(left < right){
            if(str.charAt(left) != str.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
