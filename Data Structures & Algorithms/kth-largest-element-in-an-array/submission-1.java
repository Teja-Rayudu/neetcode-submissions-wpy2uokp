class Solution {
    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        return quickSelect(nums, 0, n - 1, n - k);
    }

    private int quickSelect(int[] nums, int lo, int hi, int k){
        int pivot = nums[hi];
        int pivotIndex = partition(nums, lo, hi, pivot);
        if(pivotIndex == k) return nums[pivotIndex];

        if(pivotIndex < k){
            return quickSelect(nums, lo, pivotIndex - 1, k);
        }
        else return quickSelect(nums, pivotIndex + 1, hi, k);
        
    }

    private int partition(int[] nums, int lo, int hi, int pivot){
        int i = lo;
        int j = lo;

        while(i <= hi){
            if(nums[i] > pivot) i++;
            else{
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
                j++;
            }
        }
        return j - 1;
    }
}
