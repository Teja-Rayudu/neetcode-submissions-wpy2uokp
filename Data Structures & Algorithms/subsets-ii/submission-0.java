class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList();
        Arrays.sort(nums);
        recur(0, nums, new ArrayList<>(), res);
        return res;
    }

    private void recur(int start, int[] nums, List<Integer> ds, List<List<Integer>> res){
        
        res.add(new ArrayList(ds));

        for(int i = start; i < nums.length; i++){
            if(i > start && nums[i] == nums[i - 1]) continue;
            ds.add(nums[i]);
            recur(i + 1, nums, ds, res);
            ds.remove(ds.size() - 1);
        }
    }
}
