import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int findLongestChain(int[][] pairs) {
        // SLOW SORTING: Arrays.sort(pairs, (a, b) -> a[0] - b[0]); 98ms
        Arrays.sort(pairs, new Comparator<int[]>() {//31ms
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        int n = pairs.length;
        if(n == 0) return 0;

        int cnt = 1;
        int pev0 = pairs[n-1][0];
        for (int i = n-2; i >= 0; i--){
            if(pairs[i][1] < pev0){
                cnt++;
                pev0 = pairs[i][0];
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        Solution Launcher = new Solution();
        Launcher.start();
    }

    public void start() {
        int[][] pairs = {{1,2},{2,3},{3,4}};
        System.out.println("2:"+findLongestChain(pairs));

        int[][] pairs1 = {{1,2},{3,7},{5,6},{0,8},{9,10},{10,100},{78,79},{80,81},{82,83}};
        System.out.println("6:"+findLongestChain(pairs1));

        int[][] pairs2 = {{7,8},{1,3},{2,5},{4,8},{5,6},{9,10}};
        System.out.println("4:"+findLongestChain(pairs2));

        int[][] pairs4 = {};
        System.out.println("0:"+findLongestChain(pairs4));

        //int[][] pairs5 = {{}};
        //System.out.println("0:"+findLongestChain(pairs5));
    }
}

                /*boolean inside = false;
                while (i >= 1 && pairs[i-1][0] > cur0 && pairs[i-1][1] < cur1){
                    inside = true;
                    cnt++;
                    i--;
                }
                if(!inside)*/