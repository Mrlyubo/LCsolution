class Solution {


    //concise O(m+n) solution.
    /**
     * We start search the matrix from top right corner, initialize the current position
     * to top right corner, if the target is greater than the value in current position,
     * then the target can not be in entire row of current position because the row is
     * sorted, if the target is less than the value in current position, then the target
     * can not in the entire column because the column is sorted too. We can rule out one
     * row or one column each time, so the time complexity is O(m+n).
     * */
    public boolean searchMatrix1(int[][] matrix, int target) {
        if(matrix == null || matrix.length < 1 || matrix[0].length <1) {
            return false;
        }
        int col = matrix[0].length-1;
        int row = 0;
        while(col >= 0 && row <= matrix.length-1) {
            if(target == matrix[row][col]) {
                return true;
            } else if(target < matrix[row][col]) {
                col--;
            } else if(target > matrix[row][col]) {
                row++;
            }
        }
        return false;
    }
    public boolean searchMatrix(int[][] matrix, int target) {//O(log(R)+log(R)+R*log(C))=O(log(R)+R*log(C))
        int R = matrix.length;
        if(R == 0) return false;
        int C = matrix[0].length;
        if(C == 0) return false;
        // Binary Search to find the maximum valid start row index : startR.
        int min = 0, max = R-1, i=min + (max-min)/2 ; // *** note: init i before the loop begin;
        while ( min < max  ){//log(R)
            if(i == min || i == max || matrix[i-1][C-1] < target && target <= matrix[i][C-1])
                break;
            else if(matrix[i][C-1] > target )
                max = i;
            else
                min = i;
            i = min + (max-min)/2; //*** note : update i in the end of every loop inside.
        }
        int startR = i;
        //System.out.println("startR:"+startR);

        // Binary Search to find the minimum valid end row index : endR.
        min = 0; max = R-1;i = min + (max-min)/2;
        while (min < max){
            if(i == min || i == max || matrix[i-1][0] < target && target <= matrix[i][0] )
                break;
            else if(matrix[i][0] > target)
                max = i;
            else
                min = i;
            i = min + (max-min)/2;
        }
        int endR = i+1 > R-1 ? R-1 : i+1;
        //System.out.println("endR:"+endR);

        //In the range of {startRow , endRow}, do binary search to find the target.
        for(int idx = startR; idx <= endR; idx++){
            // Binary Search in i-th Row.
            int mini = 0, maxi = C-1, j=mini + (maxi-mini)/2;
            if(matrix[idx][mini] == target || matrix[idx][maxi] == target)
                return true;
            while (mini < maxi-1){
                if(matrix[idx][j] == target)
                    return true;
                else if(matrix[idx][j] > target )
                    maxi = j;
                else
                    mini = j;
                j=mini + (maxi-mini)/2;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution Launcher = new Solution();
        Launcher.start();
    }

    public void start() {
        int[][] matrix = {
              // 0    1   2   3   4
                {1,   4,  7, 11, 15},//0
                {2,   5,  8, 12, 19},//1
                {3,   6,  9, 16, 22},//2
                {10, 13, 14, 17, 24},//3
                {18, 21, 23, 26, 30} //4
        };
        System.out.println("true:0,3:"+searchMatrix(matrix, 5));
        System.out.println("false:2,4"+searchMatrix(matrix, 20));
        System.out.println("***********1*****************");
        int[][] matrix1 = {};
        System.out.println("false:"+searchMatrix(matrix1, 0));
        System.out.println("***********2*****************");
        int[][] matrix2 = {{-5}};
        System.out.println("true:0,0,"+searchMatrix(matrix2, -5));
        System.out.println("false:0,0"+searchMatrix(matrix2, -1));
        System.out.println("************3****************");
        int[][] matrix3 = {{-5},{-1},{5}};
        System.out.println("true:0,0:"+searchMatrix(matrix3, -5));
        System.out.println("false:1,1"+searchMatrix(matrix3, -4));
        System.out.println("false:0,1"+searchMatrix(matrix3, -6));
        System.out.println("true:1,1"+searchMatrix(matrix3, -1));
        System.out.println("true:2,2"+searchMatrix(matrix3, 5));
        System.out.println("false:1,2"+searchMatrix(matrix3, 3));
        System.out.println("false:2,2"+searchMatrix(matrix3, 6));
        System.out.println("**************4**************");
        int[][] matrix4 = {{-5,-1}};
        System.out.println("true:0,0"+searchMatrix(matrix4, -1));
        System.out.println("**************5**************");

    }
}

