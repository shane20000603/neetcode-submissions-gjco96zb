class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList();
        HashMap<String, List<String>> map = new HashMap();
        for(String str: strs){
            char[] chars = str.toCharArray();
            int[] count = new int[26];
            for(char c: chars){
                count[c - 'a']++;
            }
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < count.length; i++){
                sb.append(count[i]).append('#');
            }
            String key = sb.toString();
            List<String> value = map.getOrDefault(key, new ArrayList<String>());
            value.add(str);
            map.put(key, value);
        }
        return new ArrayList<>(map.values());
    }
}
