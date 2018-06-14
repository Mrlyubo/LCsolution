import java.util.*;

class A {
/**Explanation

 Starting from (0, 0), for each tree in height order,
 we will calculate the distance from where we are to the
 next tree (and move there), adding that distance to the answer.

 We frame the problem as providing some distance function
 dist(forest, sr, sc, tr, tc) that calculates the path distance
 from source (sr, sc) to target (tr, tc) through obstacles dist[i][j] == 0.
 (This distance function will return -1 if the path is impossible.)

Dist function:
 We perform a breadth-first-search, processing nodes (grid positions)
 in a queue. seen keeps track of nodes that have already been added to
 the queue at some point - those nodes will be already processed or
 are in the queue awaiting processing.

 For each node that is next to be processed, we look at it's neighbors.
 If they are in the forest (grid), they haven't been enqueued, and they
 aren't an obstacle, we will enqueue that neighbor.

 We also keep a side count of the distance travelled for each node.
 If the node we are processing is our destination 'target' (tr, tc),
 we'll return the answer.
 * */
        int[] dr = {-1,1,0,0};
        int[] dc = {0,0,-1,1};
        public int cutOffTree(List<List<Integer>> forest) {
            List<int[]> trees = new LinkedList<>();
            for(int r = 0; r < forest.size(); r++)
                for(int c = 0; c < forest.get(0).size(); c++){
                    int v = forest.get(r).get(c);
                    if(v > 1) trees.add(new int[]{v, r, c});// add tree's height and its coordinates;
                }
            Collections.sort(trees, (a,b)->a[0]-b[0]);// sort the tree according to its height. 从小到大->a-b
            int ans = 0, sr = 0, sc = 0;
            for(int[] tree: trees){
                int d = dist(forest,sr,sc,tree[1],tree[2]);
                if(d<0) return -1;
                ans += d;
                sr = tree[1];
                sc = tree[2];
            }
            return ans;
        }

        private int dist(List<List<Integer>> forest, int sr, int sc, int tr, int tc){
            Queue<int[]> q = new LinkedList<>();
            int R = forest.size(), C = forest.get(0).size();
            boolean[][] seen = new boolean[R][C];
            q.add(new int[]{sr,sc,0});
            seen[sr][sc] = true;// initialize the first tree.
            while(!q.isEmpty()){
                int[] cur = q.poll();
                if(cur[0] == tr && cur[1] == tc) return cur[2]; // check before the breadth-first-search;
                for(int i = 0; i < 4; i++){
                    int r = cur[0]+dr[i];
                    int c = cur[1]+dc[i];
                    if(r >= 0 && r < R && c >= 0 && c < C
                    && !seen[r][c] && forest.get(r).get(c) > 0){
                        q.add(new int[]{r,c,cur[2]+1});
                        seen[r][c] = true;
                    }
                }
            }
            return -1;
        }



    public static void main(String [] args){
        A Launcher = new A();
        Launcher.start();
    }

    public void start(){
       /* int[][] ff =
        {
            {1,2,3},
            {0,0,4},
            {7,6,5}
        };
        List<List<Integer>> forest = new ArrayList<>();
        for(int[] f1: ff) {
            List<Integer> list = new ArrayList<>();
            for (int f : f1)
                list.add(f);
            forest.add(list);
        }
        System.out.println(cutOffTree(forest));

        int[][] ff1 =
                {
                        {1,2,3},
                        {0,0,0},
                        {7,6,5}
                };
        List<List<Integer>> forest1 = new ArrayList<>();
        for(int[] f1: ff1) {
            List<Integer> list = new ArrayList<>();
            for (int f : f1)
                list.add(f);
            forest1.add(list);
        }
        System.out.println(cutOffTree(forest1));*/

        int[][] ff2 =
                {
                        {1,2,3},
                        {0,0,4},
                        {7,6,5},
                        {0,0,8},
                       {11,10,9}
                };
        List<List<Integer>> forest2 = new ArrayList<>();
        for(int[] f1: ff2) {
            List<Integer> list = new ArrayList<>();
            for (int f : f1)
                list.add(f);
            forest2.add(list);
        }
        System.out.println(cutOffTree(forest2));
    }
}