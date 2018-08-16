import java.util.*;

public class maxAreaOfIsland {

    int ans = 0;
    int tmpans = 0;
    public int maxAreaOfIsland(int[][] grid) {
        int R = grid.length;
        int C = grid[0].length;
        for(int i = 0; i < R; i++){
            for(int j = 0; j < C; j++){
                if(grid[i][j] == 1){
                    tmpans = 0;
                    dfs(i, j, R, C, grid);
                    //System.out.println(tmpans);
                    if(tmpans > ans){
                        ans = tmpans;
                        //System.out.println(ans);
                    }

                }

            }
        }
        printmatrix(grid);
        return ans;
    }

    public void dfs(int i, int j, int R, int C, int[][] grid){
        if( i >= R || j >= C || i < 0 || j < 0 || grid[i][j] != 1){
            return;
        }


        if(grid[i][j] == 1)
            tmpans++;
        grid[i][j] = 0;

        dfs(i+1, j, R, C, grid);
        dfs(i-1, j, R, C, grid);
        dfs(i, j+1, R, C, grid);
        dfs(i, j-1, R, C, grid);

    }

    public static void main(String[] args) {
        maxAreaOfIsland Launcher = new maxAreaOfIsland();
        Launcher.start();
    }

    public void start() {

//        int[][] grid1 = {{0,0,0,0,0},
//                         {0,1,0,1,0},
//                         {0,1,1,1,0},
//                         {0,0,0,1,0},
//                         {0,0,0,0,0},
//        };
//        System.out.println(maxAreaOfIsland(grid1));
//
//        int[][] grid = { {0,0,1,0,0,0,0,1,0,0,0,0,0},
//                         {0,0,0,0,0,0,0,1,1,1,0,0,0},
//                         {0,1,1,0,1,0,0,0,0,0,0,0,0},
//                         {0,1,0,0,1,1,0,0,1,0,1,0,0},
//                         {0,1,0,0,1,1,0,0,1,1,1,0,0},
//                         {0,0,0,0,0,0,0,0,0,0,1,0,0},
//                         {0,0,0,0,0,0,0,1,1,1,0,0,0},
//                         {0,0,0,0,0,0,0,1,1,0,0,0,0}};
//
//        System.out.println(maxAreaOfIsland(grid));

        int[][] grid2 = {{0}};

        System.out.println(maxAreaOfIsland(grid2));
    }

    public void printmatrix (int[][] M) {

        for(int[] row: M){
            System.out.print("{");
            for(int i: row){
                System.out.print(i+",");
            }
            System.out.println("}");
        }

    }

}
