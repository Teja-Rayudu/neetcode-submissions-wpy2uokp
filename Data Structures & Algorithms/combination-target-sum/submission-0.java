class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        combinationRecur(nums, 0, target, new ArrayList<>(), res);
        return res;
    }

    private void combinationRecur(int[] nums, int index, int target, List<Integer> ds, List<List<Integer>> res){
        if(index == nums.length){
            if(target == 0){
                res.add(new ArrayList<>(ds));
            }

            return;
        }
        if(nums[index] <= target){
            ds.add(nums[index]);
            combinationRecur(nums, index, target - nums[index], ds, res);
            ds.removeLast();
        }
        combinationRecur(nums, index + 1, target, ds, res);
    }
}
