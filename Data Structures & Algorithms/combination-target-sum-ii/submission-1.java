class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList();
        Arrays.sort(candidates);
        recur(0, target, candidates, new ArrayList(), res);
        return res;
    }

    private void recur(int index, int target, int[] nums ,List<Integer> ds, List<List<Integer>> res){
        if(target == 0){
            res.add(new ArrayList<>(ds));
            return;
        }

        for(int i = index; i < nums.length; i++){
            if(nums[i] > target) break;

            if(i > index && nums[i] == nums[i - 1]) continue;

            ds.add(nums[i]);
            recur(i + 1, target - nums[i], nums, ds, res);
            ds.removeLast();
        }
    }
}
