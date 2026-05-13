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
    // 0,40 5,10 15,20
    // 0 -> 1
    // 40 -> -1
    // 5,10  5,11 11,20

    public int minMeetingRooms(List<Interval> intervals) {
        List<int[]> diff = new ArrayList();
        for(Interval interval: intervals){
            diff.add(new int[]{interval.start, 1});
            diff.add(new int[]{interval.end, -1});
        }
        Collections.sort(diff, (a,b) -> {
            if(a[0] == b[0]){
                return a[1] - b[1];
            } else {
                return a[0] - b[0];
            }
        });
        int max = 0;
        int cur = 0;
        for(int[] d: diff){
            cur += d[1];
            max = Math.max(max, cur);
        }
        return max;
    }
}
