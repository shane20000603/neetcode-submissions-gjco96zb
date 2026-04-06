class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String str: strs){
            sb.append(str.length()).append('#').append(str);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> res = new ArrayList();
        int pointer = 0;
        while(pointer < str.length()){
            int len = 0;
            while(str.charAt(pointer) != '#'){
                len = len * 10 + str.charAt(pointer) - '0';
                pointer++;
            }
            pointer++;
            res.add(str.substring(pointer, pointer + len));
            pointer += len;
        }
        // char[] chars = str.toCharArray();        
        // int pointer = 0;
        // while(pointer < chars.length){
        //     StringBuilder timesRec = new StringBuilder();
        //     StringBuilder sb = new StringBuilder();
        //     while(chars[pointer] != '#'){
        //         timesRec.append(chars[pointer]);
        //         pointer++;
        //     }
        //     int len = Integer.valueOf(new String(timesRec));
        //     pointer++;//move to first char of new string
        //     for(int i = 0; i < len; i++){
        //         sb.append(chars[pointer++]);
        //     }
        //     res.add(sb.toString());
        // }
        return res;
    }
}
