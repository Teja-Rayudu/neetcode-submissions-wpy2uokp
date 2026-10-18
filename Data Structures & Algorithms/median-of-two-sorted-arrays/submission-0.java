class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] arr = merge(nums1, nums2);

        int n = arr.length - 1;

        double sum = 0.0;

        if( (n + 1) % 2 == 0){
            sum = arr[n / 2] + arr[(n / 2) + 1];
            return sum / 2;
        }

        return (double) arr[n / 2];
    }

    private int[] merge(int[] nums1, int[] nums2){
        if(nums1 == null || nums1.length == 0) return nums2;
        if(nums2 == null || nums2.length == 0) return nums1;

        int l1 = nums1.length, l2 = nums2.length;

        int[] merged = new int[l1 + l2];

        int i = 0, j = 0, k = 0;

        while(i < l1 && j < l2){
            if(nums1[i] <= nums2[j]){
                merged[k++] = nums1[i++];
            }
            else merged[k++] = nums2[j++];
        }

        while(i < l1) merged[k++] = nums1[i++];
        while(j < l2) merged[k++] = nums2[j++];

        return merged;
    }
}
