class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = 0;

        for(int pile : piles){
            right = Math.max(right, pile);
        }
        int result = 0;

        while(left <= right){
            int mid = left + (right - left) / 2;

            if(canFinish(mid, h, piles)){
                result = mid;
                right = mid - 1;
            }
            else{
                left = mid + 1;
            }
        }

        return result;
    }

    private boolean canFinish(int k, int h, int[] piles){
        long hoursNeeded = 0;

        for(int pile: piles){
            hoursNeeded += (pile + k - 1) / k;
        }

        return hoursNeeded <= h;
    }
}
