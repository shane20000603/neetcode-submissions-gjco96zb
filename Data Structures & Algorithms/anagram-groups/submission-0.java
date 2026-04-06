class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList();
        HashMap<String, List<String>> map = new HashMap();
        for(String str: strs){
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            List<String> value = map.getOrDefault(key, new ArrayList<String>());
            value.add(str);
            map.put(key, value);
        }
        return new ArrayList<>(map.values());
    }
}
