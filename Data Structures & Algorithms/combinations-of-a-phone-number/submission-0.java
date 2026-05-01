class Solution {
    public List<String> letterCombinations(String digits) {
        HashMap<Integer, String> map = new HashMap();
        map.put(2, "abc");
        map.put(3, "def");
        map.put(4, "ghi");
        map.put(5, "jkl");
        map.put(6, "mno");
        map.put(7, "pqrs");
        map.put(8, "tuv");
        map.put(9, "wxyz");
        List<String> res = new ArrayList();
        dfs(digits, 0, res, new StringBuilder(), map);
        return res;
    }

    private void dfs(String digits, int index, 
    List<String> res, StringBuilder sb, Map<Integer, String> map){
        if(index == digits.length()){
            if(sb.length() != 0){res.add(sb.toString());}
            return;
        }
        String cur = map.get(digits.charAt(index) - '0');
        for(int i = 0; i < cur.length(); i++){
            sb.append(cur.charAt(i));
            dfs(digits, index + 1, res, sb, map);
            sb.deleteCharAt(sb.length() - 1);
        }
    }


}
