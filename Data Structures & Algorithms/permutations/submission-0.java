class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList();
        boolean[] pick = new boolean[nums.length];

        backtrack(nums, new ArrayList(),res, pick);
        return res;
    }

    private void backtrack(int[] nums, List<Integer> ds, List<List<Integer>> res, boolean[] pick){
        if(ds.size() == nums.length){
            res.add(new ArrayList<>(ds));
            return;
        }

        for(int i = 0; i < nums.length; i++){
            if(!pick[i]){
                ds.add(nums[i]);
                pick[i] = true;
                backtrack(nums, ds, res, pick);
                ds.remove(ds.size() - 1);
                pick[i] = false;
            }
        }
    }
}
