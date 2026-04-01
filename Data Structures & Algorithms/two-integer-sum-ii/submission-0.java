class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int n = numbers.length;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < i; j++){
                if( i != j && numbers[i] + numbers[j] == target){
                    return new int[]{j + 1, i + 1};
                }
            }
        }
        return new int[]{};
    }
}
