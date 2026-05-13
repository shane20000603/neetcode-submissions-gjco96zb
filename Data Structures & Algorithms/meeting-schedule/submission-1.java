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
        Collections.sort(intervals, (a,b) -> {
            if(a.start == b.start){
                return a.end - b.end;
            } else {
                return a.start - b.start;
            }
        });
        int end = 0;
        for(Interval interval: intervals){
            if(end > interval.start){
                return false;
            }
            end = interval.end;
        }
        return true;
    }
}
