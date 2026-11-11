class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals,(a,b) -> a[1] - b[1]);
        int meets = 1;
        int freeTime = intervals[0][1];

        for(int i = 1; i < intervals.length; i++){
            if(intervals[i][0] >= freeTime){
                freeTime = intervals[i][1];
                meets++;
            }
        }

        return intervals.length - meets;
    }
}
