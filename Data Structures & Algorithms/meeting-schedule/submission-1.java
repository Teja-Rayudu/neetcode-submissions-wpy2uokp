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
    public boolean canAttendMeetings(List<Interval> intervals) {
        if(intervals.size() == 0) return true;
        Collections.sort(intervals, (a,b) -> (a.end - b.end));
        int size = intervals.size();

        int meet = 1;
        int freeTime = intervals.get(0).end;

        for(int i = 1; i < size; i++){
            if(intervals.get(i).start >= freeTime){
                meet++;
                freeTime = intervals.get(i).end;
            }
        }

        return meet == size;
    }
}
