/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        Collections.sort(intervals, (a, b) -> a.start- b.start);
        int count = 1;
        for(int i = 1; i < intervals.size(); i++){
            if(intervals.get(i).start < intervals.get(i - 1).end) count++;
        }
        return count;
    }
}
