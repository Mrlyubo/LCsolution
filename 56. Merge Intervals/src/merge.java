import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class A {
    public class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }
    public List<Interval> merge(List<Interval> intervals) {
        LinkedList<Interval> res = new LinkedList<>();
        int n = intervals.size();
        if( n <= 1) return intervals;
        int[] starts = new int[n];
        int[] ends = new int[n];
        int i = 0, j = 0;
        for(Interval itv: intervals){
            starts[i++] = itv.start;
            ends[j++] = itv.end;
        }
        Arrays.sort(starts);
        Arrays.sort(ends);

        if(ends[0]<starts[1]) res.add(new Interval(starts[0],ends[0]));// deal with the head.
        int p = 0,cnt =0;
        while (p < n-2){
            if(ends[p]>=starts[p+1]){// merge
                if(p!=n-2 && ends[p+1]>=starts[p+2]){//next merge
                    p++;
                    cnt++;
                    continue;
                }
                else if (p == n-2){
                    if(ends[p]>=starts[p+1])
                        res.add(new Interval(starts[p-cnt],ends[p+1]));
                    else{
                        res.add(new Interval(starts[p],ends[p]));
                        res.add(new Interval(starts[p+1],ends[p+1]));
                    }
                    p++;
                }
                else{ // next do not merge
                    res.add(new Interval(starts[p-cnt],ends[p+1]));
                    p++;
                    cnt = 0;}
            }
            else{// do not merge
                if(ends[p+1] >= starts[p+2]){// next merge
                    p++;
                    continue;
                }
                else{// next do not merge
                    res.add(new Interval(starts[p+1],ends[p+1]));
                    p++;
                }
            }
        }
        if(ends[n-2]<starts[n-1]) res.add(new Interval(starts[n-1],ends[n-1])); // deal with the tail.
        if(ends[n-2]>=starts[n-1]){
            cnt++;
            res.add(new Interval(starts[n-cnt-1],ends[n-1]));
        }
        return res;
    }

    public static void main(String [] args){
        A Launcher = new A();
        Launcher.start();
    }

    public void start(){

        List<Interval> intervals = new LinkedList<>();
        intervals.add(new Interval(1,3));
        intervals.add(new Interval(2,6));
        intervals.add(new Interval(8,10));
        intervals.add(new Interval(15,18));
        for(Interval in: merge(intervals))
            System.out.print("["+in.start+","+in.end+"]");
        System.out.println("***");

        List<Interval> intervals1 = new LinkedList<>();
        intervals1.add(new Interval(1,100));
        intervals1.add(new Interval(2,3));
        intervals1.add(new Interval(4,6));
        intervals1.add(new Interval(1,4));
        for(Interval in: merge(intervals1))
            System.out.print("["+in.start+","+in.end+"]");
        System.out.println("***");

       List<Interval> intervals2 = new LinkedList<>();
        for(Interval in: merge(intervals2))
            System.out.print("["+in.start+","+in.end+"]");
        System.out.println("***");

        List<Interval> intervals3 = new LinkedList<>();
        intervals3.add(new Interval(1,3));
        intervals3.add(new Interval(4,5));
        for(Interval in: merge(intervals3))
            System.out.print("["+in.start+","+in.end+"]");
        System.out.println("***");

        List<Interval> intervals4 = new LinkedList<>();
        intervals4.add(new Interval(2,3));
        intervals4.add(new Interval(2,2));
        intervals4.add(new Interval(3,3));
        intervals4.add(new Interval(1,3));
        intervals4.add(new Interval(5,7));
        intervals4.add(new Interval(2,2));
        intervals4.add(new Interval(4,6));
        for(Interval in: merge(intervals4))
            System.out.print("["+in.start+","+in.end+"]");
        System.out.println("***");

        List<Interval> intervals5 = new LinkedList<>();
        intervals5.add(new Interval(1,4));
        intervals5.add(new Interval(4,5));
        for(Interval in: merge(intervals5  ))
            System.out.print("["+in.start+","+in.end+"]");
        System.out.println("***");










    }
}