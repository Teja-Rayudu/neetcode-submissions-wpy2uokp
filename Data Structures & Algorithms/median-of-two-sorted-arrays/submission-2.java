class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] arr = merge(nums1, nums2);

        int n = arr.length;
        int len = nums1.length + nums2.length;

        if(len % 2 == 0){
            return (arr[n - 1] + arr[n - 2]) / 2.0;
        }
        else{
            return (double) arr[n - 1];
        }
    }

    private int[] merge(int[] nums1, int[] nums2){

        int l1 = nums1.length, l2 = nums2.length;
        int n = l1 + l2;

        int[] merged = new int[n/2 + 1];

        int i = 0, j = 0, k = 0;

        while(i < l1 && j < l2 && k < merged.length){
            if(nums1[i] <= nums2[j]){
                merged[k++] = nums1[i++];
            }
            else merged[k++] = nums2[j++];
        }

        while(i < l1 && k < merged.length) merged[k++] = nums1[i++];
        while(j < l2 && k < merged.length) merged[k++] = nums2[j++];

        return merged;
    }
}
