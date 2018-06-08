/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
    public boolean canAttendMeetings(Interval[] intervals) {
        int[] starts = new int[intervals.length];
        int[] ends = new int[intervals.length];
        for(int i = 0; i < intervals.length; i++){
            starts[i] = intervals[i].start;
            ends[i] = intervals[i].end;
        }
        boolean flag = true;
        Arrays.sort(starts);
        Arrays.sort(ends);
        for(int i = 0; i < intervals.length-1; i++){
            if(ends[i] > starts[i+1])
                flag = false;
        }
        return flag;
    }
}