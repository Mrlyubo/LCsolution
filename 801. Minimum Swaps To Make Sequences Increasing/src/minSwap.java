class Solution {
    public int minSwap(int[] A, int[] B) {
        int n = A.length;
        int fixCnt = 0;
        int swapCnt = 1;
        for(int i = 1;i < n; i++){
            // in this case, the ith manipulation should be the same as of the i-1th manipulation.
            if(A[i-1] >= B[i] || B[i-1] >= A[i]){
                swapCnt++;
            }
            // in this case,  the ith manipulation should be the opposite of the i-1th manipulation.
            else if(A[i-1] >= A[i] || B[i-1] >= B[i]){
                int tmp = swapCnt;
                swapCnt = fixCnt+1;
                fixCnt = tmp;
            }

            //Either swap or fix is OK .
            else{
                int min = Math.min(fixCnt, swapCnt);
                fixCnt = min;
                swapCnt = min+1;
            }
        }
        return Math.min(fixCnt,swapCnt);
    }
    public static void main(String[] args) {
        Solution Launcher = new Solution();
        Launcher.start();
    }

    public void start() {
        System.out.println(minSwap(new int[]{1,5,6,4}, new int[]{1,2,3,7}));
    }
}

