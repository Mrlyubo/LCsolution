import java.util.*;

class Solution {
    public int numDistinctIslands(int[][] grid) {
        //DFS : find the original cells;
        int r = grid.length, c = grid[0].length;
        Set<String> keys = new HashSet<>();
        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                if(grid[i][j] == 1){
                    List<int[]> cells = new ArrayList<>();
                    dfs(grid, i, j, cells);
                    keys.add(getkey(cells));
                }
            }
        }
        return keys.size();
    }

    private void dfs(int[][] grid, int i, int j, List<int[]> cells){
        if(i < 0 || i >= grid.length || j < 0 || j>= grid[0].length || grid[i][j] == 0)
            return;
        grid[i][j] = 0;
        cells.add(new int[]{i,j});
        dfs(grid, i,j+1,cells);
        dfs(grid, i,j-1,cells);
        dfs(grid, i+1,j,cells);
        dfs(grid, i-1,j,cells);
    }

    private String getkey(List<int[]> cells){
        Collections.sort(cells, (x,y)->(x[0]==y[0]?x[1]-y[1]:x[0]-y[0]));
        int x = cells.get(0)[0], y = cells.get(0)[1];
        StringBuilder sb = new StringBuilder();
        for(int[] cell: cells){
            sb.append(cell[0]-x).append(":").append(cell[1]-y).append(":");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution Launcher = new Solution();
        Launcher.start();
    }

    public void start() {
        int[][] grid = {
                {1,1,0,0,0},
                {1,0,0,0,0},
                {0,0,0,0,1},
                {0,0,0,1,1},
        };
        System.out.println("2:"+numDistinctIslands(grid));

        int[][] grid1 = {
                {1,1,1,0,0},
                {1,0,0,0,1},
                {0,1,0,0,1},
                {0,1,1,1,0},
        };
        System.out.println("3:"+numDistinctIslands(grid1));

        int[][] grid2 = {
                {0,1},
                {1,1},

        };
        System.out.println("1:"+numDistinctIslands(grid2));

        int[][] grid3 = {
                {1,1,0,0,0},
                {1,1,0,0,0},
                {0,0,0,1,1},
                {0,0,0,1,1},
        };
        System.out.println("1:"+numDistinctIslands(grid3));
    }
}

