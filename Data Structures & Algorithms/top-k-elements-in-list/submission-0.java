class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        List<Integer>[] lists = new ArrayList[nums.length + 1];

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int value = entry.getKey();
            int count = entry.getValue();

            if (lists[count] == null) {
                lists[count] = new ArrayList<>();
            }
            lists[count].add(value);
        }

        int[] res = new int[k];
        int index = 0;

        for (int i = lists.length - 1; i >= 0; i--) {
            if (lists[i] != null) {
                for (int num : lists[i]) {
                    res[index++] = num;
                    if (index == k) return res;
                }
            }
        }

        return res;
    }
}