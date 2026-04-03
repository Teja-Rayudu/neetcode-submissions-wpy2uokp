class Solution {
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int currSum = 0;
        for(int i = 0; i < nums.length; i++){
            for(int j = i; j < nums.length; j++){
                currSum = sum(nums, i, j);
                max = Math.max(max, currSum);
            }
        }

        return max;
    }

    private int sum(int[] arr, int start, int end){
        int sum = 0;
        while(start <= end){
            sum += arr[start];
            start++;
        }
        return sum;
    }
}
