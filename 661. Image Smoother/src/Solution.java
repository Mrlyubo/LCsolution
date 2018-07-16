class Solution {

    public int[][] imageSmoother(int[][] M) {
        int[][] res = new int[M.length][M[0].length];
        for(int r = 0; r < M.length; r ++){
            for(int c = 0; c < M[0].length; c++){
                res[r][c] = bfs(M, r, c);
            }
        }
        return res;
    }

    int[] R = {0, -1, 0, 1, 1, 1, 0, -1, -1};
    int[] C = {0, 1, 1, 1, 0, -1, -1, -1, 0};
    private int bfs(int[][] M, int r, int c){
        int cnt = 0;
        int sum = 0;
        for(int i = 0; i < 9; i++){
            int rr = r+R[i];
            int cc = c+C[i];
            if(rr >= 0 && rr < M.length && cc >= 0 && cc < M[0].length){
                cnt++;
                sum += M[rr][cc];
            }
        }
        //System.out.println("[r,c]="+"["+r+","+c+"]  "+",sum = "+sum+",cnt="+cnt );
        return sum/cnt;
    }

    public static void main(String[] args) {
        Solution Launcher = new Solution();
        Launcher.start();
    }

    public void start() {
        int[][] M = {{1,1,1},
                     {1,0,1},
                     {1,1,1}};
        printMatrix(imageSmoother(M));
    }

    public void printMatrix ( int[][] matrix){
        for(int[] arr: matrix){
            System.out.print("[");
            for(int n: arr)
                System.out.print(n+",");
            System.out.println("]");
        }
    }
}

