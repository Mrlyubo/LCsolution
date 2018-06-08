import  java.util.*;

class A {
    
     public class Interval {
          int start;
          int end;
          Interval() { start = 0; end = 0; }
          Interval(int s, int e) { start =  s; end = e; }
     }
    public int minMeetingRooms4(Interval[] intervals) {
        int len = intervals.length;
        int [] start = new int [len];
        int [] end = new int [len];
        for ( int i = 0; i < len; i++ ){
            start[i] = intervals[i].start;
            end[i] = intervals[i].end;
        }
        int res = 0;
        Arrays.sort(start);
        Arrays.sort(end);
        for (int i = 0,j =0; i< start.length; i++){// i : the number of meeting that have started.
            if(start[i]>=end[j]) j++;// j : the number of meeting that have ended.
            res = Math.max(i-j+1,res);//
        }
        return res;
    }


     //Better Approach
    public int minMeetingRooms3(Interval[] intervals) {
        int len = intervals.length;
        int [] start = new int [len];
        int [] end = new int [len];
        for ( int i = 0; i < len; i++ ){
            start[i] = intervals[i].start;
            end[i] = intervals[i].end;
        }
        Arrays.sort(start);
        Arrays.sort(end);
        int rooms = 0;
        int endsItr = 0;
        for(int i=0; i<len; i++) {
            if(start[i]<end[endsItr])
                rooms++;
            else
                endsItr++;
        }
        return rooms;

    }

    public int minMeetingRooms1(Interval[] intervals) {
          int maxEnd = 0;
          for(Interval itv: intervals){
              maxEnd = Math.max(itv.end,maxEnd);
          }
          int[] time = new int[maxEnd+1];
          for(Interval itv: intervals){
              for(int i = itv.start;i < itv.end; i++)
                  time[i] += 1;
             // printarray(time);
          }
          //System.out.println("Before sort : ");
          //printarray(time);
          Arrays.sort(time);
          //System.out.println("After sort :");
          //printarray(time);
          return time[maxEnd];

    }

    //My approach O(n^2)
    public void printarray(int[] a) {
        for (int ai : a) System.out.print(ai+",");
        System.out.println(" ");
    }


    public static void main(String [] args){
        A Launcher = new A();
        Launcher.start();
    }
    public void start(){
        Interval[] intervals= new Interval[]{
                new Interval(0,30),
                new Interval(5,10),
                new Interval(15,20),
                new Interval(7,16)
        };
        Interval[] intervals1= new Interval[]{
                new Interval(13,15),
                new Interval(1,13)

        };
        System.out.println(minMeetingRooms4(intervals1));
    }
}
