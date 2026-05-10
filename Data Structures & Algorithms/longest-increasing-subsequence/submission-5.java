class Solution { 
    // 9 1 4 2 3 3 7
    // dp -> min value of lenth i
    // 9 3 5 2 3
    public int lengthOfLIS(int[] nums) {
        List<Integer> list = new ArrayList();
        for(int num: nums){
            boolean replace = false;
            for(int i = 0; i < list.size(); i++){
                if(list.get(i) >= num){
                    list.set(i, num);
                    replace = true;
                    break;
                }
            }
            if(!replace){
                list.add(num);
                System.out.println(num);
            }
        }
        return list.size();
    }
}
