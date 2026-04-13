class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;
        List<int[]> inserted = new ArrayList<>();
        int i = 0;
        while(i < n && intervals[i][1] < newInterval[0]){
            inserted.add(intervals[i]);
            i++;
        }

        while(i < n && intervals[i][0] < newInterval[1]){
            newInterval[0] = Math.min(intervals[i][0],newInterval[0]);
            newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
            i++;
        }

        inserted.add(newInterval);

        while(i < n){
            inserted.add(intervals[i]);
            i++;
        }

        int[][] res = new int[inserted.size()][2];

        for(int j = 0; j < res.length; j++){
            res[j] = inserted.get(j);
        }

        return res;
    }
}
