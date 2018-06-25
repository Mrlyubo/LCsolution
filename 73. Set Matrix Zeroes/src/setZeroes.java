class Solution {
    //Space:O(1).
    /**My idea is simple: store states of each row in the first of that row,
     * and store states of each column in the first of that column. Because
     * the state of row0 and the state of column0 would occupy the same cell,
     * I let it be the state of row0, and use another variable "col0" for column0.
     * In the first phase, use matrix elements to set states in a top-down way.
     * In the second phase, use states to set matrix elements in a bottom-up way.*/
    public void setZeroes1(int[][] matrix) {
        int col0 = 1, rows = matrix.length, cols = matrix[0].length;

        for (int i = 0; i < rows; i++) {
            if (matrix[i][0] == 0) col0 = 0;
            for (int j = 1; j < cols; j++)
                if (matrix[i][j] == 0)
                    matrix[i][0] = matrix[0][j] = 0;
        }

        for (int i = rows - 1; i >= 0; i--) {
            for (int j = cols - 1; j >= 1; j--)
                if (matrix[i][0] == 0 || matrix[0][j] == 0)
                    matrix[i][j] = 0;
            if (col0 == 0) matrix[i][0] = 0;
        }
    }
//**********************************************************************************************
    //Space: O(m+n)
    public void setZeroes(int[][] matrix) {
        int row = matrix.length, col = matrix[0].length;
        boolean[] R = new boolean[row];
        boolean[] C = new boolean[col];
        for(int r = 0; r < row; r++)
            for(int c = 0; c < col; c++)
                if(matrix[r][c] == 0){
                    R[r] = true;
                    C[c] = true;
                }

        for(int r = 0; r < row; r++)
            for(int c = 0; c < col; c++){
                if(R[r]||C[c])
                    matrix[r][c] = 0;
            }

    }
    public static void main(String[] args) {
        Solution Launcher = new Solution();
        Launcher.start();
    }

    public void start() {
        int[][] matrix = {
                {1,1,1},
                {1,0,1},
                {1,1,1}
        };
        setZeroes(matrix);
        printMatrix(matrix);

        int[][] matrix1 = {
                {0,1,2,0},
                {3,4,5,2},
                {1,3,1,5}
        };
        setZeroes(matrix1);
        printMatrix(matrix1);

        int[][] matrix2 = {
                {0,1,2,0},
                {3,4,5,2},
                {1,3,1,5}
        };
        setZeroes(matrix2);
        printMatrix(matrix2);

    }
    public void printMatrix ( int[][] matrix){
        for(int[] arr: matrix){
            System.out.print("[");
            for(int n: arr)
                System.out.print(n+",");
            System.out.println("]");

        }
        System.out.println("*************");
    }
}

