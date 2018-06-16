class Solution {
    public void rotate(int[][] matrix) {
        int N = matrix.length;
        for(int r = 0; r < N/2; r++ )
                for(int c = r; c < N-1-r; c++ )
                    rot(r, c, matrix,N-1);

    }
    public void rot(int r, int c, int[][] matrix,int N){
        int tmp = matrix[r][c];
        matrix[r][c] = matrix[N-c][r];
        matrix[N-c][r] = matrix[N-r][N-c];
        matrix[N-r][N-c] = matrix[c][N-r];
        matrix[c][N-r] = tmp;
    }
    public static void main(String[] args) {
        Solution Launcher = new Solution();
        Launcher.start();
    }
    public void printMatrix ( int[][] matrix){
        for(int[] arr: matrix){
            System.out.print("[");
            for(int n: arr)
                System.out.print(n+",");
            System.out.println("]");
        }
    }

    public void start() {
        int[][] matrix = {
            {1,2,3,4,5},
            {6,7,8,9,10},
            {11,12,13,14,15},
            {16,17,18,19,20},
            {21,22,23,24,25},
        };
        rotate(matrix);
        printMatrix(matrix);
    }
}

