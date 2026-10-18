class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while(left <= right){
            int mid = left + (right - left) / 2;

            if(nums[mid] == target) return mid;

            if(target < nums[mid] && nums[mid] > nums[left] && nums[mid] > nums[left]) left = mid + 1;
            else right = mid - 1;
        }

        return -1;
    }
}
