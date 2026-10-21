class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList();
        recur(0, target, nums, new ArrayList(), res);

        return res;
    }

    private void recur(int index, int target, int[] nums ,List<Integer> ds, List<List<Integer>> res){
        if(index == nums.length){
            if(target == 0){
                res.add(new ArrayList<>(ds));
            }
            return;
        }

        if(nums[index] <= target){
            ds.add(nums[index]);
            recur(index, target - nums[index], nums, ds, res);
            ds.remove(ds.size() - 1);
        }

        recur(index + 1, target, nums,ds, res);
    }
}
