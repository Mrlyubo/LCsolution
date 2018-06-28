import java.util.*;

class Solution {
    Map<Integer, List<Integer>> map;
    int[] res;//!!!!!
    public int[] loudAndRich(int[][] richer, int[] quiet) {
        map = new HashMap<>();
        int M = quiet.length;
        for(int i: quiet) map.put(i, new ArrayList<>());
        //@@@@@ necessary, otherwise will getNullPointerEXT in: for(int ii: map.get(i));
        for(int[] v : richer) map.get(v[1]).add(v[0]);
        res = new int[M];
        Arrays.fill(res, -1);//!!!!!
        for(int i = 0; i < M; i++)
            res[i] = dfs(i, quiet);
        return res;
    }

    private int dfs (int i, int[] quiet){
        if(res[i] >= 0) return res[i];
        //!!!!!! no need to do dfs again when the res[i] had been calculated.
        res[i] = i;
        for(int ii: map.get(i)){
            int newi = dfs(ii, quiet);
            if( quiet[newi] < quiet[res[i]])
                res[i] = newi;
        }
        return res[i];
    }

    public static void main(String[] args) {
        Solution Launcher = new Solution();
        Launcher.start();
    }

    public void start() {
        int[][] richer = {{1,0},{2,1},{3,1},{3,7},{4,3},{5,3},{6,3}};
        int[] quiet = {3,2,5,4,6,1,7,0};
        printArray(loudAndRich(richer, quiet));
    }
    public void printArray ( int[] array){
        System.out.print("[");
        for(int n: array)
            System.out.print(n+",");
        System.out.println("]");
    }
}

