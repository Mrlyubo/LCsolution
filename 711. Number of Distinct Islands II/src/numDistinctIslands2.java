import java.util.*;

/**
 * 1. It can do rotation and mirror at the same time.
 * 2. Use a String to represent island itself and its 7 transformations(siblings);
 * 3. Use<List<int[]>> to represent coordinates, no need to create Pair Class.
 * 4. Use Collections.sort to do the sorting.
 * 5. use List<int[]> cells  and   dfs(grid, i, j, cells).
 */
/**
 * class Solution {
 *     int[][] dirs={{-1,0}, {1,0}, {0,-1}, {0,1}};
 *     int[][] trans={{1,1}, {1,-1}, {-1,1}, {-1,-1}};
 *
 *     public int numDistinctIslands2(int[][] grid) {
 *         if (grid==null || grid.length==0 || grid[0].length==0) return 0;
 *         int m=grid.length, n=grid[0].length;
 *         Set<String>islands=new HashSet<>();
 *
 *         for (int i=0;i<m;i++){
 *             for (int j=0;j<n;j++){
 *                 if (grid[i][j]==1){
 *                     List<int[]> cells=new ArrayList<>();
 *                     dfs(grid, i, j, cells);
 *                     String key=norm(cells);
 *                     islands.add(key);
 *                 }
 *             }
 *         }
 *         return islands.size();
 *     }
 *
 *     private void dfs(int[][] grid, int i, int j, List<int[]> cells){
 *         cells.add(new int[]{i, j});
 *         grid[i][j]=-1;
 *
 *         for (int[] dir:dirs){
 *             int x=i+dir[0];
 *             int y=j+dir[1];
 *             if (x>=0 && x<grid.length && y>=0 && y<grid[0].length && grid[x][y]==1)
 *                 dfs(grid, x, y, cells);
 *         }
 *     }
 *
 *     private String norm(List<int[]>cells){
 *         List<String> forms=new ArrayList<>();
 *         // generate the 8 different transformations
 *         // (x, y), (x, -y), (-x, y), (-x, -y)
 *         // (y, x), (-y, x), (y, -x), (-y, -x)
 *         for (int[] ts:trans){
 *             List<int[]> list1=new ArrayList<>();
 *             List<int[]> list2=new ArrayList<>();
 *             for (int[] cell:cells){
 *                 list1.add(new int[]{cell[0]*ts[0], cell[1]*ts[1]});
 *                 list2.add(new int[]{cell[1]*ts[1], cell[0]*ts[0]});
 *             }
 *             forms.add(getKey(list1));
 *             forms.add(getKey(list2));
 *         }
 *
 *         // sort the keys: take the first one as the representative key
 *         Collections.sort(forms);
 *         return forms.get(0);
 *     }
 *
 *     private String getKey(List<int[]>cells){
 *         // sort the cells before generate the key
 *         Collections.sort(cells, new Comparator<int[]>() {
 *             @Override
 *             public int compare(int[] a, int[] b) {
 *                 if (a[0]!=b[0]){
 *                     return a[0]-b[0];
 *                 }else{
 *                     return a[1]-b[1];
 *                 }
 *             }
 *         });
 *
 *         StringBuilder sb=new StringBuilder();
 *         int x=cells.get(0)[0], y=cells.get(0)[1];
 *         for (int[] cell:cells)
 *             sb.append((cell[0]-x)+":"+(cell[1]-y)+":");
 *
 *         return sb.toString();
 *     }
 * }
 * */   //DFS + Sorting + Canonical_representation.
class Solution {
    List<List<Integer>> set = new ArrayList<>();
    int[] a1 = {-1,1,-1, 1,-1,1,-1};
    int[] a2 = {1,-1,-1, 1,1,-1,-1};
    Boolean[] swap = {false,false,false,true,true,true,true};

    public int numDistinctIslands2(int[][] grid) {
        set.clear();
        for(int i = 0; i < grid.length; i++)
            for(int j = 0; j < grid[i].length; j++){
                if(grid[i][j] == 1){
                    List<Integer> old = new ArrayList<>();
                    old = listres;
                    List<Integer> next = new ArrayList<>();
                    listres = next;
                    List<Integer> curCoors =  dfs(grid, i, j);
                    if(isDistinct(set, curCoors)){
                        sortList(curCoors);
                        //System.out.println("set:"+curCoors.size()+curCoors);
                        set.add(curCoors);

                    }
                }
            }
/*      PriorityQueue<List<Integer>> pqres = new PriorityQueue<>((x,y)->x.size()-y.size());
        for(List<Integer> listinset : set){
            pqres.add(listinset);
        }
        while (!pqres.isEmpty()){
            List<Integer> toprint = pqres.poll();
            System.out.print(toprint.size());
            System.out.println(toprint);
        }*/
        return set.size();
    }
    List<Integer> listres = new ArrayList<>();

    public List<Integer> dfs(int[][] grid, int i, int j){
        listres.add(i);
        listres.add(j);
        grid[i][j] = -1;

        if(j+1 < grid[i].length && grid[i][j+1] > 0 )
            dfs(grid, i, j+1);
        if(j-1 >= 0 && grid[i][j-1] > 0)
            dfs(grid, i, j-1);
        if(i+1 < grid.length && grid[i+1][j] > 0)
            dfs(grid, i+1, j);
        if(i-1 >= 0 && grid[i-1][j] > 0)
            dfs(grid, i-1, j);
        return listres;
    }

    private boolean isDistinct(List<List<Integer>> set, List<Integer> curCoors){
        for(int t = 0; t < 7; t++)
           for(List<Integer> list: set){
               if(list.size() == curCoors.size() &&
                 (isParal(list, siblings(curCoors,t)) || isParal(list,curCoors)))
                   return false;
        }
        return true;
    }

    private List<Integer> siblings (List<Integer> list, int t){
        List<Integer> listbuiler = new LinkedList<>();
        for(int i = 0; i < list.size()-1; i += 2){
            int c1 = list.get(i);
            int c2 = list.get(i+1);
            if(swap[t]){
                int tmp = c1;
                c1 = c2;
                c2 = tmp;
            }
            c1 *= a1[t];
            c2 *= a2[t];

            listbuiler.add(c1);
            listbuiler.add(c2);
        }
        return listbuiler;
    }

    private boolean isParal( List<Integer> s, List<Integer> t){
        if(s.size() == 1 && t.size() == 1)
            return true;
        sortList(t);
        //System.out.println(s+":"+t);
        if(s.size() != t.size())
            return false;
        int diffr = s.get(0) - t.get(0);
        int diffc = s.get(1) - t.get(1);
        for(int i = 1; i < s.size(); i++) {
            if (i % 2 == 0) {
                if (s.get(i) - t.get(i) != diffr)
                    return false;
            } else {
                if (s.get(i) - t.get(i) != diffc)
                    return false;
            }
        }
        return true;

    }

    class Pair implements Comparable<Pair>{
        int r;
        int c;
        public Pair(int r, int c){
            this.r = r;
            this.c = c;
        }
        @Override
        public int compareTo(Pair o){
            if(this.r != o.r) return this.r-o.r;
            else return this.c-o.c;
        }
    }
    private void sortList(List<Integer> list){
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for(int i = 0; i < list.size(); i++){
            if(i % 2 == 0 ){
                Pair pair = new Pair(list.get(i),list.get(i+1));
                pq.add(pair);
            }
        }
        list.clear();
        while (!pq.isEmpty()){
            Pair cur = pq.poll();
            list.add(cur.r);
            list.add(cur.c);
        }
    }

    public static void main(String[] args) {
        Solution Launcher = new Solution();
        Launcher.start();
    }


    public void start() {
        /*int[][] grid = {
                {1,1,0,0,0},
                {1,0,0,0,0},
                {0,0,0,0,1},
                {0,0,0,1,1},
        };
        System.out.println(numDistinctIslands2(grid));*/
/*
        int[][] grid1 = {
                {1,1,1,0,0},
                {1,0,0,0,1},
                {0,1,0,0,1},
                {0,1,1,1,0},
        };
        System.out.println(numDistinctIslands2(grid1));*/

/*        int[][] grid2 = {
                {0,1},
                {1,1},

        };
        System.out.println(numDistinctIslands2(grid2));*/

/*        int[][] grid3 = {
                {1,1,1,0,0,1,0,1,1,0,0,1,0,1,1},
                {1,1,0,1,1,1,0,0,1,0,1,0,0,0,1},
                {0,0,1,1,1,0,1,0,0,1,0,1,1,0,0},
                {1,1,1,1,1,1,0,0,0,0,0,1,1,1,0},
                {0,1,1,0,1,1,1,0,0,0,0,1,0,1,0},
                {1,0,0,0,0,0,1,1,0,1,1,1,1,0,0},
                {1,0,1,0,0,1,1,1,0,1,0,1,1,0,1},
                {0,0,0,1,0,0,1,1,1,1,0,1,0,0,1},
                {1,1,1,0,0,0,0,1,1,1,1,0,0,0,0},
                {1,1,0,0,0,0,0,0,0,1,0,0,0,1,0}
        };
        System.out.println(numDistinctIslands2(grid3));*/

        int[][] grid4 ={
              //     0 1 2 3 4 5 6 7 8 910111213141516171819202122232425262728293031323334353637383940414243444546474849
           /*0*/    {1,0,1,0,0,1,0,0,1,1,0,0,0,1,1,1,1,0,1,1,0,1,0,0,0,0,0,0,1,1,0,1,0,0,1,0,0,0,0,1,0,1,0,0,1,1,0,1,0,0},
           /*1*/    {1,1,0,1,0,0,1,0,1,1,0,1,1,1,1,1,0,0,0,0,1,1,1,0,0,0,1,0,0,1,1,1,1,1,0,0,1,0,0,0,1,0,1,1,1,1,1,0,0,1},
            /*2*/   {1,1,0,0,1,0,0,1,0,1,0,1,1,0,0,1,0,0,1,1,0,0,0,1,0,0,0,1,1,1,1,1,0,0,0,1,1,0,1,0,0,0,1,1,1,0,0,1,1,0},
            /*3*/   {1,1,1,0,0,0,0,1,0,1,0,1,1,0,0,1,1,0,1,0,1,0,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0,1,1,1,0,1,0,0,1,0,0,1,0,1},
            /*4*/   {0,0,1,0,1,0,0,1,1,0,1,1,0,1,1,1,0,1,1,1,0,1,0,0,1,1,1,0,0,0,0,1,1,0,1,1,1,0,0,0,0,0,0,0,0,1,1,0,1,0},
            /*5*/   {0,0,1,1,1,0,0,1,0,1,1,0,0,1,1,1,0,0,1,0,0,1,0,0,1,1,1,1,0,1,0,0,1,1,1,1,1,1,0,0,1,0,0,1,0,1,1,0,1,1},
            /*6*/   {0,0,0,0,0,1,1,1,1,0,0,0,0,1,1,1,1,1,0,0,0,0,1,1,0,0,0,1,1,0,0,1,1,0,0,0,1,1,0,0,1,1,1,1,1,0,1,1,1,1},
            /*7*/   {1,1,1,1,1,0,1,1,0,1,1,0,0,0,1,1,1,0,0,0,0,1,1,0,0,0,0,0,0,1,1,1,0,1,1,0,0,0,1,0,1,1,0,1,0,0,1,0,1,0},
            /*8*/   {0,0,0,1,0,1,1,0,1,0,1,1,0,1,0,0,1,1,1,0,1,1,1,1,1,0,1,0,1,0,1,0,0,1,1,1,1,1,0,1,1,1,1,1,1,0,1,0,1,1},
            /*9*/   {1,1,0,0,0,1,0,0,1,0,0,0,0,1,0,1,1,1,1,1,1,1,0,0,0,1,0,0,1,1,0,0,1,1,0,0,0,1,0,1,0,1,1,1,1,0,0,0,0,1},
           /*10*/   {0,1,0,1,0,1,1,0,0,0,0,0,0,1,1,0,1,1,1,1,1,1,0,0,0,1,0,0,1,0,1,1,1,0,0,0,0,1,1,0,0,0,0,0,1,1,1,1,0,0},
           /*11*/   {0,0,1,0,0,0,0,0,1,0,0,1,1,0,0,0,1,1,1,0,1,1,1,1,0,0,1,1,1,1,1,0,0,0,0,1,1,1,0,0,1,1,1,0,0,1,0,0,1,1},
           /*12*/   {1,1,0,0,1,1,0,0,0,0,1,1,1,1,1,1,0,0,1,1,0,0,1,1,0,1,0,1,0,0,0,1,1,1,0,0,0,1,0,1,1,1,1,0,0,0,1,0,0,0},
           /*13*/   {0,1,1,0,1,1,1,1,1,0,0,1,1,1,1,0,0,0,1,0,0,1,0,1,1,0,1,0,1,1,1,1,0,1,1,1,0,0,1,0,1,0,1,1,1,1,0,1,1,1},
           /*14*/   {1,0,1,0,1,1,1,1,1,0,1,0,0,0,1,1,1,1,0,1,1,1,1,0,1,1,1,0,0,1,1,0,1,1,1,1,1,1,1,0,0,0,1,0,1,1,0,1,0,0},
           /*15*/   {1,1,1,0,0,0,1,1,1,0,0,1,0,1,1,1,0,0,1,0,1,0,0,1,0,0,1,0,0,0,0,1,1,0,0,0,0,0,1,1,1,1,1,1,1,1,1,0,0,1},
           /*16*/   {0,0,1,1,1,0,1,1,1,1,1,0,0,1,1,0,0,0,1,1,0,1,1,0,1,1,0,1,1,1,1,1,0,0,1,1,1,0,1,1,1,1,0,0,0,0,1,1,0,0},
           /*17*/   {1,1,1,0,0,0,1,0,1,1,1,1,1,0,0,0,1,0,0,0,1,0,1,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,1,0,1,1,0,1,0,0,1,0,0,1},
           /*18*/   {0,0,1,0,1,1,1,1,0,0,0,1,0,1,1,0,0,1,0,0,1,1,1,0,1,1,1,0,0,1,0,0,0,1,0,0,1,0,0,1,1,0,1,0,1,1,1,0,0,0},
           /*19*/   {0,1,0,0,1,0,0,1,0,1,1,0,1,0,0,0,1,1,1,0,0,1,0,0,1,0,1,0,0,0,0,0,1,1,0,1,1,0,1,0,1,0,0,1,1,1,0,0,0,0},
           /*20*/   {1,0,0,0,0,1,1,1,1,0,0,0,1,1,0,1,1,0,1,0,1,0,1,0,0,1,1,0,1,1,0,1,0,0,0,0,0,0,0,1,0,0,1,0,1,0,0,0,1,0},
           /*21*/   {1,0,1,0,0,1,1,0,1,1,0,0,1,0,0,1,1,0,1,1,1,0,1,0,1,1,1,0,1,0,0,0,1,0,0,1,0,1,0,1,1,1,0,1,1,1,1,0,0,1}
        };
        System.out.println(numDistinctIslands2(grid4));
    }
}

