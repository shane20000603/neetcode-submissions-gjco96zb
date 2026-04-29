class Solution {

    List<Integer> path = new ArrayList();
    List<List<Integer>> res = new ArrayList();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        dfs(candidates, target, 0);
        return res;
    }

    private void dfs(int[] candidates, int target, int start){
        if(target == 0){
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i = start; i < candidates.length; i++){
            if(candidates[i] > target) break;
            if(i > start && candidates[i] == candidates[i - 1]) continue;
            path.add(candidates[i]);
            dfs(candidates, target - candidates[i], i + 1);
            path.remove(path.size() - 1);
        }
    }
}
