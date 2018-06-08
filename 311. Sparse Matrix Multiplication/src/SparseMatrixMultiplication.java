class A {
    /**
     * 1.Time complexity is O(n^3).
     * 2.we can use some if statement to skip some loop.
     * 3.Switch the loop order from i,j,k to i,k,j, in this case, we can skip A[i][k] or B[k][j]
     *   before the internal loop;
     *
     * @param A
     * @param B
     * @return
     */

    public int[][] multiply(int[][] A, int[][] B) {
        int Arow = A.length;
        int Acol = A[0].length;
        int Bcol = B[0].length;
        int[][] res = new int[Arow][Bcol];
        for(int i = 0; i < Arow; i++)
            for(int k = 0; k < Acol; k++) {
                if (A[i][k] != 0) {// the
                    for (int j = 0; j < Bcol; j++) {
                        if (B[k][j]!=0) {
                            res[i][j] += A[i][k] * B[k][j];
                        }
                    }
                }
            }
        return res;
    }
    public void printarray(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print("[");
            for (int j = 0; j < arr[i].length; j++)
                System.out.print(arr[i][j] + ",");
            System.out.println("]");
        }
        System.out.println("***End of the array**");
    }
    public static void main(String [] args){
        A Launcher = new A();
        Launcher.start();
    }
    public void start(){
        int[][] A = {{1,2,3},{4,5,6}},B = {{1,4},{2,5},{3,6}};
        int[][] A1 ={{1,0,0},{-1,0,3}},B1 = {{7,0,0},{0,0,0},{0,0,1}};
        printarray(multiply(A,B));
        printarray(multiply(A1,B1));
    }
}