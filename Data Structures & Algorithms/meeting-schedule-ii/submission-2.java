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
        int count = 0;
        int j = 0, i = 0;
        while(i < intervals.size()){
            if(intervals.get(i).start < intervals.get(j).end){
                count++;
                i++;
            }
            else{
                count--;
                j++;
            }
        }
        return count;
    }
}
