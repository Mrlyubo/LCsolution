class Solution {
    public int maxRotateFunction(int[] A) {
        int n = A.length;
        if(n == 0) return 0;
        int sum = 0;
        for(int i : A)
            sum += i;

        int curF = 0;
        for(int i = 0; i < n; i++)
            curF += A[i]*i;

        int diff;
        int res = curF;
        for(int i = 1; i < n; i++){
            diff = sum - n * A[n-i];
            curF += diff;
            if(diff > 0) {//F[i] > F[i-1]
                res = Math.max(res, curF);
            }
        }
        return res;

    }
    public static void main(String[] args) {
        Solution Launcher = new Solution();
        Launcher.start();
    }

    public void start() {

        System.out.println(maxRotateFunction(new int[]{4,3,2,6}));
    }
}

