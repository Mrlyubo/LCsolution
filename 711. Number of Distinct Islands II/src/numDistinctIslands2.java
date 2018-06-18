class Solution {
    public int numDistinctIslands2(int[][] grid) {
        int res = 0;
        return res;
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
        System.out.println(numDistinctIslands2(grid));
    }
}

