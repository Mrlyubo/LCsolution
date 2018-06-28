import java.util.*;

class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new LinkedList<>();
         res.add(1);
        if (rowIndex == 0) return res;
        int t = rowIndex, b = 1;
        long cur = 1;
        for(int i = 1; i < rowIndex+1; i++){
            cur = cur * t;
            cur = cur / b;
            res.add((int)cur);
            t--;b++;
        }
        return res;
    }

/*    private int Cbt ( int b, int t){
        if(t >= b/2) t = b-t;
        if(t == 0) return 1;
        long topsum = b;long bottomsum = t;long curres = 1;
        while (t > 1){
            topsum *= (b-1);
            b--;
            bottomsum *= (t-1);
            t--;
            if(topsum%bottomsum == 0){
                curres *= (topsum/bottomsum);
                topsum = 1;
                bottomsum = 1;
            }
        }
        return (int)(curres*topsum/bottomsum);*/


    public static void main(String[] args) {
        Solution Launcher = new Solution();
        Launcher.start();
    }

    public void start() {
        System.out.println(getRow(0));
        System.out.println(getRow(1));
        System.out.println(getRow(2));
        System.out.println(getRow(3));
        System.out.println(getRow(4));
        System.out.println(getRow(31));
    }
}

