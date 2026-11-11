class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        if (intervals == null || intervals.size() == 0) {
            return 0;
        }
        
        int n = intervals.size();
        int[] starts = new int[n];
        int[] ends = new int[n];
        
        // 1. Separate the starts and ends
        for (int i = 0; i < n; i++) {
            starts[i] = intervals.get(i).start;
            ends[i] = intervals.get(i).end;
        }
        
        // 2. Sort them independently
        Arrays.sort(starts);
        Arrays.sort(ends);
        
        int count = 0;
        int maxCount = 0;
        int i = 0; 
        int j = 0;
        
        // 3. Walk through the timeline
        while (i < n) {
            // If a meeting starts before the earliest ending meeting finishes
            if (starts[i] < ends[j]) {
                count++;
                maxCount = Math.max(maxCount, count); // Track the peak!
                i++;
            } else {
                // A meeting ended, freeing up a room
                count--;
                j++;
            }
        }
        
        return maxCount;
    }
}