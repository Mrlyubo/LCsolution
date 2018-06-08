class A {

/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

    public class Solution extends VersionControl {
        public int firstBadVersion(int n) {
            int max = n;
            int min = 1;
            n = min + (max-min)/2;
            // in math, (min+max)/2 == min +(max-min)/2, but the left one may be overflow when
            while(min+1<max){
                if(isBadVersion(n)) max = n;
                else min = n;
                n = min + (max-min)/2;
            }
            if(isBadVersion(n)) return min;
            else return max;
        }
    }
    public static void main(String [] args){
        A Launcher = new A();
        Launcher.start();
    }
    public void start(){

        System.out.println(  );
    }
}