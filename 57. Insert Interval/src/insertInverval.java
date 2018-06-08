import java.util.LinkedList;
import java.util.List;

class A {
    public class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }

    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        if(intervals.isEmpty()){
            intervals.add(newInterval);
            return intervals;
        }
        int ns = newInterval.start;
        int ne = newInterval.end;
        int start_idx=0,end_idx=0,newstart=ns,newend=ne;

        if(ne<intervals.get(0).start) {
            intervals.add(0,newInterval);
            return intervals;
        }
        if(ns>intervals.get(intervals.size()-1).end){
            intervals.add(newInterval);
            return intervals;
        }
        if(ns <= intervals.get(0).start && ne >= intervals.get(intervals.size()-1).end){
            List<Interval> ans = new LinkedList<>();
            ans.add(newInterval);
            return ans;
        }


        for(int i = 0; i < intervals.size(); i++){
            int start = intervals.get(i).start;
            int end = intervals.get(i).end;
            int pre_end = 0;
            if(i>0)
                pre_end = intervals.get(i-1).end;
            // find the position for newInterval.start
            if( ns >= start && ns <= end){//
                start_idx = i;
                newstart = start;
            }
            else if( i>0 && ns < start && ns > pre_end ){
                start_idx = i;
                newstart = ns;
            }
            //find the position for newInterval.end
            if( ne >= start && ne <= end){
                end_idx = i;
                newend = end;
                break;
            }
            else if( i>0 && ne < start && ne > pre_end ){
                end_idx = i-1;
                newend = ne;
                break;
            }
            else if ( i== intervals.size()-1 && ne > end){
                end_idx = i;
                newend = ne;
                break;
            }
        }

        //delete the overlapping intervals
        for(int i = start_idx; i<= end_idx; i++)
            intervals.remove(start_idx);

        //insert newIntervals;
        intervals.add(start_idx,new Interval(newstart,newend));

        return intervals;
    }

    public static void main(String [] args){
        A Launcher = new A();
        Launcher.start();
    }

    public void printListIntervals(List<Interval> intervals){
        for(Interval itv: intervals) {
            System.out.print("[" + itv.start);
            System.out.print(","+itv.end+"]"+",");
        }
        System.out.println(" ");
    }
    public void start(){

        List<Interval> intervals = new LinkedList<>();
        intervals.add(new Interval(1,2));
        intervals.add(new Interval(3,5));
        intervals.add(new Interval(6,7));
        intervals.add(new Interval(8,10));
        intervals.add(new Interval(12,16));
        Interval newInterval = new Interval(4,8);
        printListIntervals(insert(intervals,newInterval));


        List<Interval> intervals1 = new LinkedList<>();
        intervals1.add(new Interval(1,3));
        intervals1.add(new Interval(6,9));
        Interval newInterval1 = new Interval(2,5);
        printListIntervals(insert(intervals1,newInterval1));

        List<Interval> intervals2 = new LinkedList<>();
        intervals2.add(new Interval(2,3));
        Interval newInterval2 = new Interval(1,2);
        printListIntervals(insert(intervals2,newInterval2));

        List<Interval> intervals3 = new LinkedList<>();
        intervals3.add(new Interval(1,4));
        Interval newInterval3 = new Interval(6,8);
        printListIntervals(insert(intervals3,newInterval3));

        List<Interval> intervals4 = new LinkedList<>();
        intervals4.add(new Interval(1,5));
        intervals4.add(new Interval(6,8));
        Interval newInterval4 = new Interval(5,6);
        printListIntervals(insert(intervals4,newInterval4));

        List<Interval> intervals5 = new LinkedList<>();
        intervals5.add(new Interval(1,5));
        intervals5.add(new Interval(6,8));
        Interval newInterval5 = new Interval(0,9);
        printListIntervals(insert(intervals5,newInterval5));

        List<Interval> intervals7 = new LinkedList<>();
        intervals7.add(new Interval(3,5));
        Interval newInterval7 = new Interval(1,4);
        printListIntervals(insert(intervals7,newInterval7));

        List<Interval> intervals6 = new LinkedList<>();
        intervals6.add(new Interval(1,5));
        intervals6.add(new Interval(6,11));
        Interval newInterval6 = new Interval(9,15);
        printListIntervals(insert(intervals6,newInterval6));
    }
}
