class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList();
        backtrack(0, new ArrayList(), nums, result);

        return result;
    }

    private void backtrack(int index, List<Integer> ds, int[] nums, List<List<Integer>> res){
        if(index == nums.length){
            res.add(new ArrayList<>(ds));
            return;
        }

        ds.add(nums[index]);
        backtrack(index + 1, ds, nums , res);

        ds.remove(ds.size() -1);
        backtrack(index + 1, ds, nums, res);
    }
}
