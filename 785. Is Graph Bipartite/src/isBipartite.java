class A { //9ms,75%
    /** corner cases:
     * 1. node without edge: graph[i].length == 0;
     * 2. graph is separated into 2 or more sub_graphs.
     *
     * Idea: use an array to map (node->subset)
    */
    boolean flag;
    int cnt;
    int prevj;
    public boolean isBipartite(int[][] graph) {
        flag = true;
        cnt = 1;
        prevj = 0;
        int[] res = new int[graph.length];
        for(int i = 0; i< graph.length; i++){
            if(graph[i].length != 0) {
                res[i] = 1;
                fillmap(i,res,graph);
                while(cnt != graph.length){ // map: node-> subset.
                    int j;
                    for(j = prevj; i < graph.length;j ++){
                        prevj = j;
                        if(res[j] == 0) break;
                    }
                    res[j] = 1;  // node -> subset 1
                    cnt++;
                    fillmap(j,res,graph);
                }
            }
        }
        return flag;
    }
    private void fillmap (int idx,int[]  res, int[][] graph){
        if(cnt == graph.length )
            return;
        for( int n: graph[idx]){
            if(res[n] == 0){
                res[n] = -res[idx];// node -> opposite subset
                cnt ++;
                fillmap(n,res,graph);
            }
            else {
                if(res[n] == -res[idx]) // when map is matched to previous map, continue;
                    continue;
                else
                    flag = false;// when map is conflicted, return false;
            }
        }
    }


    public static void main(String [] args){
        A Launcher = new A();
        Launcher.start();
    }
    public void start(){
        int[][] graph = {{1,3},{0,2},{1,3},{0,2}};
        System.out.println("true:"+isBipartite(graph));

        int[][] graph1 = {{1,2,3},{0,2},{0,1,3},{0,2}};
        System.out.println("false:"+isBipartite(graph1));

        int[][] graph2 = {{3},{2,4},{1},{0,4},{1,3}};
        System.out.println("true:"+isBipartite(graph2));

        int[][] graph3 = {{},{2,4,6},{1,4,8,9},{7,8},{1,2,8,9},{6,9},{1,5,7,8,9},{3,6,9},{2,3,4,6,9},{2,4,5,6,7,8}};
        System.out.println("false:"+isBipartite(graph3));

        int[][] graph4 = {{2,4},{2,3,4},{0,1},{1},{0,1},{7},{9},{5},{},{6},{12,14},{},{10},{},
                {10},{19},{18},{},{16},{15},{23},{23},{},{20,21},{},{},{27},{26},{},{},{34},{33,34},
                {},{31},{30,31},{38,39},{37,38,39},{36},{35,36},{35,36},{43},{},{},{40},{},{49},
                {47,48,49},{46,48,49},{46,47,49},{45,46,47,48}};
        System.out.println("false:"+isBipartite(graph4));

        int[][] graph5 = {{4},{},{4},{4},{0,2,3}};
        System.out.println("true:"+isBipartite(graph5));

        int[][] graph6 = {{},{2,4,6},{1,4,8,9},{7,8},{1,2,8,9},{6,9},{1,5,7,8,9},{3,6,9},{2,3,4,6,9},{2,4,5,6,7,8}};
        System.out.println("false:"+isBipartite(graph6));
    }
}